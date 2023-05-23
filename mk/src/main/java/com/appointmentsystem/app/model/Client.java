package com.appointmentsystem.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

    @Id
    private String username;
    private String clientName;
    private String dealerUsername;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDealerUsername() {
        return dealerUsername;
    }

    public void setDealerUsername(String dealerUsername) {
        this.dealerUsername = dealerUsername;
    }

    @Override
    public String toString() {
        return "Client [username=" + username + ", clientName=" + clientName + ", dealerUsername=" + dealerUsername
                + "]";
    }

}
