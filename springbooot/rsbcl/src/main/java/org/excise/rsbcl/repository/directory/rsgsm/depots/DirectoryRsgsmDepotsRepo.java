package org.excise.rsbcl.repository.directory.rsgsm.depots;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.directory.rsgsm.depots.DirectoryRsgsmDepots;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRsgsmDepotsRepo extends MongoRepository<DirectoryRsgsmDepots, ObjectId> {
}
