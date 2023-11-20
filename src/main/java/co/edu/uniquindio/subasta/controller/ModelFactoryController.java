package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.exceptions.AnuncianteException;
import co.edu.uniquindio.subasta.exceptions.CompradorException;
import co.edu.uniquindio.subasta.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.model.*;
import co.edu.uniquindio.subasta.utils.*;
import co.edu.uniquindio.subasta.viewController.LoginViewController;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelFactoryController {
    Subasta subasta;

    public void mostrarMensajeAlerta(String titulo, String header, String contenido, Alert.AlertType tipoAlerta) {
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static boolean mostrarAlertaConfirmacion(String mensaje, String titulo) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        // Configura los botones (Aceptar y Cancelar)
        ButtonType botonAceptar = new ButtonType("Aceptar");
        ButtonType botonCancelar = new ButtonType("Cancelar");
        alerta.getButtonTypes().setAll(botonAceptar, botonCancelar);

        // Muestra la alerta y espera a que el usuario elija una opción
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true); // Asegura que la alerta esté encima de otras ventanas

        alerta.showAndWait();

        // Devuelve true si se presionó "Aceptar", false si se presionó "Cancelar"
        return alerta.getResult() == botonAceptar;
    }




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
        inicializarDatos();
    }

    //----------------------------------------  Singleton ---------------------------------------------------------------


    //-----------------------------------------Subasta--------------------------------------------------------------
    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
    //-----------------------------------------Subasta--------------------------------------------------------------


    //-----------------------------------------Persistencia--------------------------------------------------------------
    private void inicializarDatos() {
        subasta = new Subasta();
        //1. inicializar datos y luego guardarlo en archivos
        //System.out.println("invocación clase singleton");

        //guardarResourceXML();
        cargarResourceXML();


        //Siempre se debe verificar si la raiz del recurso es null


        if(subasta == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");
    }

    private void cargarDatosDesdeArchivos() {
        subasta = new Subasta();
        try {
            Persistencia.cargarDatosArchivos(subasta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {
        //Persistencia.guardarClientes(getSubasta().getListaUsuarios());
        guardarUsuarios(getSubasta().getListaUsuarios());
    }

    private void cargarDatosBase() {
        subasta = SubastaUtils.inicializarDatos();
    }

    private void cargarResourceXML() {
        subasta = Persistencia.cargarRecursoSubastaXML();
        System.out.println("pasando por cargar xml");
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoSubastaXML(subasta);
        System.out.println("pasando por guardar xml");
    }

    private void cargarResourceBinario() {
        subasta = Persistencia.cargarRecursoSubastaBinario();
        System.out.println("cargando por cargar bin");
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoSubastaBinario(subasta);
        System.out.println("pasando por guardar bin");
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    //-----------------------------------------Persistencia-------------------------------------------------------------


    //-----------------------------------------Usuario--------------------------------------------------------------
    /**
     * llama a la funcion guardarUsuarios de la clase Persistencia para guardar la lista de Usuarios
     * @param listaUsuarios
     */
    public void guardarUsuarios(ArrayList<Usuario> listaUsuarios){
        try{
            Persistencia.guardarUsuarios(listaUsuarios);
            registrarAccionesSistema(" Se han guardado los usuarios ",1, " Guardar Lista de Usuarios ");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void guardarUsuario(Usuario usuario){
        try{
            Persistencia.guardarUsuario(usuario);
            registrarAccionesSistema(" Se han guardado el usuario ",1, " Guardar usuario ");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public Usuario crearUsuario(String nombreUsuario, String contrasenia, Persona persona) {
        Usuario usuario = subasta.agregarUsuario(nombreUsuario, contrasenia, persona);
        guardarUsuario(usuario);
        registrarAccionesSistema(" Se ha creado un usuarioc", 1, "creación del usuario " + nombreUsuario);
        guardarResourceXML();
        return usuario;

    }

    public void eliminarUsuario (String nombre){
        subasta.eliminarUsuario(nombre);
        registrarAccionesSistema(" Se ha eliminado un usuario ", 1,"usuario eliminado" );
        guardarResourceXML();
    }

    public void actualizarUsuario(Usuario usuarioSeleccionado, String telefono, String correoElectronico, Persona persona) {
        //TODO: HACERLO
        subasta.actualizarUsuario(usuarioSeleccionado, telefono, correoElectronico, persona);
        registrarAccionesSistema(" Se ha actualizado un usuario ", 1, " El usuario:  (" + persona.getNombre()+") se ha actualizado");
        guardarResourceXML();
    }


    //-----------------------------------------Usuario--------------------------------------------------------------


    //-----------------------------------------Anunciante--------------------------------------------------------------

    // TODO: terminar los CRUD

    public Anunciante crearAnunciante(String nombre, String telefono, String identificacion, String correoElectronico,
                                      String fechaNacimiento, List<Anuncio> listaAnuncios)  {
        try {
            Anunciante anunciante= subasta.crearAnunciante(nombre, telefono, identificacion, correoElectronico, fechaNacimiento,listaAnuncios );
            //TODO: revisar lo de registrar acciones
            registrarAccionesSistema(" Se ha creado un anunciante ", 1, " El usuario:  (" +") se ha actualizado");
            guardarResourceXML();
            guardarAnunciante(anunciante);
            return anunciante;
            // TODO: 2021-09-30 revisar si va a quedar aqui lo de usuario
            //Usuario usuario= subasta.agregarUsuario(nombreusuario, contrasenia);
            //guardarUsuario(usuario);
        } catch (AnuncianteException e) {
            throw new RuntimeException(e);
        }
    }
    private void guardarAnunciante(Anunciante anunciante) {
        try{
            Persistencia.guardarAnunciante(anunciante);
            registrarAccionesSistema(" Se han guardado el anunciante ",1, " Guardar anunciante ");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------Anunciante--------------------------------------------------------------


    //-----------------------------------------Comprador--------------------------------------------------------------


    public Comprador crearComprador(String nombreCompleto, String telefono, String identificacion, String correoElectronico,
                                    String fechaNacimiento, List<Puja> listaPujas) {
        try {
            Comprador comprador=subasta.crearComprador(nombreCompleto, telefono, identificacion, correoElectronico, fechaNacimiento ,listaPujas);
            guardarResourceXML();
            // TODO: 2021-09-30 revisar si va a quedar aqui lo de usuario
            //Usuario usuario= subasta.agregarUsuario(nombreusuario, contrasenia);
            //guardarUsuario(usuario);
            return comprador;
        } catch (CompradorException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------Comprador--------------------------------------------------------------



    public Producto crearProducto(String nombre, TipoProducto selectedItem, String nombreAnunciante) {
        Producto producto = subasta.crearProducto(nombre, selectedItem, nombreAnunciante);
        return producto;
    }

    public void eliminarProducto(Producto producto) {
        subasta.eliminarProducto(producto);
    }

    //-------------------------------------------Producto---------------------------------------------------------------


    //-------------------------------------------Anuncio---------------------------------------------------------------


    public Anuncio crearAnuncio(String nombre, String codigo, Anunciante anunciante, Producto producto,
                                String descripcion, Image imagen, LocalDate fechaPublicacion,
                                LocalDate fechaTerminacion, Double valorInicial) {
        Anuncio anuncio = subasta.crearAnuncio(nombre, codigo, anunciante, producto,
                descripcion, imagen,  fechaPublicacion,
                fechaTerminacion,  valorInicial);
        return  anuncio;
    }

    public List<Producto> cargarProducto() {
        List<Producto> lista = subasta.getListaProductos();
        return lista;
    }


    //----------------------------------------------Inicio Sesion------------------------------------------------------------------

    Persona persona;

    Usuario usuario;

    public boolean inicioSesion(String nombre, String contraseña) throws UsuarioException, IOException {
        return subasta.existeUsuario(nombre,contraseña);
    }

    public Persona retornarPersona(String nombreUsuario) {
        usuario= subasta.retornarUsuario(nombreUsuario);
        persona= usuario.getPersona();
        return persona;
    }

    public Persona retornarPersonaLog(){
        return persona;
    }

    public Usuario retornarUsuarioLog(){
        return usuario;
    }

    //--------------------------------------------------Puja--------------------------------------------------------------

    public void crearPuja(Anuncio selectedItem, int valorPuja) {
        subasta.crearPuja(selectedItem, valorPuja, persona);
        guardarResourceXML();
    }

    public boolean puedePujar(Anuncio anuncio) {
        return subasta.puedePujar(anuncio,(Comprador)persona);
    }

    public ObservableList<Puja> getListaPujasPendientes() {
        return subasta.getListaPujasPendientes((Comprador)persona);
    }

    public List<Puja> getListaPujasResueltas(List<Puja> list) {
        return subasta.filtrarPujasResueltas(list);
    }

}
