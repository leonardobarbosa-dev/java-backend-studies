package com.leonardobarbosa.javastudy.utils.wrappers;

import java.util.Objects;

public class NullHandlingExample {
    public static void main(String[] args) {

        Integer value = null;

        // Forma segura
        if (value != null) {
            System.out.println("Dobro: " + value * 2);
        } else {
            System.out.println("Valor é nulo, usando padrão.");
        }

        // Alternativa com operador ternário
        int result = (value != null) ? value * 2 : 0;
        System.out.println("Resultado: " + result);

        // Proteção explícita
        try {
            Objects.requireNonNull(value, "valor não pode ser null");
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Metodo com tratamento para wrapper
        System.out.println(calculate(10));   // 20
        System.out.println(calculate(value)); // 0 (null tratado)

    }


    // Ideal: tratar null no próprio metodo
    static int calculate(Integer valor) {
        if (valor == null) return 0;
        return valor * 2;
    }
}
