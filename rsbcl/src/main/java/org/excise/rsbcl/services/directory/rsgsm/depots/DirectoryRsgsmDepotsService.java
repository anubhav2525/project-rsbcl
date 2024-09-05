package org.excise.rsbcl.services.directory.rsgsm.depots;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.excise.rsbcl.repository.directory.rsgsm.depots.DirectoryRsgsmDepotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DirectoryRsgsmDepotsService {
    @Autowired
    private DirectoryRsgsmDepotsRepo directoryRsgsmDepotsRepo;

    public Response<Page<DirectoryRsgsmDepots>> getPaginatedDirectoryRSGSMDepots(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<DirectoryRsgsmDepots> directoryRsgsmDepots = directoryRsgsmDepotsRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated rsgsm depots", directoryRsgsmDepots);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmDepots> getById(ObjectId id) {
        try {
            DirectoryRsgsmDepots directoryRsgsmDepot = directoryRsgsmDepotsRepo.findById(id).orElse(null);
            if (directoryRsgsmDepot == null) return new Response<>("Error404", "No content", null);
            return new Response<>("Success", "Content found", directoryRsgsmDepot);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmDepots> saveDirectory(DirectoryRsgsmDepots directoryRsgsmDepots) {
        try {
            DirectoryRsgsmDepots directoryRsgsmDepot = directoryRsgsmDepotsRepo.save(directoryRsgsmDepots);
            return new Response<>("Success", "Data saved", directoryRsgsmDepot);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsgsmDepots> updateById(ObjectId id, DirectoryRsgsmDepots directoryRsgsmDepots) {
        try {
            DirectoryRsgsmDepots oldData = directoryRsgsmDepotsRepo.findById(id).orElse(null);
            if (oldData == null) return new Response<>("Error404", "Content not found", null);
            oldData.setLastUpdate(LocalDateTime.now());
            directoryRsgsmDepotsRepo.save(oldData);
            return new Response<>("Success", "Data updated", oldData);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteById(ObjectId id) {
        try {
            DirectoryRsgsmDepots directoryRsgsmDepots = directoryRsgsmDepotsRepo.findById(id).orElse(null);
            if (directoryRsgsmDepots == null) return new Response<>("Error404", "Data not found", null);
            directoryRsgsmDepotsRepo.deleteById(id);
            return new Response<>("Success", "Data removed", null);
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
