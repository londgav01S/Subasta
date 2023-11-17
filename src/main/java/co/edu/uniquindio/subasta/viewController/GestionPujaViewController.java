package co.edu.uniquindio.subasta.viewController;

import co.edu.uniquindio.subasta.model.Anuncio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GestionPujaViewController {


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

    @FXML
    void pujar(ActionEvent event) {
        System.out.println(txtPuja.getText());
    }

    @FXML
    void setInfo(MouseEvent event) {
        System.out.println("Pusieron porno");
    }

}