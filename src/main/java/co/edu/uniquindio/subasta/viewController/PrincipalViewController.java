package co.edu.uniquindio.subasta.viewController;
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
    private StackPane contentArea;

    @FXML
    private AnchorPane panelCentral;

    @FXML
    void abrir1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/co/edu/uniquindio/subasta/GestionAnuncio.fxml")));
        panelCentral.getChildren().add(root);
    }

    @FXML
    void abrir2(ActionEvent event) {

    }

    @FXML
    void abrir3(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private Stage stage;

    public void init(Stage primaryStage) {
        this.stage = primaryStage;
    }

}
