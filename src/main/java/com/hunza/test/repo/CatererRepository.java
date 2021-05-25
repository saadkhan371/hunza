package com.hunza.test.repo;

import com.hunza.test.document.Caterer;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatererRepository extends MongoRepository<Caterer, String> {

    public Caterer findByName(String firstName);

    Page<Caterer> findAll(Pageable pageable);

}
