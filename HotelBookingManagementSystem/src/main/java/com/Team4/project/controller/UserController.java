package com.Team4.project.controller;

import com.Team4.project.entity.BookingDetails;
import com.Team4.project.entity.Hotel;
import com.Team4.project.entity.Payment;
import com.Team4.project.entity.RoomDetails;
import com.Team4.project.entity.Transaction;
import com.Team4.project.entity.User;
import com.Team4.project.exception.BookingsNotFoundException;
import com.Team4.project.exception.UserNotFoundException;
import com.Team4.project.repository.IHotelRepository;
import com.Team4.project.repository.IRoomDetailsRepository;
import com.Team4.project.repository.ITransactionRepository;
import com.Team4.project.repository.IUserRepository;
import com.Team4.project.service.services.BookingDetailsService;
import com.Team4.project.service.services.PaymentService;
import com.Team4.project.service.services.TransactionService;
import com.Team4.project.service.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;
    
    @Autowired
    BookingDetailsService bookingService;
    
    @Autowired
    IRoomDetailsRepository roomRepo;
    
    @Autowired
    IUserRepository userRepo;
    
    @Autowired
    IHotelRepository hotelRepo;
    
    @Autowired
    ITransactionRepository transRepo;
    
    @Autowired
    PaymentService paymentservice;
    
    @Autowired
    TransactionService transservice;

    //GET method to show all users
    @GetMapping("/")
	public List<User> showUsers(){
		return userservice.getAllUsers();
	}
    
    
    
    //POST method to add a new User
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		Optional<User> userById = userservice.showUser(user.getUser_id());		
		if(userById.isPresent())
			throw new UserNotFoundException("user with id "+user.getUser_id()+" exists");
		
		return userservice.addUser(user);
	}
	
	
	
	//PUT method to update User
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}
	
	
	//Delete method to delete user by Id
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		Optional<User> user = userservice.showUser(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User with id "+id+" not exists");
		return userservice.removeUser(id);
		
	}
	
	//GET method to fetch User by User Id
	@GetMapping("/{id}")
	public User getUserbyId(@PathVariable("id") int id) {
		Optional<User> user = userservice.showUser(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User with id "+id+" not exists");
		return user.get();
	}
	
	

	
	
	@GetMapping("/mobile/{mobile_no}")
	public List<User> getUserbyMobile(@PathVariable("mobile_no") String mobile) {
		List<User> user = userservice.getUserByMobile(mobile);
		if (user.isEmpty())
			throw new UserNotFoundException("User does not exist");
		return user;
	}
	
	
	@GetMapping("/email/{email}")
	public List<User> getUserbyEmail(@PathVariable("email") String email) {
		List<User> user = userservice.getUserByEmail(email);
		if (user.isEmpty())
			throw new UserNotFoundException("User does not exist");
		return user;
	}
	
	
	//Add Booking Details
		@PostMapping("/booking/")
		public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails) {
			
			User user=userRepo.findById(bookingDetails.getUser_id()).get();
			
			
			Hotel hotel=hotelRepo.findById(bookingDetails.getHotel_id()).get();

			

			
			Optional<BookingDetails> bookingsById = bookingService.showBookingDetails(bookingDetails.getBooking_id());

			if(bookingsById.isPresent())
				throw new BookingsNotFoundException("Booking with Id "+bookingDetails.getBooking_id()+" exists");
			List<RoomDetails> room = new ArrayList<>();
			for(RoomDetails a:bookingDetails.getRoom_details()) {
				RoomDetails r = roomRepo.findById(a.getRoom_id()).get();
				room.add(r);
			}
				
				bookingDetails.setRoom_details(room);
				bookingDetails.setUser(user);
				bookingDetails.setHotel(hotel);
			this.bookingService.addBookingDetails(bookingDetails);
			
			return bookingDetails;
		}
		
		
		//GET All 
		@GetMapping("/bookings/all")
		public List<BookingDetails> listAllBookingDetails(){
			
			return this.bookingService.showAllBookingDetails();
		}
		
		//Adding payment
		@PostMapping("/payment")
		public Payment addPayment(@RequestBody Payment payment) {
			Transaction t = transRepo.findById(payment.getTransaction_id()).get();
			payment.setTransaction(t);
			return paymentservice.addPayment(payment);
		}
		
		//Adding transaction
		@PostMapping("/transaction")
		public Transaction addTransaction(@RequestBody Transaction transaction) {
			return transservice.addTransaction(transaction);
		}
	
    
	}
	
