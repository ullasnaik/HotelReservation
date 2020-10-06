package com.hotel.reservation.service;

import java.util.List;

import com.hotel.reservation.model.Room;

public interface RoomService {

	Room findRoom(Long id);

	Room addroom(Room room);

	List<Room> getAllRooms();

	Room updateRoom(Room room);
	
	List<Room> findByRoomType(String roomType);

}