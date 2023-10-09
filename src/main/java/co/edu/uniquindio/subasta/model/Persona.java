package co.edu.uniquindio.subasta.model;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String telefono;
    private String identificacion;
    private String correoElectronico;


    public Persona() {}

    public Persona(String nombre, String telefono, String identificacion, String correoElectronico) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
