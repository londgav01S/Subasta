package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.model.Persona;
import co.edu.uniquindio.subasta.model.Usuario;
import javafx.scene.control.Alert;

import java.io.IOException;

public class LoginController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public boolean validarUsuario(String nombre, String contraseña) throws UsuarioException, IOException {
        return mfm.inicioSesion(nombre, contraseña);
    }

    public Persona retornarPersona(String nombre){
        return mfm.retornarPersona(nombre);
    }

    public void mostrarAlert(String titulo, String header, String contenido, Alert.AlertType tipoAlerta) {
        mfm.mostrarMensajeAlerta(titulo, header, contenido, tipoAlerta);
    }
}
