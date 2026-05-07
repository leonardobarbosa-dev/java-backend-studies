package com.leonardobarbosa.javastudy.utils.wrappers;

import java.util.Objects;

public class NullHandlingExample {
    public static void main(String[] args) {

        // Cenário comum de NPE com wrapper
        Integer valor = getNullableValue();

        // RUIM: pode explodir se valor for null
        // int resultado = valor * 2; → NullPointerException

        // BOM 1: verificação manual
        if (valor != null) {
            System.out.println("Dobro: " + valor * 2);
        } else {
            System.out.println("Valor é nulo, usando padrão.");
        }

        // BOM 2: operador ternário
        int result = (valor != null) ? valor * 2 : 0;
        System.out.println("Resultado: " + result);

        // BOM 3: Objects.requireNonNull → lança NPE com mensagem descritiva
        try {
            Integer required = Objects.requireNonNull(valor, "valor não pode ser null");
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Metodo recebendo wrapper → documente se aceita null
        System.out.println(calculate(10));   // 20
        System.out.println(calculate(null)); // 0 (null tratado)

        // Comparação segura com null via Objects.equals
        Integer x = null;
        Integer y = 42;
        System.out.println(Objects.equals(x, y));    // false → sem NPE
        System.out.println(Objects.equals(x, null)); // true
    }

    // Simula retorno que pode ser null (ex: busca em banco, input do usuário)
    static Integer getNullableValue() {
        return null;
    }

    // Boa prática: tratar null no próprio metodo
    static int calculate(Integer valor) {
        if (valor == null) return 0;
        return valor * 2;
    }
}
