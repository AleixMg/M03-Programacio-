package com.example.database;
import com.example.database.models.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author aleix
 */
public class DataManager {

private Connection connection;


    public void connect() {
        try {
            
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Students", "postgres", "yqkb0219");
            System.out.println("Connexio establerta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Student getStudent(int id) {
        String query = "SELECT * FROM students WHERE id = ?";


        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("fisrt_name"), rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


    public void addStudent(Student student) {
        String query = "INSERT INTO students (fisrt_name, last_name) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLastName());
            stmt.executeUpdate();
            System.out.println("Estudiant afegit.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateStudent(Student student) {
        String query = "UPDATE students SET fisrt_name = ?, last_name = ? WHERE id = ?";


        try {
            PreparedStatement stmt = connection.prepareStatement(query);


            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLastName());
            stmt.setInt(3, student.getId());
            stmt.executeUpdate();
            System.out.println("Estudiant modificat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";


        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Estudiant eliminat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connexio tancada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

