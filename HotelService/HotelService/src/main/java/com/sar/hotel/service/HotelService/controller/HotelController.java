package com.sar.hotel.service.HotelService.controller;

import com.sar.hotel.service.HotelService.entities.Hotel;
import com.sar.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        hotelService.createHotel(hotel);

        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    //single hotel get
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);

        return new ResponseEntity<>(hotel, HttpStatus.FOUND);
    }

    //get all hotel
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelService.getAllHotels();

        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    //update hotel
    @PutMapping
    public ResponseEntity<Hotel> updateHotel(Hotel hotel){
        hotelService.updateHotel(hotel);

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    //delete hotel
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId){
        hotelService.deleteHotel(hotelId);

        return new ResponseEntity<>("Hotel Deleted with hotelId : "+hotelId,HttpStatus.OK);
    }

}
