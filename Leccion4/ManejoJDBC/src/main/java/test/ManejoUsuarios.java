package test;

import datos.Conexion;
import datos.UsuarioJDBC;
import java.util.List;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

public class ManejoUsuarios {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            UsuarioJDBC usuarioJDBC = new UsuarioJDBC(conexion);
            Usuario cambioUsuario = new Usuario();
            cambioUsuario.setId_usuario(2);
            cambioUsuario.setUsername("karla_G");
            cambioUsuario.setPassword("karlsss");
            usuarioJDBC.update(cambioUsuario);

            Usuario newUsuario = new Usuario();
            newUsuario.setUsername("ramonJ");
            newUsuario.setPassword("5643564");
            usuarioJDBC.insert(newUsuario);

            conexion.commit();
            System.out.println("Commit transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}