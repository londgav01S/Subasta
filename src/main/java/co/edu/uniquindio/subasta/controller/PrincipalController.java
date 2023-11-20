package co.edu.uniquindio.subasta.controller;

public class PrincipalController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public boolean verificarTipoUsuario() {
        if(mfm.verificarTipoUsuario()){
            return true;
        }
        return false;
    }
}
