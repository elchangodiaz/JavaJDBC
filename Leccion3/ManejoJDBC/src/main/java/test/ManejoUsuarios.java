package test;

import datos.UsuarioJDBC;
import java.util.List;
import domain.Usuario;

public class ManejoUsuarios {
    public static void main(String[] args) {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        List<Usuario> usuarios = usuarioJDBC.select();
        
        for(Usuario usuario:usuarios){
            System.out.println("Usuario: " + usuario);
        }
        
//        //Insert
//        Usuario usuario = new Usuario();
//        usuario.setUsername("changodiaz");
//        usuario.setPassword("arctic");
//        usuarioJDBC.insert(usuario);

        //Update
//        Usuario usuario = new Usuario();
//        usuario.setUsername("karlita.G");
//        usuario.setPassword("karls");
//        usuario.setId_usuario(2);
//        usuarioJDBC.update(usuario);

//       Delete
//        Usuario usuario = new Usuario();
//        usuario.setId_usuario(4);
//        usuarioJDBC.delete(usuario);
    
    }
}
