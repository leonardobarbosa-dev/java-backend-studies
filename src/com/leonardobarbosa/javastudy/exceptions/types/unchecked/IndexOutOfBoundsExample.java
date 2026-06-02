package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBoundsExample {
    public static void main(String[] args) {

        /*
        IndexOutOfBoundsExceptions
        - tentar acessar uma posição que não existe em uma coleção

        Índices válidos:
        0 até size() -1
         */

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Sarah");
        System.out.println(names.get(5));


        /*
        ArrayIndexOutOfBoundsException
        - tentar acessar posição que não existe dentro de um array

        Índices válidos:
        0 até lenght -1
         */

        String[] lastNames = {"Travolta", "Land"};
        System.out.println(lastNames[5]);
    }
}
