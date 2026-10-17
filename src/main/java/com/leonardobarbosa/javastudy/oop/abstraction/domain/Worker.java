package com.leonardobarbosa.javastudy.oop.abstraction.domain;

public abstract class Worker extends Person {

    /*
    Classes abstratas não podem ser instanciadas
    - Servem apenas como base para outras classes

    Podem conter:
    - Metodos concretos (com código)
    - Metodos abstratos (sem código)
    - Construtores

    Para que serve:
    - Evitar duplicacao
    - Centralizar regras comuns
    - Definir uma estrutura base
     */

    /*
    A classe abstrata define uma estrutura comum (o que deve ser feito)

    As subclasses são responsáveis
    por implementar os comportamentos específicos (como será feito)
     */
    protected double salary;

    public Worker(String name, double salary) {
        super(name);
        this.salary = salary;
    }


    /*
    getClass()
    - Retorna o objeto Class do tipo real do objeto em memória (class -> <pacotes>).

    getSimpleName()
    - Retorna apenas o nome simples da classe, sem o pacote.

    Exemplo:
    Worker worker = new Manager(...);

    worker.getClass()                   -> class <pacotes> Manager
    worker.getClass().getSimpleName()   -> Manager

    Mesmo usando uma referência do tipo Worker,
    o Java identifica o tipo real do objeto (new Manager)
     */
    @Override
    public String toString() {
        return String.format("%s{name= %s, salary= %,.2f, bonus= %,.2f}",
                this.getClass().getSimpleName(),
                this.name,
                this.salary,
                calculateBonus());
    }

    /*
    Metodos abstratos não possuem implementação.
    As subclasses são obrigadas a implementar.
     */
    public abstract double calculateBonus();


    public String getName() {
        return name;
    }
}

