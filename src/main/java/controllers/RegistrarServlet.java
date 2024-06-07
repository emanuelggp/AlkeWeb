package controllers;

import models.Usuario;
import services.ServiceUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrar")
public class RegistrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/AlkeWeb/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String password = req.getParameter("password");


        ServiceUsuario service = new ServiceUsuario();
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        service.registrarUsuario(usuario);
    }
}
