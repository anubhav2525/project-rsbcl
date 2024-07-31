package org.excise.rsbcl.services.directory.rsgsm.reductionCenters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.excise.rsbcl.repository.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DirectoryRsgsmReductionCenterService {
    @Autowired
    private DirectoryRsgsmReductionCenterRepo directoryRsgsmReductionCenterRepo;

    public Response<List<DirectoryRsgsmReductionCenter>> getAll() {
        try {
            List<DirectoryRsgsmReductionCenter> directoryRsgsmReductionCenters = directoryRsgsmReductionCenterRepo.findAll();
            if (directoryRsgsmReductionCenters.isEmpty()) return new Response<>("Error404", "No content", null);
            return new Response<>("Success", "Content found", directoryRsgsmReductionCenters);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmReductionCenter> getById(ObjectId id) {
        try {
            DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter = directoryRsgsmReductionCenterRepo.findById(id).orElse(null);
            if (directoryRsgsmReductionCenter == null) return new Response<>("Error404", "No content", null);
            return new Response<>("Success", "Content found", directoryRsgsmReductionCenter);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmReductionCenter> save(DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter) {
        try {
            DirectoryRsgsmReductionCenter oldData = directoryRsgsmReductionCenterRepo.findByEmail(directoryRsgsmReductionCenter.getEmail()).orElse(null);
            if (oldData != null) return new Response<>("Error208", "Content already saved by this email id", oldData);
            directoryRsgsmReductionCenter.setLastUpdate(LocalDateTime.now());
            directoryRsgsmReductionCenterRepo.save(directoryRsgsmReductionCenter);
            return new Response<>("Success", "Saved successfully", directoryRsgsmReductionCenter);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmReductionCenter> updateById(ObjectId id, DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter) {
        try {
            DirectoryRsgsmReductionCenter oldData = directoryRsgsmReductionCenterRepo.findById(id).orElse(null);
            if (oldData == null) return new Response<>("Error404", "No content, data not exists", null);
            oldData.setRcName((directoryRsgsmReductionCenter.getRcName() != null && !directoryRsgsmReductionCenter.getRcName().equals(oldData.getRcName())) ? directoryRsgsmReductionCenter.getRcName() : oldData.getRcName());
            oldData.setEmail((directoryRsgsmReductionCenter.getEmail() != null && !directoryRsgsmReductionCenter.getEmail().equals(oldData.getEmail())) ? directoryRsgsmReductionCenter.getEmail() : oldData.getEmail());
            oldData.setSno((directoryRsgsmReductionCenter.getSno() != 0 && !(directoryRsgsmReductionCenter.getSno() == oldData.getSno())) ? directoryRsgsmReductionCenter.getSno() : oldData.getSno());
            oldData.setLastUpdate(LocalDateTime.now());
            directoryRsgsmReductionCenterRepo.save(directoryRsgsmReductionCenter);
            return new Response<>("Success", "Content updated", oldData);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmReductionCenter> updateByEmail(String email, DirectoryRsgsmReductionCenter directoryRsgsmReductionCenter) {
        try {
            DirectoryRsgsmReductionCenter oldData = directoryRsgsmReductionCenterRepo.findByEmail(email).orElse(null);
            if (oldData == null) return new Response<>("Error404", "No content, data not exists", null);
            oldData.setRcName((directoryRsgsmReductionCenter.getRcName() != null && !directoryRsgsmReductionCenter.getRcName().equals(oldData.getRcName())) ? directoryRsgsmReductionCenter.getRcName() : oldData.getRcName());
            oldData.setEmail((directoryRsgsmReductionCenter.getEmail() != null && !directoryRsgsmReductionCenter.getEmail().equals(oldData.getEmail())) ? directoryRsgsmReductionCenter.getEmail() : oldData.getEmail());
            oldData.setSno((directoryRsgsmReductionCenter.getSno() != 0 && !(directoryRsgsmReductionCenter.getSno() == oldData.getSno())) ? directoryRsgsmReductionCenter.getSno() : oldData.getSno());
            oldData.setLastUpdate(LocalDateTime.now());
            directoryRsgsmReductionCenterRepo.save(directoryRsgsmReductionCenter);
            return new Response<>("Success", "Content updated", oldData);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteById(ObjectId id) {
        try {
            DirectoryRsgsmReductionCenter oldData = directoryRsgsmReductionCenterRepo.findById(id).orElse(null);
            if (oldData == null) return new Response<>("Error404", "No content, data not exists", null);
            directoryRsgsmReductionCenterRepo.deleteById(id);
            return new Response<>("Success", "Content updated", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteByEmail(String email) {
        try {
            DirectoryRsgsmReductionCenter oldData = directoryRsgsmReductionCenterRepo.findByEmail(email).orElse(null);
            if (oldData == null) return new Response<>("Error404", "No content, data not exists", null);
            directoryRsgsmReductionCenterRepo.deleteById(oldData.getId());
            return new Response<>("Success", "Content updated", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    // Response static class
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
