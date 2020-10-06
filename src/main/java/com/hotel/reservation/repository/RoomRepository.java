package com.hotel.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.reservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	public List<Room> findByRoomType(String roomType);
}
