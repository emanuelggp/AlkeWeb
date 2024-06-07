package controllers;

import models.Usuario;
import services.ServiceUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceUsuario service = new ServiceUsuario();
        List<Usuario> usuarios = service.obtenerUsuarios();
        System.out.println(usuarios);
        req.setAttribute("usuarios", usuarios);
        getServletContext().getRequestDispatcher("/lista.jsp").forward(req, resp);
    }
}
