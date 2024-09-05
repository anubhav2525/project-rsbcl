package org.excise.rsbcl.services.mobileApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.mobileApp.MobileAppDao;
import org.excise.rsbcl.model.mobileApp.MobileApp;
import org.excise.rsbcl.repository.mobileApp.MobileAppRepo;
import org.excise.rsbcl.services.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MobileAppService {
    @Autowired
    private final MobileAppRepo mobileAppRepo;
    @Autowired
    private final CloudinaryService cloudinaryService;

    public MobileAppService(MobileAppRepo mobileAppRepo, CloudinaryService cloudinaryService) {
        this.mobileAppRepo = mobileAppRepo;
        this.cloudinaryService = cloudinaryService;
    }

    public Response<List<MobileApp>> getMobileApps() {
        try {
            List<MobileApp> mobileApps = mobileAppRepo.findAll();
            if (mobileApps.isEmpty()) {
                return new Response<>("Error404", "Mobile Apps not found", null);
            } else {
                return new Response<>("Success", "Mobile apps found", mobileApps);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Page<MobileApp>> getPaginatedMobileApps(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<MobileApp> mobileAppPage = mobileAppRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated mobile apps", mobileAppPage);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch paginated mobile apps: " + e.getMessage(), null);
        }
    }

    public Response<MobileApp> getMobileAppByName(String name) {
        try {
            MobileApp mobileApp = mobileAppRepo.findByAppName(name).orElse(null);
            if (mobileApp != null) return new Response<>("Success", "Mobile App found", mobileApp);
            return new Response<>("Error404", "Mobile app not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<MobileApp> getMobileAppById(ObjectId id) {
        try {
            MobileApp mobileApp = mobileAppRepo.findById(id).orElse(null);
            if (mobileApp != null) return new Response<>("Success", "Mobile App found", mobileApp);
            return new Response<>("Error404", "Mobile app not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<MobileApp> saveMobileApp(MobileAppDao mobileAppDao) {
        try {
            MobileApp oldMobileApp = mobileAppRepo.findByAppName(mobileAppDao.getAppName()).orElse(null);
            if (oldMobileApp == null) {
                // Upload files to Cloudinary and get the links
                String documentLink = cloudinaryService.uploadFileToCloudinary(mobileAppDao.getDocument());
                String videoLink = cloudinaryService.uploadFileToCloudinary(mobileAppDao.getVideo());
                String applicationImageLink = cloudinaryService.uploadFileToCloudinary(mobileAppDao.getApplicationImage());

                // Create new MobileApp entity
                MobileApp newMobileApp = new MobileApp();
                newMobileApp.setAppName(mobileAppDao.getAppName());
                newMobileApp.setDescription(mobileAppDao.getDescription());
                newMobileApp.setLink(mobileAppDao.getLink());
                newMobileApp.setSuggestion(mobileAppDao.getSuggestion());
                newMobileApp.setVersion(mobileAppDao.getVersion().toLowerCase());
                newMobileApp.setDocumentLink(documentLink);
                newMobileApp.setApplicationImageLink(applicationImageLink);
                newMobileApp.setVideoLink(videoLink);
                newMobileApp.setStatus(mobileAppDao.getStatus());
                newMobileApp.setLastUpdate(LocalDateTime.now());
                MobileApp savedApp = mobileAppRepo.save(newMobileApp);
                return new Response<>("Saved", "Mobile app saved successfully", savedApp);
            } else {
                return new Response<>("Error208", "This Mobile App already exists !!", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<List<MobileApp>> saveMobileApps(List<MobileApp> mobileApps) {
        try {
            List<MobileApp> mobileAppList = new ArrayList<>();
            for (MobileApp mobileApp : mobileApps) {
                mobileApp.setLastUpdate(LocalDateTime.now());
                mobileAppList.add(mobileApp);
            }
            List<MobileApp> savedApps = mobileAppRepo.saveAll(mobileAppList);
            return new Response<>("Success", "Mobile apps saved successfully", savedApps);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<MobileApp> updateMobileApp(ObjectId id, MobileApp mobileApp) {
        try {
            MobileApp existingMobileApp = mobileAppRepo.findById(id).orElse(null);
            if (existingMobileApp != null) {
                existingMobileApp.setAppName((mobileApp.getAppName() != null && !mobileApp.getAppName().equals(existingMobileApp.getAppName()) ? mobileApp.getAppName() : existingMobileApp.getAppName()));
                existingMobileApp.setVersion((mobileApp.getVersion() != null && !mobileApp.getVersion().equals(existingMobileApp.getVersion()) ? mobileApp.getVersion() : existingMobileApp.getVersion()));
                existingMobileApp.setLink((mobileApp.getLink() != null && !mobileApp.getLink().equals(existingMobileApp.getLink()) ? mobileApp.getLink() : existingMobileApp.getLink()));
                existingMobileApp.setDescription((mobileApp.getDescription() != null && !mobileApp.getDescription().equals(existingMobileApp.getDescription()) ? mobileApp.getDescription() : existingMobileApp.getDescription()));
                existingMobileApp.setSuggestion((mobileApp.getSuggestion() != null && !mobileApp.getSuggestion().equals(existingMobileApp.getSuggestion()) ? mobileApp.getSuggestion() : existingMobileApp.getSuggestion()));
                existingMobileApp.setDocumentLink((mobileApp.getDocumentLink() != null && !mobileApp.getDocumentLink().equals(existingMobileApp.getDocumentLink()) ? mobileApp.getDocumentLink() : existingMobileApp.getDocumentLink()));
                existingMobileApp.setVideoLink((mobileApp.getVideoLink() != null && !mobileApp.getVideoLink().equals(existingMobileApp.getVideoLink()) ? mobileApp.getVideoLink() : existingMobileApp.getVideoLink()));
                existingMobileApp.setStatus(mobileApp.getStatus());
                existingMobileApp.setLastUpdate(LocalDateTime.now());
                mobileAppRepo.save(existingMobileApp);
                return new Response<>("Success", "Mobile app updated successfully", existingMobileApp);
            } else {
                return new Response<>("Error404", "Mobile App not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<Void> deleteMobileApp(ObjectId id) {
        try {
            MobileApp oldMobileApp = mobileAppRepo.findById(id).orElse(null);
            if (oldMobileApp != null) {
                // Delete files from Cloudinary
                if (oldMobileApp.getDocumentLink() != null) {
                    String documentPublicId = getCloudinaryPublicId(oldMobileApp.getDocumentLink());
                    cloudinaryService.deleteFileFromCloudinary(documentPublicId);
                }
                if (oldMobileApp.getVideoLink() != null) {
                    String videoPublicId = getCloudinaryPublicId(oldMobileApp.getVideoLink());
                    cloudinaryService.deleteFileFromCloudinary(videoPublicId);
                }
                if (oldMobileApp.getApplicationImageLink() != null) {
                    String applicationPublicId = getCloudinaryPublicId(oldMobileApp.getApplicationImageLink());
                    cloudinaryService.deleteFileFromCloudinary(applicationPublicId);
                }
                // Delete the mobile app from the database
                mobileAppRepo.deleteById(id);
                return new Response<>("Success", "Mobile app deleted successfully", null);
            } else {
                return new Response<>("Error404", "Mobile app not found", null);
            }
        } catch (IOException e) {
            return new Response<>("Error", "Failed to delete files from Cloudinary: " + e.getMessage(), null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    private String getCloudinaryPublicId(String url) {
        // Extract the public ID from the URL
        String[] parts = url.split("/");
        String publicIdWithExtension = parts[parts.length - 1];
        return publicIdWithExtension.split("\\.")[0];
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
