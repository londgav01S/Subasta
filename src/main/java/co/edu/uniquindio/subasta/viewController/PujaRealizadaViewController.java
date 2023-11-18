package co.edu.uniquindio.subasta.viewController;
import co.edu.uniquindio.subasta.model.Puja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
public class PujaRealizadaViewController {
    @FXML
    private Button btnAceptarPuja;

    @FXML
    private Button btnRechazarPuja;

    @FXML
    private TableColumn<?, ?> clmEstado;

    @FXML
    private TableColumn<?, ?> clmPrecioPendiente;

    @FXML
    private TableColumn<?, ?> clmPrecioRespondido;

    @FXML
    private TableColumn<?, ?> clmProductoPendiente;

    @FXML
    private TableColumn<?, ?> clmProductoRespondido;

    @FXML
    private TableView<Puja> tblPujasAnswered;

    @FXML
    private TableView<Puja> tblPujasPendientes;

    @FXML
    private TextArea txtAreaInformacionPuja;

    @FXML
    private TextField txtPrecioConcordado;

    @FXML
    void aceptarPuja(ActionEvent event) {
        System.out.println("sexo");
    }

    @FXML
    void rechazarPuja(ActionEvent event) {

    }

    @FXML
    void selectPujaRespondida(MouseEvent event) {
        btnAceptarPuja.setDisable(true);
        btnRechazarPuja.setDisable(true);
    }

    @FXML
    void selectPujasPendiente(MouseEvent event) {
        btnAceptarPuja.setDisable(false);
        btnRechazarPuja.setDisable(false);
    }
}
