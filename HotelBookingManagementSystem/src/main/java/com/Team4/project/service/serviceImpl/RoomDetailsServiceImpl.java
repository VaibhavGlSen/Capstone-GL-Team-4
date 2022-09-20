package com.Team4.project.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.RoomDetails;
import com.Team4.project.repository.IRoomDetailsRepository;
import com.Team4.project.service.services.RoomDetailsService;

@Component
public class RoomDetailsServiceImpl implements RoomDetailsService{
	@Autowired
	IRoomDetailsRepository repo;

	
	//add Room Details
	@Override
	public RoomDetails addRoomDetails(RoomDetails roomdetails) {
		repo.save(roomdetails);
		return roomdetails;
	}

	//Update Room Details
	@Override
	public RoomDetails updateRoomDetails(RoomDetails roomdetails) {
		repo.save(roomdetails);
		return roomdetails;
	}

	//Remove Room details by Id
	@Override
	public String removeRoomDetails(int id) {
		repo.deleteById(id);
		return "Record has been deleted!";
	}

	//Fetch all Room details
	@Override
	public List<RoomDetails> showAllRoomDetails() {
		return repo.findAll();
	}

	
	// get room details by Id
	@Override
	public Optional<RoomDetails> showRoomDetails(int id) {
		return this.repo.findById(id);
		
		
	}

}
