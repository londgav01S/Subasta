package co.edu.uniquindio.subasta.utils;

import co.edu.uniquindio.subasta.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.model.Producto;
import co.edu.uniquindio.subasta.model.Subasta;
import co.edu.uniquindio.subasta.model.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Persistencia {

    //bancoUq/src/main/resources/persistencia/archivoClientes.txt
    public static final String RUTA_ARCHIVO_ANUNCIANTE = "Subasta/src/main/resources/persistencia/rchivoClientes.txt";
    public static final String RUTA_ARCHIVO_COMPRADOR= "Subasta/src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_PRODUCTO = "Subasta/src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_PUJA = "Subasta/src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_ANUNCIO = "Subasta/src/main/resources/persistencia/archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "Subasta/src/main/resources/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "Subasta/src/main/resources/persistencia/log/BancoLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "Subasta/src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO = "Subasta/src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTA_XML = "bSubasta/src/main/resources/persistencia/model.xml";
//	C:\td\persistencia


    public static void cargarDatosArchivos(Subasta subasta) throws FileNotFoundException, IOException {

        //cargar archivos Usuarios
        ArrayList<Usuario> usuariosCargados = cargarUsuarios(RUTA_ARCHIVO_USUARIOS);
        if(usuariosCargados.size() > 0)
            subasta.getListaUsuarios().addAll(usuariosCargados);

        //cargar usuarios

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
    /*
    public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Cliente cliente:listaClientes)
        {
            contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
                    +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
    }


    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
        String contenido = "";
        for(Empleado empleado:listaEmpleados)
        {
            contenido+= empleado.getNombre()+
                    ","+empleado.getApellido()+
                    ","+empleado.getCedula()+
                    ","+empleado.getFechaNacimiento()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }*/



//	----------------------LOADS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException
    {
        ArrayList<Producto> productos =new ArrayList<Producto>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTO);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Producto producto = new Producto();
            producto.setNombre(linea.split(",")[0]);
            //producto.setAnuncio(linea.split(",")[1]);
            productos.add(producto);
        }
        return productos;
    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioException {

        if(validarUsuario(usuario,contrasenia)) {
            return true;
        }else {
            throw new UsuarioException("Usuario no existe");
        }

    }

    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException
    {
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
        {
            Usuario usuarioAux = usuarios.get(indiceUsuario);
            if(usuarioAux.getNombreUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios =new ArrayList<Usuario>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
        String linea="";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(linea.split(",")[0]);
            usuario.setContrasenia(linea.split(",")[1]);
            usuario.setNombre(linea.split(",")[2]);
            usuario.setTelefono(linea.split(",")[3]);
            usuario.setIdentificacion(linea.split(",")[4]);
            usuario.setCorreoElectronico(linea.split(",")[5]);

            usuarios.add(usuario);
        }
        return usuarios;
    }


//	----------------------SAVES------------------------

    public static void guardarProducto(ArrayList<Producto> listaProductos, String ruta) throws IOException  {
        String contenido = "";

        for(Producto productoAux:listaProductos) {
            contenido+= productoAux.getNombre()+","+productoAux.getAnuncio()+"\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }

    /**
     * guardar Usuarios
     * @param listaUsuarios
     * @param ruta
     * @throws IOException
     */
    public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios, String ruta) throws IOException  {
        String contenido = "";

        for(Usuario usuarioAux:listaUsuarios) {
            contenido+= usuarioAux.getNombreUsuario()+","+usuarioAux.getContrasenia()+","+usuarioAux.getNombre()+usuarioAux.getTelefono()
                    +","+usuarioAux.getIdentificacion()+","+usuarioAux.getCorreoElectronico()+"\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }

    //------------------------------------SERIALIZACIÓN  y XML---------------------------------------------//


    public static Subasta cargarRecursoSubastaBinario() {

        Subasta subasta = null;

        try {
            subasta = (Subasta) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subasta;
    }

    public static void guardarRecursoSubastaBinario(Subasta subasta) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO, subasta);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Subasta cargarRecursoBancoXML() {

        Subasta subasta = null;

        try {
            subasta = (Subasta) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subasta;

    }



    public static void guardarRecursoBancoXML(Subasta subasta) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML, subasta);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
