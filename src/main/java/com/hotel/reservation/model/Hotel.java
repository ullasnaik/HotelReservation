package com.hotel.reservation.model;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HOTEL")
public class Hotel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long hotelId;
	private String hotelName;
	private Long singeBedRoomPrice;
	private Long doubleBedRoomPrice;
	private Long threeBedRoomPrice;
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Room> singeBedRooms;
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Room> doubleBedRooms;
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Room> threeBedRooms;
	
	public String getHotelName() {
		return hotelName;
	}
	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public Set<Room> getThreeBedRooms() {
		return threeBedRooms;
	}
	
	public void setThreeBedRooms(Set<Room> threeBedRooms) {
		this.threeBedRooms = threeBedRooms;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getSingeBedRoomPrice() {
		return singeBedRoomPrice;
	}

	public void setSingeBedRoomPrice(Long singeBedRoomPrice) {
		this.singeBedRoomPrice = singeBedRoomPrice;
	}

	public Long getDoubleBedRoomPrice() {
		return doubleBedRoomPrice;
	}

	public void setDoubleBedRoomPrice(Long doubleBedRoomPrice) {
		this.doubleBedRoomPrice = doubleBedRoomPrice;
	}

	public Long getThreeBedRoomPrice() {
		return threeBedRoomPrice;
	}

	public void setThreeBedRoomPrice(Long threeBedRoomPrice) {
		this.threeBedRoomPrice = threeBedRoomPrice;
	}

	public Set<Room> getSingeBedRooms() {
		return singeBedRooms;
	}

	public void setSingeBedRooms(Set<Room> singeBedRooms) {
		this.singeBedRooms = singeBedRooms;
	}

	public Set<Room> getDoubleBedRooms() {
		return doubleBedRooms;
	}

	public void setDoubleBedRooms(Set<Room> doubleBedRooms) {
		this.doubleBedRooms = doubleBedRooms;
	}
	
		
}
