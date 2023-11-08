package co.edu.uniquindio.subasta.viewController;


import co.edu.uniquindio.subasta.SubastaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private PasswordField fContrasenia;

    @FXML
    private TextField fUsuario;

    private Stage stage;
    private Stage stage2 = new Stage();

    public void init(Stage primaryStage) {
        this.stage = primaryStage;
    }
    @FXML
    void iniciarSesionEvent(ActionEvent event) {
       // String identificacion = userLogin.getText();
       // String contrasenia = contraLogin.getText();
       // Persona persona= obtener2();
       // System.out.println(persona.getIdentificacion());
        //if(verificarDatos(identificacion, contrasenia)) {
         //   if (identificacion.equals("Robinson") && contrasenia.equals("010101")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Concesionario.fxml"));
                    Parent root = loader.load();
                    ProductoViewController productoViewController = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
              //      productoViewController.init(stage, this);
                    stage.show();
                    this.stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            //}
        }



    @FXML
    void registrarUsuarioEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SubastaApplication.class.getResource("RegistroUsuarioView.fxml"));
            AnchorPane rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(rootLayout);
            RegistroUsuarioViewController registroUsuarioViewController = loader.getController();
            registroUsuarioViewController.init(stage2, this);
            this.stage2.setScene(scene);
            stage.close();
            this.stage2.show();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void show() {
        this.stage.show();
    }

}
