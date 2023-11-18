package co.edu.uniquindio.subasta.viewController;


import co.edu.uniquindio.subasta.SubastaApplication;
import co.edu.uniquindio.subasta.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable{

    InicialViewController inicialViewController = new InicialViewController();

    RegistroUsuarioViewController registroUsuarioViewController = new RegistroUsuarioViewController();

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


    public static String nombreUsuario ;


    public static String getNombreUsuario() {
        return nombreUsuario;
    }



    public static void setNombreUsuario(String nombreUsuario) {
        LoginViewController.nombreUsuario = nombreUsuario;
    }

    private Stage stage = new Stage();

    public void  init(Stage primaryStage) {
        this.stage = primaryStage;
    }

    private Producto producto;
    @FXML
    void iniciarSesionEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaApplication.class.getResource("PrincipalView.fxml"));
            StackPane rootLayout = (StackPane) loader.load();
            Stage stage2 = new Stage();
            PrincipalViewController principalViewController = loader.getController();
            Scene scene= new Scene(rootLayout,1050 ,660,false, SceneAntialiasing.BALANCED);
            stage2.setScene(scene);
            principalViewController.init(stage2, this);
            stage2.show();
            this.stage.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    @FXML
    void registrarseEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaApplication.class.getResource("RegistroUsuarioView.fxml"));
            AnchorPane anchorPane = (AnchorPane)loader.load();
            Stage stage2 = new Stage();
            RegistroUsuarioViewController registroUsuarioViewController1 = loader.getController();
            Scene scene= new Scene(anchorPane,1050 ,660,false, SceneAntialiasing.BALANCED);
            stage2.setScene(scene);
            registroUsuarioViewController1.init(stage2, this);
            stage2.show();
            this.stage.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void mortrar() {
        this.stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        producto = new Producto();
    }
}
