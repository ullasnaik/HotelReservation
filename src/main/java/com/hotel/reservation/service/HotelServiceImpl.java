package com.hotel.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.model.Hotel;
import com.hotel.reservation.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository repository;

	@Override
	public Hotel findHotel(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Hotel addhotel(Hotel hotel) {
		return repository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return repository.findAll();
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		return repository.saveAndFlush(hotel);
	}

}
