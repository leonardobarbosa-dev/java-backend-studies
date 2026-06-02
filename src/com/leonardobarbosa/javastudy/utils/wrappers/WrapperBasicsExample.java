package com.leonardobarbosa.javastudy.utils.wrappers;

import java.util.ArrayList;
import java.util.List;

public class WrapperBasicsExample {
    public static void main(String[] args) {

        /*
         CLASSES WRAPPER
         - Versões objetos dos tipos primitivos
         - Necessários em Collections e Generics
         - Podem ser null (diferente de primitivos)

         TABELA DE CORRESPONDÊNCIA:
         byte    -> Byte
         short   -> Short
         int     -> Integer
         long    -> Long
         float   -> Float
         double  -> Double
         char    -> Character
         boolean -> Boolean
         */

        // Autoboxing e unboxing
        Integer a = 10; // autoboxing (int vira Integer)
        int b = a;  // unboxing (Integer vira int)
        System.out.println("Valor: " + b);

        // Wrappers podem ser null
        Integer n = null;
        System.out.println("Integer: " + n);

        // Uso em Collections
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        int sum = 0;
        for (int i : list) {    // unboxing
            sum += i;
        }
        System.out.println("Soma: " + sum);

    }
}
