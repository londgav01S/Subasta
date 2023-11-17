package co.edu.uniquindio.subasta.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombreUsuario;
    private String contrasenia;
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public Usuario(String nombreUsuario, String contrasenia, Persona persona) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
