package co.edu.uniquindio.subasta.model;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private TipoProducto tipo;
    private String nombreAnunciante;

    public Producto() {}

    public Producto(String nombre, TipoProducto tipo, String nombreAnunciante) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nombreAnunciante = nombreAnunciante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public String getNombreAnunciante() {
        return nombreAnunciante;
    }

    public void setNombreAnunciante(String nombreAnunciante) {
        this.nombreAnunciante = nombreAnunciante;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                 +
                '}';
    }
}
