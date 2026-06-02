package com.leonardobarbosa.javastudy.oop.polymorphism.service;

import com.leonardobarbosa.javastudy.oop.polymorphism.repository.Repository;

public class MemoryRepository implements Repository {

    @Override
    public void save() {
        System.out.println("Salvando em memória!");
    }
}
