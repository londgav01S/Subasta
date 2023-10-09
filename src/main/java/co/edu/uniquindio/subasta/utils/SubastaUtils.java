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

            return subasta;
    }
}
