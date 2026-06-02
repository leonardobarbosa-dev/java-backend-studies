package com.leonardobarbosa.javastudy.oop.abstraction.test;

import com.leonardobarbosa.javastudy.oop.abstraction.domain.Developer;
import com.leonardobarbosa.javastudy.oop.abstraction.domain.Worker;
import com.leonardobarbosa.javastudy.oop.abstraction.domain.Manager;

public class AbstractionExample {
    public static void main(String[] args) {

        Developer developer = new Developer("Kira", 14500);
        System.out.println(developer);

        Manager manager = new Manager("Ryuuk", 12000);
        System.out.println(manager);

        /*
        Mesmo usando referência do tipo Worker,
        o objeto real continua sendo Manager.

        O Java executa o metodo sobrescrito
        de acordo com o tipo real do objeto.
         */
        Worker worker = new Manager("Nicolas Cage", 100000);
        System.out.println(worker);

    }
}
