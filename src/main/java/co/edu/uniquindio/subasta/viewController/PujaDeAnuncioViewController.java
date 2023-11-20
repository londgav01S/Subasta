package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.controller.AnuncioController;
import co.edu.uniquindio.subasta.controller.ProductoController;
import co.edu.uniquindio.subasta.controller.PujaDeAnuncioController;
import co.edu.uniquindio.subasta.model.Anuncio;
import co.edu.uniquindio.subasta.model.Puja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.ResourceBundle;

public class PujaDeAnuncioViewController implements Initializable {

    @FXML
    private Button btnElegirPuja;

    @FXML
    private TableView<Anuncio> tableAnuncios;

    @FXML
    private TableView<Puja> tablePujasRealizadas;

    @FXML
    private TableColumn<Anuncio, String> columnCodigoAnuncio;

    @FXML
    private TableColumn<Anuncio, String> columnNombreAnuncio;


    @FXML
    void elegirPujaEvent(ActionEvent event) {

    }

    private Anuncio anuncioSeleccionado;
    private PujaDeAnuncioController pujaDeAnuncioController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pujaDeAnuncioController = new PujaDeAnuncioController();
        this.columnNombreAnuncio.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnCodigoAnuncio.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        agregarDatosBase();
        tableAnuncios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                anuncioSeleccionado = (Anuncio) newSelection;
            }
        });
    }
    ObservableList<Anuncio> listadoAnuncios = FXCollections.observableArrayList();

    public void agregarDatosBase (){
        listadoAnuncios = pujaDeAnuncioController.agregarDatosBase();
        tableAnuncios.getItems().addAll(listadoAnuncios);
    }
}
