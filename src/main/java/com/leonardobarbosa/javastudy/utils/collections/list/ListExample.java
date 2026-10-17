package com.leonardobarbosa.javastudy.utils.collections.list;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        return code != null && code.equals(product.code);
    }

    @Override
    public int hashCode() {
        return code == null ? 0 : this.code.hashCode();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class ListExample {
    public static void main(String[] args) {

        /*
        List -> interface que representa uma coleção ordenada,
        permite elementos duplicados e acesso por índice

        Principais implementações:
        - ArrayList -> array redimensionável, acesso O(1), inserção no meio O(n)
        - LinkedList -> lista encadeada, inserção nas pontas O(1), acesso O(n)
         */

        List<String> names = new ArrayList<>();

        names.add("Leonardo");
        names.add("Maria");
        names.add("Pedro");
        names.add(1, "Jubileu");    // insere na posição 1, empurra os outros pra frente

        System.out.println(names);
        System.out.println("getFirst -> " + names.getFirst());
        System.out.println("get(1) -> " + names.get(1));
        System.out.println("size() -> " + names.size());
        System.out.println("contains(\"Maria\") -> " + names.contains("Maria"));
        System.out.println("indexOf(\"Pedro\") -> " + names.indexOf("Pedro"));

        /*
        Em List<Integer>, remove(int) e remove(Object) ficam ambíguos
        — lista.remove(5) remove o índice 5, não o valor 5. Pra remover pelo valor nesse caso,
        precisa de lista.remove(Integer.valueOf(5)). Como aqui é List<String>,
        não tem esse problema (não existe overload de índice vs valor confundindo tipos)
         */
        names.remove("Pedro");  // remove pelo valor
        names.remove(2);    // remove pelo índice
        System.out.println("Após remoções -> " + names);



        /*
        List<Product> -> contains(), indexOf() e remove(Object) usam o
        equals() da classe pra comparar, não a referência (==)

        Como Product.equals() compara só pelo "code", um Product novo
        com o mesmo code é reconhecido como igual a um já existente
         */

        List<Product> products = new ArrayList<>();

        products.add(new Product("P001", "Celular", 2500));
        products.add(new Product("P002", "Notebook", 4500));
        products.add(new Product("P003", "Tablet", 2500));

        for (Product p : products) {
            System.out.println(p);
        }

        Product search = new Product("P002", "Notebook Gamer", 8500);   // mesmo code, objeto diferente
        System.out.println("contains(search - code P002) -> " + products.contains(search));
        System.out.println("indexOf(search - code P002) -> " + products.indexOf(search));   // retorna o índice ou -1 se não for encontrado
        System.out.println(products.get(1));

        products.remove(search);    // remove o produto com o code P002 -> Notebook
        System.out.println("Após remover -> " + products);
        products.add(1,  search);   // insere o próprio objeto search na lista (mesmo code mas name/price diferentes)
        System.out.println("Após adicionar o novo produto com mesmo code -> " + products);

        for (Product product : products) {
            System.out.println("Code: " + product.getCode() + " Name: " + product.getName() + " Price: " + product.getPrice());
        }
    }
}
