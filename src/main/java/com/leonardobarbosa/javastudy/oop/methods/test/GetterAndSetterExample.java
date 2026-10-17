package com.leonardobarbosa.javastudy.oop.methods.test;

import com.leonardobarbosa.javastudy.oop.methods.domain.GettersAndSetters;

public class GetterAndSetterExample {
    public static void main(String[] args) {

        GettersAndSetters shinigami = new GettersAndSetters();

        System.out.println(shinigami.getName());    // sem valor atribuido retorna o padrão (no caso da String = null)
        System.out.println(shinigami.getAge());     // (int = 0)

        shinigami.setName("Ryuuk"); // definir nome
        shinigami.setAge(999);  // definir idade

        System.out.println(shinigami.getName());    // get retorna o valor da variável
        System.out.println(shinigami.getAge());
    }
}
