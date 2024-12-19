package com.sar.user.service.UserService.controller;

import com.sar.user.service.UserService.entities.User;
import com.sar.user.service.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.saveUser(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    int retryCount=0;

    //single user get
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback") //for Circuit Breaker
//    @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback") //for Retry
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        logger.info("Retry Count : {}",retryCount);
        retryCount++;

        User user = userService.getUser(userId);

        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //creating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
//        logger.info("Fallback is executed because service is down : ",ex.getMessage());
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("Created a dummy user because service is down.")
                .userId("DummyId")
                .build();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //get all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //update user
    @PutMapping
    public ResponseEntity<User> updateUser(User user){
        userService.updateUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);

        return new ResponseEntity<>("User Deleted with userId : "+userId,HttpStatus.OK);
    }


}
