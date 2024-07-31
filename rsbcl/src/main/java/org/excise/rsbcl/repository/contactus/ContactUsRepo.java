package org.excise.rsbcl.repository.contactus;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.contactUs.ContactUs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactUsRepo extends MongoRepository<ContactUs, ObjectId> {
    Optional<ContactUs> findByBranch(String branch);
}
