package com.leonardobarbosa.javastudy.oop.overriding.domain;

public class MethodOverride {

    private String name;
    private int seasons;

    @Override
    public String toString() {
        return String.format("Anime [name: %s | seasons: %d]", name, seasons);
    }

    public MethodOverride(String name, int seasons) {
        this.name = name;
        this.seasons = seasons;
    }

}
