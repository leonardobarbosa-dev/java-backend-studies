package com.leonardobarbosa.javastudy.jdbc.test;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepository;


public class PublisherRepositoryTest {
    public static void main(String[] args) {
        Publisher publisher = Publisher.builder().name("Shogakukan").build();

        PublisherRepository.save(publisher);
    }
}
