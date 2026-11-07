package com.leonardobarbosa.javastudy.jdbc.repository;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherRepositoryRowSet {

    public static List<Publisher> findByNameRowSet(String nameSearch) {

        List<Publisher> publishers = new ArrayList<>();

        String sql = """
                SELECT id, name
                FROM anime_store.publisher
                WHERE name LIKE ?;
                """;

        try(JdbcRowSet jdbcRowSet = ConnectionFactory.getConnectionRowSet()) {

            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, "%" + nameSearch + "%");

            // Executa o comando SQL configurado no RowSet
            jdbcRowSet.execute();

            while (jdbcRowSet.next()) {
                Publisher publisher = Publisher.builder()
                        .id(jdbcRowSet.getInt("id"))
                        .name(jdbcRowSet.getString("name"))
                        .build();
                publishers.add(publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publishers;
    }
}
