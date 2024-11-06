/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el parámetro 'name' de la solicitud
        String studentName = request.getParameter("name");
        System.out.println(studentName);
        // Verificar si el nombre fue proporcionado
        if (studentName != null && !studentName.isEmpty()) {
            // Buscar el estudiante por su nombre en la base de datos
            Student student = Student.findByName(studentName);

            // Verificar si se encontró el estudiante
            if (student != null) {
                // Agregar el estudiante al request
                request.setAttribute("student", student);
            } else {
                // Si no se encuentra el estudiante, agregar un mensaje de error
                request.setAttribute("error", "Estudiante no encontrado.");
            }
        } else {
            // Si no se proporciona un nombre, agregar un mensaje de error
            request.setAttribute("error", "Por favor, proporciona un nombre de estudiante.");
        }

        // Enviar la solicitud a la vista (JSP)
        request.getRequestDispatcher("Views/students.jsp").forward(request, response);
    }
}



