package com.leonardobarbosa.javastudy.jdbc.service;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepository;

import java.util.List;

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

    public static List<Publisher> findAll() {
        return PublisherRepository.findAll();
    }

    public static List<Publisher> findByName(String nameSearch) {
        return PublisherRepository.findByName(nameSearch);
    }

    public static void showPublishersMetadata() {
        PublisherRepository.showPublishersMetadata();
    }

    public static void showDriverMetaData() {
        PublisherRepository.showDriverMetaData();
    }

    public static void showTypeScrollWorking() {
        PublisherRepository.showTypeScrollWorking();
    }

    public static List<Publisher> findByNameAndUpdateToLowerCase(String nameSearch) {
        return PublisherRepository.findByNameAndUpdateToLowerCase(nameSearch);
    }

    public static List<Publisher> findByNameAndInsertWhenNotFound(String nameSearch) {
        return PublisherRepository.findByNameAndInsertWhenNotFound(nameSearch);
    }

    public static void deleteByName(String nameSearch) {
        PublisherRepository.deleteByName(nameSearch);
    }

    public static List<Publisher> findByNamePreparedStatement(String nameSearch) {
        return PublisherRepository.findByNamePreparedStatement(nameSearch);
    }

    public static void updatePreparedStatement(Publisher publisher) {
        requireValidId(publisher.getId());
        PublisherRepository.updatePreparedStatement(publisher);
    }

    // Metodo para evitar repetição de validação no código
    private static void requireValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Valor do id inválido!");
        }

    }
}
