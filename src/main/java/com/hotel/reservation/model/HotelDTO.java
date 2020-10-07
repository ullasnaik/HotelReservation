package com.hotel.reservation.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HotelDTO {
	private User user;
	private BookingDetails bookingDetails;
	private Room room;
	private List<BookingDetails> bookingList;
	private int noOf1BedAvalable;
	private int noOf2BedAvalable;
	private int noOf3BedAvalable;
	private Date bookingDate;
	private String userAction;
	private Long actionId;

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<BookingDetails> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingDetails> bookingList) {
		this.bookingList = bookingList;
	}

	public int getNoOf1BedAvalable() {
		return noOf1BedAvalable;
	}

	public void setNoOf1BedAvalable(int noOf1BedAvalable) {
		this.noOf1BedAvalable = noOf1BedAvalable;
	}

	public int getNoOf2BedAvalable() {
		return noOf2BedAvalable;
	}

	public void setNoOf2BedAvalable(int noOf2BedAvalable) {
		this.noOf2BedAvalable = noOf2BedAvalable;
	}

	public int getNoOf3BedAvalable() {
		return noOf3BedAvalable;
	}

	public void setNoOf3BedAvalable(int noOf3BedAvalable) {
		this.noOf3BedAvalable = noOf3BedAvalable;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

}
