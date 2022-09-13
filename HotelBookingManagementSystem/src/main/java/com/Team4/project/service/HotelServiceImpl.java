package com.Team4.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.entity.Hotel;
import com.Team4.project.entity.RoomDetails;
import com.Team4.project.exception.HotelsNotFoundException;
import com.Team4.project.repository.BookingDetailsRepo;
import com.Team4.project.repository.HotelRepo;
import com.Team4.project.repository.RoomDetailsRepo;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired 
	HotelRepo hotelrepo;
	
	@Autowired
	RoomDetailsRepo roomrepo;
	
	@Autowired
	BookingDetailsRepo bookingrepo;

	@Override
	public Hotel addHotel(Hotel hotel) {
		BookingDetails bookingDetails=bookingrepo.findById(hotel.getBookingDetails().getBooking_id()).get();
		

		List<RoomDetails>add=new ArrayList<>();
		for(RoomDetails a:hotel.getRoomDetails()) {
			RoomDetails room=roomrepo.findById(a.getRoom_id()).get();
			add.add(room);	
		}
		
		hotel.setBookingDetails(bookingDetails);
		hotel.setRoomDetails(add);
		
		this.hotelrepo.save(hotel);
	return hotel;
	}

	@Override
	public ResponseEntity<Hotel> updateHotel(int hotel_id, Hotel hotel) {
Hotel updateHotel=this.hotelrepo.findById(hotel_id).orElseThrow();
		
updateHotel.setAddress(hotel.getAddress());
updateHotel.setAvg_rate_per_day(hotel.getAvg_rate_per_day());
updateHotel.setCity(hotel.getCity());
updateHotel.setDescription(hotel.getDescription());
updateHotel.setEmail(hotel.getEmail());
updateHotel.setHotel_name(hotel.getHotel_name());
updateHotel.setPhone1(hotel.getPhone1());
updateHotel.setPhone2(hotel.getPhone2());
updateHotel.setWebsite(hotel.getWebsite());
updateHotel.setRoomDetails(hotel.getRoomDetails());
updateHotel.setBookingDetails(hotel.getBookingDetails());

		
		 this.hotelrepo.save(updateHotel);
		 return ResponseEntity.ok(hotel);
	}

	@Override
	public void removeHotel(int Id) {
		this.hotelrepo.deleteById(Id);
	}

	@Override
	public List<Hotel> showAllHotels(Hotel hotel) {
		return this.hotelrepo.findAll();
	}
	
	
	
	//--------------------------------------------------------//
	//show hotels by Id
	@Override
	public Hotel showHotelsById( int hotel_id) {
Optional<Hotel> hotelById=this.hotelrepo.findById(hotel_id);
		
				if(!hotelById.isPresent())
			throw new HotelsNotFoundException();
		return hotelById.get();
	}

}
