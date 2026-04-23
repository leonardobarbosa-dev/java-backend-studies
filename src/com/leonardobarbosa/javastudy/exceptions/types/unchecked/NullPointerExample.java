package com.leonardobarbosa.javastudy.exceptions.types.unchecked;

public class NullPointerExample {
    public static void main(String[] args) {

        /*
        NullPointerException -> Acontece ao acessar algo que não existe - Erro mais comum em java
        - variável sem instancia
        */
        String text = null;

        System.out.println(text.length());
    }
}
