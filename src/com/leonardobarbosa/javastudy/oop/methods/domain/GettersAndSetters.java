package com.leonardobarbosa.javastudy.oop.methods.domain;

public class GettersAndSetters {

    private String name;
    private int age;

    /*
    Getters e Setters
    - set -> definir (sempre retorna void com o parametro da variavel)
    - get -> pegar (retorna o tipo da variavel sem parametros)
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
