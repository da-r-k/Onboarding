package com.appointmentsystem.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer apointmentId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer status = 0;
    private String clientUsername;

    public Integer getApointmentId() {
        return apointmentId;
    }

    public void setApointmentId(Integer apointmentId) {
        this.apointmentId = apointmentId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    @Override
    public String toString() {
        return "Appointment [apointmentId=" + apointmentId + ", startTime=" + startTime + ", endTime=" + endTime
                + ", status=" + status + ", clientUsername=" + clientUsername + "]";
    }

}
