package com.leonardobarbosa.javastudy.exceptions.flow;

public class ExceptionPropagationExample {
    public static void main(String[] args) {

        /*
        Demonstrar a propagação de uma exception:

        - O erro ocorre em methodOne()
        - Propaga para methodTwo()
        - Sobe para o main
        - Chega na JVM

        -> Se não for tratado, a exception sobe até a JVM e encerra o programa
         */

        methodTwo();
    }

    /*
    Fluxo básico de exception:

    1. a exception ocorre
    2. a execução do metodo é interrompida
    3. a exception sobe pela call stack
    4. pode ser tratada por um catch
    5. se não for tratada, chega na JVM
    6. a aplicação é encerrada
     */

    public static void methodTwo() {
        methodOne();
    }

    public static void methodOne() {
        int x = 10 / 0;
    }
}
