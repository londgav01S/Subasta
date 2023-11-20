package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.controller.PrincipalController;
import co.edu.uniquindio.subasta.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PrincipalViewController implements Initializable {

    @FXML
    private Button bPage1;
    @FXML
    private Button bPage2;
    @FXML
    private Button bPage3;
    @FXML
    private Button estadisticas;
    @FXML
    private Button btnSalir;
    @FXML
    private StackPane contentArea;
    @FXML
    private AnchorPane panelCentral;

    private PrincipalController principalController;
    Persona persona;

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @FXML
    void abrir1(ActionEvent event) throws IOException {
        panelCentral.getChildren().clear();
        Parent root = FXMLLoader.load((getClass().getResource("/co/edu/uniquindio/subasta/GestionAnuncio.fxml")));
        panelCentral.getChildren().add(root);
    }
    @FXML
    void abrir2(ActionEvent event) throws IOException {
        panelCentral.getChildren().clear();
        Parent root = FXMLLoader.load((getClass().getResource("/co/edu/uniquindio/subasta/PujaView.fxml")));

        panelCentral.getChildren().add(root);
    }
    @FXML
    void abrir3(ActionEvent event) {
    }

    @FXML
    void salirEvent(ActionEvent event) {
        loginController.mortrar();
        this.stage.close();


    }

    public void bloquearBotones (){
        if(principalController.verificarTipoUsuario()){
            bPage1.setDisable(true);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        principalController = new PrincipalController() ;
        bloquearBotones();

    }
    private LoginViewController loginController;
    private Stage stage;
    public void init(Stage stage, LoginViewController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }
}
