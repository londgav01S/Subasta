package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Anunciante;
import co.edu.uniquindio.subasta.model.Anuncio;
import co.edu.uniquindio.subasta.model.Producto;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class AnuncioController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public AnuncioController() {
    }


    public Anuncio crearAnuncio(String nombre, String codigo, Anunciante anunciante, Producto producto,
                                String descripcion, Image imagen, LocalDate fechaPublicacion,
                                LocalDate fechaTerminacion, Double valorInicial) {
    Anuncio anuncio = mfm.crearAnuncio(nombre, codigo, anunciante, producto,
            descripcion, imagen,  fechaPublicacion,
            fechaTerminacion,  valorInicial);
    return anuncio;
    }
}
