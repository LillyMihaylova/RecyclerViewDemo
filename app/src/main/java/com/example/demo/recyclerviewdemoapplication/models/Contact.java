package com.example.demo.recyclerviewdemoapplication.models;

public class Contact {

    private String name;
    private String phoneNumber;
    private boolean isInPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isInPhone() {
        return isInPhone;
    }

    public void setInPhone(boolean inPhone) {
        isInPhone = inPhone;
    }
}
