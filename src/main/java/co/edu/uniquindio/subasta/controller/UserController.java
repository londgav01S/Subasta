package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Persona;
import co.edu.uniquindio.subasta.model.Usuario;
import javafx.scene.control.Alert;

public class UserController {

    static ModelFactoryController mfm = ModelFactoryController.getInstance();

    public static Persona retornarPersona(){
        return mfm.retornarPersonaLog();
    }

    public static Usuario retornarUsuario(){
        return mfm.retornarUsuarioLog();
    }

    public static void actualizarUsuario(Usuario usuarioSeleccionado, String telefono, String correoElectronico, Persona persona){
        mfm.actualizarUsuario(usuarioSeleccionado, telefono, correoElectronico, persona);
    }

    public static void eliminarUsuario(String nombre){
        mfm.eliminarUsuario(nombre);
    }

    public static boolean mostrarMensajeAlerta(String mensaje, String header){
        return ModelFactoryController.mostrarAlertaConfirmacion(mensaje, header);
    }
}
