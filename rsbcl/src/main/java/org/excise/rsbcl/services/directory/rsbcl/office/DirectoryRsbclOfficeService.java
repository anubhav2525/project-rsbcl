package org.excise.rsbcl.services.directory.rsbcl.office;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsbcl.office.DirectoryRsbclOffice;
import org.excise.rsbcl.repository.directory.rsbcl.office.DirectoryRsbclOfficeRepo;
import org.excise.rsbcl.services.directory.excise.office.DirectoryExciseOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectoryRsbclOfficeService {
    @Autowired
    private DirectoryRsbclOfficeRepo directoryRsbclOfficeRepo;

    public Response<Page<DirectoryRsbclOffice>> getPaginatedDirectoryRSBCLOffice(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<DirectoryRsbclOffice> directoryRsbclOffices = directoryRsbclOfficeRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated rsbcl offices", directoryRsbclOffices);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsbclOffice> getOfficeById(ObjectId id) {
        try {
            DirectoryRsbclOffice directoryRsbclOffice = directoryRsbclOfficeRepo.findById(id).orElse(null);
            if (directoryRsbclOffice == null) return new Response<>("Error404", "Directory not found", null);
            return new Response<>("Success", "Directory found", directoryRsbclOffice);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsbclOffice> saveDirectory(DirectoryRsbclOffice directoryRsbclOffice) {
        try {
            DirectoryRsbclOffice oldDirectory = directoryRsbclOfficeRepo.findByEmail(directoryRsbclOffice.getEmail()).orElse(null);
            if (oldDirectory != null)
                return new Response<>("Error208", "Directory already saved using email, email address should be unique.", directoryRsbclOffice);
            directoryRsbclOffice.setLastUpdated(LocalDateTime.now());
            DirectoryRsbclOffice saved = directoryRsbclOfficeRepo.save(directoryRsbclOffice);
            return new Response<>("Success", "Directory added", saved);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    @Transactional
    public Response<List<DirectoryRsbclOffice>> saveDirectories(List<DirectoryRsbclOffice> directoryRsbclOffices) {
        try {
            List<DirectoryRsbclOffice> lists = new ArrayList<>();
            for (DirectoryRsbclOffice newData : directoryRsbclOffices) {
                newData.setLastUpdated(LocalDateTime.now());
                lists.add(newData);
            }

            // save depots one by one
            boolean status = false;

            // error list
            List<DirectoryRsbclOffice> errorData = new ArrayList<>();
            for (DirectoryRsbclOffice directory : directoryRsbclOffices) {
                Response<DirectoryRsbclOffice> response = saveDirectory(directory);
                if (!(response.getStatus().equals("Success"))) {
                    status = true;
                    errorData.add(directory);
                }
            }
            if (status) return new Response<>("Error", "Data has error", errorData);
            return new Response<>("Success", "Data's saved", lists);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<DirectoryRsbclOffice> updateDepotById(ObjectId id, DirectoryRsbclOffice directoryRsbclOffice) {
        try {
            DirectoryRsbclOffice oldData = directoryRsbclOfficeRepo.findById(id).orElse(null);
            if (oldData == null) return new Response<>("Error404", "Directory not found", null);
            // setting and updating oldDirectory
            oldData.setSno((directoryRsbclOffice.getSno() != 0 && directoryRsbclOffice.getSno() != oldData.getSno()) ? directoryRsbclOffice.getSno() : oldData.getSno());
            oldData.setLastUpdated(LocalDateTime.now());
            oldData.setName((directoryRsbclOffice.getName() != null && !directoryRsbclOffice.getName().equals(oldData.getName())) ? directoryRsbclOffice.getName() : oldData.getName());
            oldData.setEmail((directoryRsbclOffice.getEmail() != null && !directoryRsbclOffice.getEmail().equals(oldData.getEmail())) ? directoryRsbclOffice.getEmail() : oldData.getEmail());
            oldData.setDesignation((directoryRsbclOffice.getDesignation() != null && !directoryRsbclOffice.getDesignation().equals(oldData.getDesignation())) ? directoryRsbclOffice.getDesignation() : oldData.getDesignation());
            oldData.setPhoneNo((directoryRsbclOffice.getPhoneNo() != null && !directoryRsbclOffice.getPhoneNo().equals(oldData.getPhoneNo())) ? directoryRsbclOffice.getPhoneNo() : oldData.getPhoneNo());
            oldData.setMobileNo((directoryRsbclOffice.getMobileNo() != null && !directoryRsbclOffice.getMobileNo().equals(oldData.getMobileNo())) ? directoryRsbclOffice.getMobileNo() : oldData.getMobileNo());
            // save data into db
            directoryRsbclOfficeRepo.save(oldData);
            return new Response<>("Success", "Directory updated successfully", oldData);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<Void> deleteById(ObjectId id) {
        try {
            DirectoryRsbclOffice directoryRsbclOffice = directoryRsbclOfficeRepo.findById(id).orElse(null);
            if (directoryRsbclOffice == null) return new Response<>("Error404", "Directory not found", null);
            directoryRsbclOfficeRepo.deleteById(id);
            return new Response<>("Success", "Directory deleted successfully", null);
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
