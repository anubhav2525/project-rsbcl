package org.excise.rsbcl.services.about.rsbcl.introduction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.excise.rsbcl.model.about.rsbcl.introduction.AboutRsbclIntroduction;
import org.excise.rsbcl.repository.about.rsbcl.introduction.AboutRsbclIntroductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsbclIntroductionService {
    @Autowired
    private AboutRsbclIntroductionRepo aboutRsbclIntroductionRepo;

    public Response<List<AboutRsbclIntroduction>> getAll() {
        try {
            List<AboutRsbclIntroduction> aboutRsbclIntroductions = aboutRsbclIntroductionRepo.findAll();
            if (aboutRsbclIntroductions.isEmpty()) return new Response<>("Error404", "Intro not found", null);
            return new Response<>("Success", "Intro found", aboutRsbclIntroductions);
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
