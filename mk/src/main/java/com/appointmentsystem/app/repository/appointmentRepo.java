package com.appointmentsystem.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.app.model.Appointment;

public interface appointmentRepo extends JpaRepository<Appointment, Integer>{
    List<Appointment> findByClientUsername(String client_username);
    Appointment save(Appointment appointment);
    Appointment findByApointmentId(Integer id);
}
