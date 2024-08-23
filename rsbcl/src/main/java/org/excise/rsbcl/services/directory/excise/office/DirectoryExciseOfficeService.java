package org.excise.rsbcl.services.directory.excise.office;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.actsPolicies.ActsPolicies;
import org.excise.rsbcl.model.directory.excise.office.DirectoryExciseOffice;
import org.excise.rsbcl.repository.directory.excise.office.DirectoryExciseOfficeRepo;
import org.excise.rsbcl.services.actsPolicies.ActsPoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectoryExciseOfficeService {
    @Autowired
    private DirectoryExciseOfficeRepo directoryExciseOfficeRepo;

    public Response<Page<DirectoryExciseOffice>> getPaginatedDirectoryExcise(int page,int size){
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<DirectoryExciseOffice> directoryExciseOfficePage = directoryExciseOfficeRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated acts policies", directoryExciseOfficePage);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch paginated acts policies: " + e.getMessage(), null);
        }
    }

    public Response<DirectoryExciseOffice> getDirectoryById(ObjectId id) {
        try {
            DirectoryExciseOffice directoryExciseOffice = directoryExciseOfficeRepo.findById(id).orElse(null);
            if (directoryExciseOffice == null) return new Response<>("Error404", "Directories not found", null);
            return new Response<>("Success", "Directory found", directoryExciseOffice);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryExciseOffice> saveDirectory(DirectoryExciseOffice directoryExciseOffice) {
        try {
            DirectoryExciseOffice oldDirectory = directoryExciseOfficeRepo.findByEmail(directoryExciseOffice.getEmail()).orElse(null);
            if (oldDirectory != null)
                return new Response<>("Error208", "Directory already saved using email, email address should be unique.", directoryExciseOffice);
            directoryExciseOffice.setLastUpdate(LocalDateTime.now());
            DirectoryExciseOffice savedDirectory = directoryExciseOfficeRepo.save(directoryExciseOffice);
            return new Response<>("Success", "Directory added", savedDirectory);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<List<DirectoryExciseOffice>> saveDirectories(List<DirectoryExciseOffice> directoryExciseOffices) {
        try {
            List<DirectoryExciseOffice> directoryExciseOffices1 = new ArrayList<>();
            for (DirectoryExciseOffice newDirectory : directoryExciseOffices) {
                newDirectory.setLastUpdate(LocalDateTime.now());
                directoryExciseOffices1.add(newDirectory);
            }
            List<DirectoryExciseOffice> savedDirectory = directoryExciseOfficeRepo.saveAll(directoryExciseOffices1);
            return new Response<>("Success", "Directories saved successfully", savedDirectory);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryExciseOffice> updateDirectory(ObjectId id, DirectoryExciseOffice directoryExciseOffice) {
        try {

            DirectoryExciseOffice oldDirectoryExciseOffice = directoryExciseOfficeRepo.findById(id).orElse(null);
            if (oldDirectoryExciseOffice == null) return new Response<>("Error404", "Directory not found", null);
            // setting and updating oldDirectory
            oldDirectoryExciseOffice.setSno((directoryExciseOffice.getSno() != 0 && directoryExciseOffice.getSno() != oldDirectoryExciseOffice.getSno()) ? directoryExciseOffice.getSno() : oldDirectoryExciseOffice.getSno());
            oldDirectoryExciseOffice.setName((directoryExciseOffice.getName() != null && !directoryExciseOffice.getName().equals(oldDirectoryExciseOffice.getName())) ? directoryExciseOffice.getName() : oldDirectoryExciseOffice.getName());
            oldDirectoryExciseOffice.setDesignation((directoryExciseOffice.getDesignation() != null && !directoryExciseOffice.getDesignation().equals(oldDirectoryExciseOffice.getDesignation())) ? directoryExciseOffice.getDesignation() : oldDirectoryExciseOffice.getDesignation());
            oldDirectoryExciseOffice.setMobileNo((directoryExciseOffice.getMobileNo() != null && !directoryExciseOffice.getMobileNo().equals(oldDirectoryExciseOffice.getMobileNo())) ? directoryExciseOffice.getMobileNo() : oldDirectoryExciseOffice.getMobileNo());
            oldDirectoryExciseOffice.setStdCode((directoryExciseOffice.getStdCode() != null && !directoryExciseOffice.getStdCode().equals(oldDirectoryExciseOffice.getStdCode())) ? directoryExciseOffice.getStdCode() : oldDirectoryExciseOffice.getStdCode());
            oldDirectoryExciseOffice.setOfficeAddress((directoryExciseOffice.getOfficeAddress() != null && !directoryExciseOffice.getOfficeAddress().equals(oldDirectoryExciseOffice.getOfficeAddress())) ? directoryExciseOffice.getOfficeAddress() : oldDirectoryExciseOffice.getOfficeAddress());
            oldDirectoryExciseOffice.setFaxNo((directoryExciseOffice.getFaxNo() != null && !directoryExciseOffice.getFaxNo().equals(oldDirectoryExciseOffice.getFaxNo())) ? directoryExciseOffice.getFaxNo() : oldDirectoryExciseOffice.getFaxNo());
            oldDirectoryExciseOffice.setEmail((directoryExciseOffice.getEmail() != null && !directoryExciseOffice.getEmail().equals(oldDirectoryExciseOffice.getEmail())) ? directoryExciseOffice.getEmail() : oldDirectoryExciseOffice.getEmail());
            oldDirectoryExciseOffice.setLastUpdate(LocalDateTime.now());
            directoryExciseOfficeRepo.save(oldDirectoryExciseOffice);
            return new Response<>("Success", "Directory updated successfully", oldDirectoryExciseOffice);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteById(ObjectId id) {
        try {
            DirectoryExciseOffice directoryExciseOffice = directoryExciseOfficeRepo.findById(id).orElse(null);
            if (directoryExciseOffice == null) return new Response<>("Error404", "Directory not found", null);
            directoryExciseOfficeRepo.deleteById(id);
            return new Response<>("Success", "Directory deleted successfully", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    // Response static class
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response<T> {
        private String status;
        private String message;
        private T data;
    }
}
