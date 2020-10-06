package com.hotel.reservation.service;

import java.util.List;

import com.hotel.reservation.model.Hotel;

public interface HotelService {

	Hotel findHotel(Long id);

	Hotel addhotel(Hotel hotel);

	List<Hotel> getAllHotels();

	Hotel updateHotel(Hotel hotel);

}