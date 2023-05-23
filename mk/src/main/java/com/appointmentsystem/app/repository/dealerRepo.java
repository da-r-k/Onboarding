package com.appointmentsystem.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.app.model.Dealer;

public interface dealerRepo extends JpaRepository<Dealer, String>{
    boolean existsById(String username);
    Dealer findByUsername(String username);
    Dealer save(Dealer dealer);
}
