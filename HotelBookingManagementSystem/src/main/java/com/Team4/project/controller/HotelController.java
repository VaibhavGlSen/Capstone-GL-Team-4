package com.Team4.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Team4.project.entity.Hotel;
import com.Team4.project.entity.RoomDetails;
import com.Team4.project.exception.HotelsNotFoundException;
import com.Team4.project.repository.IRoomDetailsRepository;
import com.Team4.project.service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	HotelService hotelservice;
	
	@Autowired
	IRoomDetailsRepository roomrepo;
	
	@PostMapping("/")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		
		Optional<Hotel> hotelById = hotelservice.showHotel(hotel.getHotel_id());
		List<Hotel> hotelByName = hotelservice.getHotelByHotel_name(hotel.getHotel_name());
		
		if(hotelById.isPresent())
			throw new HotelsNotFoundException("hotel with id "+hotel.getHotel_id()+" exists");
		else if(!hotelByName.isEmpty())
			throw new HotelsNotFoundException("hotel with this name already registered");
		
		List<RoomDetails> room = new ArrayList<>();
		for(RoomDetails a:hotel.getRoom_details()) {
			RoomDetails r = roomrepo.findById(a.getRoom_id()).get();
			room.add(r);
		}
		hotel.setRoom_details(room);
		hotelservice.addHotel(hotel);
		return hotel;
	}
	
	@GetMapping("/")
	public List<Hotel> showHotel(){
		return hotelservice.showAllHotels();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("id") int id, @RequestBody Hotel hotel){
		Optional<Hotel> hotelById = hotelservice.showHotel(id);
		if(hotelById.isEmpty())
			throw new HotelsNotFoundException("hotel with id "+id+" not exists");
		
		Hotel updateHotel = hotelById.get();
		
		List<RoomDetails> room = new ArrayList<>();
		for(RoomDetails a:hotel.getRoom_details()) {
			RoomDetails r = roomrepo.findById(a.getHotel_id()).get();
			room.add(r);
		}
		
		updateHotel.setAddress(hotel.getAddress());
		updateHotel.setCity(hotel.getCity());
		updateHotel.setAvg_rate_per_day(hotel.getAvg_rate_per_day());
		updateHotel.setHotel_name(hotel.getHotel_name());
		updateHotel.setDescription(hotel.getDescription());
		updateHotel.setEmail(hotel.getEmail());
		updateHotel.setPhone1(hotel.getPhone1());
		updateHotel.setPhone2(hotel.getPhone2());
		updateHotel.setWebsite(hotel.getWebsite());
		updateHotel.setRoom_details(room);
		
		return ResponseEntity.ok(updateHotel);
	}
	
	@DeleteMapping("/{id}")
	public String deleteHotel(@PathVariable("id") int id) {
		Optional<Hotel> hotel = hotelservice.showHotel(id);
		if(hotel.isEmpty())
			throw new HotelsNotFoundException("hotel with id "+id+" not exists");
		return hotelservice.removeHotel(id);	}
	
	@GetMapping("/{id}")
	public Hotel getHotelbyId(@PathVariable("id") int id) {
		Optional<Hotel> hotel = hotelservice.showHotel(id);
		if(hotel.isEmpty())
			throw new HotelsNotFoundException("hotel with id "+id+" not exists");
		return hotel.get();	}
	
	@GetMapping("/name/{name}")
	public List<Hotel> getHotelbyName(@PathVariable("name") String name) {
		List<Hotel> hotel = hotelservice.getHotelByHotel_name(name);
		if(hotel.isEmpty())
			throw new HotelsNotFoundException("Hotel does not exist");
		return hotel;
		
	}
}
