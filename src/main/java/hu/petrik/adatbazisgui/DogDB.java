package hu.petrik.adatbazisgui;

import java.sql.*;

public class DogDB {
    Connection conn;
    public static String DB_DRIVER = "mysql";
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_NAME = "java";
    public static String DB_USERNAME = "root";
    public static String DB_PASSWORD = "";

    public DogDB() throws SQLException {
        String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT, DB_NAME);
        conn = DriverManager.getConnection(url,DB_USERNAME,DB_PASSWORD);
    }

    public void createDog() {

    }

    public void readDogs() {

    }

    public void updateDog() {

    }

    public void deleteDog() {

    }
}
