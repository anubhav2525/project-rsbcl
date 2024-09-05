package org.excise.rsbcl.services.actsPolicies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.actsPolicies.ActsPoliciesDAO;
import org.excise.rsbcl.model.actsPolicies.ActsPolicies;
import org.excise.rsbcl.repository.actsPolicies.ActsPoliciesRepo;
import org.excise.rsbcl.services.cloudinary.CloudinaryService;
import org.excise.rsbcl.services.newsUpdates.NewsUpdatesService;
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
public class ActsPoliciesService {
    @Autowired
    private final ActsPoliciesRepo actsPoliciesRepo;
    @Autowired
    private final CloudinaryService cloudinaryService;

    public ActsPoliciesService(ActsPoliciesRepo actsPoliciesRepo, CloudinaryService cloudinaryService) {
        this.actsPoliciesRepo = actsPoliciesRepo;
        this.cloudinaryService = cloudinaryService;
    }

    public Response<List<ActsPolicies>> getActsPoliciesFive(String department) {
        // Find news by department and sort by lastUpdate in descending order
        List<ActsPolicies> latestActs = actsPoliciesRepo.findByDepartment(department.toUpperCase(), Sort.by(Sort.Direction.DESC, "lastUpdate")).stream().limit(5) // Limit to the latest 5 records
                .collect(Collectors.toList());
        if (latestActs.isEmpty())
            return new Response<>("Error", "NO content " + department, latestActs);
        return new Response<>("Success", "Fetched latest 5 records for department: " + department, latestActs);
    }

        // get data as batch of 10 pagination
    public Response<Page<ActsPolicies>> getPaginatedActsPolicies(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<ActsPolicies> actsPoliciesPage = actsPoliciesRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated acts policies", actsPoliciesPage);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch paginated acts policies: " + e.getMessage(), null);
        }
    }

    public Response<ActsPolicies> saveActsPolicies(ActsPoliciesDAO actsPoliciesDAO) {
        try {
            // calculate file size
            long sizeInBytes = actsPoliciesDAO.getDocument().getSize();

            if (sizeInBytes > 50 * 1024 * 1024) {
                return new Response<>("Error", "File size too large. Maximum allowed size is 50MB.", null);
            }

            String fileSize = formatFileSize(sizeInBytes);

            // file upload into cloud
            String documentUrl = cloudinaryService.uploadFileToCloudinary(actsPoliciesDAO.getDocument());

            ActsPolicies actsPolicies = new ActsPolicies();
            actsPolicies.setTitle(actsPoliciesDAO.getTitle());
            actsPolicies.setDescription(actsPoliciesDAO.getDescription());
            actsPolicies.setNewsStatus(actsPoliciesDAO.getNewsStatus());
            actsPolicies.setDepartment(actsPoliciesDAO.getDepartment());
            actsPolicies.setLastUpdate(LocalDate.now());
            actsPolicies.setDocumentLinkUrl(documentUrl);
            actsPolicies.setFileSize(fileSize);

            // saving code
            ActsPolicies saved = actsPoliciesRepo.save(actsPolicies);
            return new Response<>("Saved", "Act saved successfully", saved);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to save act: " + e.getMessage(), null);
        }
    }

    public Response<ActsPolicies> updateActsPolicies(ObjectId id, ActsPoliciesDAO actsPoliciesDAO) {
        Optional<ActsPolicies> existingRecord = actsPoliciesRepo.findById(id);
        if (existingRecord.isPresent()) {
            try {
                ActsPolicies actsPolicies = existingRecord.get();
                actsPolicies.setTitle(actsPoliciesDAO.getTitle().trim());
                actsPolicies.setDescription(actsPoliciesDAO.getDescription().trim());
                actsPolicies.setDepartment(actsPoliciesDAO.getDepartment());
                actsPolicies.setLastUpdate(actsPoliciesDAO.getLastUpdate());
                actsPolicies.setNewsStatus(actsPoliciesDAO.getNewsStatus());

                if (actsPoliciesDAO.getDocument() != null && !actsPoliciesDAO.getDocument().isEmpty()) {
                    // If there's a new document, replace the old one
                    cloudinaryService.deleteFileFromCloudinary(actsPolicies.getDocumentLinkUrl());
                    String documentUrl = cloudinaryService.uploadFileToCloudinary(actsPoliciesDAO.getDocument());
                    actsPolicies.setDocumentLinkUrl(documentUrl);
                }

                actsPoliciesRepo.save(actsPolicies);
                return new Response<>("Success", "Act updated successfully", actsPolicies);
            } catch (Exception e) {
                return new Response<>("Error", "Failed to update act : " + e.getMessage(), null);
            }
        } else {
            return new Response<>("Error404", "Act not found", null);
        }
    }

    public Response<ActsPolicies> deleteActsPolicies(ObjectId id) {
        Optional<ActsPolicies> existingRecord = actsPoliciesRepo.findById(id);
        if (existingRecord.isPresent()) {
            try {
                ActsPolicies actsPolicies = existingRecord.get();
                if (actsPolicies.getDocumentLinkUrl() != null) {
                    String documentPublicId = getCloudinaryPublicId(actsPolicies.getDocumentLinkUrl());
                    cloudinaryService.deleteFileFromCloudinary(documentPublicId);
                }
                actsPoliciesRepo.delete(actsPolicies);
                return new Response<>("Success", "Act and policy deleted successfully", null);
            } catch (Exception e) {
                return new Response<>("Error", "Failed to delete act update: " + e.getMessage(), null);
            }
        } else {
            return new Response<>("Error404", "Act not found", null);
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

