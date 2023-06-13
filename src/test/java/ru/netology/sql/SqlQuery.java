package ru.netology.sql;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlQuery {
    private static final String DB_URL = System.getProperty("datasource.url");

    private SqlQuery() {

    }

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(DB_URL, "app", "pass");
    }

    @SneakyThrows
    public static void clearDB() {
        var runner = new QueryRunner();
        var deleteSQL = ("DELETE FROM credit_request_entity; DELETE FROM order_entity; DELETE FROM payment_entity;");
        try (var connection = getConnection()) {
            runner.execute(connection, deleteSQL);
        }
    }

    @SneakyThrows
    public static String getDebitPaymentStatus() {
        var runner = new QueryRunner();
        var SqlStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (var connection = getConnection()) {
            String result = runner.query(connection, SqlStatus, new ScalarHandler<>());
            return result;
        }
    }

    @SneakyThrows
    public static String getCreditPaymentStatus() {
        var runner = new QueryRunner();
        String SqlStatus = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        try (var connection = getConnection()) {
            String result = runner.query(connection, SqlStatus, new ScalarHandler<>());
            return result;
        }
    }
}
