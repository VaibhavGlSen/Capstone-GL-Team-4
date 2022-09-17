package com.Team4.project.controller;

import com.Team4.project.entity.User;
import com.Team4.project.exception.UserNotFoundException;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;

    @GetMapping("/")
	public List<User> showUsers(){
		return userservice.getAllUsers();
	}
    
    
    

	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		Optional<User> userById = userservice.showUser(user.getUser_id());		
		if(userById.isPresent())
			throw new UserNotFoundException("user with id "+user.getUser_id()+" exists");
		
		return userservice.addUser(user);
	}
	
	
	
	
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		Optional<User> user = userservice.showUser(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User with id "+id+" not exists");
		return userservice.removeUser(id);
		
	}
	
	
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
    
}
