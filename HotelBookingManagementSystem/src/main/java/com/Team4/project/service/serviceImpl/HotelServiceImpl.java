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

	@Override
	public Hotel addHotel(Hotel hotel) {
		repo.save(hotel);
		return hotel;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		repo.save(hotel);
		return hotel;
	}

	@Override
	public String removeHotel(int id) {
		repo.deleteById(id);
		return "Record has been deleted!";
	}

	@Override
	public List<Hotel> showAllHotels() {
		return repo.findAll();
	}

	@Override
	public Optional<Hotel> showHotel(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Hotel> getHotelByHotel_name(String hotel_name) {
		List<Hotel> hotels = repo.findAll();
		List<Hotel> hotelName  = hotels.stream().filter(e -> e.getHotel_name().equalsIgnoreCase(hotel_name)).collect(Collectors.toList());
		
		return hotelName;
	}
}
