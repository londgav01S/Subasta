package co.edu.uniquindio.subasta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Subasta {


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }



    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Subasta() {
    }

    private ArrayList<Producto> listaProductos= new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios= new ArrayList<>();

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



    ////////////////////////////////////////////////////////////////////////////////////////


    public Usuario leerUsuarioPorIdentificacion(String identificacion) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equals(identificacion)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }

    public Usuario agregarUsuario (String nombre, String telefono, String identificacion, String correoElectronico, String nombreusuario, String contrasenia){
        Usuario usuario = new Usuario(nombre, telefono, identificacion, correoElectronico, nombreusuario, contrasenia);
        listaUsuarios.add(usuario);
        return usuario;
    }

    public void actualizarUsuario(Usuario usuario, String telefono, String correoElectronico, String nombreusuario) {
        if (nombreusuario != null) {
            usuario.setNombreUsuario(nombreusuario);
        }
        if (telefono != null) {
            usuario.setTelefono(telefono);
        }
        if (correoElectronico != null) {
            usuario.setCorreoElectronico(correoElectronico);
        }

    }

    // Método para eliminar un usuario por su identificación
    public void eliminarUsuario(String identificacion) {
        listaUsuarios.removeIf(usuario -> usuario.getIdentificacion().equals(identificacion));
    }
}
