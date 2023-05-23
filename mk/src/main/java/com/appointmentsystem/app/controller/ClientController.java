package com.appointmentsystem.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appointmentsystem.app.model.Appointment;
import com.appointmentsystem.app.model.Users;
import com.appointmentsystem.app.service.AppointmentService;
import com.appointmentsystem.app.service.AuthService;
import com.appointmentsystem.app.service.AuthorizationService;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private AuthService authService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping("/view_appointments")
    public ResponseEntity<List<Appointment>> viewAppointments(@RequestBody Users user){
        List<Appointment>ret = new ArrayList<Appointment>();
        if(!authService.isValid(user)){
            System.out.println(authService.isValid(user));
            return new ResponseEntity<>(ret, HttpStatus.UNAUTHORIZED);
        }
        if(!authorizationService.authorizeClient(user)){
            System.out.println(authorizationService.authorizeClient(user));
            return new ResponseEntity<>(ret, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(appointmentService.getAppointmentsByClientUsername(user.getUsername()), HttpStatus.OK);     
    }

    @PostMapping("/book_appointment")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Users user){
        Appointment appointment=new Appointment();
        if(!authService.isValid(user)){
            return new ResponseEntity<>(appointment, HttpStatus.UNAUTHORIZED);
        }
        if(!authorizationService.authorizeClient(user)){
            return new ResponseEntity<>(appointment, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(appointmentService.bookAppointment(user.getUsername()) , HttpStatus.OK);
    }

    @DeleteMapping("/cancel_appointment/{id}")
    public ResponseEntity<String> cancelAppointment(@RequestBody Users user, @PathVariable Integer id){
        if(!authService.isValid(user)){
            System.out.println(authService.isValid(user));
            return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
        }
        if(!authorizationService.authorizeClient(user)){
            System.out.println(authorizationService.authorizeClient(user));
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        if(!appointmentService.validAppointment(user,id)){
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }
        appointmentService.cancelAppointment(id);
        return new ResponseEntity<>("Appointment Cancelled", HttpStatus.OK);     
    }

    
    


}
