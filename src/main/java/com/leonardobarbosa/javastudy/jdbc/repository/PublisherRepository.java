package com.leonardobarbosa.javastudy.jdbc.repository;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import com.leonardobarbosa.javastudy.jdbc.domain.Publisher;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
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

    public static void showPublishersMetadata() {

        log.info("Buscando Metadados...");

        String sql = """
                SELECT *
                FROM anime_store.publisher;
                """;

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Recupera informações sobre as colunas retornadas pela consulta
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // Retorna a quantidade de colunas presentes no resultado
            int columnCount = resultSetMetaData.getColumnCount();
            log.info("Columns: {}", columnCount);

            // A contagem das colunas no JDBC começa em 1
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name: {}", resultSetMetaData.getTableName(i));
                log.info("Column name: {}", resultSetMetaData.getColumnName(i));
                log.info("Column display size {}", resultSetMetaData.getColumnDisplaySize(i));
                log.info("Column type name {}", resultSetMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar Metadados", e);
        }
    }

    public static void showDriverMetaData() {

        try (Connection connection = ConnectionFactory.getConnection()) {

            DatabaseMetaData metaData = connection.getMetaData();

            // Permite navegar somente para a frente, registro por registro
            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Suporta: TYPE_FORWARD_ONLY");

                // possibilita modificar registros diretamente pelo próprio ResultSet, em vez de executar um UPDATE separado
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("e suporta: CONCUR_UPDATABLE");
                }
            }

            // Permite navegar para frente e para trás, mas não reflete alterações feitas no banco enquanto o ResultSet está aberto
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Suporta TYPE_SCROLL_INSENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("e suporta CONCUR_UPDATABLE");
                }
            }

           /*
            Permite navegar para frente e para trás e pode refletir
            alterações externas feitas no banco enquanto o
            ResultSet está aberto, caso o driver ofereça esse suporte.
            */
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Suporta TYPE_SCROLL_SENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("e suporta CONCUR_UPDATABLE");
                }
            }

        } catch (SQLException e) {
            log.error("Erro ao consultar MetaDados do driver", e);
        }
    }

    public static void showTypeScrollWorking() {

        String sql = """
                SELECT id, name
                FROM anime_store.publisher;
                """;

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Cursor move para a primeira linha do resultado
            log.info("First row? {}", resultSet.first());
            log.info(Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            log.info("------------------------------------------------------------------------------");

            // Cursor move para a última linha do resultado
            log.info("Last row? {}", resultSet.last());
            log.info(Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            log.info("------------------------------------------------------------------------------");

            // Cursor aponta para a linha número 2
            log.info("Absolute row? {}", resultSet.absolute(2));
            log.info(Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            log.info("------------------------------------------------------------------------------");

            // Cursor move uma linha para trás em relação à posição atual
            log.info("Relative row? {}", resultSet.relative(-1));
            log.info(Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            log.info("------------------------------------------------------------------------------");

            // Verifica se o cursor está na última linha, sem movê-lo
            log.info("Is last? {}", resultSet.isLast());
            log.info(Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            log.info("------------------------------------------------------------------------------");

            // Move o cursor para a última linha e, em seguida, para depois dela
            resultSet.last();
            resultSet.next();

            // Verifica se o cursor está posicionado após a última linha
            log.info("Is after last? {}", resultSet.isAfterLast());

            // Move o cursor para trás, percorrendo os registros até antes da primeira linha.
            while (resultSet.previous()) {
                log.info(Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar publishers", e);
        }
    }

    public static List<Publisher> findByNameAndUpdateToLowerCase(String nameSearch) {

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
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            // next() avança para a próxima linha e retorna true enquanto houver registros
            while (resultSet.next()) {

                // Atualiza a coluna name com seu valor convertido para letras minúsculas
                // updateString() sozinho não persiste a alteração no banco. É necessário chamar updateRow()
                resultSet.updateString("name", resultSet.getString("name").toLowerCase());

                // Persiste no banco de dados as alterações realizadas na linha atual do ResultSet.
                resultSet.updateRow();

                // Cria um Publisher com os dados do registro atual e adiciona à lista
                Publisher publisher = Publisher
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                publishers.add(publisher);

            }

        } catch (SQLException e) {
            log.error("Erro ao buscar publishers e atualizar", e);
        }

        // Retorna a lista com os publishers encontrados
        return publishers;
    }

    public static List<Publisher> findByNameAndInsertWhenNotFound(String nameSearch) {

        log.info("Buscando publishers...");
        // Lista que armazenará os publishers encontrados e será retornada pelo metodo
        List<Publisher> publishers = new ArrayList<>();

        // Busca publishers cujo nome contenha o texto informado.
        String sql = """
                SELECT id, name
                FROM anime_store.publisher
                WHERE name = '%s';
                """.formatted(nameSearch);

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Retorna a lista com nome caso encontrado
            if (resultSet.next()) {
                log.info("Publisher encontrada");
                Publisher publisher = Publisher
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                publishers.add(publisher);
                return publishers;
            }

            log.info("Inserindo nova publisher...");

            // move para uma linha temporária e efine o valor da coluna name na nova linha
            resultSet.moveToInsertRow();
            resultSet.updateString("name", nameSearch);
            // Insere a nova linha no banco de dados, mas sua inclusão no ResultSet atual não é garantida pela especificação JDBC
            resultSet.insertRow();


            // Volta o cursor para a posição anterior à primeira linha
            resultSet.beforeFirst();
            // Avança para a primeira linha disponível no ResultSet
            resultSet.next();
            // Cria um Publisher com os dados do registro e adiciona à lista.
            Publisher publisher = Publisher.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build();
            publishers.add(publisher);

        } catch (SQLException e) {
            log.error("Erro ao buscar publishers", e);
        }


        // Retorna a lista com o publisher encontrado ou inserido
        return publishers;
    }

    public static void deleteByName(String nameSearch) {

        // Consulta os publishers pelo nome exato
        String sql = """
            SELECT id, name
            FROM anime_store.publisher
            WHERE name = '%s';
            """.formatted(nameSearch);

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE
             );
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Indica se algum publisher foi encontrado
            boolean found = false;

            while (resultSet.next()) {
                found = true;

                log.info("Deletando Publisher -> {}", resultSet.getString("name"));

                // Remove a linha atual do ResultSet e do banco de dados
                resultSet.deleteRow();
            }

            if (!found) {
                log.info("Nenhum publisher encontrado com o nome: {}", nameSearch);
            }

        } catch (SQLException e) {
            log.error("Erro ao deletar publisher", e);
        }
    }
}