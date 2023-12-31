package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.model.Anunciante;
import co.edu.uniquindio.subasta.model.CSVExporter;
import co.edu.uniquindio.subasta.model.Comprador;
import co.edu.uniquindio.subasta.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    void abrir3(ActionEvent event) throws IOException {
        panelCentral.getChildren().clear();
        Parent root = FXMLLoader.load((getClass().getResource("/co/edu/uniquindio/subasta/UsuarioView.fxml")));
        panelCentral.getChildren().add(root);
    }

    @FXML
    void salirEvent(ActionEvent event) {
        loginController.mostrar();
        this.stage.close();


    }

    @FXML
    void crearEstadisticas(ActionEvent event) {
        if(persona instanceof Anunciante){
            CSVExporter.exportarAnunciosCSV(((Anunciante) persona).getListaAnuncios(), (Stage) ((Node) event.getSource()).getScene().getWindow());
        }else if(persona instanceof Comprador) {
            CSVExporter.exportarPujasResueltasCSV(((Comprador) persona).getListaPujas(), (Stage) ((Node) event.getSource()).getScene().getWindow());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    private LoginViewController loginController;
    private Stage stage;
    public void init(Stage stage, LoginViewController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }
}
