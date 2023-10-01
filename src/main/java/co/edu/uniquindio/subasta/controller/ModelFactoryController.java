package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.Subasta;
import co.edu.uniquindio.subasta.model.TipoProducto;

public class ModelFactoryController {
    Subasta subasta = null;




    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        inicializarDatos();
    }


    private void inicializarDatos() {
        subasta = new Subasta();

    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Producto crearProducto(String nombre, TipoProducto selectedItem, Object o) {
        Producto producto = subasta.crearProducto(nombre, selectedItem, null);
        return producto;
    }

    public void eliminarProducto(Producto producto) {
    }

}
