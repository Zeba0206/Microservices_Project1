package com.stackroute.muzixapplication.respository;

import com.stackroute.muzixapplication.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MuzixRepository extends MongoRepository<Track,Integer> {

}
