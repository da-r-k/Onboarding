package com.appointmentsystem.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appointmentsystem.app.model.Client;
import com.appointmentsystem.app.model.Dealer;
import com.appointmentsystem.app.model.Users;
import com.appointmentsystem.app.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @PostMapping("/add_client/{dealer_username}")
    public ResponseEntity<Client> addClient(@RequestBody Users user, @PathVariable String dealer_username){
        user.setRole("client");
        return new ResponseEntity<Client>(adminService.addClient(user,dealer_username),HttpStatus.CREATED);
    }

    @PostMapping("/add_dealer")
    public ResponseEntity<Dealer> addDealer(@RequestBody Users user){
        user.setRole("dealer");
        return new ResponseEntity<Dealer>(adminService.addDealer(user),HttpStatus.CREATED);
    }

}
