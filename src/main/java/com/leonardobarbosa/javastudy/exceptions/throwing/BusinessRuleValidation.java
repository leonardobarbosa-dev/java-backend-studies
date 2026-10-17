package com.leonardobarbosa.javastudy.exceptions.throwing;

public class BusinessRuleValidation {
    public static void main(String[] args) {

        /*
        Demonstrar validação de regra de negócio

        IllegalStateException deve ser utilizada quando
        o estado atual do objeto não permite a operação

        Neste exemplo:
        - o valor informado está correto
        porém o pagamento já foi realizado

        O problema não é o argumento recebido
        mas o estado atual da aplicação
         */

        // OK
        try {
            pay(100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // ERRO (o valor já foi pago)
        try {
            pay(100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean paid = false;

    public static void pay(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("O valor a ser pago preciso ser positivo");
        }
        if (paid) {
            throw new IllegalStateException("O valor já foi pago");
        }
        paid = true;
        System.out.println("Valor pago!");
    }
}
