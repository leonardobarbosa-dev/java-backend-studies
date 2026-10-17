package com.leonardobarbosa.javastudy.generics.intro;

import java.util.ArrayList;
import java.util.List;

public class IntroExample {
    public static void main(String[] args) {

        /*
        Generics -> permite escrever classes, interfaces e métodos que
        funcionam com qualquer tipo, mantendo segurança de tipo em
        tempo de compilação

        Sem generics -> o compilador não sabe o tipo real,
        qualquer Object pode entrar, e o cast fica por conta do dev
         */

        List noGenerics = new ArrayList();   // raw type -> sem <T>
        noGenerics.add("Sem generics");
        noGenerics.add(123);                 // compilador aceita qualquer coisa

        String s = (String) noGenerics.get(0);   // cast manual necessário
        System.out.println(s);

        try {
            String incorrect = (String) noGenerics.get(1);   // ClassCastException em runtime
        } catch (ClassCastException e) {
            System.out.println("ClassCastException -> " + e.getMessage());
        }

        /*
        Com generics -> o tipo é definido em <T> e verificado em
        tempo de compilação, sem cast manual e sem risco de ClassCastException
         */

        List<String> generics = new ArrayList<>();
        generics.add("Com generics");
//        generics.add(123);    // erro de compilação -> não compila, sem surpresas em runtime

        String safe = generics.get(0);   // sem cast
        System.out.println(safe);

        /*
        <T> é só um nome de convenção:

        T -> Type       (tipo genérico geral)
        E -> Element    (elementos de coleções)
        K -> Key        (chave de Map)
        V -> Value      (valor de Map)
        N -> Number     (tipos numéricos)
        Qualquer letra funciona, mas seguir a convenção facilita a leitura
         */

    }
}
