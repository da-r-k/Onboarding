package com.appointmentsystem.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dealer")
public class Dealer {

    @Id
    private String username;
    private String dealerName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    @Override
    public String toString() {
        return "Dealer [username=" + username + ", dealerName=" + dealerName + "]";
    }

}
