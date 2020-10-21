package com.hotel.reservation.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_DETAILS")
public class BookingDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookigId;
	private String status;
	private Date bookingDate;
	private String roomType;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "User_Id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Room_Num", nullable = false)
	private Room room;

	public void setBookigId(long bookigId) {
		this.bookigId = bookigId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Long getBookigId() {
		return bookigId;
	}

	public void setBookigId(Long bookigId) {
		this.bookigId = bookigId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookigId=" + bookigId + ", status=" + status + ", bookingDate=" + bookingDate
				+ ", roomType=" + roomType + "]";
	}

}
