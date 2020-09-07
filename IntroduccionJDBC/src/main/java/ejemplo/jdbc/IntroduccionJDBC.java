package ejemplo.jdbc;

import java.sql.*;

public class IntroduccionJDBC {
    public static void main(String[] args) {
        //paso1 creamos cadena de conexion a mysql
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        
        try {
            //paso2 creamos el objeto de conexion a la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            
            //paso 3 creamos un objeto de tipo statement
            Statement instruccion = conexion.createStatement();
            
            //paso4 creamos query     1         2       3        4       5       
            String sql = "select id_persona, nombre, apellido, email, telefono from persona";
            
            //paso 5 ejecucion del query
            ResultSet resultado = instruccion.executeQuery(sql);
            
            //paso6 procesamos resultado
            while(resultado.next()){
                System.out.println("Id Persona: " + resultado.getInt(1));
                System.out.println("Nombre: " + resultado.getString(2));
                System.out.println("Apellido: " + resultado.getString(3)); 
                System.out.println("Email: " + resultado.getString(4)); 
                System.out.println("Telefono: " + resultado.getString(5));
                System.out.println("");
            }
            
            //Cerramos cada objeto que hemos utilizado
            resultado.close();
            instruccion.close();
            conexion.close();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
