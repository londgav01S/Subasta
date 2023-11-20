package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Puja;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class PujaRealizadaController {
    static ModelFactoryController singleton = ModelFactoryController.getInstance();
    public static ObservableList<Puja> getListaPujasPendientes() {
        return singleton.getListaPujasPendientes();
    }

    public static void cancelarPuja(Puja selectedItem) {
        singleton.cancelarPuja(selectedItem);
    }

    public static ObservableList<Puja> getListaPujasRespondidas() {
        return singleton.getListaPujasRespondidas();
    }

    public static void aceptarPuja(Puja selectedItem) {
        singleton.aceptarPuja(selectedItem);
    }

    public static void rechazarPuja(Puja selectedItem) {
        singleton.rechazarPuja(selectedItem);
    }

    public static void enviarAlerta(String titulo, String heador, String contenido, Alert.AlertType tipoAlerta) {
        singleton.mostrarMensajeAlerta(titulo,heador,contenido,tipoAlerta);
    }
}
