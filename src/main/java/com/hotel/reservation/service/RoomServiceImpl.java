package com.hotel.reservation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.model.Room;
import com.hotel.reservation.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository repository;

	@Override
	@Transactional
	public Room findRoom(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Room addroom(Room room) {
		return repository.save(room);
	}

	@Override
	@Transactional
	public List<Room> getAllRooms() {
		return repository.findAll();
	}

	@Override
	public Room updateRoom(Room room) {
		return repository.saveAndFlush(room);
	}

	@Override
	@Transactional
	public List<Room> findByRoomType(String roomType) {
		return repository.findByRoomType(roomType);
	}

}
