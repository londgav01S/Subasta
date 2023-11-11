package co.edu.uniquindio.subasta.viewController;


import co.edu.uniquindio.subasta.SubastaApplication;
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

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private PasswordField fContrasenia;

    @FXML
    private TextField fUsuario;

    private Stage stage2 = new Stage();

    public String nombreUsuario ;

    private Stage stage;
    @FXML
    void iniciarSesionEvent(ActionEvent event) {
        nombreUsuario = fUsuario.getText();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaApplication.class.getResource("PrincipalView.fxml"));
            StackPane rootLayout = (StackPane) loader.load();
            Scene scene = new Scene(rootLayout);
            PrincipalViewController principalViewController = loader.getController();
            principalViewController.init(stage2, this);
            this.stage2.setScene(scene);
            //inicialViewController.getStage().hide();
            //inicialViewController.cerrar(stage);
            //stage.close();
            this.stage2.show();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stage = inicialViewController.getStage();
    }
}
