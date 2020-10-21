package com.hotel.reservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.model.BookingDetails;
import com.hotel.reservation.model.Room;
import com.hotel.reservation.repository.BookingDetailsRepository;
import com.hotel.reservation.repository.RoomRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsRepository repository;

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public BookingDetails findBookingDetails(Long id) {
		return repository.findById(id).get();
	}

	@Override
	@Transactional
	public BookingDetails addbookingDetails(BookingDetails bookingDetails) {
		return repository.save(bookingDetails);
	}

	@Override
	public List<BookingDetails> getAllBookingDetailss() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
		return repository.saveAndFlush(bookingDetails);
	}

	public int getAllavailableRoomCounts(Date bookingDate, String roomType) {
		System.out.println("roomRepository.findAll() : ##################################");
		System.out.println(roomRepository.findAll().stream().filter(r -> r.getRoomType().equals(roomType)).count());
		System.out.println("repository.findByBookingDateAndRoomType() : ##################################");
		System.out.println(repository.findByBookingDateAndRoomType(bookingDate, roomType).size());
		return (int) (roomRepository.findAll().stream().filter(r -> r.getRoomType().equals(roomType)).count()
				- repository.findByBookingDateAndRoomType(bookingDate, roomType).size());
	}

	@Override
	@Transactional
	public List<Room> availableRooms(Date bookingDate, String roomType) {
		return roomRepository.availableRooms(bookingDate, roomType);
	}

	@Override
	public List<BookingDetails> findbyUserId(Long userId) {
		return repository.findbyUserId(userId);
	}

	@Override
	public List<BookingDetails> findbyBookingDate(Date bookingDate) {
		return repository.findbyBookingDate(bookingDate);
	}

}
