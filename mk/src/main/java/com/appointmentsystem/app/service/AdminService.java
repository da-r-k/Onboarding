package com.appointmentsystem.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentsystem.app.model.Client;
import com.appointmentsystem.app.model.Dealer;
import com.appointmentsystem.app.model.Users;
import com.appointmentsystem.app.repository.clientRepo;
import com.appointmentsystem.app.repository.dealerRepo;
import com.appointmentsystem.app.repository.userRepo;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AdminService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private clientRepo clientRepo;

    @Autowired
    private dealerRepo dealerRepo;

    public Client addClient(Users user, String dealerUsername) {
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        userRepo.save(user);
        Client ret = new Client();
        ret.setUsername(user.getUsername());
        ret.setDealerUsername(dealerUsername);
        return clientRepo.save(ret);
    }

    public Dealer addDealer(Users user) {
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        userRepo.save(user);
        Dealer ret = new Dealer();
        ret.setUsername(user.getUsername());
        return dealerRepo.save(ret);
    }

}
