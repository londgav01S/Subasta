package co.edu.uniquindio.subasta.viewController;
import co.edu.uniquindio.subasta.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.controller.ProductoController;
import co.edu.uniquindio.subasta.controller.RegistroUsuarioController;
import co.edu.uniquindio.subasta.model.Persona;
import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.Usuario;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistroUsuarioViewController implements Initializable {


    private LoginViewController loginController;
    private Stage stage;
    public void init(Stage stage, LoginViewController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    RegistroUsuarioController registroUsuarioController;
    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnIVolverniciarSesion;

    @FXML
    private TableColumn<Usuario, String> columnaCorreoElectronico;

    @FXML
    private TableColumn<Usuario, String> columnaIdentificacion;

    @FXML
    private TableColumn<Usuario, String> columnaTelefono;

    @FXML
    private TableColumn<Usuario, String> columnaUsuario;

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
    private TableView<Usuario> tableViewUsuario;

    private ArrayList<Usuario> obtenerUsuarios(){
        //listadoUsuarios.addAll(mfm.obtenerUsuarios());
        return (ArrayList<Usuario>) listadoUsuarios;
    }

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


    ObservableList<Usuario> listadoUsuarios = FXCollections.observableArrayList();

    @FXML
    void agregarUsuarioEvent(ActionEvent event) {
        String nombreUsuario = fUsuario.getText();
        String identificacion = fIdentificacion.getText();
        String nombreCompleto = fNombreCompleto.getText();
        String correoElectronico = fCorreoElectronico.getText();
        String telefono = fTelefono.getText();
        String contrasenia = fContrasenia.getText();
        if(datosValidados(nombreCompleto, nombreUsuario, identificacion, correoElectronico, telefono, contrasenia)){
            crearUsuario( nombreCompleto,  telefono,  identificacion,  correoElectronico,  nombreUsuario,  contrasenia);
            tableViewUsuario.setItems(listadoUsuarios);
        }
        fUsuario.setText("");
        fIdentificacion.setText("");
        fNombreCompleto.setText("");
        fContrasenia.setText("");
        fCorreoElectronico.setText("");
        fTelefono.setText("");

    }

    private void crearUsuario(String nombreCompleto, String telefono, String identificacion, String correoElectronico, String nombreUsuario, String contrasenia) {
        Usuario usuario = registroUsuarioController.crearUsuario(nombreCompleto,  telefono,  identificacion,  correoElectronico,  nombreUsuario,  contrasenia) ;
        if(usuario != null){
            listadoUsuarios.add(usuario);
            mostrarMensajeAlerta("Notificacion ", "Registro exitoso", "El usuario con id: " + identificacion +" ha sido registrado" , Alert.AlertType.INFORMATION);
        }
        else{
            mostrarMensajeAlerta("Notificacion ", "Registro invalido", "El usuario con id: " + identificacion  + "  No ha sido registrado", Alert.AlertType.WARNING);

        }
    }

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
    }


    @FXML
    void volverIniciarSesionEvent(ActionEvent event) {
        loginController.show();
        this.stage.close();
    }

    public  Stage getPrimaryStage() {
        return stage;
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

        Usuario usuario = new Usuario();
        usuario.setNombre("Royer Garcia Palacio");
        usuario.setNombreUsuario("Royer1010");
        usuario.setTelefono("3245646473");
        usuario.setCorreoElectronico("royergarci10@gmail.com");
        usuario.setIdentificacion("1098546043");
        usuario.setContrasenia("royer12345");


        Usuario usuario2 = new Usuario();
        //usuario2.setNombre("Santiago Londoño Gaviria");
        usuario2.setNombre("Santiago");
        usuario2.setNombreUsuario("Santiago   ");
        usuario2.setTelefono("3236519124");
        usuario2.setCorreoElectronico("londgav01@gmail.com");
        usuario2.setIdentificacion("1091884016");
        usuario2.setContrasenia("santiago12345");


        Usuario usuario3 = new Usuario();
        usuario3.setNombre("J Oscar");
        usuario3.setNombreUsuario("Jo1010");
        usuario3.setTelefono("123456789");
        usuario3.setCorreoElectronico("qRikoJO@gmail.com");
        usuario3.setIdentificacion("0987654321");
        usuario3.setContrasenia("JO12345");

        listadoUsuarios.add(usuario);
        listadoUsuarios.add(usuario2);
        listadoUsuarios.add(usuario3);
        tableViewUsuario.setItems(listadoUsuarios);
        tableViewUsuario.refresh();




    }

    private void mostrarDatosField() {

        if (usuarioSeleccionado != null){
            fNombreCompleto.setText(usuarioSeleccionado.getNombre());
            fUsuario.setText(usuarioSeleccionado.getNombreUsuario());
            fIdentificacion.setText(usuarioSeleccionado.getIdentificacion());
            fTelefono.setText(usuarioSeleccionado.getTelefono());
            fCorreoElectronico.setText(usuarioSeleccionado.getCorreoElectronico());
            fContrasenia.setDisable(true);
            fIdentificacion.setDisable(true);
            fNombreCompleto.setDisable(true);
        }
    }


}
