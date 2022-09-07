package com.Team4.project.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.RoomDetails;
import com.Team4.project.repository.IRoomDetailsRepository;
import com.Team4.project.service.services.RoomDetailsService;

@Component
public class RoomDetailsServiceImpl implements RoomDetailsService{
	@Autowired
	IRoomDetailsRepository repo;

	@Override
	public RoomDetails addRoomDetails(RoomDetails roomdetails) {
		repo.save(roomdetails);
		return roomdetails;
	}

	@Override
	public RoomDetails updateRoomDetails(RoomDetails roomdetails) {
		repo.save(roomdetails);
		return roomdetails;
	}

	@Override
	public String removeRoomDetails(int id) {
		repo.deleteById(id);
		return "Record has been deleted!";
	}

	@Override
	public List<RoomDetails> showAllRoomDetails() {
		return repo.findAll();
	}

	@Override
	public RoomDetails showRoomDetails(int id) {
		return repo.findById(id).get();
	}

}
