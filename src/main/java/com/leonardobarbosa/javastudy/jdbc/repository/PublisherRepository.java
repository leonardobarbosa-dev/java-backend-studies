package com.leonardobarbosa.javastudy.jdbc.repository;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

        // A conexão e o Statement são fechados automaticamente ao final do bloco.
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

        // A conexão e o Statement são fechados automaticamente ao final do bloco.
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {

            // executeUpdate() executa o UPDATE e retorna a quantidade de linhas afetadas.
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Rows affected '{}'", rowsAffected);

        } catch (SQLException e) {
            log.error("Erro ao tentar atualizar publisher", e);
        }
    }
}