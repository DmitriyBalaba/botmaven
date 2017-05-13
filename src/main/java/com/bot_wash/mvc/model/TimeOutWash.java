package com.bot_wash.mvc.model;

import java.util.Date;


public class TimeOutWash {

    private boolean free = true;
    private String firstName;
    private String lastName;
    private Date dateNow;
    private Long time;
    private String message;

    public TimeOutWash() {}

    public boolean checkTime(){

        return false;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateNow() {
        return dateNow;
    }

    public void setDateNow(Date now) {
        this.dateNow = now;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
