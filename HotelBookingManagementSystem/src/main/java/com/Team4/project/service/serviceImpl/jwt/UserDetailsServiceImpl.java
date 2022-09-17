package com.Team4.project.service.serviceImpl.jwt;

import com.Team4.project.entity.User;
import com.Team4.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	 User user = userService.getUserByUser_name(username).get(0);
         return UserDetailsImpl.build(user);
    }
}
