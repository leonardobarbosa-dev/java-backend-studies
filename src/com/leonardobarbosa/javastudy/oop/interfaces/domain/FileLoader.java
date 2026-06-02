package com.leonardobarbosa.javastudy.oop.interfaces.domain;

public class FileLoader implements DataLoader, DataRemover {

    @Override
    public void load() {
        System.out.println("\nIniciando dados de um arquivo...");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados de um arquivo...");
    }

    @Override
    public void checkPermission() {
        DataLoader.super.checkPermission();
    }
}
