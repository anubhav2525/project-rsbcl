package org.excise.rsbcl.services.about.rsbcl.directors;

import org.excise.rsbcl.model.about.rsbcl.directors.AboutRsbclDirector;
import org.excise.rsbcl.repository.about.rsbcl.directors.AboutRsbclDirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutRsbclDirectorService {
    @Autowired
    private AboutRsbclDirectorRepo aboutRsbclDirectorRepo;

    public List<AboutRsbclDirector> getAll(){
        return aboutRsbclDirectorRepo.findAll();
    }
}
