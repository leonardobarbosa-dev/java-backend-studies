package com.leonardobarbosa.javastudy.oop.classes.test;

import com.leonardobarbosa.javastudy.oop.classes.domain.Car;

public class CarExample {

    public static void main(String[] args) {

        Car wv = new Car();
        wv.name = "voyage";
        wv.color = "vermelho";
        wv.model = "sedan";
        wv.year = 1997;

        System.out.println("Carro: " + wv.name +
                " - Modelo: " + wv.model +
                " - Ano de fabricação: " + wv.year +
                " - Cor: " + wv.color);

        Car nissan = new Car();
        nissan.name = "Skyline";
        nissan.color = "prata";
        nissan.model = "sedan";
        nissan.year = 2002;

        System.out.println("Carro: " + nissan.name +
                " - Modelo: " + nissan.model +
                " - Ano de fabricação: " + nissan.year +
                " - Cor: " + nissan.color);
    }
}