package co.edu.uniquindio.subasta;

import co.edu.uniquindio.subasta.viewController.ProductoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class SubastaApplication extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
         mostrarVentanaPrincial();
    }

    private void mostrarVentanaPrincial() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SubastaApplication.class.getResource("ProductoView.fxml"));
        AnchorPane anchorPane = (AnchorPane)loader.load();
        ProductoViewController bancoController = loader.getController();
        bancoController.setAplicacion(this);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args)  {
        launch(args);
    }
}