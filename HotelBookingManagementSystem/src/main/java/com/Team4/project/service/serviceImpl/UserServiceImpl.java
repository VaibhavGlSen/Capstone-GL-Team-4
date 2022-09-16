package com.Team4.project.service.serviceImpl;

import com.Team4.project.entity.User;
import com.Team4.project.repository.IUserRepository;
import com.Team4.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User showUser(int id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User addUser(User user) {
        //TODO : yet to be completed
        return userRepository.save(user);
    }

    @Override
    public String removeUser(int id) {
        userRepository.deleteById(id);
        return "User has been deleted";
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserByUser_name(String user_name) {
        List<User> users = getAllUsers();
        for (User user : users)
            if(user.getUser_name().equalsIgnoreCase(user_name))
                return user;
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> users = getAllUsers();
        for (User user : users)
            if(user.getEmail().equalsIgnoreCase(email))
                return user;
        return null;
    }

    @Override
    public User getUserByMobile(String mobile) {
        List<User> users = getAllUsers();
        for (User user : users)
            if(user.getMobile().equals(mobile))
                return user;
        return null;
    }
}
