package com.appointmentsystem.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.app.model.Client;
import com.appointmentsystem.app.model.Users;

public interface clientRepo extends JpaRepository<Client, String>{
    boolean existsById(String username);
    Client findByUsername(String username);
    Client save(Client client);
    List<Client> findByDealerUsername(String username);
}
