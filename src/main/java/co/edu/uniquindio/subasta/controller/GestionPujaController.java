package co.edu.uniquindio.subasta.controller;

import javafx.scene.control.Alert;

public class GestionPujaController {

    static ModelFactoryController singleton = ModelFactoryController.getInstance();
    public static void enviarAlerta(String titulo, String header, String contenido, Alert.AlertType tipoAlerta) {
        singleton.mostrarMensajeAlerta(titulo,header,contenido, tipoAlerta);
    }
}
