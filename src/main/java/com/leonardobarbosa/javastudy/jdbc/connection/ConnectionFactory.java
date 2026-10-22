package com.leonardobarbosa.javastudy.jdbc.connection;

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
}
