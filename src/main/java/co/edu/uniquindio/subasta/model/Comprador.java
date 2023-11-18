package co.edu.uniquindio.subasta.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comprador extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Puja> listaPujas= new ArrayList<>();

    public Comprador() {}

    public Comprador(String nombre, String telefono, String identificacion, String correoElectronico, LocalDate fechaNacimiento, List<Puja> listaPujas) {
        super(nombre, telefono, identificacion, correoElectronico, fechaNacimiento);
        this.listaPujas = listaPujas;
    }

    public List<Puja> getListaPujas() {
        return listaPujas;
    }

    public void setListaPujas(List<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }
}
