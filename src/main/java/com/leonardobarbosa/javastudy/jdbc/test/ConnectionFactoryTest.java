package com.leonardobarbosa.javastudy.jdbc.test;

import com.leonardobarbosa.javastudy.jdbc.connection.ConnectionFactory;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;

// @Log4j2 gera automaticamente o logger utilizado pela classe.
@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionFactory.getConnection()) {
            log.info("Conexão estabelecida com o banco! -> '{}'", connection);
        }
    }
}
