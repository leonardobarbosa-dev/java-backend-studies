package com.leonardobarbosa.javastudy.oop.association.domain;

public class Player {

    /*
    Associação unidirecional:
    - O jogador conhece o time,
    mas o time não conhece o jogador.
     */

    private String name;
    private Team team;

    public void print() {
        System.out.println("Jogador: " + this.name);
        if (team != null) {
            System.out.println("Time: " + team.getTeamName());
        }
    }

    // Construtor
    public Player(String name) {
        this.name = name;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
