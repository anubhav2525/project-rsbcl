package org.excise.rsbcl.repository.about.rsgsm.salesData;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.about.rsgsm.salesData.AboutRsgsmSalesData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRsgsmSalesDataRepo extends MongoRepository<AboutRsgsmSalesData, ObjectId> {
}
