package com.appointmentsystem.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentsystem.app.model.Appointment;
import com.appointmentsystem.app.model.Client;
import com.appointmentsystem.app.model.Users;
import com.appointmentsystem.app.repository.appointmentRepo;
import com.appointmentsystem.app.repository.clientRepo;

@Service
public class AppointmentService {

    @Autowired
    private appointmentRepo appointmentRepo;

    @Autowired
    private clientRepo clientRepo;


    public Appointment bookAppointment(String username) {
        Appointment appointment=new Appointment(); 
        appointment.setClientUsername(username);
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> getAppointmentsByClientUsername(String username) {
        return appointmentRepo.findByClientUsername(username);
    }

    public boolean validAppointment(Users user, Integer id) {
        if(!appointmentRepo.existsById(id)){
            return false;
        }
        if(!appointmentRepo.findByApointmentId(id).getClientUsername().equals(user.getUsername())){
            return false;
        }
        if(appointmentRepo.findByApointmentId(id).getStatus()!=0){
            return false;
        }
        return true;
    }

    public void cancelAppointment(Integer id) {
        appointmentRepo.deleteById(id);
    }

    public List<Appointment> getAppointmentsByDealerUsername(String username) {
        List<Client> clientsList = clientRepo.findByDealerUsername(username);
        List<Appointment>ret = new ArrayList<Appointment>();
        for(Client client: clientsList){
            ret.addAll(getAppointmentsByClientUsername(client.getUsername()));
        }
        return ret;
    }

    public boolean validAppointment(Users user, Appointment appointment) {
        Integer id = appointment.getApointmentId();
        if(!appointmentRepo.existsById(id)){
            return false;
        }
        return clientRepo.findByUsername(appointmentRepo.findByApointmentId(id).getClientUsername()).getDealerUsername().equals(user.getUsername());
    }

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    
    
}
