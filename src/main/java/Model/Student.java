/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Método para listar estudiantes
    public static List<Student> lista() {
        String query = "SELECT * FROM students";
        List<Student> studentsList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            // Recorre todos los resultados y agrégalos a la lista
            while (resultSet.next()) {
                String studentName = resultSet.getString("name");
                int studentAge = resultSet.getInt("age");
                studentsList.add(new Student(studentName, studentAge));
            }
        } catch (SQLException e) {
            // Imprime cualquier error de SQL
            
        }

        return studentsList;  // Retorna la lista completa de estudiantes
    }
    
    // Método para buscar un estudiante por nombre
    public static Student findByName(String name) {
        String query = "SELECT * FROM students WHERE name = ?";
                   
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String studentName = resultSet.getString("name");
                int studentAge = resultSet.getInt("age");
                return new Student(studentName, studentAge);
            }
        } catch (SQLException e) {
        }
        return null;
    }

}