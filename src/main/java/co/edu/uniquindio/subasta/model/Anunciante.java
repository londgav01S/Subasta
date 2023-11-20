package co.edu.uniquindio.subasta.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Anunciante extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Anuncio> listaAnuncios= new ArrayList<>();
    public Anunciante() {}

    public Anunciante(String nombre, String telefono, String identificacion, String correoElectronico,
                      String fechaNacimiento, List<Anuncio> listaAnuncios) {
        super(nombre, telefono, identificacion, correoElectronico, fechaNacimiento);
        this.listaAnuncios = listaAnuncios;
    }

    public List<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }
}
