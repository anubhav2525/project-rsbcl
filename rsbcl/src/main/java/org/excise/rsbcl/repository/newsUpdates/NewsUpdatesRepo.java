package org.excise.rsbcl.repository.newsUpdates;

import org.bson.types.ObjectId;
import org.excise.rsbcl.model.newsUpdates.NewsUpdates;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsUpdatesRepo extends MongoRepository<NewsUpdates, ObjectId> {
    List<NewsUpdates> findByDepartment(String department, Sort sort);
}
