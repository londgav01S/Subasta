package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Usuario;

public class RegistroUsuarioController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Usuario crearUsuario(String nombreCompleto, String nombreUsuario, String identificacion, String correoElectronico, String telefono, String contrasenia) {
    Usuario usuario = mfm.crearUsuario(nombreCompleto, telefono, identificacion, correoElectronico, nombreUsuario, contrasenia);
    return usuario;
    }

    public void eliminarUsuario(Usuario usuarioSeleccionado) {
        mfm.eliminarUsuario(usuarioSeleccionado.getIdentificacion());
    }
}
