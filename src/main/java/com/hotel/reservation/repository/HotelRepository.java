package com.hotel.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.reservation.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long > {

}
