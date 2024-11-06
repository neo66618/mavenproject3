/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Integrador;encrypt=true;trustServerCertificate=true";
    
    private static final String USERNAME = "soporte";
    private static final String PASSWORD = "1234";

    // Método estático para obtener la conexión
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el driver de SQL Server si es necesario
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver encontrado.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado.");
        }
        
        System.out.println("Intentando conectar a la base de datos...");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Conexión establecida.");
        return connection;
    }
}

