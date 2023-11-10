package co.edu.uniquindio.subasta.viewController;

import javafx.stage.Stage;

public class PrincipalViewController {


    private LoginViewController loginController;
    private Stage stage;
    public void init(Stage stage, LoginViewController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }
}
