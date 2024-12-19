package com.sar.rating.service.RatingService.repository;

import com.sar.rating.service.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    //custom finder methods
    public List<Rating> findByUserId(String userId);
    public List<Rating> findByHotelId(String hotelId);

}
