package com.hotel.reservation.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long roomNum;
	private String roomType;
	public static int roomPrice;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Hotel_Id", nullable = false)
	private Hotel hotel;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<BookingDetails> bookingDetails;

	public Long getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(Long roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public static int getRoomPrice() {
		return roomPrice;
	}

	public static void setRoomPrice(int roomPrice) {
		Room.roomPrice = roomPrice;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Set<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Set<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomType=" + roomType + ", hotel=" + hotel + ", bookingDetails="
				+ bookingDetails + "]";
	}
	
}
