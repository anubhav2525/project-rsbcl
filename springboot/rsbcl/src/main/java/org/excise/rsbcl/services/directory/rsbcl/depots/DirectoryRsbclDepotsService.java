package org.excise.rsbcl.services.directory.rsbcl.depots;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsbcl.depots.DirectoryRsbclDepots;
import org.excise.rsbcl.repository.directory.rsbcl.depots.DirectoryRsbclDepotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectoryRsbclDepotsService {
    @Autowired
    private DirectoryRsbclDepotsRepo directoryRsbclDepotsRepo;

    public Response<List<DirectoryRsbclDepots>> getAll() {
        try {
            List<DirectoryRsbclDepots> directoryRsbclDepots = directoryRsbclDepotsRepo.findAll();
            if (directoryRsbclDepots.isEmpty()) return new Response<>("Error404", "No content", null);
            return new Response<>("Success", "Directories found", directoryRsbclDepots);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsbclDepots> getDepotsById(ObjectId id) {
        try {
            DirectoryRsbclDepots directoryRsbclDepots = directoryRsbclDepotsRepo.findById(id).orElse(null);
            if (directoryRsbclDepots == null) return new Response<>("Error404", "Directory not found", null);
            return new Response<>("Success", "Directory found", directoryRsbclDepots);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsbclDepots> saveDepot(DirectoryRsbclDepots directoryRsbclDepots) {
        try {
            DirectoryRsbclDepots oldDepots = directoryRsbclDepotsRepo.findByEmail(directoryRsbclDepots.getEmail()).orElse(null);
            if (oldDepots != null)
                return new Response<>("Error208", "Depot already saved using email, email address should be unique.", directoryRsbclDepots);
            directoryRsbclDepots.setLastUpdated(LocalDateTime.now());
            DirectoryRsbclDepots savedDepots = directoryRsbclDepotsRepo.save(directoryRsbclDepots);
            return new Response<>("Success", "Directory added", savedDepots);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<List<DirectoryRsbclDepots>> saveDepots(List<DirectoryRsbclDepots> directoryRsbclDepots) {
        try {
            List<DirectoryRsbclDepots> lists = new ArrayList<>();
            for (DirectoryRsbclDepots newData : directoryRsbclDepots) {
                newData.setLastUpdated(LocalDateTime.now());
                lists.add(newData);
            }
            List<DirectoryRsbclDepots> saved = directoryRsbclDepotsRepo.saveAll(lists);
            return new Response<>("Success", "Depots saved successfully", saved);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsbclDepots> updateDepot(ObjectId id, DirectoryRsbclDepots directoryRsbclDepots) {
        try {

            DirectoryRsbclDepots oldDirectoryRsbclDepots = directoryRsbclDepotsRepo.findById(id).orElse(null);
            if (oldDirectoryRsbclDepots == null) return new Response<>("Error404", "Depot not found", null);
            // setting and updating oldDirectory
            oldDirectoryRsbclDepots.setSno((directoryRsbclDepots.getSno() != 0 && directoryRsbclDepots.getSno() != oldDirectoryRsbclDepots.getSno()) ? directoryRsbclDepots.getSno() : oldDirectoryRsbclDepots.getSno());
            oldDirectoryRsbclDepots.setDepotName(directoryRsbclDepots.getDepotName());
            oldDirectoryRsbclDepots.setLastUpdated(LocalDateTime.now());
            oldDirectoryRsbclDepots.setAddress(directoryRsbclDepots.getAddress());
            oldDirectoryRsbclDepots.setEmail(directoryRsbclDepots.getEmail());
            oldDirectoryRsbclDepots.setMobileNo(directoryRsbclDepots.getMobileNo());
            oldDirectoryRsbclDepots.setPhoneNo(directoryRsbclDepots.getPhoneNo());
            directoryRsbclDepotsRepo.save(oldDirectoryRsbclDepots);
            return new Response<>("Success", "Deport updated successfully", oldDirectoryRsbclDepots);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteById(ObjectId id) {
        try {
            DirectoryRsbclDepots directoryRsbclDepots = directoryRsbclDepotsRepo.findById(id).orElse(null);
            if (directoryRsbclDepots == null) return new Response<>("Error404", "Depot not found", null);
            directoryRsbclDepotsRepo.deleteById(id);
            return new Response<>("Success", "Depot deleted successfully", null);
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
