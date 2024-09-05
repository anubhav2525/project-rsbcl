package org.excise.rsbcl.services.newsUpdates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.newsUpdates.NewsUpdatesDAO;
import org.excise.rsbcl.model.newsUpdates.NewsUpdates;
import org.excise.rsbcl.repository.newsUpdates.NewsUpdatesRepo;
import org.excise.rsbcl.services.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsUpdatesService {
    @Autowired
    private final NewsUpdatesRepo newsUpdatesRepo;
    @Autowired
    private final CloudinaryService cloudinaryService;

    public NewsUpdatesService(NewsUpdatesRepo newsUpdatesRepo, CloudinaryService cloudinaryService) {
        this.newsUpdatesRepo = newsUpdatesRepo;
        this.cloudinaryService = cloudinaryService;
    }

    public Response<List<NewsUpdates>> getNewsUpdatesFive(String department) {
        // Find news by department and sort by lastUpdate in descending order
        List<NewsUpdates> latestNews = newsUpdatesRepo.findByDepartment(department.toUpperCase(), Sort.by(Sort.Direction.DESC, "lastUpdate"))
                .stream()
                .limit(5) // Limit to the latest 5 records
                .collect(Collectors.toList());
        if(latestNews.isEmpty())
            return new Response<>("Error", "NO content " + department, latestNews);
        return new Response<>("Success", "Fetched latest 5 records for department: " + department, latestNews);
    }

    // get data as batch of 10 pagination
    public Response<Page<NewsUpdates>> getPaginatedNewsUpdates(int page, int size) {
        try {
            // Create a PageRequest with page number and size
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<NewsUpdates> newsUpdatesPage = newsUpdatesRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated news updates", newsUpdatesPage);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch paginated news updates: " + e.getMessage(), null);
        }
    }

    public Response<Optional<NewsUpdates>> getNewsUpdatesById(ObjectId id) {
        try {
            Optional<NewsUpdates> newsUpdates = newsUpdatesRepo.findById(id);
            if (newsUpdates.isEmpty())
                return new Response<>("Error404", "No content", null);
            return new Response<>("Success", "Data found", newsUpdates);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch news updates: " + e.getMessage(), null);
        }
    }

    public Response<NewsUpdates> saveNewsUpdates(NewsUpdatesDAO newsUpdatesDAO) {
        try {
            // calculate file size
            long sizeInBytes = newsUpdatesDAO.getDocument().getSize();

            if (sizeInBytes > 50 * 1024 * 1024)
                return new Response<>("Error", "File size too large. Maximum allowed size is 50MB.", null);

            String fileSize = formatFileSize(sizeInBytes);

            // file upload into cloud
            String documentUrl = cloudinaryService.uploadFileToCloudinary(newsUpdatesDAO.getDocument());

            NewsUpdates newsUpdates = new NewsUpdates();
            newsUpdates.setTitle(newsUpdatesDAO.getTitle().trim());
            newsUpdates.setDescription(newsUpdatesDAO.getDescription().trim());
            newsUpdates.setNewsStatus(newsUpdatesDAO.getNewsStatus());
            newsUpdates.setDepartment(newsUpdatesDAO.getDepartment().toUpperCase());
            newsUpdates.setLastUpdate(LocalDate.now());
            newsUpdates.setDocumentLinkUrl(documentUrl);
            newsUpdates.setFileSize(fileSize);

            // saving code
            NewsUpdates saved = newsUpdatesRepo.save(newsUpdates);
            return new Response<>("Saved", "News update saved successfully", saved);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to save news update: " + e.getMessage(), null);
        }
    }

    public Response<NewsUpdates> updateNewsUpdates(ObjectId id, NewsUpdatesDAO newsUpdatesDAO) {
        Optional<NewsUpdates> existingRecord = newsUpdatesRepo.findById(id);
        if (existingRecord.isPresent()) {
            try {
                NewsUpdates newsUpdates = existingRecord.get();
                newsUpdates.setTitle(newsUpdatesDAO.getTitle());
                newsUpdates.setDescription(newsUpdatesDAO.getDescription());
                newsUpdates.setDepartment(newsUpdatesDAO.getDepartment());
                newsUpdates.setLastUpdate(newsUpdatesDAO.getLastUpdate());
                newsUpdates.setNewsStatus(newsUpdatesDAO.getNewsStatus());

                if (newsUpdatesDAO.getDocument() != null && !newsUpdatesDAO.getDocument().isEmpty()) {
                    // If there's a new document, replace the old one
                    cloudinaryService.deleteFileFromCloudinary(newsUpdates.getDocumentLinkUrl());
                    String documentUrl = cloudinaryService.uploadFileToCloudinary(newsUpdatesDAO.getDocument());
                    newsUpdates.setDocumentLinkUrl(documentUrl);
                }

                newsUpdatesRepo.save(newsUpdates);
                return new Response<>("Success", "News update updated successfully", newsUpdates);
            } catch (Exception e) {
                return new Response<>("Error", "Failed to update news update: " + e.getMessage(), null);
            }
        } else {
            return new Response<>("Error404", "News update not found", null);
        }
    }

    public Response<NewsUpdates> deleteNewsUpdates(ObjectId id) {
        Optional<NewsUpdates> existingRecord = newsUpdatesRepo.findById(id);
        if (existingRecord.isPresent()) {
            try {
                NewsUpdates newsUpdates = existingRecord.get();
                if (newsUpdates.getDocumentLinkUrl() != null) {
                    String documentPublicId = getCloudinaryPublicId(newsUpdates.getDocumentLinkUrl());
                    cloudinaryService.deleteFileFromCloudinary(documentPublicId);
                }
                newsUpdatesRepo.delete(newsUpdates);
                return new Response<>("Success", "News update deleted successfully", null);
            } catch (Exception e) {
                return new Response<>("Error", "Failed to delete news update: " + e.getMessage(), null);
            }
        } else {
            return new Response<>("Error404", "News update not found", null);
        }
    }


    private String getCloudinaryPublicId(String url) {
        // Extract the public ID from the URL
        String[] parts = url.split("/");
        String publicIdWithExtension = parts[parts.length - 1];
        return publicIdWithExtension.split("\\.")[0];
    }

    // Helper method to format file size
    private String formatFileSize(long sizeInBytes) {
        if (sizeInBytes < 1024) {
            return sizeInBytes + " B";
        } else if (sizeInBytes < 1024 * 1024) {
            return (sizeInBytes / 1024) + " KB";
        } else {
            return (sizeInBytes / (1024 * 1024)) + " MB";
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
