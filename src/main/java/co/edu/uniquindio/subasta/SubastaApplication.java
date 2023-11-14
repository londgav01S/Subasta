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

import javafx.stage.Stage;

public class SubastaApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= new FXMLLoader(SubastaApplication.class.getResource("InicialView.fxml"));
        Scene scene= new Scene(loader.load(),691 ,625,false, SceneAntialiasing.BALANCED);
        InicialViewController loginViewController = loader.getController();
        loginViewController.init(primaryStage);
        primaryStage.setTitle("Subasta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)  {
        launch(args);
    }
}