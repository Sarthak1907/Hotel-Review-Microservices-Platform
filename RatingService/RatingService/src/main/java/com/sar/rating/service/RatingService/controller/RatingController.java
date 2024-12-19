package com.sar.rating.service.RatingService.controller;

import com.sar.rating.service.RatingService.entities.Rating;
import com.sar.rating.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        ratingService.createRating(rating);

        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    //single rating get
    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
        Rating rating = ratingService.getRating(ratingId);

        return new ResponseEntity<>(rating, HttpStatus.FOUND);
    }

    //get all rating
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings = ratingService.getAllRatings();

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    //get all rating using UserId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
        List<Rating> ratings = ratingService.getAllRatingsByUserId(userId);

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    //get all rating
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
        List<Rating> ratings = ratingService.getAllRatingsByHotelId(hotelId);

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    //update rating
    @PutMapping
    public ResponseEntity<Rating> updateRating(Rating rating){
        ratingService.updateRating(rating);

        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    //delete rating
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable String ratingId){
        ratingService.deleteRating(ratingId);

        return new ResponseEntity<>("Rating Deleted with ratingId : "+ratingId,HttpStatus.OK);
    }
    
}
