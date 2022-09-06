package com.Team4.project.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.RoomDetails;

@Service
public interface RoomDetailsService {
	
	public RoomDetails addRoomDetails(RoomDetails roomdetails);
	
	public RoomDetails updateRoomDetails(RoomDetails roomdetails);
	
	public String removeRoomDetails(int id);
	
	public List<RoomDetails> showAllRoomDetails();
	
	public RoomDetails showRoomDetails(int id);
}
