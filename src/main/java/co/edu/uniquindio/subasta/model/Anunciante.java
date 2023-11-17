package co.edu.uniquindio.subasta.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Anunciante extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    public Anunciante() {}

    public Anunciante(String nombre, String telefono, String identificacion, String correoElectronico, String nombreUsuario, String contrasenia) {
        super(nombre, telefono, identificacion, correoElectronico, nombreUsuario, contrasenia);
    }

    public Anunciante(String nombre, String telefono, String identificacion, String correoElectronico, LocalDate fechaNacimiento, String nombreUsuario, String contrasenia) {
        super(nombre, telefono, identificacion, correoElectronico, fechaNacimiento, nombreUsuario, contrasenia);
    }
}
