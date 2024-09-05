package org.excise.rsbcl.services.inFocus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.inFocus.InFocus;
import org.excise.rsbcl.repository.inFocus.InFocusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InFocusService {
    @Autowired
    private final InFocusRepo inFocusRepo;

    public InFocusService(InFocusRepo inFocusRepo) {
        this.inFocusRepo = inFocusRepo;
    }

    // get all
    public Response<List<InFocus>> getAll() {
        try {
            List<InFocus> latestInFoucs = inFocusRepo.findAll(Sort.by(Sort.Direction.DESC, "lastUpdate")).stream().toList();
            return new Response<>("Success", "Fetched latest focuses", latestInFoucs);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch focuses: " + e.getMessage(), null);
        }
    }

    public Response<Page<InFocus>> getAllInfousPage(int page, int size) {
        try {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<InFocus> inFocusPage = inFocusRepo.findAll(pageRequest);
            return new Response<>("Success", "Fetched paginated acts policies", inFocusPage);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch paginated acts policies: " + e.getMessage(), null);
        }
    }

    // get by id
    public Response<Optional<InFocus>> getInFocusById(ObjectId id) {
        try {
            Optional<InFocus> inFocusOptional = inFocusRepo.findById(id);
            if (inFocusOptional.isEmpty()) return new Response<>("Error404", "No content", null);
            return new Response<>("Success", "Data found", inFocusOptional);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to fetch news updates: " + e.getMessage(), null);
        }
    }

    // save
    public Response<InFocus> saveInFocus(InFocus inFocus) {
        try {
            // saving code
            inFocus.setLastUpdate(LocalDateTime.now());
            InFocus saved = inFocusRepo.save(inFocus);
            return new Response<>("Saved", "InFocus saved successfully", saved);
        } catch (Exception e) {
            return new Response<>("Error", "Failed to save InFocus: " + e.getMessage(), null);
        }
    }

    // update using id
    public Response<InFocus> updateInFocusById(ObjectId id, InFocus inFocus) {
        Optional<InFocus> existingRecord = inFocusRepo.findById(id);
        if (existingRecord.isPresent()) {
            try {
                InFocus existingInFocus = existingRecord.get();
                existingInFocus.setTitle(inFocus.getTitle());
                existingInFocus.setLinks(inFocus.getLinks());
                existingInFocus.setStatus(inFocus.getStatus());
                existingInFocus.setLastUpdate(LocalDateTime.now());
                inFocusRepo.save(existingInFocus);
                return new Response<>("Success", "InFocus updated successfully", existingInFocus);
            } catch (Exception e) {
                return new Response<>("Error", "Failed to update InFocus: " + e.getMessage(), null);
            }
        } else {
            return new Response<>("Error404", "InFocus not found", null);
        }
    }

    // delete using id
    public Response<InFocus> deleteInFocusById(ObjectId id) {
        Optional<InFocus> existingRecord = inFocusRepo.findById(id);
        if (existingRecord.isPresent()) {
            try {
                inFocusRepo.deleteById(id);
                return new Response<>("Success", "InFocus deleted successfully", null);
            } catch (Exception e) {
                return new Response<>("Error", "Failed to delete InFocus: " + e.getMessage(), null);
            }
        } else {
            return new Response<>("Error404", "InFocus not found", null);
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
