package com.Team4.project;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Team4.project.controller.HotelController;
import com.Team4.project.entity.Hotel;
import com.Team4.project.jwt.JwtAuthEntryPoint;
import com.Team4.project.jwt.JwtUtil;
import com.Team4.project.repository.IRoomDetailsRepository;
import com.Team4.project.service.serviceImpl.jwt.UserDetailsServiceImpl;
import com.Team4.project.service.services.HotelService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(HotelController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HotelControllerTest {
	
	 @Autowired
	 MockMvc mockMvc;
	 
	 @MockBean
	 UserDetailsServiceImpl userservice;
	 
	 @MockBean
	 JwtAuthEntryPoint handler;
	 
	 @MockBean
	 HotelService hotelService;
	 
	 @MockBean
	 IRoomDetailsRepository roomrepo;
	 
	 @MockBean
	 JwtUtil jwtUtil;
	 
	 
	 @Autowired
	 ObjectMapper mapper;
	 
	 
	    
	    Hotel RECORD_1 = new Hotel(1, "Noida", "Hotel Taj", "Mumbai","The best Hotel",3000,"hotel@gmail.com","888","999","hotel.com");
	    
	    Hotel RECORD_2 = new Hotel(2, "Gurgaon", "Hotel Trident", "Mumbai","The best Hotel",3000,"hotel@gmail.com","888","999","hotel.com");

	    
	    
	    //TEST method - Hotel added Successfully
	    @Test
	    @Order(1)
	    public void createRecord_success() throws Exception {
	        Hotel hotel = Hotel.builder()
	        		.hotel_id(3)
	                .city("New York")
	                .hotel_name("YSA Hotel")
	                .address("India")
	                .description("Best Hotel")
	                .avg_rate_per_day(3000)
	                .email("hotel@gmail.com")
	                .phone1("888")
	                .phone2("999")
	                .website("hotel.com")
	                .build();

	        Mockito.when(hotelService.addHotel(hotel)).thenReturn(hotel);

	        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/hotel/")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(this.mapper.writeValueAsString(hotel));

	           mockMvc.perform(mockRequest)
	                .andExpect(status().isOk());
	           
	   	    System.out.println("############# TEST 1 ##################");

	        
	        
		     System.out.println("Hotel with name "+RECORD_1.getHotel_name()+" created successfully");


	        
	        
	        }
	    
	    
	    
	    //TEST method - All hotels fetched successfully.

	    @Test
	    @Order(2)

	    public void getAllRecords_success() throws Exception {
	    	
	        List<Hotel> records = new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2));
	     
	        
	        Mockito.when(hotelService.showAllHotels()).thenReturn(records);
	        
	        mockMvc.perform(MockMvcRequestBuilders
	                .get("/hotel/")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        

	     
	     
	   	    System.out.println("############# TEST 2 ##################");

	     
	     System.out.println("All records fetched successfully");
	       
	    }
	    
	    
	    
	    //TEST method - Hotel fetched by Id

	    @Test
	    @Order(3)

	    public void getHotelById_success() throws Exception {
	        Mockito.when(hotelService.showHotel(RECORD_1.getHotel_id())).thenReturn(java.util.Optional.of(RECORD_1));

	          mockMvc.perform(MockMvcRequestBuilders
	                .get("/hotel/1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	        
	          
	          
		   	    System.out.println("############# TEST 3 ##################");

		     System.out.println("Record with Id "+ RECORD_1.getHotel_id()+" fetched successfully.");


	        
	    }
	    
	    
	   
	    //TEST method - Hotel updated by Hotel Id

	    @Test
	    @Order(4)

	    public void updateHotel() throws Exception {
	        Hotel updatedHotel = Hotel.builder()
	                .hotel_id(3)
	                .city("Melampur")
	                .hotel_name("Aiyangar Hotel")
	                .address("Karnataka")
	                .build();

	        Mockito.when(hotelService.showHotel(RECORD_1.getHotel_id())).thenReturn(Optional.of(RECORD_1));
	        Mockito.when(hotelService.updateHotel(updatedHotel)).thenReturn(updatedHotel);

	        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/hotel/")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(this.mapper.writeValueAsString(updatedHotel));

	        mockMvc.perform(mockRequest)
	                .andExpect(status().isOk());
	        
	   	    System.out.println("############# TEST 4 ##################");

	        
		     System.out.println("Record with Id "+RECORD_1.getHotel_id() +" updated successfully");


	        
	        
	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    //TEST method - Hotel Deleted by Hotel Id

	    @Test
	    @Order(5)

	    public void deleteHotelById_success() throws Exception {
	        Mockito.when(hotelService.showHotel(RECORD_2.getHotel_id())).thenReturn(Optional.of(RECORD_2));
	        mockMvc.perform(MockMvcRequestBuilders.delete("/hotel/2")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());	        
	        
	   	    System.out.println("############# TEST 5 ##################");

		     System.out.println("Record with Id "+RECORD_2.getHotel_id() +" deleted successfully");
	        
	        
	        
	    }
	    

		
	    
	    
	    
}
