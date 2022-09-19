package com.Team4.project.controller;

import com.Team4.project.entity.Role;
import com.Team4.project.entity.User;
import com.Team4.project.entity.request.SignInRequest;
import com.Team4.project.entity.request.SignUpRequest;
import com.Team4.project.entity.response.JwtResponse;
import com.Team4.project.entity.response.MessageResponse;
import com.Team4.project.jwt.JwtUtil;
import com.Team4.project.service.serviceImpl.jwt.UserDetailsImpl;
import com.Team4.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser( @RequestBody SignUpRequest signUpRequest) {

        if(userService.getUserByUser_name(signUpRequest.getUser_name()) !=null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username already exists!"));
        }

        if(userService.getUserByEmail(signUpRequest.getEmail())!=null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email already exists!"));
        }

        if(userService.getUserByMobile(signUpRequest.getMobile())!=null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Mobile already exists!"));
        }

        //Adding to the user table

        //Lombok
//        User users = User.builder()
//                .userName(signUpRequest.getUserName())
//                .email(signUpRequest.getEmail())
//                .password(passwordEncoder.encode(signUpRequest.getPassword()))
//                .role(
//                        (signUpRequest.getRole().equalsIgnoreCase("ADMIN"))
//                                ? Role.ADMIN
//                                : Role.CUSTOMER
//                )
//                .address(signUpRequest.getAddress())
//                .mobile(signUpRequest.getMobile())
//                .build();

        //user made Constructor, getter-setters
        User user = new User();
        user.setAddress(signUpRequest.getAddress());
        user.setEmail(signUpRequest.getEmail());
        user.setMobile(signUpRequest.getMobile());
        user.setRole(
                (signUpRequest.getRole().equalsIgnoreCase("ADMIN"))
                        ? Role.ADMIN
                        : Role.CUSTOMER
        );
        user.setUser_name(signUpRequest.getUser_name());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userService.addUser(user);

        //If the role is admin, adding to the admin table
//        if(user.getRole()== Role.ADMIN){
//            Admin admin = Admin.builder()
//                    .adminId(
//                            userService
//                                    .getUserByUsername(user.getUserName())
//                                    .getUserId()
//                    )
//                    .adminName(user.getUserName())
//                    .password(passwordEncoder.encode(user.getPassword()))
//                    .build();
//            adminService.addAdmin(admin);
//        }

//        return  ResponseEntity.ok(MessageResponse.builder().message("Registered Successfully").build());
        return  ResponseEntity.ok(new MessageResponse("Registered Successfully"));
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody SignInRequest signInRequest)throws Exception{

        if(userService.getUserByUser_name(signInRequest.getUser_name())==null)
            throw new Exception("Username does not exists");

//        final boolean isAdmin= adminService.existsByAdmin_name(signInRequest.getUsername());

        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                signInRequest.getUser_name(),
                signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList()).get(0);
        System.err.println("AuthController/signIn: "+ role);

        return "Role: "+ role+"\n"+"Token: "+jwt;
    }
}
