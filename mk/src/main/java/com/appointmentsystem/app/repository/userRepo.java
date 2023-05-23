package com.appointmentsystem.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.app.model.Users;

public interface userRepo extends JpaRepository<Users,String>{
    boolean existsById(String username);
    Users findByUsername(String username);
    Users save(Users user);
}
