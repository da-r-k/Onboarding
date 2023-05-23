package com.appointmentsystem.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentsystem.app.model.Users;
import com.appointmentsystem.app.repository.userRepo;

@Service
public class AuthorizationService {

    @Autowired
    private userRepo userRepo;

    public boolean authorizeClient(Users user) {
        return (userRepo.findByUsername(user.getUsername()).getRole()).equals("client");
    }

    public boolean authorizeDealer(Users user) {
        return (userRepo.findByUsername(user.getUsername()).getRole()).equals("dealer");
    }
    
}
