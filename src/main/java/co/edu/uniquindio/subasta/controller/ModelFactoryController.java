package co.edu.uniquindio.subasta.controller;

import co.edu.uniquindio.subasta.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.Subasta;
import co.edu.uniquindio.subasta.model.TipoProducto;
import co.edu.uniquindio.subasta.model.Usuario;
import co.edu.uniquindio.subasta.utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        inicializarDatos();
    }

    private void inicializarDatos() {
        subasta = new Subasta();
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");

        //cargarDatosBase();
        //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        //cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
        //guardarResourceBinario();
        //cargarResourceBinario();


        //4. Guardar y Cargar el recurso serializable XML
        //guardarResourceXML();
        //cargarResourceXML();

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



    private void cargarDatosBase() {
        subasta = SubastaUtils.inicializarDatos();
    }

    private void cargarResourceXML() {
        subasta = Persistencia.cargarRecursoSubastaXML();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoSubastaXML(subasta);
    }

    private void cargarResourceBinario() {
        subasta = Persistencia.cargarRecursoSubastaBinario();
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoSubastaBinario(subasta);
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
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
        subasta.eliminarProducto(producto);
    }

    public Usuario crearUsuario(String nombre, String telefono, String identificacion, String correoElectronico, String nombreUsuario, String contrasenia) {

        Usuario usuario = subasta.agregarUsuario(nombre, telefono, identificacion, correoElectronico, nombreUsuario, contrasenia);
        guardarUsuario(usuario);
        registrarAccionesSistema(" Se ha creado un usuarioc", 1, "creación del usuario " + nombreUsuario);
        return usuario;

    }

    public void eliminarUsuario (String id){
        subasta.eliminarUsuario(id);
        registrarAccionesSistema(" Se ha eliminado un usuario ", 1, "eliminacion del usuario con id: " + id);

    }

    public void actualizarUsuario(Usuario usuarioSeleccionado, String telefono, String correoElectronico, String nombreUsuario) {
        subasta.actualizarUsuario( usuarioSeleccionado,  telefono,  correoElectronico,  nombreUsuario);
        registrarAccionesSistema(" Se ha actualizado un usuario ", 1, " El usuario:  (" + nombreUsuario+") se ha actualizado");

    }


}
