package com.Team4.project.service.services;

import com.Team4.project.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    public User showUser(int id);

    public User addUser(User user);

    public String removeUser(int id);

    public User updateUser(User user);

    public User getUserByUser_name(String user_name);

    public User getUserByEmail(String email);

    public User getUserByMobile(String mobile);

}
