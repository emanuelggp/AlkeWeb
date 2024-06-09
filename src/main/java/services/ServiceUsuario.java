package services;

import dao.Repositorio;
import dao.UsuarioRepositorio;
import models.Usuario;

import java.sql.SQLException;
import java.util.List;

public class ServiceUsuario {
    private UsuarioRepositorio repositorio = new UsuarioRepositorio();

    public void registrarUsuario(Usuario usuario) {
        try {
            repositorio.crear(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> obtenerUsuarios() {
        try {
            return repositorio.leer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        try {
            return repositorio.obtenerPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean actualizarUsuario(Usuario usuario) {
        try {
            int filasAfectadas = repositorio.actualizar(usuario);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}