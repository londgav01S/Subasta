package co.edu.uniquindio.subasta.viewController;
import co.edu.uniquindio.subasta.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.controller.ProductoController;
import co.edu.uniquindio.subasta.controller.RegistroUsuarioController;
import co.edu.uniquindio.subasta.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import co.edu.uniquindio.subasta.model.Persona;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 */
public class RegistroUsuarioViewController implements Initializable {

    @FXML
    private Button btnVolverInisioSesion;
    private LoginViewController loginController;

    private InicialViewController inicialViewController;

    private Stage stage = new Stage();

    public void init(Stage stage, LoginViewController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }

    public  void  cerrar (){
        this.stage.close();
    }
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    RegistroUsuarioController registroUsuarioController;

    @FXML
    private TableColumn<Usuario, String> columnaCorreoElectronico;

    @FXML
    private TableColumn<Usuario, String> columnaIdentificacion;

    @FXML
    private TableColumn<Usuario, String> columnaTelefono;

    @FXML
    private TableColumn<Usuario, String> columnaUsuario;

    @FXML
    private TableView<Usuario> tableViewUsuario;

    @FXML
    private Button btnAgregar;

    @FXML
    private TextField fContrasenia;

    @FXML
    private TextField fCorreoElectronico;

    @FXML
    private TextField fIdentificacion;

    @FXML
    private TextField fNombreCompleto;

    @FXML
    private TextField fTelefono;

    @FXML
    private TextField fUsuario;

    @FXML
    private DatePicker tfFechaNacimiento;

    @FXML
    private ComboBox<String> cbTipoUsuario;

    private ArrayList<Usuario> obtenerUsuarios(){
        //listadoUsuarios.addAll(mfm.obtenerUsuarios());
        return (ArrayList<Usuario>) listadoUsuarios;
    }
/*
    @FXML
    void actualizarUsuarioEvent(ActionEvent event) {
        String nombreUsuario = fUsuario.getText();
        String correoElectronico = fCorreoElectronico.getText();
        String telefono = fTelefono.getText();
        if(usuarioSeleccionado!= null) {
            if (datosValidados(nombreUsuario, correoElectronico, telefono, "no tocar", "no tocar", "no tocar")) {
                registroUsuarioController.actualizarUsuario( usuarioSeleccionado,  telefono,  correoElectronico,  nombreUsuario);
                usuarioSeleccionado.setCorreoElectronico(correoElectronico);
                usuarioSeleccionado.setTelefono(telefono);
                usuarioSeleccionado.setNombreUsuario(nombreUsuario);
                tableViewUsuario.refresh();
            }
        }

        fNombreCompleto.setDisable(false);
        fIdentificacion.setDisable(false);
        fContrasenia.setDisable(false);
        fUsuario.setText("");
        fIdentificacion.setText("");
        fNombreCompleto.setText("");
        fContrasenia.setText("");
        fCorreoElectronico.setText("");
        fTelefono.setText("");
    }

*/
    ObservableList<Usuario> listadoUsuarios = FXCollections.observableArrayList();

    @FXML
    void agregarUsuarioEvent(ActionEvent event) {
        String nombreUsuario = fUsuario.getText();
        String identificacion = fIdentificacion.getText();
        String nombreCompleto = fNombreCompleto.getText();
        String correoElectronico = fCorreoElectronico.getText();
        String telefono = fTelefono.getText();
        String contrasenia = fContrasenia.getText();
        String fechaNacimiento = tfFechaNacimiento.getValue().toString();
        String tipoUsuario = cbTipoUsuario.getValue();

        crearUsuario(nombreCompleto, telefono, identificacion, correoElectronico, nombreUsuario, contrasenia,
                fechaNacimiento, tipoUsuario);

        fUsuario.setText("");
        fIdentificacion.setText("");
        fNombreCompleto.setText("");
        fContrasenia.setText("");
        fCorreoElectronico.setText("");
        fTelefono.setText("");
        tfFechaNacimiento.setValue(LocalDate.parse(""));
        cbTipoUsuario.setValue("");

    }

    private void crearUsuario(String nombreCompleto, String telefono, String identificacion, String correoElectronico,
                              String nombreUsuario, String contrasenia, String fechaNacimiento, String tipoUsuario) {

        Persona persona;
        if(datosValidados(nombreCompleto, identificacion,telefono, correoElectronico,  nombreUsuario,contrasenia,
                fechaNacimiento, tipoUsuario)){

            if(tipoUsuario.equals("Anunciante")){
                persona= registroUsuarioController.crearAnunciante(nombreCompleto, telefono, identificacion, correoElectronico,
                        LocalDate.parse(fechaNacimiento),null);
            }
            else{
                persona= registroUsuarioController.crearComprador(nombreCompleto, telefono, identificacion, correoElectronico,
                        LocalDate.parse(fechaNacimiento),null);
            }

            if(persona != null){
                //TODO: Pensar Bien la Logica de esto, es decir, lo del usuario con anunciante-comprador
                Usuario usuario= registroUsuarioController.crearUsuario(nombreUsuario,  contrasenia, persona);
                if(usuario != null){
                    listadoUsuarios.add(usuario);
                    mostrarMensajeAlerta("Notificacion ", "Registro exitoso", "El usuario con id: " + identificacion +" ha sido registrado" , Alert.AlertType.INFORMATION);
                }
                else{
                    mostrarMensajeAlerta("Notificacion ", "Registro invalido", "El usuario con id: " + identificacion  + "  No ha sido registrado", Alert.AlertType.WARNING);

                }
            }

            //TODO: mirar de que es esto
            tableViewUsuario.setItems(listadoUsuarios);
        }


    }

    @FXML
    void volverInicioSesionEvent(ActionEvent event) {
        loginController.mortrar();
        this.stage.close();
    }

    /*
    @FXML
    void eliminarUsuarioEvent(ActionEvent event) {
        if (usuarioSeleccionado != null){
            registroUsuarioController.eliminarUsuario(usuarioSeleccionado);
            mostrarMensajeAlerta("Producto eliminado ", "Producto selección ", "El prosucto se elimino correctamente ", Alert.AlertType.INFORMATION);
            listadoUsuarios.remove(usuarioSeleccionado);
        }
        else{
            mostrarMensajeAlerta("Cuenta seleccion ", "Cuenta seleccion ", "No se ha realizado ninguna seleccion", Alert.AlertType.WARNING);
        }
    }*/

/*
    @FXML
    void volverIniciarSesionEvent(ActionEvent event) {
        inicialViewController.show();
        this.stage.close();
    }
*/
    public  Stage getPrimaryStage() {
        return stage;
    }

    private boolean datosValidados(String nombreAux, String idAux, String telefonoAux, String correoAux,
                                   String usuarioAux, String contraAux, String fechaNacimientoAux, String tipoUsuarioAux) {
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

        if (fechaNacimientoAux == null || fechaNacimientoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(tipoUsuarioAux == null || tipoUsuarioAux.equals("")){
            notificacion+= "El dato es invalido";
        }

        if(notificacion.equals("") || notificacion == null){
            return true;
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

    private Usuario usuarioSeleccionado;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbTipoUsuario.getItems().addAll("Anunciante", "Comprador");

        registroUsuarioController = new RegistroUsuarioController();
        this.columnaUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        this.columnaIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        this.columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        this.columnaCorreoElectronico.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        tableViewUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if(newSelection!= null){
                usuarioSeleccionado = (Usuario) newSelection;
                mostrarDatosField ();
            }
        });
        //TODO: QUEMAR DATOS AQUI PA SABER SI FUNCIONA
        tableViewUsuario.setItems(listadoUsuarios);
        tableViewUsuario.refresh();




    }

    private void mostrarDatosField() {
        // TODO: arreglar pa mostrar los dtos
        /*
        if (usuarioSeleccionado != null){
            fNombreCompleto.setText(usuarioSeleccionado.getNombre());
            fUsuario.setText(usuarioSeleccionado.getNombreUsuario());
            fIdentificacion.setText(usuarioSeleccionado.getIdentificacion());
            fTelefono.setText(usuarioSeleccionado.getTelefono());
            fCorreoElectronico.setText(usuarioSeleccionado.getCorreoElectronico());
            fContrasenia.setDisable(true);
            fIdentificacion.setDisable(true);
            fNombreCompleto.setDisable(true);
        }*/
    }


}
