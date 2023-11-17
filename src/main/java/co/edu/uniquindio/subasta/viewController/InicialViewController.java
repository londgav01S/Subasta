package co.edu.uniquindio.subasta.viewController;

import javafx.stage.Stage;

public class InicialViewController {

    public InicialViewController() {
    }

    RegistroUsuarioViewController registroUsuarioViewController = new RegistroUsuarioViewController();
    Stage stage = new Stage();


public void cerrar (){
    System.out.println("Se cerro");

        this.stage.close();
}

    public Stage getStage() {
        return this.stage;
    }

    public void show() {
        this.stage.show();
    }
}
