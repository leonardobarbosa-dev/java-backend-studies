package com.leonardobarbosa.javastudy.jdbc.repository;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// @Log4j2 gera automaticamente o logger para registrar mensagens e erros.
@Log4j2
public class PublisherRepository {

    public static void save(Publisher publisher) {

        // O banco gera o id automaticamente, por isso ele não é informado no INSERT.
        String sql = """
                INSERT INTO publisher
                (name)
                VALUES('%s');
                """.formatted(publisher.getName());

        // A conexão e o Statement são fechados automaticamente ao final do bloco.
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {

            // executeUpdate() executa o INSERT e retorna a quantidade de linhas afetadas.
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Rows affected '{}'", rowsAffected);

        } catch (SQLException e) {
            log.error("Erro ao salvar publisher", e);
        }
    }

    public static void delete(int id) {

        // O id identifica o publisher que será excluído.
        String sql = """
                DELETE FROM anime_store.publisher
                WHERE id = %d;
                """.formatted(id);

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {

            // executeUpdate() executa o DELETE e retorna a quantidade de linhas afetadas.
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Rows affected '{}'", rowsAffected);

        } catch (SQLException e) {
            log.error("Erro ao tentar deletar publisher", e);
        }
    }

    public static void update(Publisher publisher) {

        // O id identifica o publisher que será alterado.
        String sql = """
                UPDATE anime_store.publisher
                SET name='%s'
                WHERE id = %d;
                """.formatted(publisher.getName(), publisher.getId());

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {

            // executeUpdate() executa o UPDATE e retorna a quantidade de linhas afetadas.
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Rows affected '{}'", rowsAffected);

        } catch (SQLException e) {
            log.error("Erro ao tentar atualizar publisher", e);
        }
    }

    public static List<Publisher> findAll() {

        log.info("Buscando publishers...");
        // Simplificando código
         return findByName("");

        // Lista que armazenará os publishers encontrados e será retornada pelo metodo
//        List<Publisher> publishers = new ArrayList<>();
//
//        // Recupera os valores das colunas id e name do registro atual.
//        String sql = """
//                SELECT id, name
//                FROM anime_store.publisher;
//                """;
//
//        try (Connection connection = ConnectionFactory.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            // next() avança para a próxima linha e retorna true enquanto houver registros
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//
//                // Cria um Publisher com os dados do registro atual e adiciona à lista
//                Publisher publisher = Publisher.builder().id(id).name(name).build();
//                publishers.add(publisher);
//
//            }
//
//        } catch (SQLException e) {
//            log.error("Erro ao buscar publishers", e);
//        }
//
//        // Retorna a lista com os publishers encontrados
//        return publishers;
    }

    public static List<Publisher> findByName(String nameSearch) {

        log.info("Buscando publishers pelo nome...");
        // Lista que armazenará os publishers encontrados e será retornada pelo metodo
        List<Publisher> publishers = new ArrayList<>();

        // Busca publishers cujo nome contenha o texto informado.
        String sql = """
                SELECT id, name
                FROM anime_store.publisher
                WHERE name LIKE '%%%s%%';
                """.formatted(nameSearch);

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

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
}