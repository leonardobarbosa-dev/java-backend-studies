package com.leonardobarbosa.javastudy.oop.inheritance.domain;

public class Person {

    protected String name;
    protected String cpf;
    /*
    Associação:
    - uma pessoa possui um endereço
     */
    protected Address address;
    /*
    Protected permite acesso direto a variavel a todas
    as subclasses independente de onde estiverem,
    porem todas as classes que estao no mesmo pacote tambem tem acesso
     */


    public Person(String name, String cpf, Address address) {
        this.name = name; //Antes de construir completamente o objeto, use outro construtor como base.
        this.cpf = cpf;
        this.address = address;
    }

    public void print() {
        System.out.println("Nome: " + this.name);
        System.out.println("CPF: " + this.cpf);
        if (address != null) {
            address.print();
        }
    }
}
