module co.edu.uniquindio.subasta {
    requires javafx.controls;
    requires javafx.fxml;



    opens co.edu.uniquindio.subasta to javafx.fxml;
    exports co.edu.uniquindio.subasta;
    exports co.edu.uniquindio.subasta.viewController;
    opens co.edu.uniquindio.subasta.viewController to javafx.fxml;
    exports co.edu.uniquindio.subasta.model;
    exports co.edu.uniquindio.subasta.controller;
    opens co.edu.uniquindio.subasta.controller to javafx.fxml;
}