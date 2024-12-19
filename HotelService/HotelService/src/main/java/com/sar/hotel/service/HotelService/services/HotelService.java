package com.sar.hotel.service.HotelService.services;

import com.sar.hotel.service.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //hotel operations

    //create
    public Hotel createHotel(Hotel hotel);

    //get all hotels
    public List<Hotel> getAllHotels();

    //get single hotel of given hotelId
    public Hotel getHotel(String hotelId);

    //update hotel with given hotelId
    public Hotel updateHotel(Hotel hotel);

    //delete hotel with given hotelId
    public void deleteHotel(String hotelId);


}
