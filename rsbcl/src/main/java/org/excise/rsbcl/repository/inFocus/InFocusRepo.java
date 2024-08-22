package org.excise.rsbcl.repository.inFocus;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.inFocus.InFocus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InFocusRepo extends MongoRepository<InFocus, ObjectId> {
}
