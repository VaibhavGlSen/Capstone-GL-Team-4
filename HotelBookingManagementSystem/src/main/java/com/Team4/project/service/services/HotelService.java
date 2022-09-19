package com.Team4.project.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.Hotel;

@Service
public interface HotelService {
	
	public Hotel addHotel(Hotel hotel);
	
	public Hotel updateHotel(Hotel hotel);
	
	public String removeHotel(int id);
	
	public List<Hotel> showAllHotels();
	
	public Hotel showHotel(int id);
	
}
