package com.sar.rating.service.RatingService.services;

import com.sar.rating.service.RatingService.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    //rating operations

    //create
    public Rating createRating(Rating rating);

    //get all ratings
    public List<Rating> getAllRatings();

    //get all ratings by UserId
    public List<Rating> getAllRatingsByUserId(String userId);

    //get all ratings by HotelId
    public List<Rating> getAllRatingsByHotelId(String hotelId);

    //get single rating of given ratingId
    public Rating getRating(String ratingId);

    //update rating with given ratingId
    public Rating updateRating(Rating rating);

    //delete rating with given ratingId
    public void deleteRating(String ratingId);


}
