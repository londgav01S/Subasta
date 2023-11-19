package co.edu.uniquindio.subasta.viewController;


import co.edu.uniquindio.subasta.SubastaApplication;
import co.edu.uniquindio.subasta.controller.LoginController;
import co.edu.uniquindio.subasta.model.Persona;
import co.edu.uniquindio.subasta.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable{


    InicialViewController inicialViewController = new InicialViewController();

    RegistroUsuarioViewController registroUsuarioViewController = new RegistroUsuarioViewController();
    LoginController loginController = new LoginController();

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private PasswordField fContrasenia;

    @FXML
    private TextField fUsuario;

    private Stage stage = new Stage();

    private Producto producto;
    public static String nombreUsuario;

    public static  String contrasenia;

    public Persona persona;


    public void  init(Stage primaryStage) {
        this.stage = primaryStage;
    }


    public void iniciarSesion() {
        if (validarDatos()) {
            try {
                nombreUsuario = fUsuario.getText();
                contrasenia = fContrasenia.getText();
                if(loginController.validarUsuario(nombreUsuario, contrasenia)) {
                    persona= loginController.retornarPersona(nombreUsuario);
                    abrirPrincipal(persona);
                } else {
                    loginController.mostrarAlert("Error", "datos invalidos", "Por favor ingrese los datos correctos", Alert.AlertType.ERROR);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void abrirPrincipal(Persona persona) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SubastaApplication.class.getResource("PrincipalView.fxml"));
        StackPane rootLayout = (StackPane) loader.load();
        Stage stage2 = new Stage();
        PrincipalViewController principalViewController = loader.getController();
        principalViewController.setPersona(persona);
        Scene scene= new Scene(rootLayout,950 ,630,false, SceneAntialiasing.BALANCED);
        stage2.setScene(scene);
        principalViewController.init(stage2, this);
        stage2.show();
        this.stage.close();
    }

    public boolean validarDatos() {
        if (fUsuario.getText().isEmpty() || fContrasenia.getText().isEmpty()) {
            loginController.mostrarAlert("Error", "datos invalidos", "Por favor ingrese todos los datos", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    @FXML
    void iniciarSesionEvent(ActionEvent event) {
        iniciarSesion();
        fUsuario.setText("");
        fContrasenia.setText("");
    }


    @FXML
    void registrarseEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaApplication.class.getResource("RegistroUsuarioView.fxml"));
            AnchorPane anchorPane = (AnchorPane)loader.load();
            Stage stage2 = new Stage();
            RegistroUsuarioViewController registroUsuarioViewController1 = loader.getController();
            Scene scene= new Scene(anchorPane,667 ,610,false, SceneAntialiasing.BALANCED);
            stage2.setScene(scene);
            registroUsuarioViewController1.init(stage2, this);
            stage2.show();
            this.stage.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Persona getPersona (){
        return persona;
    }
    public void mostrar() {
        this.stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        producto = new Producto();
    }
}
