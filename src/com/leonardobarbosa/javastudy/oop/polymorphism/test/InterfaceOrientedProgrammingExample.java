package com.leonardobarbosa.javastudy.oop.polymorphism.test;

import com.leonardobarbosa.javastudy.oop.polymorphism.repository.Repository;
import com.leonardobarbosa.javastudy.oop.polymorphism.service.DatabaseRepository;
import com.leonardobarbosa.javastudy.oop.polymorphism.service.FileRepository;
import com.leonardobarbosa.javastudy.oop.polymorphism.service.MemoryRepository;

public class InterfaceOrientedProgrammingExample {
    public static void main(String[] args) {

        /*
          - Criar a interface repository
          - Criar <service> repositorios de (arquivos, banco de dados, memoria)
          - No main, chamar pela referencia <interface> e o objeto do servico desejado (new ...)
         */

        Repository repository;

        repository = new DatabaseRepository();
        repository.save();

        repository = new FileRepository();
        repository.save();

        repository = new MemoryRepository();
        repository.save();

        /*
         Programação orientada a interfaces:

         O código utiliza o tipo mais genérico (Repository),
         e não uma implementação específica.

         Isso permite trocar a implementação
         sem alterar o restante do código.
         */
    }
}
