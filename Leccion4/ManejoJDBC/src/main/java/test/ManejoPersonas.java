package test;

import datos.Conexion;
import datos.PersonaJDBC;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
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
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            Persona cambioPersona = new Persona();
            cambioPersona.setId_persona(2);
            cambioPersona.setNombre("Karla Ivone");
            cambioPersona.setApellido("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            cambioPersona.setTelefono("58489696");
            personaJDBC.update(cambioPersona);

            Persona newPersona = new Persona();
            newPersona.setNombre("Carlos");
            newPersona.setApellido("Ramirez");
            //newPersona.setApellido("Ramirezasdfasdfasdfasdfasdfasdfasdfasdfasf");
            newPersona.setEmail("cram@mail.com");
            newPersona.setTelefono("654321654");
            personaJDBC.insert(newPersona);

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
