package test;

import datos.Conexion;
import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import java.util.List;
import domain.UsuarioDTO;
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
            UsuarioDao usuarioDao = new UsuarioDaoJDBC(conexion);

            List<UsuarioDTO> usuarios = usuarioDao.select();
            
            for(UsuarioDTO usuario: usuarios){ 
                System.out.println("PersonaDTO: " + usuario);
            }
            
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
