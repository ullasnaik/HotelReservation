package com.hotel.reservation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.reservation.model.BookingDetails;
import com.hotel.reservation.model.Room;
import com.hotel.reservation.model.User;
import com.hotel.reservation.service.BookingDetailsService;
import com.hotel.reservation.service.RoomService;
import com.hotel.reservation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private BookingDetailsService bookingDetailsService;
	@Autowired
	private RoomService roomService;

	@GetMapping("/UserHome")
	public String home() {
		System.out.println("##################################################");
		return "UserHome.jsp";
	}

	@GetMapping("/UserRegistration")
	public String reg(Map<String, Object> model) {
		model.put("user", new User());
		return "UserRegistration.jsp";
	}

	@PostMapping("/AddUser")
	public String createUser(@ModelAttribute("user") User user) {
		user.setUserType("USER");
		service.adduser(user);
		return "redirect:/UserHome";
	}
	
	@GetMapping("/BookingDetails")
	public String userRoomBookig(Map<String, Object> model ) {
		BookingDetails bookingDetails=new BookingDetails();
		bookingDetails.setUser(service.findUser(2000L));
		model.put("bookingDetails", bookingDetails);
		System.out.println("BookingDetails : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "BookingDetails.jsp";
	}
	
	@PostMapping("/bookRoom")
	public String bookRoom(@ModelAttribute("bookingDetails") BookingDetails bookingDetails) {
		System.out.println("bookRoom : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(bookingDetails.toString());
		List<Room> roomList =roomService.findByRoomType(bookingDetails.getRoom().getRoomType());
		System.out.println(roomList.size());
		bookingDetails.setRoom(roomList.get(0));
		bookingDetails.setStatus("BOOKED");
		bookingDetails.setUser(service.findUser(bookingDetails.getUser().getId()));
		bookingDetailsService.addbookingDetails(bookingDetails);
		return "redirect:/UserHome";
	}

}
