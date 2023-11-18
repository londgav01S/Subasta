package co.edu.uniquindio.subasta.model;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Anuncio implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String codigo;
    private Anunciante anunciante;
    private Producto producto;
    private String descripcion;
    private Image imagen;
    private LocalDate fechaPublicacion;
    private LocalDate fechaTerminacion;
    private Double valorInicial;

    public Anuncio() {
    }

    public Anuncio(String nombre, String codigo, Anunciante anunciante, Producto producto,
                   String descripcion, Image imagen, LocalDate fechaPublicacion,
                   LocalDate fechaTerminacion, Double valorInicial) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.anunciante = anunciante;
        this.producto = producto;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaTerminacion = fechaTerminacion;
        this.valorInicial = valorInicial;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDate getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(LocalDate fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return Objects.equals(codigo, anuncio.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\n' +
                "codigo='" + codigo + '\n' +
                "anunciante=" + anunciante.getNombre() +'\n' +
                "producto=" + producto + '\n' +
                "descripcion='" + descripcion + '\n' +
                "fechaPublicacion=" + fechaPublicacion +'\n' +
                "fechaTerminacion=" + fechaTerminacion + '\n' +
                "valorInicial=" + valorInicial;
    }
}
