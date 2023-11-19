package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.controller.UserController;
import co.edu.uniquindio.subasta.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {

    @FXML
    private Button btActualizarDatos;

    @FXML
    private Button btElimanar;

    @FXML
    private TextField fContrasenia;

    @FXML
    private TextField fContraseniaNuevo;

    @FXML
    private TextField fCorreoElectronico;

    @FXML
    private TextField fIdentificacion;

    @FXML
    private TextField fNombreCompleto;

    @FXML
    private TextField fTelefono;

    @FXML
    private TextField fUsuario;

    @FXML
    private DatePicker tfFechaNacimiento;

    Persona persona= UserController.retornarPersona();

    @FXML
    void actualizar(ActionEvent event) {
    }

    @FXML
    void eliminarUsuario(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fNombreCompleto.setText(persona.getNombre());
        fIdentificacion.setText(persona.getIdentificacion());
        fCorreoElectronico.setText(persona.getCorreoElectronico());
        fTelefono.setText(persona.getTelefono());
        tfFechaNacimiento.setValue(persona.getFechaNacimiento());
    }
}
