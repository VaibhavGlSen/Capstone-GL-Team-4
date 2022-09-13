package com.Team4.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.Hotel;


@Service
public interface HotelService {
	
	public Hotel addHotel(Hotel hotel);

	
public ResponseEntity<Hotel> updateHotel(int hotel_id,Hotel hotel);
	
	public void removeHotel(int Id);
	
	public List<Hotel> showAllHotels(Hotel hotel);
	
	public Hotel showHotelsById(int hotel_id);
	

}
