package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Comprador;
import co.edu.uniquindio.subasta.model.Subasta;
import co.edu.uniquindio.subasta.model.Usuario;

import java.time.LocalDate;

public class RegistroUsuarioController {

    Subasta subasta;

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Usuario crearUsuario(String nombreUsuario, String contrasenia) {
        return mfm.crearUsuario(nombreUsuario, contrasenia);
    }

    public void crearAnunciante(String nombreCompleto, String telefono, String identificacion, String correoElectronico,
                                LocalDate fechaNacimiento, String nombreUsuario, String contrasenia) {
        mfm.crearAnunciante(nombreCompleto, telefono, identificacion, correoElectronico, fechaNacimiento, nombreUsuario, contrasenia);
    }

    public void eliminarUsuario(Usuario usuarioSeleccionado) {
        mfm.eliminarUsuario(usuarioSeleccionado.getIdentificacion());
    }

    public void actualizarUsuario(Usuario usuarioSeleccionado, String telefono, String correoElectronico, String nombreUsuario) {
        mfm.actualizarUsuario ( usuarioSeleccionado,  telefono,  correoElectronico,  nombreUsuario);
    }


    public Comprador crearComprador(String nombreCompleto, String telefono, String identificacion, String correoElectronico, LocalDate parse, String nombreUsuario, String contrasenia) {
        return mfm.crearComprador(nombreCompleto, telefono, identificacion, correoElectronico, parse, nombreUsuario, contrasenia);
    }
}
