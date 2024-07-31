package org.excise.rsbcl.services.about.excise.introduction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.excise.rsbcl.model.about.excise.introduction.AboutExciseIntroduction;
import org.excise.rsbcl.repository.about.excise.introduction.AboutExciseIntroductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutExciseIntroductionService {
    @Autowired
    private AboutExciseIntroductionRepo aboutExciseIntroductionRepo;

    public Response<List<AboutExciseIntroduction>> getAll() {
        try {
            List<AboutExciseIntroduction> aboutExciseIntroductionList = aboutExciseIntroductionRepo.findAll();
            if (aboutExciseIntroductionList.isEmpty()) return new Response<>("Error404", "Intro. not found", null);
            return new Response<>("Success", "Intro. found", aboutExciseIntroductionList);
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
