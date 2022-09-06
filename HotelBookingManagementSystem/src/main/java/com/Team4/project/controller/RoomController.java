package com.Team4.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Team4.project.entity.RoomDetails;
import com.Team4.project.service.services.RoomDetailsService;


@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	RoomDetailsService roomservice;
	
	@PostMapping("/")
	public RoomDetails addRoom(@RequestBody RoomDetails room) {
		return roomservice.addRoomDetails(room);	
	}
	
	
	@GetMapping("/")
	public List<RoomDetails> showRoom() {
		return roomservice.showAllRoomDetails();
	}
	
	
	@PutMapping("/")
	public RoomDetails updateRoom(@RequestBody RoomDetails room) {
		return roomservice.updateRoomDetails(room);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteRoom(@PathVariable("id") int id) {
		roomservice.removeRoomDetails(id);
		return "Record has been deleted!";
	}
	
}
