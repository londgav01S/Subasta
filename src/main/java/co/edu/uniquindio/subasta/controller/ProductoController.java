package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.TipoProducto;
import co.edu.uniquindio.subasta.model.Usuario;

import java.util.ArrayList;

public class ProductoController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Producto crearProducto(String nombre, TipoProducto selectedItem, String nombreAnunciante) {
       Producto producto=  mfm.crearProducto(nombre, selectedItem, nombreAnunciante);
      return producto;
    }

    public void eliminarProducto(Producto productoSeleccionado) {
        mfm.eliminarProducto(productoSeleccionado);

    }
}
