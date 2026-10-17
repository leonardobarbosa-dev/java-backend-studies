package com.leonardobarbosa.javastudy.oop.finalmodifier.domain;

public class Purchaser {

    private String purchaserName;

    @Override
    public String toString() {
        return String.format(" | Comprador: %s%n", this.purchaserName);
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }
}
