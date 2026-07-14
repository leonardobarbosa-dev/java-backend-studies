package com.leonardobarbosa.javastudy.innerclasses.intro;

public class InnerClassIntroExample {

    /*
    Classe interna -> classe definida dentro de outra classe
    Tipos:
    - Classe interna de instância  -> acessa membros da classe externa, inclusive private
    - Classe local                 -> definida dentro de um metodo
    - Classe anônima               -> sem nome, implementa interface ou estende classe no local
    - Classe aninhada estática     -> static, não acessa membros de instância da classe externa
     */

    private String name = "InnerClassIntroExample";

    class Inner {
        // acessa o campo private da classe externa diretamente
        void print() {
            System.out.println("acessando name da classe externa -> " + name);
        }
    }

    public static void main(String[] args) {

        InnerClassIntroExample outer = new InnerClassIntroExample();

        // para instanciar Inner, precisa de uma instância da classe externa
        InnerClassIntroExample.Inner inner = outer.new Inner();
        inner.print();

        // forma mais comum: instanciar direto a partir da referência
        Inner inner2 = outer.new Inner();
        inner2.print();
    }
}