package com.leonardobarbosa.javastudy.jdbc.service;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepositoryRowSet;

import java.util.List;

public class PublisherServiceRowSet {

    public static List<Publisher> findByNameRowSet(String nameSearch) {
        return PublisherRepositoryRowSet.findByNameRowSet(nameSearch);
    }
}
