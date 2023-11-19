package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.controller.GestionPujaController;
import co.edu.uniquindio.subasta.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.model.Anunciante;
import co.edu.uniquindio.subasta.model.Anuncio;
import co.edu.uniquindio.subasta.model.EstadoPuja;
import co.edu.uniquindio.subasta.model.Puja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GestionPujaViewController implements Initializable {


    @FXML
    private Button btnPujar;

    @FXML
    private TableColumn<?, ?> clmAnunciante;

    @FXML
    private TableColumn<?, ?> clmCodigo;

    @FXML
    private TableColumn<?, ?> clmNombre;

    @FXML
    private ImageView imgVwImagen;

    @FXML
    private TableView<Anuncio> tblAnunciosPublicados;

    @FXML
    private TextArea txtAreaInfoProducto;

    @FXML
    private TextField txtPuja;

    private int valorPuja;

    ObservableList<Anuncio> listaAnuncios = FXCollections.observableArrayList();



    @FXML
    void pujar(ActionEvent event) {
        Anuncio anuncio= tblAnunciosPublicados.getSelectionModel().getSelectedItem();
        if(GestionPujaController.puedePujar(anuncio)){
            if(!txtPuja.getText().isEmpty() && txtPuja.getText().matches("\\d+")) {
                //En este ejemplo, la expresión regular \\d+ se utiliza para verificar si la cadena
                // contiene uno o más dígitos numéricos.
                // Aquí, \\d representa cualquier dígito numérico, y + significa uno o más ocurrencias.
                valorPuja = Integer.parseInt(txtPuja.getText());
                GestionPujaController.crearPuja(anuncio,valorPuja);

            }
            else {
                GestionPujaController.enviarAlerta("Error", "Error en el monto",
                        "Por favor ingresa un monto valido",
                        Alert.AlertType.WARNING);
            }
        }else{
            GestionPujaController.enviarAlerta("Error", "Cantidad máxima de pujas",
                    "Haz alcanzado la máxima cantidad de pujas para este anuncio 😭😭",
                    Alert.AlertType.WARNING);
        }
    }

    @FXML
    void setInfo(MouseEvent event) {
        Anuncio anuncio = tblAnunciosPublicados.getSelectionModel().getSelectedItem();
        txtAreaInfoProducto.setText(anuncio.toString());
    }



    public void initialize (URL url, ResourceBundle resourceBundle){
        this.clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.clmAnunciante.setCellValueFactory(new PropertyValueFactory<>("anunciante"));
        this.clmCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        Anunciante ader = new Anunciante("José","315450677","1232589857"
        ,"luichiMail", LocalDate.now(),null);
        Anuncio ad = new Anuncio("Carro","123",ader,null,"Carrito lindo uwu",null,null,null,120.000);
        listaAnuncios.add(ad);
        tblAnunciosPublicados.setItems(listaAnuncios);
        /*
        TODO: En Teoría aqui se le pide al ViewController qn a su vez
         le pide al Singleton q porfis le mande la lista de Anuncios :beg
        */
    }



}