package co.edu.uniquindio.subasta.viewController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AnuncioViewController {
    @FXML
    private Button btnCargarImagen;

    @FXML
    private Button btnPublicar;

    @FXML
    private ComboBox<?> comboProducto;

    @FXML
    private TextField fCodigoAnuncio;

    @FXML
    private TextField fDescripcion;

    @FXML
    private TextField fNombreAnuncio;

    @FXML
    private TextField fValorInicial;

    @FXML
    private DatePicker fechaFinal;

    @FXML
    private DatePicker fechaInicial;

    @FXML
    private TableView<?> tableAnuncio;

    @FXML
    void publicarEvent(ActionEvent event) {

    }

}
