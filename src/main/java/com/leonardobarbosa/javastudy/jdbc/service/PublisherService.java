package com.leonardobarbosa.javastudy.jdbc.service;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepository;

public class PublisherService {

    public static void save(Publisher publisher) {
        PublisherRepository.save(publisher);
    }

    public static void delete(int id) {
        PublisherRepository.delete(id);
    }
}
