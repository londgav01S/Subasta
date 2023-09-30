package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.model.Anuncio;
import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.TipoProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductoViewController implements Initializable {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    private Producto productoSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;
    @FXML
    private ComboBox<TipoProducto> cTipoProducto;

    @FXML
    private TableColumn<Anuncio, String> columnaAnuncio;

    @FXML
    private TableColumn<Producto, String> columnaNombreProducto;

    @FXML
    private TableColumn<TipoProducto, String> columnaTipoProducto;

    @FXML
    private TextField fNombreProducto;

    @FXML
    private TableView<Producto> tableViewProducto;


    @FXML
    void actualizarProductoEvent(ActionEvent event) {

    }

    @FXML
    void agregarProductoEvent(ActionEvent event) {

    }

    @FXML
    void eliminarProductoEvent(ActionEvent event) {

    }

    private boolean datosValidados(String saldoAux, String tasaAux, String numeroCuenta1) {
        String notificacion = "";
        if(saldoAux == null || saldoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(tasaAux == null || tasaAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(numeroCuenta1 == null || numeroCuenta1.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(notificacion.equals("") || notificacion == null){
            return true;
        }
        return false;

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.columnaNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnaTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.columnaAnuncio.setCellValueFactory(new PropertyValueFactory<>("anuncio"));
        tableViewProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if(newSelection!= null){
                productoSeleccionado = newSelection;
                mostrarDatosField ();
            }
        });

    }


    private void mostrarDatosField() {

        if (productoSeleccionado != null){
            fNombreProducto.setText(productoSeleccionado.getNombre());

        }
    }
    ;
}
