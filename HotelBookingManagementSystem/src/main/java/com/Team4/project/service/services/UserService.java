package com.Team4.project.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Team4.project.entity.User;

@Service
public interface UserService {
	
	public List<User> getAllUsers();

    public Optional<User> showUser(int id);

    public User addUser(User user);

    public String removeUser(int id);

    public User updateUser(User user);

    public List<User> getUserByUser_name(String user_name);

    public List<User> getUserByEmail(String email);

    public List<User> getUserByMobile(String mobile);
}
