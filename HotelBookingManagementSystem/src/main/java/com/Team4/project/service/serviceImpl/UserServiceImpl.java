package com.Team4.project.service.serviceImpl;

import com.Team4.project.entity.User;
import com.Team4.project.repository.IUserRepository;
import com.Team4.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	IUserRepository userRepository;

	//Get all Users
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	//get User by Id
	@Override
	public Optional<User> showUser(int id) {
		return userRepository.findById(id);

	}

	//add a new User
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	// Delete User by Id
	@Override
	public String removeUser(int id) {
		userRepository.deleteById(id);
		return "User has been deleted";
	}

	//Update User Details
	@Override
	public User updateUser(User user) {
		userRepository.save(user);
		return user;
	}

	
	//Get User by Username
	@Override
	public List<User> getUserByUser_name(String user_name) {
		List<User> users = userRepository.findAll();
		List<User> userList = users.stream().filter(e -> e.getUser_name().equalsIgnoreCase(user_name)).collect(Collectors.toList());
		
		return userList;
	}

	
	//Get User by Email
	@Override
	public List<User> getUserByEmail(String email) {
		List<User> users = userRepository.findAll();
		List<User> userList = users.stream().filter(e -> e.getUser_name().equalsIgnoreCase(email)).collect(Collectors.toList());
		
		return userList;
	}

	
	//Get User by mobile
	@Override
	public List<User> getUserByMobile(String mobile) {
		List<User> users = userRepository.findAll();
		List<User> userList = users.stream().filter(e -> e.getUser_name().equalsIgnoreCase(mobile)).collect(Collectors.toList());
		
		return userList;
	}


}
