package org.excise.rsbcl.services.directory.rsgsm.reductionCenters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.excise.rsbcl.repository.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectoryRsgsmReductionCenterService {
    @Autowired
    private DirectoryRsgsmReductionCenterRepo directoryRsgsmReductionCenterRepo;

    public Response<Page<DirectoryRsgsmReductionCenter>> getPaginatedDirectoryRSGSMReductionCenter(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<DirectoryRsgsmReductionCenter> directoryRsgsmReductionCenters = directoryRsgsmReductionCenterRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated rsgsm reduction centers", directoryRsgsmReductionCenters);
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

    public Response<List<DirectoryRsgsmReductionCenter>> saveList(List<DirectoryRsgsmReductionCenter> directoryRsgsmReductionCenterList) {
        try {
            List<DirectoryRsgsmReductionCenter> lists = new ArrayList<>();
            for (DirectoryRsgsmReductionCenter newData : directoryRsgsmReductionCenterList) {
                newData.setLastUpdate(LocalDateTime.now());
                lists.add(newData);
            }
            // save depots one by one
            boolean status = false;
            // error list
            List<DirectoryRsgsmReductionCenter> errorData = new ArrayList<>();
            for (DirectoryRsgsmReductionCenter directory : directoryRsgsmReductionCenterList) {
                Response<DirectoryRsgsmReductionCenter> response = save(directory);
                if (!(response.getStatus().equals("Success"))) {
                    status = true;
                    errorData.add(directory);
                }
            }
            if (status) return new Response<>("Error", "Data has error", errorData);
            return new Response<>("Success", "Saved successfully", lists);
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
