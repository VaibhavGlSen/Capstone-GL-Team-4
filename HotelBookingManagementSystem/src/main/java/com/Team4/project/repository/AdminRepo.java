package com.Team4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Team4.project.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{

}
