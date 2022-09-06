package com.Team4.project.controller;

import java.util.List;

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

import com.Team4.project.entity.RoomDetails;
import com.Team4.project.service.RoomDetailService;

@RestController
@RequestMapping("/roomDetails")
public class RoomDetailsController {
	
	@Autowired
	RoomDetailService service;
	
	@PostMapping("/")
	public RoomDetails addRoomDetails(@RequestBody RoomDetails roomDetails) {
		
	 this.service.addRoomDetails(roomDetails);
	 return roomDetails;
		
	}
	
	@GetMapping("/")
	public List<RoomDetails> showAllRoomDetails(@RequestBody RoomDetails roomDetails){
		return this.service.showAllRoomDetails(roomDetails);
	}
	
	
	
	@PutMapping("/{room_id}")
	public ResponseEntity<RoomDetails> updateRoomDetails(@PathVariable int room_id, @RequestBody RoomDetails roomDetails) {
		this.service.updateRoomDetails(room_id, roomDetails);

		return ResponseEntity.ok(roomDetails);
	}
	
	
	@DeleteMapping("/delete/{Id}")
	public String removeRoomDetails(@PathVariable int Id) {
		this.service.removeRoomDetails(Id);
		
		return "record deleted successfully";
		
		
	}
	
	
	//Get Rooms by roomId
	
	@GetMapping("/rooms/{room_id}")
	public RoomDetails showRoomDetailsById(@PathVariable int room_id,@RequestBody RoomDetails roomDetails) {
		
		this.service.showRoomDetailsById(roomDetails, room_id);
		return roomDetails;
	}
	
	

}
