package com.hotel.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.model.BookingDetails;
import com.hotel.reservation.repository.BookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsRepository repository;

	@Override
	public BookingDetails findBookingDetails(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public BookingDetails addbookingDetails(BookingDetails bookingDetails) {
		return repository.save(bookingDetails);
	}

	@Override
	public List<BookingDetails> getAllBookingDetailss() {
		return repository.findAll();
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
		return repository.saveAndFlush(bookingDetails);
	}

}
