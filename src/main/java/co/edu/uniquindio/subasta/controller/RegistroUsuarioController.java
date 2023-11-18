package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.*;

import java.time.LocalDate;
import java.util.List;

public class RegistroUsuarioController {

    Subasta subasta;

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Usuario crearUsuario(String nombreUsuario, String contrasenia, Persona persona) {
        return mfm.crearUsuario(nombreUsuario, contrasenia, persona);
    }

    public Anunciante crearAnunciante(String nombreCompleto, String telefono, String identificacion, String correoElectronico,
                                      LocalDate fechaNacimiento, List<Anuncio> listaAnuncios) {
        return mfm.crearAnunciante(nombreCompleto, telefono, identificacion, correoElectronico, fechaNacimiento, listaAnuncios);
    }

    public void eliminarUsuario(Usuario usuarioSeleccionado) {
        //mfm.eliminarUsuario(usuarioSeleccionado.getIdentificacion());
    }

    public void actualizarUsuario(Usuario usuarioSeleccionado, String telefono, String correoElectronico, String nombreUsuario) {
        mfm.actualizarUsuario ( usuarioSeleccionado,  telefono,  correoElectronico,  nombreUsuario);
    }


    public Comprador crearComprador(String nombreCompleto, String telefono, String identificacion, String correoElectronico, LocalDate parse, List<Puja> listaPujas) {
        return mfm.crearComprador(nombreCompleto, telefono, identificacion, correoElectronico, parse, listaPujas);
    }
}
