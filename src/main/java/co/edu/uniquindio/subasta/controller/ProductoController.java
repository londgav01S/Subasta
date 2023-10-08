package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.TipoProducto;

public class dProductoController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Producto crearProducto(String nombre, TipoProducto selectedItem, Object o) {
       Producto producto=  mfm.crearProducto(nombre, selectedItem, null);
      return producto;
    }

    public void eliminarProducto(Producto productoSeleccionado) {
        mfm.eliminarProducto(productoSeleccionado);

    }
}
