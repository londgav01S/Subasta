package co.edu.uniquindio.subasta.viewController;
import co.edu.uniquindio.subasta.controller.PujaRealizadaController;
import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.Puja;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PujaRealizadaViewController  implements Initializable {
    @FXML
    private Button btnAceptarPuja;

    @FXML
    private Button btnRechazarPuja;
    @FXML
    private Button btnCancelar;

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
        PujaRealizadaController.aceptarPuja(tblPujasPendientes.getSelectionModel().getSelectedItem());
        updateTablas();
        PujaRealizadaController.enviarAlerta("Puja Aceptada",
                "La puja ha sido confirmada", "Has aceptado esta compra",
        Alert.AlertType.CONFIRMATION);
        txtPrecioConcordado.clear();
        txtAreaInformacionPuja.clear();
    }

    @FXML
    void cancelarPuja(ActionEvent event) {
        PujaRealizadaController.cancelarPuja(tblPujasPendientes.getSelectionModel().getSelectedItem());
        updateTablas();
        PujaRealizadaController.enviarAlerta("Puja cancelada", "La puja ha sido Cancelada",
                "Has cancelado esta puja", Alert.AlertType.INFORMATION);
        txtPrecioConcordado.clear();
        txtAreaInformacionPuja.clear();

    }

    private void updateTablas() {
        tblPujasPendientes.setItems(PujaRealizadaController.getListaPujasPendientes());
        tblPujasAnswered.setItems(PujaRealizadaController.getListaPujasRespondidas());

    }


    @FXML
    void rechazarPuja(ActionEvent event) {
        PujaRealizadaController.rechazarPuja(tblPujasPendientes.getSelectionModel().getSelectedItem());
        updateTablas();
        PujaRealizadaController.enviarAlerta("Puja Rechazada",
                "La puja ha sido rechazada", "Has rechazado esta compra",
                Alert.AlertType.CONFIRMATION);
        txtPrecioConcordado.clear();
        txtAreaInformacionPuja.clear();
    }

    @FXML
    void selectPujaRespondida(MouseEvent event) {
        btnAceptarPuja.setDisable(false);
        btnRechazarPuja.setDisable(false);
        btnCancelar.setDisable(true);
    }

    @FXML
    void selectPujasPendiente(MouseEvent event) {
        btnAceptarPuja.setDisable(true);
        btnRechazarPuja.setDisable(true);
        btnCancelar.setDisable(false);
        txtAreaInformacionPuja.setText(tblPujasPendientes.getSelectionModel().getSelectedItem().getAnuncio().toString());
        txtPrecioConcordado.setText(tblPujasPendientes.getSelectionModel().getSelectedItem().getValorInicial()+"");
    }
    public void initialize (URL url, ResourceBundle resourceBundle){
        clmEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        clmPrecioPendiente.setCellValueFactory(new PropertyValueFactory<>("valorInicial"));
        clmProductoPendiente.setCellValueFactory(new PropertyValueFactory<>("producto"));
        clmPrecioRespondido.setCellValueFactory(new PropertyValueFactory<>("valorInicial"));
        clmProductoRespondido.setCellValueFactory(new PropertyValueFactory<>("producto"));
        updateTablas();
    }
}
