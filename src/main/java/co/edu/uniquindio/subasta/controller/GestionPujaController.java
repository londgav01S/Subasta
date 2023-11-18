package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Anuncio;
import co.edu.uniquindio.subasta.model.Persona;
import co.edu.uniquindio.subasta.viewController.LoginViewController;
import javafx.scene.control.Alert;

public class GestionPujaController {

    static ModelFactoryController singleton = ModelFactoryController.getInstance();
    public static void enviarAlerta(String titulo, String header, String contenido, Alert.AlertType tipoAlerta) {
        singleton.mostrarMensajeAlerta(titulo,header,contenido, tipoAlerta);
    }

    public static void crearPuja(Anuncio selectedItem, int valorPuja) {
        singleton.crearPuja(selectedItem,valorPuja);
    }




}
