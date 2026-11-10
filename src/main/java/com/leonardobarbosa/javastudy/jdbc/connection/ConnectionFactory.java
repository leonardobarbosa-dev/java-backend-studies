package com.leonardobarbosa.javastudy.jdbc.connection;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = System.getenv("DB_PASSWORD");

        // DriverManager estabelece a conexão com o banco usando a URL e as credenciais.
        return DriverManager.getConnection(url, username, password);
    }

    public static JdbcRowSet getConnectionRowSet () throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = System.getenv("DB_PASSWORD");

        // Cria uma fábrica responsável por fornecer implementações de RowSet
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();

        // Configura os dados necessários para estabelecer a conexão com o banco
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);

        return jdbcRowSet;
    }

    public static CachedRowSet getConnectionCachedRowSet () throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = System.getenv("DB_PASSWORD");

        // Cria um CachedRowSet que permite armazenar os resultados em memória
        // e trabalhar com os dados desconectado do banco.
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();

        // Configura os dados necessários para estabelecer a conexão com o banco
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);

        return cachedRowSet;
    }
}
