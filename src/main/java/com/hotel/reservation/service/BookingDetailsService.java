package com.hotel.reservation.service;

import java.util.Date;
import java.util.List;

import com.hotel.reservation.model.BookingDetails;
import com.hotel.reservation.model.Room;

public interface BookingDetailsService {

	BookingDetails findBookingDetails(Long id);

	BookingDetails addbookingDetails(BookingDetails bookingDetails);

	List<BookingDetails> getAllBookingDetailss();

	BookingDetails updateBookingDetails(BookingDetails bookingDetails);

	List<Room> availableRooms(Date bookingDate, String roomType);

	List<BookingDetails> findbyUserId(Long userId);

	List<BookingDetails> findbyBookingDate(Date bookingDate);
}