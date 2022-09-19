package com.Team4.project.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Team4.project.entity.User;
import com.Team4.project.repository.IUserRepository;
import com.Team4.project.service.services.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	IUserRepository repo;

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	@Override
	public Optional<User> showUser(int id) {
		return repo.findById(id);
	}


	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public String removeUser(int id) {
		repo.deleteById(id);
		return "User has been deleted";
	}

	@Override
	public User updateUser(User user) {
		repo.save(user);
		return user;
	}

	@Override
	public List<User> getUserByUser_name(String user_name) {
		List<User> users = repo.findAll();
		List<User> userList = users.stream().filter(e -> e.getUser_name().equalsIgnoreCase(user_name)).collect(Collectors.toList());
		
		return userList;
	}

	@Override
	public List<User> getUserByEmail(String email) {
		List<User> users = repo.findAll();
		List<User> userList = users.stream().filter(e -> e.getUser_name().equalsIgnoreCase(email)).collect(Collectors.toList());
		
		return userList;
	}

	@Override
	public List<User> getUserByMobile(String mobile) {
		List<User> users = repo.findAll();
		List<User> userList = users.stream().filter(e -> e.getUser_name().equalsIgnoreCase(mobile)).collect(Collectors.toList());
		
		return userList;
	}

}
