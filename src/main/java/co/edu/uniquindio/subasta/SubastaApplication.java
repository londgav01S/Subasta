package co.edu.uniquindio.subasta;

import co.edu.uniquindio.subasta.viewController.LoginViewController;
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
    public static Stage primaryStage;
    public static Parent rootNode;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= new FXMLLoader(SubastaApplication.class.getResource("LoginView.fxml"));
        Scene scene= new Scene(loader.load(),387 ,292,false, SceneAntialiasing.BALANCED);
        LoginViewController loginViewController = loader.getController();
        loginViewController.init(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args)  {
        launch(args);
    }
}