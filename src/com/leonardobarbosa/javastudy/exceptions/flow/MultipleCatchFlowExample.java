package com.leonardobarbosa.javastudy.exceptions.flow;

public class MultipleCatchFlowExample {
    public static void main(String[] args) {

        /*
        Objetivo: Tratar tipos diferentes de exception
        - Apenas um erro ocorre e um catch é executado

        Erro acontece -> fluxo para -> exception sobe -> ou é tratada(continua) -> ou não(programa encerra)
        --------------------------------------------------------------------
        -> O java executa o primeiro catch compatível e ignora os demais.
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
