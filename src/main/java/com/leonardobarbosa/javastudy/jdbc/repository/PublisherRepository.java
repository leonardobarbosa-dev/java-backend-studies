package com.leonardobarbosa.javastudy.jdbc.repository;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PublisherRepository {

    public static void save(Publisher publisher) {

        String sql = """
                INSERT INTO publisher
                (name)
                VALUES('%s');
                """.formatted(publisher.getName());

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {

            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}