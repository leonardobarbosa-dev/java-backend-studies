package com.leonardobarbosa.javastudy.patterns.dto;

public class Address {

    private final String city;
    private final String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
