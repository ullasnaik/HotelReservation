package com.hotel.reservation.service;

import java.util.List;

import com.hotel.reservation.model.User;

public interface UserService {

	User findUser(Long id);

	User adduser(User user);

	List<User> getAllUsers();

	User updateUser(User user);

}