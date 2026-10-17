package com.leonardobarbosa.javastudy.exceptions.throwing;

public class ThrowKeywordBasic {
    public static void main(String[] args) {

        /*
        Introduzir a palabra-chave com throw

        throw é utilizado para criar e lançae
        uma exception manualmente.
         */


        checkAge(17);
    }

    /*
    Quando usar cada exception:

    IllegalArgumentException
    - argumento inválido

    IllegalStateException
    - estado inválido

    NullPointerException
    - referência nula (geralmente evitar lançar manualmente)

    UnsupportedOperationException
    - operação não suportada

    RuntimeException
    - apenas quando não existir uma exception mais específica
     */

    public static void checkAge(int age) {
        if (age < 18) {
            throw new RuntimeException("A idade mínima é 18.");
        }
        System.out.println("Acesso liberado");
    }
}
