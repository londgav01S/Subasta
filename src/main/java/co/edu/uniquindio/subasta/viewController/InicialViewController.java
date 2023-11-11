package co.edu.uniquindio.subasta.viewController;

import javafx.stage.Stage;

public class InicialViewController {

    public InicialViewController() {
    }

    Stage stage = new Stage();
    public void init(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void cerrar(Stage stage1) {
        stage1.close();
        System.out.println(" Ventana cerrada ");
    }

    public Stage getStage() {
        return this.stage;
    }

    public void show() {
        this.stage.show();
    }
}
