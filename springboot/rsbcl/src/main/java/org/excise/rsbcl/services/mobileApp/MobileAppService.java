package org.excise.rsbcl.services.mobileApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.mobileApp.MobileApp;
import org.excise.rsbcl.repository.mobileApp.MobileAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MobileAppService {
    @Autowired
    private final MobileAppRepo mobileAppRepo;

    public MobileAppService(MobileAppRepo mobileAppRepo) {
        this.mobileAppRepo = mobileAppRepo;
    }

    public Response<List<MobileApp>> getMobileApps() {
        try {
            List<MobileApp> mobileApps = mobileAppRepo.findAll();
            if (mobileApps.isEmpty()) {
                return new Response<>("Error", "Mobile Apps not found", null);
            } else {
                return new Response<>("Success", "Mobile apps found", mobileApps);
            }
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

    public Response<MobileApp> saveMobileApp(MobileApp mobileApp) {
        try {
            MobileApp oldMobileApp = mobileAppRepo.findByAppName(mobileApp.getAppName()).orElse(null);
            if (oldMobileApp != null) {
                mobileApp.setLastUpdate(LocalDateTime.now());
                MobileApp savedApp = mobileAppRepo.save(mobileApp);
                return new Response<>("Success", "Mobile app saved successfully", savedApp);
            } else {
                return new Response<>("Error208", "This Mobile App already exists !!", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

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
                existingMobileApp.setStatus(mobileApp.isStatus());
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

    public Response<Void> deleteMobileApp(ObjectId id) {
        try {
            Optional<MobileApp> existingMobileApp = mobileAppRepo.findById(id);
            if (existingMobileApp.isPresent()) {
                mobileAppRepo.deleteById(id);
                return new Response<>("Success", "Mobile app deleted successfully", null);
            } else {
                return new Response<>("Error", "Mobile App not found", null);
            }
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
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
