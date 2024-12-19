package com.sar.user.service.UserService.services.Impl;

import com.sar.user.service.UserService.entities.Hotel;
import com.sar.user.service.UserService.entities.Rating;
import com.sar.user.service.UserService.entities.User;
import com.sar.user.service.UserService.exception.ResourceNotFoundException;
import com.sar.user.service.UserService.external.services.HotelService;
import com.sar.user.service.UserService.repository.UserRepository;
import com.sar.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public User saveUser(User user) {
        //Generate Unique UserId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        // implementing fetching of rating of the above user from RATING SERVICE
        for(User user:users){
            Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
            logger.info("{} ",ratingsOfUser);

            List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

            List<Rating> ratingList = ratings.stream().map(rating -> {
                //api call to hotel service to get the hotel
                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
                Hotel hotel = forEntity.getBody();
                logger.info("Response Status Code : {} ",forEntity.getStatusCode());
//                Hotel hotel = hotelService.getHotel(rating.getHotelId());

                //set the hotel to rating
                rating.setHotel(hotel);

                //return the rating
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(ratingList);
        }

        return users;
    }

    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
                Hotel hotel = forEntity.getBody();
                logger.info("Response Status Code : {} ",forEntity.getStatusCode());
//            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //set the hotel to rating
            rating.setHotel(hotel);

            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
