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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entre al servlet do get");
        String nombre = req.getParameter("nombre");
        String password = req.getParameter("password");

        ServiceUsuario service = new ServiceUsuario();
        List<Usuario> usuarios = service.obtenerUsuarios();


        for(Usuario usuario: usuarios) {
            if(usuario.getNombre().equals(nombre)) {
                if(usuario.getPassword().equals(password)) {
                    System.out.println("Login exitoso!!! " + usuario);
                    req.setAttribute("usuario", usuario);
                    getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
                }
            }
        }



    }
}
