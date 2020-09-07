package test;

import datos.Conexion;
import datos.PersonaDao;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDao personaDao = new PersonaDaoJDBC(conexion);

            List<PersonaDTO> personas = personaDao.select();
            
            for(PersonaDTO persona: personas){ 
                System.out.println("PersonaDTO: " + persona);
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
