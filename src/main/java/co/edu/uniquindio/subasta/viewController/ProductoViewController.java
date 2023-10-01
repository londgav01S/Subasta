package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.SubastaApplication;
import co.edu.uniquindio.subasta.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.TipoProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Producto, String> columnaAnuncio;

    @FXML
    private TableColumn<Producto, String> columnaNombreProducto;

    @FXML
    private TableColumn<TipoProducto, String> columnaTipoProducto;

    @FXML
    private TextField fNombreProducto;

    @FXML
    private TableView<Producto> tableViewProducto;


    private SubastaApplication subastaApplication;

    public void setAplicacion(SubastaApplication subastaApplication) {
        this.subastaApplication = subastaApplication;

    }


    ////////////////////////////////////7
    // Acciones de botones


    @FXML
    void actualizarProductoEvent(ActionEvent event) {

    }


    ObservableList <Producto> listadoProductos = FXCollections.observableArrayList();



    @FXML
    void agregarProductoEvent(ActionEvent event) {
        agregarProductoAction();
    }

    private void agregarProductoAction() {
        /**
        String nombre = fNombreProducto.getText();
        if(datosValidados(nombre)){
            crearProducto(nombre, cTipoProducto.getSelectionModel().getSelectedItem(), null);
            tableViewProducto.setItems(listadoProductos);
        }
         */
    }

    private void crearProducto(String nombre, TipoProducto selectedItem, Object o) {
        /**
        Producto producto = mfm.crearProducto(nombre, selectedItem, o);
        if(producto != null){
            listadoProductos.add(producto);
            mostrarMensajeAlerta("Notificacion ", "Registro exitoso", "El producto: " + nombre +" ha sido registrado" , Alert.AlertType.INFORMATION);
        }
        else{
            mostrarMensajeAlerta("Notificacion ", "Registro invalido", "El producto: " + nombre  + "  No ha sido registrado", Alert.AlertType.WARNING);

        }
         */
    }


    @FXML
    void eliminarProductoEvent(ActionEvent event) {
        eliminarProductoAction();
    }

    private void eliminarProductoAction() {

        /**
        if (productoSeleccionado != null){
            mfm.eliminarProducto(productoSeleccionado);
            mostrarMensajeAlerta("Producto eliminado ", "Producto selección ", "El prosucto se elimino correctamente ", Alert.AlertType.INFORMATION);
            listadoProductos.remove(productoSeleccionado);
        }
        else{
            mostrarMensajeAlerta("Cuenta seleccion ", "Cuenta seleccion ", "No se ha realizado ninguna seleccion", Alert.AlertType.WARNING);
        }
         */
    }


    ////////////////////////////////////////////////////7
    //Funciones de uso general


    private void agregarTiposCombo() {
        /**
        List<TipoProducto> listadoTipos = new ArrayList<TipoProducto>();
        listadoTipos.add(TipoProducto.BIENRAIZ);
        listadoTipos.add(TipoProducto.DEPORTES);
        listadoTipos.add(TipoProducto.HOGAR);
        listadoTipos.add(TipoProducto.TECNOLOGIA);
        listadoTipos.add(TipoProducto.VEHICULOS);
        ObservableList<TipoProducto> lista = FXCollections.observableArrayList(listadoTipos);
        cTipoProducto.setItems(lista);
*/
    }

    /**
    private boolean datosValidados(String nombreAux) {
        String notificacion = "";
        if(nombreAux == null || nombreAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        return false;

    }

    public void mostrarMensajeAlerta (String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.columnaNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnaTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.columnaAnuncio.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        agregarTiposCombo();
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
