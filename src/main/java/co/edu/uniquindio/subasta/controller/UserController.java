package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Persona;

public class UserController {

    static ModelFactoryController mfm = ModelFactoryController.getInstance();

    public static Persona retornarPersona(){
        return mfm.retornarPersonaLog();
    }
}
