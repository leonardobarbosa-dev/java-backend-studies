package com.leonardobarbosa.javastudy.utils.collections.contract;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {
    public static void main(String[] args) {

        /*
        hashCode() -> gera um número (int) a partir do objeto
        - usado por HashSet/HashMap pra decidir em qual "balde" guardar o objeto

        String sobrescreve hashCode() -> calcula a partir do conteúdo
        - duas Strings com o mesmo texto têm o mesmo hashCode
         */

        String a = "Java";
        String b = new String("Java");

        System.out.println("a.hashCode() -> " + a.hashCode());
        System.out.println("b.hashCode() -> " + b.hashCode());
        System.out.println("a.hashCode() == b.hashCode() -> " + (a.hashCode() == b.hashCode()));

        /*
        Sem sobrescrever, hashCode() vem de Object -> baseado na referência
        (na prática, varia conforme o objeto, não o conteúdo)
         */

        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println("o1.hashCode() == o2.hashCode() -> " + (o1.hashCode() == o2.hashCode()));
        System.out.println("o1.equals(o2) : " + (o1.equals(o2)));

        /*
        HashSet usa hashCode() PRIMEIRO pra decidir onde procurar,
        e só depois confirma com equals().
        Se os dois não forem consistentes, o HashSet não reconhece
        dois objetos "iguais" (pelo equals) como duplicados.
         */

        Product p1 = new Product("P001", "Notebook", 3500.0);
        Product p2 = new Product("P001", "Notebook Gamer", 5200.0);   // mesmo code

        Set<Product> products = new HashSet<>();
        products.add(p1);
        products.add(p2);

        System.out.println("p1.hashCode() == p2.hashCode() -> " + (p1.hashCode() == p2.hashCode()));
        System.out.println("p1.equals(p2) : " + (p1.equals(p2)));
        System.out.println("products.size() -> " + products.size());

        System.out.println("p1.hashCode() -> " + p1.hashCode());
        System.out.println("p2.hashCode() -> " + p2.hashCode());
    }
}
