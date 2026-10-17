package com.leonardobarbosa.javastudy.oop.interfaces.domain;

public class DatabaseLoader implements DataLoader, DataRemover {
    /*
    Java não possui herança múltipla de de classes,
    mas permite múltiplas interfaces.
     */

    @Override
    public void load() {
        System.out.println("\nIniciando dados do banco de dados...");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do banco de dados...");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões dentro do banco de dados...");
    }

    /*
    Interfaces definem contratos.

    Uma classe que implementa uma interface
    é obrigada a implementar seus metodos abstratos.
     */
}
