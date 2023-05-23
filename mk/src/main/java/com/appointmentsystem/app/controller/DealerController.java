package com.appointmentsystem.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appointmentsystem.app.model.Appointment;
import com.appointmentsystem.app.model.Users;
import com.appointmentsystem.app.service.AppointmentService;
import com.appointmentsystem.app.service.AuthService;
import com.appointmentsystem.app.service.AuthorizationService;

@Controller
@RequestMapping("/dealer")
public class DealerController {
    
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/view_appointments")
    public ResponseEntity<List<Appointment>> viewAppointments(@RequestBody Users user){
        List<Appointment>ret = new ArrayList<Appointment>();
        if(!authService.isValid(user)){
            System.out.println(authService.isValid(user));
            return new ResponseEntity<>(ret, HttpStatus.UNAUTHORIZED);
        }
        if(!authorizationService.authorizeDealer(user)){
            return new ResponseEntity<>(ret, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(appointmentService.getAppointmentsByDealerUsername(user.getUsername()), HttpStatus.OK);     
    }

    @PostMapping("/update")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment){
        // if(!authService.isValid(user)){
        //     System.out.println(authService.isValid(user));
        //     return new ResponseEntity<>(new Appointment(), HttpStatus.UNAUTHORIZED);
        // }
        // if(!authorizationService.authorizeClient(user)){
        //     System.out.println(authorizationService.authorizeDealer(user));
        //     return new ResponseEntity<>(new Appointment(), HttpStatus.FORBIDDEN);
        // }
        // if(!appointmentService.validAppointment(user,appointment)){
        //     return new ResponseEntity<>(new Appointment(), HttpStatus.FORBIDDEN);
        // }
        return new ResponseEntity<>(appointmentService.updateAppointment(appointment), HttpStatus.OK);
    }
}
