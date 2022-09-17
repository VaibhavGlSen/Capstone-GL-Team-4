package com.Team4.project.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.Hotel;

@Service
public interface HotelService {
	
	public Hotel addHotel(Hotel hotel);
	
	public Hotel updateHotel(Hotel hotel);
	
	public String removeHotel(int id);
	
	public List<Hotel> showAllHotels();
	
	public Optional<Hotel> showHotel(int id);
	
	public List<Hotel> getHotelByHotel_name(String hotel_name);

	
}
