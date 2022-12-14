package hu.petrik.adatbazisgui;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogDB {
    Connection conn;

    public static String DB_DRIVER = "mysql";
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_DBNAME = "java";
    public static String DB_USER = "root";
    public static String DB_PASS = "";

    public DogDB() throws SQLException {
        String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT, DB_DBNAME);
        conn = DriverManager.getConnection(url, DB_USER, DB_PASS);
    }

    public boolean createDog(Dog dog) throws SQLException {
        String sql = "INSERT INTO dogs(name, age, breed) VALUES (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dog.getName());
        stmt.setInt(2, dog.getAge());
        stmt.setString(3, dog.getBreed());
        return stmt.executeUpdate() > 0;
    }

    public List<Dog> readDogs() throws SQLException {
        List<Dog> dogs = new ArrayList<>();
        String sql = "SELECT * FROM dogs";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getInt("age");
            String breed = result.getString("breed");
            Dog dog = new Dog(id, name, age, breed);
            dogs.add(dog);
        }
        return dogs;
    }

    public boolean updateDog(Dog dog) throws SQLException {
        String sql = "UPDATE dogs " +
                "SET name = ?, " +
                "age = ?, " +
                "breed = ?" +
                "WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dog.getName());
        stmt.setInt(2, dog.getAge());
        stmt.setString(3, dog.getBreed());
        stmt.setInt(4, dog.getId());
        return stmt.executeUpdate() > 0;
    }

    public boolean deleteDog(int id) throws SQLException {
        String sql = "DELETE FROM dogs WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    }
}