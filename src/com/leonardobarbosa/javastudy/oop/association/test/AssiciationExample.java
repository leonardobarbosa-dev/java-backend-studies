package com.leonardobarbosa.javastudy.oop.association.test;

import com.leonardobarbosa.javastudy.oop.association.domain.Player;
import com.leonardobarbosa.javastudy.oop.association.domain.Team;

public class AssiciationExample {
    public static void main(String[] args) {

        /*
        - Associação:
        Objetos podem possuir referência para outros objetos.

        - Associação unidirecional:
        apenas um objeto conhece o outro
        Player -> Team

        - Associação bidirecional
        os dois objetos possuem referência entre si
        */

        Team team = new Team("Brazil");
        Player player = new Player("Pele");

        player.setTeam(team);
        player.print();
    }
}
