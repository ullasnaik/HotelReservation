package com.hotel.reservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.reservation.model.BookingDetails;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {
	public List<BookingDetails> findByBookingDateAndRoomType(Date bookingDate, String roomType);

	@Query(value = "SELECT * FROM BOOK_DETAILS where USER_ID = :userId ", nativeQuery = true)
	public List<BookingDetails> findbyUserId(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM BOOK_DETAILS WHERE BOOKING_DATE= :bookingDate ", nativeQuery = true)
	public List<BookingDetails> findbyBookingDate(@Param("bookingDate") Date bookingDate);
}
