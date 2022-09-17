package com.Team4.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Team4.project.entity.RoomDetails;
import com.Team4.project.exception.RoomDetailsNotFoundException;
import com.Team4.project.service.services.RoomDetailsService;


@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	RoomDetailsService roomservice;
	
	@PostMapping("/")
	public RoomDetails addRoom(@RequestBody RoomDetails room) {
		Optional<RoomDetails> roomById = roomservice.showRoomDetails(room.getRoom_id());
		
		if(roomById.isPresent())
			throw new RoomDetailsNotFoundException("room with id "+room.getRoom_id()+" exists");
		
		return roomservice.addRoomDetails(room);	
		}
	
	
	@GetMapping("/")
	public List<RoomDetails> showRoom() {
		return roomservice.showAllRoomDetails();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<RoomDetails> updateRoom(@PathVariable("id") int id,@RequestBody RoomDetails room) {
		
		Optional<RoomDetails>roomById=roomservice.showRoomDetails(id);
		
		if(!roomById.isEmpty())
			throw new RoomDetailsNotFoundException("Room with Id "+ id+" does not exist");
		
		RoomDetails updateRoom=roomById.get();
		
		updateRoom.setIsavailable(room.getIsavailable());
		updateRoom.setPhotoURL(room.getPhotoURL());
		updateRoom.setRate_per_day(room.getRate_per_day());
		updateRoom.setRoom_no(room.getRoom_no());
		updateRoom.setRoom_type(room.getRoom_type());
		
		return ResponseEntity.ok(updateRoom);
		

	}
	
	
	@DeleteMapping("/{id}")
	public String deleteRoom(@PathVariable("id") int id) {
		Optional<RoomDetails> currentRoomById = roomservice.showRoomDetails(id);
		if(!currentRoomById.isPresent())
			throw new RoomDetailsNotFoundException("Room with id "+id+" does not exist");
		 roomservice.removeRoomDetails(id);
		 
		 return "Room details deleted successfully";
	}
	
}
