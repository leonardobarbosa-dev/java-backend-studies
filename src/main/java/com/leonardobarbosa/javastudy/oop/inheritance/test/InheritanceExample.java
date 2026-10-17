package com.leonardobarbosa.javastudy.oop.inheritance.test;

import com.leonardobarbosa.javastudy.oop.inheritance.domain.Address;
import com.leonardobarbosa.javastudy.oop.inheritance.domain.Worker;
import com.leonardobarbosa.javastudy.oop.inheritance.domain.Person;

public class InheritanceExample {
    public static void main(String[] args) {

        /*
        Associacao = "TEM" um
        Herança = "É" um
         */

        /*
        Herança:
        Worker herda atributos e métodos de Person
         */

        Address address = new Address("Groove", "133701-000");

        Worker cj = new Worker("Carl Johnson", "123456789-00", address, 150.000);
        cj.print();

    }
}
