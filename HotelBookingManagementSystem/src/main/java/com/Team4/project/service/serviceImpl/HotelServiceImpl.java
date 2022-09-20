package com.Team4.project.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.Hotel;
import com.Team4.project.repository.IHotelRepository;
import com.Team4.project.service.services.HotelService;

@Component
public class HotelServiceImpl implements HotelService {
	@Autowired
	IHotelRepository repo;

	
	//add Hotel 
	@Override
	public Hotel addHotel(Hotel hotel) {
		repo.save(hotel);
		return hotel;
	}

	
	//Update Hotel
	@Override
	public Hotel updateHotel(Hotel hotel) {
		repo.save(hotel);
		return hotel;
	}

	
	//Remove Hotel by Id
	@Override
	public String removeHotel(int id) {
		repo.deleteById(id);
		return "Record has been deleted!";
	}

	
	//Fetch all Hotels
	@Override
	public List<Hotel> showAllHotels() {
		return repo.findAll();
	}

	
	//Show hotel by Id
	@Override
	public Optional<Hotel> showHotel(int id) {
		return repo.findById(id);
		
		

	}
	
	
	//get Hotel by Hotel Name
	@Override
	public List<Hotel> getHotelByHotel_name(String hotel_name) {
		List<Hotel> hotels = repo.findAll();
		List<Hotel> hotelName  = hotels.stream().filter(e -> e.getHotel_name().equalsIgnoreCase(hotel_name)).collect(Collectors.toList());
		
		return hotelName;
	}

}
