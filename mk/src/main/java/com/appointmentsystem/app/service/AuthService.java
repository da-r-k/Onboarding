package com.appointmentsystem.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentsystem.app.model.Users;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AuthService {

    @Autowired
    private com.appointmentsystem.app.repository.userRepo userRepo;

    public boolean isValid(Users user) {
        if(!userRepo.existsById(user.getUsername())){
            return false;
        }
        return BCrypt.verifyer().verify(user.getPassword().toCharArray(), userRepo.findByUsername(user.getUsername()).getPassword()).verified;
    }
    
}
