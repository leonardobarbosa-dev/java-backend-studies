package com.leonardobarbosa.javastudy.oop.methods.domain;


public class VoidMethods {

    /*
    Metodo: <modificador de acesso> -> <retorno> -> <nome do metodo>
     */

    public void sum() {
        System.out.println("\nSomar números sem parâmetros:");
        System.out.println("Resultado: " + (15+100));
    }

    public void sumTwoNumbers(int a, int b) {
        int result = a + b;
        System.out.println("\nSoma números com parâmetros:");
        System.out.printf("Resultado: " + result + "\n");
    }


    /*
    O return funciona como um break em metodos void
    - também ficaria correto adicionando o else, mas com return o codigo fica "mais limpo"
     */

    public void division(double a, double b) {
        if (b == 0) {
            System.out.println("Não existe divisão por 0");
            return;
        }
        System.out.println("Resultado divisão: " + (a/b));
    }
}
