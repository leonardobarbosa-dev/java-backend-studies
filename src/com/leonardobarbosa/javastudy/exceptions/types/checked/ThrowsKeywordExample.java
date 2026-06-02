package com.leonardobarbosa.javastudy.exceptions.types.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsKeywordExample {
    public static void main(String[] args) {

        /*
        Demonstrar o uso de throws:

        - throws não trata a exception, ele apenas informa que o metodo
        pode lançar aquela exception e transfere
        a responsabilidade para quem o chamou.

        Em algum ponto da aplicação,
        a exception deverá ser tratada.

         */

//        readFile();

    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("text.txt");

    }
}
