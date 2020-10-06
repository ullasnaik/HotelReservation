package com.hotel.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.model.User;
import com.hotel.reservation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User findUser(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public User adduser(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User updateUser(User user) {
		return repository.saveAndFlush(user);
	}

}
