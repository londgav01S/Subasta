package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.TipoProducto;
import co.edu.uniquindio.subasta.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ProductoController {

    ModelFactoryController mfm = ModelFactoryController.getInstance();

    public  Producto crearProducto(String nombre, TipoProducto selectedItem, String nombreAnunciante) {
       Producto producto=  mfm.crearProducto(nombre, selectedItem, nombreAnunciante);
      return producto;
    }

    public void eliminarProducto(Producto productoSeleccionado) {
        mfm.eliminarProducto(productoSeleccionado);

    }

    public List<Producto> cargarProducto() {
        List <Producto> lista = new ArrayList<>();
        lista = mfm.cargarProducto();
        return lista;
    }

    public ObservableList<Producto> agregarDatosBase() {
        ObservableList<Producto> listadoProductos = FXCollections.observableArrayList();
        listadoProductos = mfm.agregarDatosBaseProductos();
        return listadoProductos;
    }
}
