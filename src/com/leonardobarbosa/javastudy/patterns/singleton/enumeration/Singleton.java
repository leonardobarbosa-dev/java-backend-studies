package com.leonardobarbosa.javastudy.patterns.singleton.enumeration;

public enum Singleton {

    INSTANCE;

    public void showMessage() {
        System.out.println("Singleton com ENUM...");
    }
}
