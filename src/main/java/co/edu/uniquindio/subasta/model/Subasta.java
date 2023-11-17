package co.edu.uniquindio.subasta.model;

import co.edu.uniquindio.subasta.exceptions.AnuncianteException;
import co.edu.uniquindio.subasta.exceptions.CompradorException;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Subasta implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Producto> listaProductos= new ArrayList<>();

    private ArrayList<Usuario> listaUsuarios= new ArrayList<>();

    private ArrayList<Anunciante> listaAnunciantes= new ArrayList<>();

    private ArrayList<Anuncio> listaAnuncios= new ArrayList<>();

    private ArrayList<Puja> listaPujas= new ArrayList<>();

    private ArrayList<Comprador> listaCompradores= new ArrayList<>();

    public Subasta() {}

    //------------------------------------------------------GET AND SET ------------------------------------------------

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Anunciante> getListaAnunciantes() {
        return listaAnunciantes;
    }

    public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
        this.listaAnunciantes = listaAnunciantes;
    }

    public ArrayList<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    public ArrayList<Puja> getListaPujas() {
        return listaPujas;
    }

    public void setListaPujas(ArrayList<Puja> listaPujas) {
        this.listaPujas = listaPujas;
    }

    public ArrayList<Comprador> getListaCompradores() {
        return listaCompradores;
    }

    public void setListaCompradores(ArrayList<Comprador> listaCompradores) {
        this.listaCompradores = listaCompradores;
    }


    //----------------------------------------------------CRUD Producto-------------------------------------------------

    // Método que verifica si un producto existe en la lista
    public boolean productoExiste(String nombre) {
        Predicate<Producto> porNombre = producto -> producto.getNombre().equalsIgnoreCase(nombre);
        return listaProductos.stream().anyMatch(porNombre);
    }

    //Crear un nuevo producto
    public Producto crearProducto(String nombre, TipoProducto tipo, String nombreAnunciante) {
        if (!productoExiste(nombre)) {
            Producto producto = new Producto(nombre, tipo, nombreAnunciante);
            listaProductos.add(producto);
            System.out.println( producto.toString());
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

    }

    //Eliminar un producto existente
    public void eliminarProducto(Producto producto) {
        listaProductos.removeIf(p -> p.equals(producto));
    }


    //--------------------------------------------------------------------------------------------------------------------


    //---------------------------------------------------ANUNCIANTE------------------------------------------------------------

    public Anunciante crearAnunciante(String nombre, String telefono, String identificacion, String correoElectronico,
                                      LocalDate fechaNacimiento, List<Anuncio> listaAnuncios) throws AnuncianteException {
        if(!existeIdentificacionAnunciante(identificacion)) {
            Anunciante anunciante= new Anunciante(nombre, telefono, identificacion, correoElectronico, fechaNacimiento, listaAnuncios);
            listaAnunciantes.add(anunciante);
            return anunciante;
        }else{
            throw new AnuncianteException("El anunciante con identificación "+identificacion+" ya existe");
        }
    }

    // Verificación de identificación única
    private boolean existeIdentificacionAnunciante(String identificacion) {
        return listaAnunciantes.stream().anyMatch(a -> a.getIdentificacion().equals(identificacion));
    }


    public void eliminarAnunciante(String identificacion) {
        listaAnunciantes.removeIf(anunciante -> anunciante.getIdentificacion().equals(identificacion));
        eliminarUsuario(identificacion);
    }

    public void actualizarAnunciante(Anunciante anunciante, String telefono, String correoElectronico, String nombreusuario) {
        if (nombreusuario != null) {
            //anunciante.setNombreUsuario(nombreusuario);
        }
        if (telefono != null) {
            anunciante.setTelefono(telefono);
        }
        if (correoElectronico != null) {
            anunciante.setCorreoElectronico(correoElectronico);
        }
    }
    //---------------------------------------------------ANUNCIANTE------------------------------------------------------------



    //---------------------------------------------------USUARIO------------------------------------------------------------
    public Usuario agregarUsuario(String nombreusuario, String contrasenia, Persona persona) {
        Usuario usuario = new Usuario(nombreusuario, contrasenia, persona);
        listaUsuarios.add(usuario);
        return usuario;
    }

    //TODO: terminar de mirar esto luego de mirar la logica
    public Usuario leerUsuarioPorNombre(String nombre) {
        Predicate<Usuario> porNombre = usuario -> usuario.getNombreUsuario().equalsIgnoreCase(nombre);
        return listaUsuarios.stream().filter(porNombre).findFirst().orElse(null);
    }

    public void actualizarUsuario(Usuario usuario,String nombreusuario) {
        if (nombreusuario != null) {
            usuario.setNombreUsuario(nombreusuario);
        }

    }

    // Método para eliminar un usuario por su identificación
    public void eliminarUsuario(String nombre) {
        listaUsuarios.removeIf(usuario -> Objects.equals(usuario.getNombreUsuario(), nombre));
    }

    //---------------------------------------------------USUARIO------------------------------------------------------------


    //-------------------------------------------------------COMPRADOR---------------------------------------------------
    public Comprador crearComprador(String nombreCompleto, String telefono, String identificacion, String correoElectronico,
                                    LocalDate fechaNacimiento, List<Puja> listaPujas) throws CompradorException {

        if(!existeIdentificacionComprador(identificacion)) {
            Comprador comprador= new Comprador(nombreCompleto, telefono, identificacion, correoElectronico, fechaNacimiento, listaPujas);
            listaCompradores.add(comprador);
            return comprador;
        }else{
            throw new CompradorException("El anunciante con identificación "+identificacion+" ya existe");
        }

    }

    //TODO: terminar de hacer crud para comprador

    private boolean existeIdentificacionComprador(String identificacion) {
        return listaCompradores.stream().anyMatch(a -> a.getIdentificacion().equals(identificacion));
    }


    //-------------------------------------------------------COMPRADOR---------------------------------------------------




    //----------------------------------------------------CRUD Anuncio-------------------------------------------------



    public Anuncio crearAnuncio(String nombre, String codigo, Anunciante anunciante, Producto producto,
                                String descripcion, Image imagen, LocalDate fechaPublicacion,
                                LocalDate fechaTerminacion, Double valorInicial) {
    Anuncio anuncio = new Anuncio(nombre, codigo, anunciante, producto,
            descripcion, imagen,  fechaPublicacion,
            fechaTerminacion,  valorInicial);
    listaAnuncios.add(anuncio);
    return anuncio;
    }


    //----------------------------------------------------CRUD Anuncio-------------------------------------------------
}
