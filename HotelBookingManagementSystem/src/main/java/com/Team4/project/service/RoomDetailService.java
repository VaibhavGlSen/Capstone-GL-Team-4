package com.Team4.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.RoomDetails;

@Service
public interface RoomDetailService{
	
	public RoomDetails addRoomDetails(RoomDetails roomDetails);
	
	public ResponseEntity<RoomDetails> updateRoomDetails(int room_id,RoomDetails roomDetails);
	
	public void removeRoomDetails(int Id);
	
	public List<RoomDetails> showAllRoomDetails(RoomDetails roomDetails);
	
	public RoomDetails showRoomDetailsById(RoomDetails roomDetails,int Id);
	
	

}
