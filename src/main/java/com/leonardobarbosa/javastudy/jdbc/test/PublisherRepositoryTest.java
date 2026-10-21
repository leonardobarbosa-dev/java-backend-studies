package com.leonardobarbosa.javastudy.jdbc.test;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.repository.PublisherRepository;

public class PublisherRepositoryTest {
    public static void main(String[] args) {
        Publisher kodansha = new Publisher.Builder()
                .name("Kodansha")
                .build();

        PublisherRepository.save(kodansha);
    }
}
