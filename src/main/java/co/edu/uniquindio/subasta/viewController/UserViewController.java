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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        persona.setCorreoElectronico(fCorreoElectronico.getText());
        persona.setTelefono(fTelefono.getText());
        if(fContraseniaNuevo.getText().isEmpty()){
            UserController.actualizarUsuario(UserController.retornarUsuario(),fUsuario.getText(), fContrasenia.getText(), persona);
        }else{
            UserController.actualizarUsuario(UserController.retornarUsuario(),fUsuario.getText(), fContraseniaNuevo.getText(), persona);
        }
    }


    @FXML
    void eliminarUsuario(ActionEvent event) {
        if(UserController.mostrarMensajeAlerta("¿Está seguro que desea eliminar su cuenta?", "Eliminar cuenta")){
            UserController.eliminarUsuario(UserController.retornarUsuario().getNombreUsuario());
            LoginViewController loginViewController = new LoginViewController();
            loginViewController.mostrar();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fNombreCompleto.setText(persona.getNombre());
        fNombreCompleto.setDisable(true);
        fIdentificacion.setText(persona.getIdentificacion());
        fIdentificacion.setDisable(true);
        fCorreoElectronico.setText(persona.getCorreoElectronico());
        fTelefono.setText(persona.getTelefono());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaLocalDate = LocalDate.parse(persona.getFechaNacimiento(), formatter);
        tfFechaNacimiento.setValue(fechaLocalDate);
        tfFechaNacimiento.setDisable(true);
        fUsuario.setText(UserController.retornarUsuario().getNombreUsuario());
    }
}
