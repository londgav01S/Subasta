package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Subasta;
import co.edu.uniquindio.subasta.model.Usuario;

import java.util.ArrayList;

public class RegistroUsuarioController {

    Subasta subasta;

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Usuario crearUsuario(String nombreCompleto, String telefono, String identificacion, String correoElectronico, String nombreUsuario, String contrasenia) {
    Usuario usuario = mfm.crearUsuario(nombreCompleto, telefono, identificacion, correoElectronico, nombreUsuario, contrasenia);
    return usuario;
    }

    public void eliminarUsuario(Usuario usuarioSeleccionado) {
        mfm.eliminarUsuario(usuarioSeleccionado.getIdentificacion());
    }

    public void actualizarUsuario(Usuario usuarioSeleccionado, String telefono, String correoElectronico, String nombreUsuario) {
        mfm.actualizarUsuario ( usuarioSeleccionado,  telefono,  correoElectronico,  nombreUsuario);
    }


}
