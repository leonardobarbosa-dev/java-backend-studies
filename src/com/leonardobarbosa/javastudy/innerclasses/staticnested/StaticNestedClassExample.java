package com.leonardobarbosa.javastudy.innerclasses.staticnested;

public class StaticNestedClassExample {

    private String instanceField = "campo de instância";
    private static String staticField = "campo estático";

    /*
    Classe aninhada estática -> declarada com static dentro de outra classe
    - Não acessa membros de instância da classe externa (instanceField)
    - acessa apenas membros estáticos da classe externa (staticField)
    - não precisa de uma instância da classe externa para ser instanciada
    - usada quando a classe interna não depende do estado da classe externa
     */

    static class Nested {
        void print() {
//          System.out.println(instanceField);   // erro -> não acessa membro de instância
            System.out.println(staticField);     // ok -> acessa membro estático
        }
    }

    /*
    Uso comum: Builder pattern
    - o Builder é uma classe aninhada estática que constrói a classe externa
    - não precisa de uma instância de Order pra criar um OrderBuilder
     */

    static class Order {
        private final String product;
        private final int quantity;
        private final double price;

        private Order(Builder builder) {
            this.product = builder.product;
            this.quantity = builder.quantity;
            this.price = builder.price;
        }

        @Override
        public String toString() {
            return "Order{product='" + product + "', quantity=" + quantity + ", price=" + price + "}";
        }

        static class Builder {
            private String product;
            private int quantity;
            private double price;

            public Builder product(String product) {
                this.product = product;
                return this;
            }

            public Builder quantity(int quantity) {
                this.quantity = quantity;
                return this;
            }

            public Builder price(double price) {
                this.price = price;
                return this;
            }

            public Order build() {
                return new Order(this);
            }
        }
    }

    public static void main(String[] args) {

        // instancia sem precisar de uma instância da classe externa
        Nested nested = new Nested();
        nested.print();

        // Builder pattern
        Order order = new Order.Builder()
                .product("Death Note")
                .quantity(2)
                .price(25.90)
                .build();

        System.out.println(order);
    }
}