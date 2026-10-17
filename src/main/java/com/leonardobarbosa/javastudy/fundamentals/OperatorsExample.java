package com.leonardobarbosa.javastudy.fundamentals;

public class OperatorsExample {
    public static void main(String[] args) {

        /*
        Operadores Aritméticos:

        + -> adição
        - -> subtração
        * -> multiplicação
        / -> divisão
        % -> resto da divisão (3 % 2) resto da divisão = 1
         */

        int n1 = 10;
        int n2 = 5;
        int result = n1 % n2;
        System.out.println(result);

        /*
        Operadores Relacionais

        <  -> menor que
        >  -> maior que
        <= -> menor ou igual
        >= -> maior ou igual
        == -> igual
        != -> diferente

        Sempre vão retornar boolean (True or False)
         */

        boolean different = 10 != 20;
        System.out.println(different);

        /*
        Operadores Lógicos

        && = e / and
        || = ou / or
        ! = não / not
         */

        int age = 19;
        int maxWeight = 85;
        boolean ableToWork = age > 21 && maxWeight <= 85;
        System.out.println("Apto ao trabalho: " + ableToWork);

        /*
        Operadores de atribuição

        =  -> atribuição
        += -> valorX = valorX + valorY
        -= -> valorX = valor X - valorY
        *= -> valorX = valorX * 2
        /= -> valorX = valorX / 2
        %= -> valorX = valorX % 2
         */

        int bonus = 1000;
        bonus += 2000;
        System.out.println(bonus);

        /*
        Operadores Unários

        ++ -> +1
        -- -> -1
         */

        int count = 0;
        count++;
        System.out.println(count);

        int countTwo = 9;
        System.out.println(++countTwo); // ++ antes da variável = incrementa, depois executa
    }
}