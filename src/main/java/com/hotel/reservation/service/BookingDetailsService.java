package com.hotel.reservation.service;

import java.util.List;

import com.hotel.reservation.model.BookingDetails;

public interface BookingDetailsService {

	BookingDetails findBookingDetails(Long id);

	BookingDetails addbookingDetails(BookingDetails bookingDetails);

	List<BookingDetails> getAllBookingDetailss();

	BookingDetails updateBookingDetails(BookingDetails bookingDetails);

}