package com.Team4.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Team4.project.entity.Hotel;
import com.Team4.project.entity.RoomDetails;
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
		Hotel updateHotel = hotelservice.showHotel(id);
		
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
		return hotelservice.removeHotel(id);
	}
	
	@GetMapping("/{id}")
	public Hotel getHotelbyId(@PathVariable("id") int id) {
		return hotelservice.showHotel(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Hotel> getHotelbyName(@PathVariable("name") String name) {
		List<Hotel> hotel = hotelservice.showAllHotels();
		
		List<Hotel> hotelName  = hotel.stream().filter(e -> e.getHotel_name().equalsIgnoreCase(name)).collect(Collectors.toList());
		
		return hotelName;
	}
}
