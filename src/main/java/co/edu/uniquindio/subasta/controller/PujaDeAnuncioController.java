package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Anuncio;
import co.edu.uniquindio.subasta.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PujaDeAnuncioController {
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public ObservableList<Anuncio> agregarDatosBase() {
        ObservableList<Anuncio> listadoAnuncios = FXCollections.observableArrayList();
        listadoAnuncios = mfm.agregarDatosBaseAnuncios();
        return listadoAnuncios;
    }

}
