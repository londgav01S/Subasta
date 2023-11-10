package co.edu.uniquindio.subasta.model;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private TipoProducto tipo;
    private Anunciante anunciante;

    public Producto() {}

    public Producto(String nombre, TipoProducto tipo, Anunciante anunciante) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.anunciante = anunciante;
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


    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                 +
                '}';
    }
}
