package co.edu.uniquindio.subasta;

import co.edu.uniquindio.subasta.viewController.InicialViewController;
import co.edu.uniquindio.subasta.viewController.LoginViewController;
import co.edu.uniquindio.subasta.viewController.PrincipalViewController;
import co.edu.uniquindio.subasta.viewController.ProductoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class SubastaApplication extends Application {
    public static Parent rootNode;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= new FXMLLoader(SubastaApplication.class.getResource("LoginView.fxml"));
        Scene scene= new Scene(loader.load(),300 ,289,false, SceneAntialiasing.BALANCED);
        //InicialViewController inicialViewController = loader.getController();
        LoginViewController loginViewController = loader.getController();
        //inicialViewController.init(primaryStage);
        loginViewController.init(primaryStage);
        primaryStage.setTitle("Subasta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args)  {
        launch(args);
    }
}