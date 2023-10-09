package co.edu.uniquindio.subasta.utils;

import co.edu.uniquindio.subasta.model.Subasta;
import co.edu.uniquindio.subasta.model.Usuario;

public class SubastaUtils {

    public static Subasta inicializarDatos(){
        Subasta subasta = new Subasta();

            Usuario usuario = new Usuario();
            usuario.setNombre("Royer Garcia Palacio");
            usuario.setNombreUsuario("Royer1010");
            usuario.setTelefono("3245646473");
            usuario.setCorreoElectronico("royergarci10@gmail.com");
            usuario.setIdentificacion("1098546043");
            usuario.setContrasenia("royer12345");

            subasta.getListaUsuarios().add(usuario);

            Usuario usuario2 = new Usuario();
            usuario2.setNombre("Santiago Londoño Gaviria");
            usuario2.setNombreUsuario("Santiago1010");
            usuario2.setTelefono("3236519124");
            usuario2.setCorreoElectronico("londgav01@gmail.com");
            usuario2.setIdentificacion("1091884016");
            usuario2.setContrasenia("santiago12345");

            subasta.getListaUsuarios().add(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setNombre("J Oscar");
            usuario3.setNombreUsuario("Jo1010");
            usuario3.setTelefono("123456789");
            usuario3.setCorreoElectronico("qRikoJO@gmail.com");
            usuario3.setIdentificacion("0987654321");
            usuario3.setContrasenia("JO12345");

            subasta.getListaUsuarios().add(usuario3);

            return subasta;
    }
}
