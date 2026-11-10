package com.leonardobarbosa.javastudy.jdbc.service;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepositoryRowSet;

import java.util.List;

public class PublisherServiceRowSet {

    public static List<Publisher> findByNameRowSet(String nameSearch) {
        return PublisherRepositoryRowSet.findByNameRowSet(nameSearch);
    }

    public static void updateRowSet(Publisher publisher) {
        PublisherRepositoryRowSet.updateRowSet(publisher);
    }

    public static void updateCachedRowSet(Publisher publisher) {
        PublisherRepositoryRowSet.updateCachedRowSet(publisher);
    }
}
