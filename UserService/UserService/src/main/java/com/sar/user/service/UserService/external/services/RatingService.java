package com.sar.user.service.UserService.external.services;

import com.sar.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATINGSERVICE")
@Service
public interface RatingService {

    //GET


    //POST
    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    //PUT
    @PutMapping
    public Rating updateRating(Rating ratings);

    //DELETE
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);

}
