package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class NullPointerExample {
    public static void main(String[] args) {

        /*
        NullPointerException

        Ocorre ao acessar um metodo ou atributo
        de uma referência que aponta para null.

        (uma das exceptions mais comuns)
        */

        String text = null;

        System.out.println(text.length());
    }
}
