package co.edu.uniquindio.subasta.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionPujaViewController {

    @FXML
    private Button btnPujar;

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
    private TextField fTipoProducto;

    @FXML
    private TableView<?> tableInformacionAnuncio;

    @FXML
    void btnPujarEvent(ActionEvent event) {

    }

}