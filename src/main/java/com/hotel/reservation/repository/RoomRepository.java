package com.hotel.reservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.reservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	public List<Room> findByRoomType(String roomType);

	@Query(value = "SELECT * FROM ROOM R where R.ROOM_TYPE= :roomType AND  R.ROOM_NUM not in (SELECT B.ROOM_NUM FROM   BOOK_DETAILS B where B.BOOKING_DATE = :booingDate and B.STATUS='BOOKED')", nativeQuery = true)
	public List<Room> availableRooms(@Param("booingDate") Date booingDate, @Param("roomType") String roomType);
}
