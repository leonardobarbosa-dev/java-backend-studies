package com.leonardobarbosa.javastudy.jdbc.service;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepository;

import java.sql.SQLException;

public class PublisherService {

    public static void save(Publisher publisher) {
        PublisherRepository.save(publisher);
    }

    public static void delete(Integer id) {
        requireValidId(id);
        PublisherRepository.delete(id);
    }

    public static void update(Publisher publisher) {
        requireValidId(publisher.getId());
        PublisherRepository.update(publisher);
    }

    // Metodo para evitar repetição de validação no código
    private static void requireValidId(Integer id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("Valor do id inválido!");
        }

    }
}
