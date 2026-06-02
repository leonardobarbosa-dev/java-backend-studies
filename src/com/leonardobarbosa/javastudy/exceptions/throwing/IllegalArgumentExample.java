package com.leonardobarbosa.javastudy.exceptions.throwing;

public class IllegalArgumentExample {
    public static void main(String[] args) {

        /*
        Validar argumentos recebidos por um metodo.

        IllegalArgumentException deve ser utilizada quando
        um parâmetro possui valor inválido.

        Exemplos:
        - número negativo onde só positivos são permitidos
        - String vazia em campo obrigatório
        - valor fora do intervalo esperado
         */


        positiveNumber(5);
    }

    public static void positiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("O número não pode ser negativo");
        }
        System.out.println("Número válido: " + number);
    }
}
