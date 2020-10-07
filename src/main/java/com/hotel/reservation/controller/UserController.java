package com.hotel.reservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.reservation.model.BookingDetails;
import com.hotel.reservation.model.HotelDTO;
import com.hotel.reservation.model.Room;
import com.hotel.reservation.model.User;
import com.hotel.reservation.service.BookingDetailsService;
import com.hotel.reservation.service.RoomService;
import com.hotel.reservation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookingDetailsService bookingDetailsService;
	@Autowired
	private RoomService roomService;

	@GetMapping("/Home")
	public String login(Map<String, Object> model) {
		System.out.println("Home : ##################################################");
		model.put("user", new User());
		return "Home.jsp";
	}

	@PostMapping("/UserHome")
	public String redirectUser(@ModelAttribute("user") User user, Map<String, Object> model) {
		System.out.println("UserHome : ##################################################");
		User userInDb = userService.findUser(user.getId());

		HotelDTO hotelDTO = new HotelDTO();
		if (hotelDTO.getBookingDate() == null) {
			hotelDTO.setBookingDate(new Date());
		}

		hotelDTO.setUser(userInDb);
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setBookingDate(new Date());
		hotelDTO.setBookingDetails(bookingDetails);
		hotelDTO.setBookingDate(new Date());
		hotelDTO.setBookingList(bookingDetailsService.findbyUserId(userInDb.getId()));
		hotelDTO.setNoOf1BedAvalable(bookingDetailsService.availableRooms(new Date(), "SINGLE_BED").size());
		hotelDTO.setNoOf2BedAvalable(bookingDetailsService.availableRooms(new Date(), "DOUBLE_BED").size());
		hotelDTO.setNoOf3BedAvalable(bookingDetailsService.availableRooms(new Date(), "THREE_BED").size());

		model.put("hotelDTO", hotelDTO);
		System.out.println(user.getId());
		if (userInDb.getUserType().equals("ADMIN")) {
			model.put("hotelDTO", hotelDTO);
			System.out.println(user.getId());
			return "redirect:/AdminHome.jsp";
		}
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
		userService.adduser(user);
		return "redirect:/UserHome";
	}

	@GetMapping("/BookingDetails")
	public String userRoomBookig(Map<String, Object> model) {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setUser(userService.findUser(2000L));
		model.put("bookingDetails", bookingDetails);
		System.out.println("BookingDetails : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return "BookingDetails.jsp";
	}

	@PostMapping("/UserAction")
	public String userAction(@ModelAttribute("hotelDTO") HotelDTO hotelDTO, Map<String, Object> model) {
		System.out.println("bookRoom : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		BookingDetails bookingDetails = hotelDTO.getBookingDetails();
		if (bookingDetails != null) {
			hotelDTO.setBookingDate(bookingDetails.getBookingDate());
		}

		if (hotelDTO.getUserAction().equals("BOOK")) {
			System.out.println(bookingDetails.toString());
			List<Room> roomList = bookingDetailsService.availableRooms(bookingDetails.getBookingDate(),
					bookingDetails.getRoomType());
			System.out.println(roomList.size());
			bookingDetails.setRoom(roomList.get(0));
			bookingDetails.setStatus("BOOKED");
			System.out.println("******" + hotelDTO.getUser());
			bookingDetails.setUser(hotelDTO.getUser());
			bookingDetailsService.addbookingDetails(bookingDetails);
		}
		if (hotelDTO.getUserAction().equals("CANCEL")) {
			BookingDetails bookingDetailsCancel = bookingDetailsService.findBookingDetails(hotelDTO.getActionId());
			bookingDetailsCancel.setStatus("CANCELLED");
			bookingDetailsService.updateBookingDetails(bookingDetailsCancel);
		}
		if (hotelDTO.getUserAction().equals("CHECK")) {
			bookingDetails.setBookingDate(hotelDTO.getBookingDate());
		}
		System.out.println(
				"############################################################################################################################################################################");
		int noOf1BedAvalable = bookingDetailsService.availableRooms(bookingDetails.getBookingDate(), "SINGLE_BED")
				.size();
		System.out.println(noOf1BedAvalable);
		int noOf2BedAvalable = bookingDetailsService.availableRooms(bookingDetails.getBookingDate(), "DOUBLE_BED")
				.size();
		System.out.println(noOf2BedAvalable);
		int noOf3BedAvalable = bookingDetailsService.availableRooms(bookingDetails.getBookingDate(), "THREE_BED")
				.size();
		System.out.println(noOf3BedAvalable);
		hotelDTO.setNoOf1BedAvalable(noOf1BedAvalable);
		hotelDTO.setNoOf2BedAvalable(noOf2BedAvalable);
		hotelDTO.setNoOf3BedAvalable(noOf3BedAvalable);
		hotelDTO.setBookingList(bookingDetailsService.findbyUserId(hotelDTO.getUser().getId()));

		model.put("hotelDTO", hotelDTO);
		return "UserHome.jsp";
	}

}
