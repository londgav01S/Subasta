package co.edu.uniquindio.subasta.model;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombreUsuario;
    private String contrasenia;


    public Usuario() {
    }

    public Usuario(String nombre, String telefono, String identificacion, String correoElectronico, String nombreUsuario, String contrasenia) {
        super(nombre, telefono, identificacion, correoElectronico);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
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
