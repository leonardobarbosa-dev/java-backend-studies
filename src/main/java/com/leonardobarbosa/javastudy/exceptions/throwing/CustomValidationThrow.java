package com.leonardobarbosa.javastudy.exceptions.throwing;

public class CustomValidationThrow {
    public static void main(String[] args) {

        /*
        Validar dados de entrada

        Lançar exceptions é uma forma de proteger
        as regras da aplicação contra dados inválidos.

        Falhar rapidamente costuma ser melhor do que
        permitir que dados incorretos continuem no sistema
         */


        registerUser("Leonardo");
    }

    public static void registerUser(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório!");
        }
        System.out.println("Usuário cadastrado: " + name);
    }
}
