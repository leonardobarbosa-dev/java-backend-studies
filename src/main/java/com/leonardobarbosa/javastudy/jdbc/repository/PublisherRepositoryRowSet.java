package com.leonardobarbosa.javastudy.jdbc.repository;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import com.leonardobarbosa.javastudy.jdbc.listener.CustomRowSetListener;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PublisherRepositoryRowSet {

    public static List<Publisher> findByNameRowSet(String nameSearch) {

        List<Publisher> publishers = new ArrayList<>();

        String sql = """
                SELECT id, name
                FROM anime_store.publisher
                WHERE name LIKE ?;
                """;

        try(JdbcRowSet jdbcRowSet = ConnectionFactory.getConnectionRowSet()) {

            jdbcRowSet.addRowSetListener(new CustomRowSetListener());

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

    public static void updateRowSet(Publisher publisher) {

        String sql = """
                SELECT id, name
                FROM anime_store.publisher
                WHERE id = ?;
                """;

        try(JdbcRowSet jdbcRowSet = ConnectionFactory.getConnectionRowSet()) {

            jdbcRowSet.addRowSetListener(new CustomRowSetListener());

            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setInt(1, publisher.getId());

            // Executa o comando SQL configurado no RowSet
            jdbcRowSet.execute();

            // Encerra o metodo caso nenhum registro seja encontrado
            if (!jdbcRowSet.next()) return;

            // Atualiza o valor da coluna name na linha atual
            jdbcRowSet.updateString("name", publisher.getName());

            // Persiste a alteração da linha atual no banco de dados
            jdbcRowSet.updateRow();

            log.info("Publisher atualizado:  id={} - name={}", publisher.getId(), publisher.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
