package com.leonardobarbosa.javastudy.jdbc.test;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionFactory.getConnection()) {
            System.out.println("Conexão estabelecida com o banco!");
        }
    }
}