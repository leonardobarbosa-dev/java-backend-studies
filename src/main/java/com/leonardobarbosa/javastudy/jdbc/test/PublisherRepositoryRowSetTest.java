package com.leonardobarbosa.javastudy.jdbc.test;

import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.service.PublisherServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class PublisherRepositoryRowSetTest {
    public static void main(String[] args) {

        Publisher publisherToUpdate = Publisher.builder().id(3).name("SHOGAKUKAN").build();

        PublisherServiceRowSet.updateRowSet(publisherToUpdate);
        log.info("-------------------");

        List<Publisher> byNameRowSet = PublisherServiceRowSet.findByNameRowSet("");
        log.info("Publishers: {}", byNameRowSet);
    }
}
