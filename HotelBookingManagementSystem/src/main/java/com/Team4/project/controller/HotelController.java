package com.Team4.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Team4.project.entity.Hotel;
import com.Team4.project.exception.ResourceNotFoundException;
import com.Team4.project.repository.HotelRepo;
import com.Team4.project.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService service;

	@Autowired
	HotelRepo repo;

	@PostMapping("/")
	public Hotel addHotel(@RequestBody Hotel hotel) {

		this.service.addHotel(hotel);
		return hotel;

	}

	@GetMapping("/")
	public List<Hotel> showAllRoomDetails(@RequestBody Hotel hotel) {

		return this.service.showAllHotels(hotel);

	}

	@PutMapping("/{room_id}")
	public ResponseEntity<Hotel> updateRoomDetails(@PathVariable int room_id, @RequestBody Hotel hotel) {
		this.service.updateHotel(room_id, hotel);

		return ResponseEntity.ok(hotel);
	}

	@DeleteMapping("/delete/{Id}")
	public String removeRoomDetails(@PathVariable int Id) {
		this.service.removeHotel(Id);

		return "hotel deleted successfully";

	}

	// Get hotels by hotel Id

	@GetMapping("/id/{hotel_id}")
	public Hotel showHotelsById(@PathVariable int hotel_id, @RequestBody Hotel hotel) {

		return this.service.showHotelsById(hotel_id);

	}

	@GetMapping("/name/{name}")
	public List<Hotel> getHotelbyName(@PathVariable("name") String name) {
		List<Hotel> hotel = repo.findAll();

		List<Hotel> hotelName = hotel.stream().filter(e -> e.getHotel_name().equalsIgnoreCase(name))
				.collect(Collectors.toList());

		return hotelName;
	}

}
