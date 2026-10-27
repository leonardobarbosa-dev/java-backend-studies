package com.leonardobarbosa.javastudy.jdbc.test;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.service.PublisherService;


public class PublisherRepositoryTest {
    public static void main(String[] args) {
        Publisher publisherSave = Publisher.builder().name("Shogakukan").build();
        Publisher publisherToUpdate = Publisher.builder().id(8).name("SHOGAKUKAN").build();

        PublisherService.update(publisherToUpdate);
    }
}
