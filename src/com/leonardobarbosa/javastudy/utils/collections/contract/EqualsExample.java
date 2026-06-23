package com.leonardobarbosa.javastudy.utils.collections.contract;

import java.util.Objects;

class Product {

    private String code;
    private String name;
    private double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /*
    equals -> por padrão (Object.equals), compara referência (==)
    - equals() sem override não faz nada além do ==
    - dois objetos só seriam "iguais" se fossem o mesmo objeto na memória

    Aqui sobrescrevemos pra comparar só pelo "code"
    - "filtramos" o que importa pra considerar dois produtos iguais
    - name e price podem ser diferentes, não interferem na igualdade
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        return code != null && code.equals(product.code);
    }
}

public class EqualsExample {
    public static void main(String[] args) {

        /*
        == compara referência (mesmo endereço na memória)
        equals() compara o que a classe define como "igual"

        String já sobrescreve equals() -> compara o conteúdo (valor)
         */

        String a = "Java";
        String b = "Java";
        String c = new String("Java");

        System.out.println("a == b -> " + (a == b));
        System.out.println("a == c -> " + (a == c));
        System.out.println("a.equals(c) -> " + a.equals(c));    // String sobrescreve equals() pra comparar o conteúdo, não a referência

        /*
        Sem sobrescrever equals(), uma classe usa o comportamento padrão
        de Object -> compara referência, igual o == acima
         */

        Product p1 = new Product("P001", "Notebook", 3500.0);
        Product p2 = new Product("P001", "Notebook", 3500.0);   // mesmo code, dados diferentes
        Product p3 = p1;

        System.out.println("p1 == p2 -> " + (p1 == p2));    // são objetos diferentes na memória
        System.out.println("p1.equals(p2) -> " + p1.equals(p2));    // mesmo code ("P001"), mesmo que name/price sejam diferentes
        System.out.println("p1 == p3 -> " + (p1 == p3));

    }
}
