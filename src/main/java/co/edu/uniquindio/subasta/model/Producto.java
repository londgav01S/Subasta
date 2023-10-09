package co.edu.uniquindio.subasta.model;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private TipoProducto tipo;
    private Anuncio anuncio;

    public Producto() {}

    public Producto(String nombre, TipoProducto tipo, Anuncio anuncio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.anuncio = anuncio;
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

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;

        if (!nombre.equals(producto.nombre)) return false;
        if (tipo != producto.tipo) return false;
        return anuncio.equals(producto.anuncio);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + tipo.hashCode();
        result = 31 * result + anuncio.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", anuncio=" + anuncio +
                '}';
    }
}
