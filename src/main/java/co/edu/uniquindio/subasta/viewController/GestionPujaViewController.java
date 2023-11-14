package co.edu.uniquindio.subasta.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GestionPujaViewController {

    @FXML
    private Button btnPujar;

    @FXML
    private ComboBox<?> cbTipoProducto;

    @FXML
    private TableColumn<?, ?> colAnunciante;

    @FXML
    private TableColumn<?, ?> colCodigoAnuncio;

    @FXML
    private TableColumn<?, ?> colNombreAnuncio;

    @FXML
    private TextField fCodigoPuja;

    @FXML
    private TextField fNombreProducto;

    @FXML
    private TextField fOferta;


    @FXML
    private TableView<?> tableInformacionAnuncio;

    @FXML
    void btnPujarEvent(ActionEvent event) {

    }

}