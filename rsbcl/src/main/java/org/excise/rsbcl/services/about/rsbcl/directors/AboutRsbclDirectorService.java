package org.excise.rsbcl.services.about.rsbcl.directors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsbcl.directors.AboutRsbclDirector;
import org.excise.rsbcl.repository.about.rsbcl.directors.AboutRsbclDirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AboutRsbclDirectorService {
    @Autowired
    private AboutRsbclDirectorRepo aboutRsbclDirectorRepo;

    public Response<List<AboutRsbclDirector>> getAll() {
        try {
            List<AboutRsbclDirector> aboutRsbclDirectors = aboutRsbclDirectorRepo.findAll();
            if (aboutRsbclDirectors.isEmpty()) return new Response<>("Error404", "Directors not found", null);
            return new Response<>("Success", "Directors found", aboutRsbclDirectors);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }

    }

    public Response<AboutRsbclDirector> getById(ObjectId id) {
        try {
            AboutRsbclDirector aboutRsbclDirector = aboutRsbclDirectorRepo.findById(id).orElse(null);
            if (aboutRsbclDirector != null) return new Response<>("Success", "Director found", aboutRsbclDirector);
            return new Response<>("Error404", "Director not found", null);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }

    public Response<AboutRsbclDirector> saveDirector(AboutRsbclDirector aboutRsbclDirector) {
        try {
            AboutRsbclDirector oldDirector = aboutRsbclDirectorRepo.findByEmail(aboutRsbclDirector.getEmail()).orElse(null);
            if (oldDirector != null)
                return new Response<>("Error208", "Director is added by this email address", aboutRsbclDirector);
            AboutRsbclDirector savedDirector = aboutRsbclDirectorRepo.save(aboutRsbclDirector);
            return new Response<>("Success", "Director saved successfully", savedDirector);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), aboutRsbclDirector);
        }
    }

    @Transactional
    public Response<List<AboutRsbclDirector>> saveDirectors(List<AboutRsbclDirector> aboutRsbclDirectorList) {
        try {
            List<AboutRsbclDirector> errorList= new ArrayList<>();
            for (AboutRsbclDirector aboutRsbclDirector : aboutRsbclDirectorList) {
                AboutRsbclDirectorService.Response<AboutRsbclDirector> response = saveDirector(aboutRsbclDirector);
                if(response.getStatus().equals("Error") || response.getStatus().equals("Error208")) {
                    errorList.add(response.getData());
                }
            }
            if(errorList.isEmpty()) return new Response<>("Success","All records saved successfully",aboutRsbclDirectorList);
            return new Response<>("Error","Error while creating the records please check and resubmit.",errorList);
        } catch (Exception e) {
            return new Response<>("Error", e.getMessage(), null);
        }
    }


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
