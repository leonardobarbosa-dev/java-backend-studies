package com.leonardobarbosa.javastudy.utils.wrappers;

public class WrapperMethodsExample {
    public static void main(String[] args) {

        // Metodos úteis das classes wrappers

        // Integer
        System.out.println(Integer.parseInt("42")); // parseInt: converte String para int primitivo
        System.out.println(Integer.toBinaryString(10)); // toBinaryString: converte número decimal para representação binária em String
        System.out.println(Integer.max(10, 20)); // max: retorna o maior valor entre dois inteiros
        System.out.println(Integer.sum(10, 20)); // sum: retorna a soma de dois valores inteiros

        // Double
        double resultNaN = 0.0 / 0.0;
        double resultInfinity = 1.0 / 0.0;
        double resultNegativeInfinity = -1.0 / 0.0;
        System.out.println(resultInfinity);
        /*
         Em operações com double, o Java não lança exceção para erros matemáticos comuns. Ele devolve valores especiais:

         NaN (Not a Number): resultado de uma operação matemática inválida (ex: 0.0 / 0.0)
         Infinity: resultado de uma divisão por zero positiva (ex: 1.0 / 0.0)
         -Infinity: resultado de uma divisão por zero negativa (ex: -1.0 / 0.0)
         */
        System.out.println(Double.isNaN(resultNaN)); // isNaN: verifica se o valor é "Not a Number" (resultado inválido de operações matemáticas)
        System.out.println(Double.isInfinite(resultInfinity)); // isInfinite: verifica se o valor é infinito (ex: divisão por zero)
        System.out.println(Double.isInfinite(resultNegativeInfinity));

        // Character
        System.out.println(Character.isDigit('5')); // isDigit: verifica se o caractere é um número (0-9)
        System.out.println(Character.isLetter('A')); // isLetter: verifica se o caractere é uma letra

        // Boolean
        System.out.println(Boolean.parseBoolean("true")); // parseBoolean: converte String para boolean (apenas "true" retorna true)
        System.out.println(Boolean.logicalAnd(true, false)); // logicalAnd: operação lógica E (retorna true apenas se ambos forem true)
    }
}
