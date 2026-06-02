package com.leonardobarbosa.javastudy.utils.wrappers;

import java.util.ArrayList;
import java.util.List;

public class WrapperComparisonsExample {
    public static void main(String[] args) {

        /*
         == compara referência (memória)
         .equals compara valor
         */

        Integer a = 100;
        Integer b = 100;

        System.out.println(a == b);
        System.out.println(a.equals(b));


        // Nunca use == com wrappers
        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);
        System.out.println(c.equals(d));

    }
}
