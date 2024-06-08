package dao;

import models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio extends Dao implements Repositorio<Usuario>{
    private Connection connection;

    public UsuarioRepositorio() {
        this.connectionDb();
    }

    @Override
    public int crear(Usuario usuario) throws SQLException {
        String str = String.format("Insert into usuario (nombre, password) values ('%s','%s')",
                        usuario.getNombre(), usuario.getPassword()
        );
        return this.ejecutarSql(str);
    }

    private Usuario crearUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setBalance(resultSet.getInt("balance"));

        return usuario;

    }

    @Override
    public List<Usuario> leer() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String str = "SELECT * from usuario";
        this.consultar(str);
        while(rs.next()) {
            Usuario usuario = crearUsuario(rs);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        try {
            System.out.println(repo.leer());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int actualizar(Usuario usuario) throws SQLException {
        return 0;
    }

    @Override
    public int eliminar(int id) throws SQLException {
        return 0;
    }

    public Usuario obtenerPorId(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String email = resultSet.getString("email");
                    // Crear y devolver el objeto Usuario
                    return new Usuario();
                } else {
                    return null;
                }
            }
        }
    }
}
