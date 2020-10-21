package com.hotel.reservation.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@Autowired
	private BookingDetailsService bookingDetailsService;
	@Autowired
	private RoomService roomService;

	@GetMapping("/Home")
	public String login(Map<String, Object> model) {
		logger.info("Home : ##################################################");
		logger.debug("This is a debug message");
		model.put("user", new User());
		return "Home.jsp";
	}

	@PostMapping("/UserHome")
	public String redirectUser(@ModelAttribute("user") User user, Map<String, Object> model) {
		logger.info("UserHome : ##################################################");
		User userInDb = userService.findUser(user.getId());
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date today = null;
		try {
			today = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		HotelDTO hotelDTO = new HotelDTO();
		hotelDTO.setBookingDate(today);
		hotelDTO.setUser(userInDb);
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setBookingDate(today);
		hotelDTO.setBookingDetails(bookingDetails);
		logger.info(
				"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		logger.info(hotelDTO.getBookingDate().toString());

		int noOf1BedAvalable = bookingDetailsService.availableRooms(hotelDTO.getBookingDate(), "SINGLE_BED").size();
		logger.info(String.valueOf(noOf1BedAvalable));
		int noOf2BedAvalable = bookingDetailsService.availableRooms(hotelDTO.getBookingDate(), "DOUBLE_BED").size();
		logger.info(String.valueOf(noOf2BedAvalable));
		int noOf3BedAvalable = bookingDetailsService.availableRooms(hotelDTO.getBookingDate(), "THREE_BED").size();
		logger.info(String.valueOf(noOf3BedAvalable));
		hotelDTO.setNoOf1BedAvalable(noOf1BedAvalable);
		hotelDTO.setNoOf2BedAvalable(noOf2BedAvalable);
		hotelDTO.setNoOf3BedAvalable(noOf3BedAvalable);
//		hotelDTO.setNoOf1BedAvalable(bookingDetailsService.availableRooms(new Date(), "SINGLE_BED").size());
//		hotelDTO.setNoOf2BedAvalable(bookingDetailsService.availableRooms(new Date(), "DOUBLE_BED").size());
//		hotelDTO.setNoOf3BedAvalable(bookingDetailsService.availableRooms(new Date(), "THREE_BED").size());
		if (userInDb.getUserType().equals("ADMIN")) {
			hotelDTO.setBookingList(bookingDetailsService.findbyBookingDate(hotelDTO.getBookingDate()));
			model.put("hotelDTO", hotelDTO);
			logger.info(String.valueOf(user.getId()));
			return "AdminHome.jsp";
		}
		hotelDTO.setBookingList(bookingDetailsService.findbyUserId(userInDb.getId()));
		model.put("hotelDTO", hotelDTO);
		logger.info(String.valueOf(user.getId()));
		hotelDTO.setBookingList(bookingDetailsService.findbyUserId(hotelDTO.getUser().getId()));
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
		return "redirect:/Home";
	}

	@GetMapping("/BookingDetails")
	public String userRoomBookig(Map<String, Object> model) {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setUser(userService.findUser(2000L));
		model.put("bookingDetails", bookingDetails);
		logger.info("BookingDetails : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return "BookingDetails.jsp";
	}

	@PostMapping("/UserAction")
	public String userAction(@ModelAttribute("hotelDTO") HotelDTO hotelDTO, Map<String, Object> model) {
		logger.info("bookRoom : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		BookingDetails bookingDetails = hotelDTO.getBookingDetails();

		if (hotelDTO.getUserAction().equals("BOOK")) {
			logger.info(bookingDetails.toString());
			List<Room> roomList = bookingDetailsService.availableRooms(bookingDetails.getBookingDate(),
					bookingDetails.getRoomType());
			logger.info(String.valueOf(roomList.size()));
			bookingDetails.setRoom(roomList.get(0));
			bookingDetails.setStatus("BOOKED");
			logger.info("******" + hotelDTO.getUser());
			bookingDetails.setUser(hotelDTO.getUser());
			bookingDetailsService.addbookingDetails(bookingDetails);
		}
		if (hotelDTO.getUserAction().equals("CANCEL")) {
			BookingDetails bookingDetailsCancel = bookingDetailsService.findBookingDetails(hotelDTO.getActionId());
			bookingDetailsCancel.setStatus("CANCELLED");
			bookingDetailsService.updateBookingDetails(bookingDetailsCancel);
		}
		if (hotelDTO.getBookingDate() == null) {
			hotelDTO.setBookingDate(bookingDetails.getBookingDate());
		}
		logger.info(
				"############################################################################################################################################################################");
		int noOf1BedAvalable = bookingDetailsService.availableRooms(hotelDTO.getBookingDate(), "SINGLE_BED").size();
		logger.info(String.valueOf(noOf1BedAvalable));
		int noOf2BedAvalable = bookingDetailsService.availableRooms(hotelDTO.getBookingDate(), "DOUBLE_BED").size();
		logger.info(String.valueOf(noOf2BedAvalable));
		int noOf3BedAvalable = bookingDetailsService.availableRooms(hotelDTO.getBookingDate(), "THREE_BED").size();
		logger.info(String.valueOf(noOf3BedAvalable));
		hotelDTO.setNoOf1BedAvalable(noOf1BedAvalable);
		hotelDTO.setNoOf2BedAvalable(noOf2BedAvalable);
		hotelDTO.setNoOf3BedAvalable(noOf3BedAvalable);
		hotelDTO.setBookingList(bookingDetailsService.findbyUserId(hotelDTO.getUser().getId()));

		model.put("hotelDTO", hotelDTO);
		if (hotelDTO.getUser().getUserType().equals("ADMIN")) {
			hotelDTO.setBookingList(bookingDetailsService.findbyBookingDate(hotelDTO.getBookingDate()));
			return "AdminHome.jsp";
		}

		return "UserHome.jsp";
	}

}
