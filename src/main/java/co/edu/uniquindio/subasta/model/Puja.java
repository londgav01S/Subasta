package co.edu.uniquindio.subasta.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Puja implements Serializable {

    private static final long serialVersionUID = 1L;

    private EstadoPuja estado;

    private Comprador comprador;

    private Anuncio anuncio;

    private double valorInicial;

    private LocalDate fecha;

    public Puja() {}


    public Puja(EstadoPuja estado, Comprador comprador, Anuncio anuncio, double valorInicial, LocalDate fecha) {
        this.estado = estado;
        this.comprador = comprador;
        this.anuncio = anuncio;
        this.valorInicial = valorInicial;
        this.fecha = fecha;
    }
    public EstadoPuja getEstado() {
        return estado;
    }

    public void setEstado(EstadoPuja estado) {
        this.estado = estado;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return  "estado=" + estado +
                ", comprador=" + comprador.getNombre() +
                ", anuncio=" + anuncio +
                ", valorInicial=" + valorInicial +
                ", fecha=" + fecha +
                '}';
    }
}
