package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener la sesión actual
            HttpSession session = request.getSession(false);

            if (session != null) {
                // Invalida la sesión actual
                session.invalidate();
                System.out.println("Sesión cerrada correctamente");
            } else {
                System.out.println("No se encontró una sesión activa");
            }

            // Redirigir al usuario a la página de inicio de sesión (index.jsp)
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (Exception e) {
            System.out.println("Error en LogoutServlet: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
