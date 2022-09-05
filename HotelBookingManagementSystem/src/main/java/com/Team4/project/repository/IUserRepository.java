package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.project.entity.User;

public interface IUserRepository extends JpaRepository<User,Integer>{

}
