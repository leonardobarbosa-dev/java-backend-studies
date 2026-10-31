package com.leonardobarbosa.javastudy.jdbc.test;

import lombok.extern.log4j.Log4j2;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.service.PublisherService;
import java.util.concurrent.TimeUnit;

@Log4j2
public class PublisherRepositoryTest {
    public static void main(String[] args) {

        Publisher publisher1 = Publisher.builder().name("Shueisha").build();
        Publisher publisher2 = Publisher.builder().name("Kodansha").build();
        Publisher publisher3 = Publisher.builder().name("Shogakukan").build();
        Publisher publisherToUpdate = Publisher.builder().id(11).name("SHOGAKUKAN").build();

//        PublisherService.update(publisherToUpdate);

//        for (Publisher publisher : PublisherService.findAll()) {
//            log.info(publisher);
//        }

//        for (Publisher publisher : PublisherService.findByName("ko")) {
//            log.info("Publishers encontradas -> {}", publisher);
//        }

//        PublisherService.showPublishersMetadata();

        PublisherService.showDriverMetaData();
    }
}
