package org.excise.rsbcl.repository.directory.rsgsm.reductionCenters;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.reductionCenters.DirectoryRsgsmReductionCenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectoryRsgsmReductionCenterRepo extends MongoRepository<DirectoryRsgsmReductionCenter, ObjectId> {
    Optional<DirectoryRsgsmReductionCenter> findByEmail(String email);
}
