package com.leonardobarbosa.javastudy.exceptions.flow;

public class MultipleCatchFlowExample {
    public static void main(String[] args) {

        /*
        Tratar diferentes tipos de exception

        - apenas uma exception é lançada por vez
        e um bloco catch será executado
        - o Java utiliza o primeiro catch compatível

        Por isso, os catches mais específicos
        devem vir antes dos mais genéricos.
         */

        try {
            String text = null;
            System.out.println(text.length());

            int x = 10 / 0;
        } catch (NullPointerException e) {
            System.out.println("Tratou NullPointerException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Tratou ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Tratou Exception genérica: " + e.getMessage());
        }
    }
}
