package co.edu.uniquindio.subasta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Subasta {
    //hola
    private List<Producto> listaProductos= new ArrayList<>();

    //----------------------------------------------------CRUD Producto-------------------------------------------------

    // Método que verifica si un producto existe en la lista
    public boolean productoExiste(String nombre) {
        Predicate<Producto> porNombre = producto -> producto.getNombre().equalsIgnoreCase(nombre);
        return listaProductos.stream().anyMatch(porNombre);
    }

    //Crear un nuevo producto
    public Producto crearProducto(String nombre, TipoProducto tipo, Anuncio anuncio) {
        if (!productoExiste(nombre)) {
            Producto producto = new Producto(nombre, tipo, anuncio);
            listaProductos.add(producto);
            return producto;
        } else {
            return null; // Producto con el mismo nombre ya existe
        }
    }

    //Leer un producto existente
    public Producto buscarProductoPorNombre(String nombre) {
        Predicate<Producto> porNombre = producto -> producto.getNombre().equalsIgnoreCase(nombre);
        return listaProductos.stream().filter(porNombre).findFirst().orElse(null);
    }

    // Actualizar un producto existente
    public void actualizarProducto(Producto producto, String nombre, TipoProducto tipo, Anuncio anuncio) {
        if (nombre != null) {
            producto.setNombre(nombre);
        }
        if (tipo != null) {
            producto.setTipo(tipo);
        }
        if (anuncio != null) {
            producto.setAnuncio(anuncio);
        }
    }

    //Eliminar un producto existente
    public void eliminarProducto(Producto producto) {
        listaProductos.removeIf(p -> p.equals(producto));
    }

}
