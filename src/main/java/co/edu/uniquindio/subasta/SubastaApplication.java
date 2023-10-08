package co.edu.uniquindio.subasta;

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
        this.primaryStage = primaryStage;
        FXMLLoader loader= new FXMLLoader(SubastaApplication.class.getResource("RegistroUsuarioView.fxml"));
        Scene scene= new Scene(loader.load(),680 ,520,false, SceneAntialiasing.BALANCED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)  {
        launch(args);
    }
}