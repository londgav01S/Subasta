package co.edu.uniquindio.subasta.viewController;


import co.edu.uniquindio.subasta.controller.AnuncioController;
import co.edu.uniquindio.subasta.controller.ProductoController;
import co.edu.uniquindio.subasta.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AnuncioViewController implements Initializable {

    private Subasta subasta = new Subasta();

    AnuncioController anuncioController;

    Anuncio anuncioSeleccionado;

    ObservableList<Anuncio> listadoAnuncios = FXCollections.observableArrayList();


    @FXML
    private TableColumn<Anuncio, String> columnCodigo;

    @FXML
    private TableColumn<Anuncio, LocalDate> columnFechaFinal;

    @FXML
    private TableColumn<Anuncio, LocalDate> columnFechaInicio;

    @FXML
    private TableColumn<Anuncio, String> columnNombreAnuncio;

    @FXML
    private TableColumn<Anuncio, Double> columnValorInicial;

    @FXML
    private Button btnCargarImagen;

    @FXML
    private Button btnPublicar;


    @FXML
    private Button btnCargarProductos;


    @FXML
    public ComboBox<Producto> comboProducto;

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
    private TableView<Anuncio> tableAnuncio;

    @FXML
    void publicarEvent(ActionEvent event) {
        publicarAction();
    }

    private void publicarAction() {
        String nombreAnun = fNombreAnuncio.getText();
        String codigo = fCodigoAnuncio.getText();
        String valorAux = fValorInicial.getText();
        String descripcion = fDescripcion.getText();
        LocalDate inicio = fechaInicial.getValue();
        LocalDate fechaF = fechaFinal.getValue();
        if (datosValidados(nombreAnun, codigo, valorAux, descripcion, "b", "c")) {
            Double valorInicial = Double.parseDouble(fValorInicial.getText());
            crearAnuncio (nombreAnun, codigo, null, null,
                     descripcion, null,  inicio,
                     fechaF,  valorInicial);
            tableAnuncio.setItems(listadoAnuncios);
        }
    }

    private Anuncio crearAnuncio(String nombre, String codigo, Anunciante anunciante, Producto producto,
                                 String descripcion, Image imagen, LocalDate fechaPublicacion,
                                 LocalDate fechaTerminacion, Double valorInicial) {
    Anuncio anuncio = anuncioController.crearAnuncio (nombre, codigo, anunciante, producto,
            descripcion, imagen,  fechaPublicacion,
            fechaTerminacion,  valorInicial);
    listadoAnuncios.add(anuncio);
    return anuncio;
    }

    private List<Producto> cargarProducto (){
        List<Producto> lista  = new ArrayList<>();
        lista = productoController.cargarProducto();
        return lista;
    }

    ProductoViewController productoViewController;
    ProductoController productoController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productoController = new ProductoController();
        productoViewController = new ProductoViewController();
        anuncioController = new AnuncioController();
        llenarCombo();
        this.columnNombreAnuncio.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnValorInicial.setCellValueFactory(new PropertyValueFactory<>("valorInicial"));
        this.columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.columnFechaFinal.setCellValueFactory(new PropertyValueFactory<>("fechaTerminacion"));
        this.columnFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));
        tableAnuncio.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                anuncioSeleccionado = (Anuncio) newSelection;
                mostrarDatosField();
            }
        });
    }


    @FXML
    void cargarProductosEvent(ActionEvent event) {
        List<Producto> lista = new ArrayList<Producto>();
        lista.add(subasta.getListaProductos().get(0));
        ObservableList<Producto> listadoProductos = FXCollections.observableArrayList(lista);
        System.out.println("listadoProductos = " + lista.toString());
        comboProducto.setItems(listadoProductos);
    }

    private void llenarCombo (){
        List<Producto> lista = cargarProducto();
        ObservableList<Producto> listaProducts = FXCollections.observableArrayList(lista);
        comboProducto.setItems(listaProducts);
    }
        private boolean datosValidados(String nombreAux, String idAux, String telefonoAux, String correoAux, String usuarioAux, String contraAux) {
        String notificacion = "";
        if(nombreAux == null || nombreAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(idAux == null || idAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(telefonoAux == null || telefonoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(correoAux == null || correoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(usuarioAux == null || usuarioAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(contraAux == null || contraAux.equals("")){
            notificacion+= "El dato es invalido";
        }

        if(notificacion.equals("") || notificacion == null){
            return true;
        }
        return false;

    }

    private void mostrarDatosField() {

        if (anuncioSeleccionado != null){
            fNombreAnuncio.setText(anuncioSeleccionado.getNombre());
            fCodigoAnuncio.setText(anuncioSeleccionado.getCodigo());
            fDescripcion.setText(anuncioSeleccionado.getDescripcion());

            //fContrasenia.setDisable(true);

        }
    }





}
