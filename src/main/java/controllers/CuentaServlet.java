package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cuenta;
import models.Usuario;
import services.ServiceCuenta;

import java.io.IOException;
@WebServlet("/CuentaServlet")
public class CuentaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

        Cuenta cuenta = new Cuenta(usuario.getId(), usuario.getBalance());

        req.setAttribute("cuenta", cuenta);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        if (usuario == null) {
            // Si el usuario no está en la sesión, redirigir a la página de inicio de sesión
            resp.sendRedirect("/login");
            return;
        }


        double monto = Double.parseDouble(req.getParameter("monto"));
        String accion = req.getParameter("action");

        Cuenta cuenta = new Cuenta(usuario.getId(), usuario.getBalance());

        if (accion.equals("depositar")) {
            cuenta = ServiceCuenta.depositar(cuenta, monto);
            usuario.setBalance((int) cuenta.getSaldo());
            req.getSession().setAttribute("usuario", usuario);
            resp.sendRedirect("/home");
        } else if (accion.equals("retirar")) {
            cuenta = ServiceCuenta.retirar(cuenta, monto);
            usuario.setBalance((int) cuenta.getSaldo());
            req.getSession().setAttribute("usuario", usuario);
            resp.sendRedirect("/home");
        }
    }
}