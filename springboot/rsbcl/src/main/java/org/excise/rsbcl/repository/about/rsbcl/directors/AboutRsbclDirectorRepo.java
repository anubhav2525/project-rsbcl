package org.excise.rsbcl.repository.about.rsbcl.directors;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsbcl.directors.AboutRsbclDirector;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AboutRsbclDirectorRepo extends MongoRepository<AboutRsbclDirector, ObjectId> {
    Optional<AboutRsbclDirector> findByEmail(String email);
}
