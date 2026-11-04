package com.leonardobarbosa.javastudy.jdbc.test;

import lombok.extern.log4j.Log4j2;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.service.PublisherService;

import java.util.List;

@Log4j2
public class PublisherRepositoryTest {
    public static void main(String[] args) {

        Publisher publisher1 = Publisher.builder().name("Shueisha").build();
        Publisher publisher2 = Publisher.builder().name("Kodansha").build();
        Publisher publisher3 = Publisher.builder().name("Shogakukan").build();
        Publisher publisherToUpdate = Publisher.builder().id(3).name("SHOGAKUKAN").build();

//        PublisherService.save(publisher1);
//        PublisherService.save(publisher2);
//        PublisherService.save(publisher3);

//        PublisherService.update(publisherToUpdate);

//        for (Publisher publisher : PublisherService.findAll()) {
//            log.info(publisher);
//        }

//        for (Publisher publisher : PublisherService.findByName("ko")) {
//            log.info("Publishers encontradas -> {}", publisher);
//        }

//        PublisherService.showPublishersMetadata();

//        PublisherService.showDriverMetaData();

//        PublisherService.showTypeScrollWorking();

//        List<Publisher> publishers = PublisherService.findByNameAndUpdateToLowerCase("sho");
//        log.info("Publisher atualizada -> {}", publishers);

//        List<Publisher> insertWhenNotFound = PublisherService.findByNameAndInsertWhenNotFound("Panini Comics");
//        log.info("Publisher -> {}", insertWhenNotFound);

//        PublisherService.deleteByName("Panini Comics");


//        List<Publisher> byNamePreparedStatement = PublisherService.findByNamePreparedStatement("Shu");
//        log.info("Find by name with prepared statement: {}", byNamePreparedStatement);

//        PublisherService.updatePreparedStatement(publisherToUpdate);

        List<Publisher> byNameCallableStatement = PublisherService.findByNameCallableStatement("Pan");
        log.info("Find by name with callable statement: {}", byNameCallableStatement);
    }
}
