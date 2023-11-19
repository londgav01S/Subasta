package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Puja;
import javafx.collections.ObservableList;

public class PujaRealizadaController {
    static ModelFactoryController singleton = ModelFactoryController.getInstance();
    public static ObservableList<Puja> getListaPujasPendientes() {
        return singleton.getListaPujasPendientes();
    }
}
