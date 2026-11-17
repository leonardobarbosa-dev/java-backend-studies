package com.leonardobarbosa.javastudy.jdbc.crud.repository;


import com.leonardobarbosa.javastudy.jdbc.crud.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.crud.domain.Publisher;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PublisherRepository {

    public static List<Publisher> findByName(String nameSearch) {

        log.info("Buscando \"{}\"...", nameSearch);
        // Lista que armazenará os publishers encontrados e será retornada pelo metodo
        List<Publisher> publishers = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = createPreparedStatement(connection, nameSearch);
             ResultSet resultSet = statement.executeQuery()) {

            // next() avança para a próxima linha e retorna true enquanto houver registros
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Cria um Publisher com os dados do registro atual e adiciona à lista
                Publisher publisher = Publisher.builder().id(id).name(name).build();
                publishers.add(publisher);
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar publishers", e);
        }

        // Retorna a lista com os publishers encontrados
        return publishers;
    }

    private static PreparedStatement createPreparedStatement(Connection connection, String name) throws SQLException {
        // Busca publishers cujo nome contenha o texto informado.
        String sql = """
                SELECT id, name
                FROM anime_store.publisher
                WHERE name LIKE ?;
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // caracteres curinga devem ser concatenados ao valor do parâmetro que será injetado
        preparedStatement.setString(1, "%" + name + "%");
        return preparedStatement;
    }
}
