package com.Team4.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.RoomDetails;
import com.Team4.project.repository.RoomDetailsRepo;

@Service
public class RoomDetailServiceImpl implements RoomDetailService{
	@Autowired
	RoomDetailsRepo repo;

	@Override
	public RoomDetails addRoomDetails(RoomDetails roomDetails) {
		this.repo.save(roomDetails);
		return roomDetails;
	}

	@Override
	public ResponseEntity<RoomDetails> updateRoomDetails(int room_id, RoomDetails roomDetails) {
		RoomDetails updateRoom=this.repo.findById(room_id).orElseThrow();
		
		updateRoom.setIsavailable(roomDetails.getIsavailable());
		updateRoom.setPhoto(roomDetails.getPhoto());
		updateRoom.setRate_per_day(roomDetails.getRate_per_day());
		updateRoom.setRoom_id(roomDetails.getRoom_id());
		updateRoom.setRoom_no(roomDetails.getRoom_no());
		updateRoom.setRoom_type(roomDetails.getRoom_type());
		
		 repo.save(updateRoom);
		 
			return ResponseEntity.ok(updateRoom);
	}

	@Override
	public void removeRoomDetails(int Id) {
		this.repo.deleteById(Id);
		
	}

	@Override
	public List<RoomDetails> showAllRoomDetails(RoomDetails roomDetails) {
		return this.repo.findAll();
	}

	@Override
	public RoomDetails showRoomDetailsById(RoomDetails roomDetails, int room_id) {
	RoomDetails currentRoom=this.repo.findById(room_id).orElseThrow();
	
	return currentRoom;
		
	}
	
	

}
