package org.excise.rsbcl.repository.actsPolicies;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.actsPolicies.ActsPolicies;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActsPoliciesRepo extends MongoRepository<ActsPolicies, ObjectId> {
    List<ActsPolicies> findByDepartment(String department, Sort sort);
}
