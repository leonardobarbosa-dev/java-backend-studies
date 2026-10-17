package com.leonardobarbosa.javastudy.exceptions.flow;

public class UnhandledExceptionDemo {
    public static void main(String[] args) {

        /*
        Demonstrar a interrupção do fluxo:

        Quando uma exception não é tratada:
        - a execução é interrompida imediatamente
        - as próximas instruções não são executadas
        - a exception continua propagando pela stack
         */

        System.out.println("Início...");
        methodOne();
        System.out.println("Fim..."); //Não executa
    }

    public static void methodOne() {
        int x = 10 / 0;
    }
}
