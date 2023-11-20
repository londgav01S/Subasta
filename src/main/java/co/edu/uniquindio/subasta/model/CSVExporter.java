package co.edu.uniquindio.subasta.model;

import co.edu.uniquindio.subasta.controller.ModelFactoryController;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    static ModelFactoryController mfm= new ModelFactoryController();
    public static void exportarAnunciosCSV(List<Anuncio> listaAnuncios, Stage stage) {
        // Configurar el FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));

        // Mostrar el diálogo para que el usuario elija la ubicación y el nombre del archivo
        File archivoSeleccionado = fileChooser.showSaveDialog(stage);

        if (archivoSeleccionado != null) {
            // Escribir la información de los anuncios en el archivo CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSeleccionado))) {
                // Escribir el encabezado del CSV
                writer.write("Nombre,Codigo,Anunciante,Producto,Descripcion,FechaPublicacion,FechaTerminacion,ValorInicial");
                writer.newLine();

                // Escribir cada anuncio en una línea del CSV
                for (Anuncio anuncio : listaAnuncios) {
                    String linea = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                            anuncio.getNombre(), anuncio.getCodigo(), anuncio.getAnunciante(), anuncio.getProducto(),
                            anuncio.getDescripcion(), anuncio.getFechaPublicacion(), anuncio.getFechaTerminacion(),
                            anuncio.getValorInicial());
                    writer.write(linea);
                    writer.newLine();
                }

                mfm.mostrarMensajeAlerta("Archivo CSV", "Anuncios","Archivo CSV de anuncios creado exitosamente.", Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                mfm.mostrarMensajeAlerta("Archivo CSV", "ERROR", "Archivo CSV de anuncios no ha sido creado ", Alert.AlertType.ERROR);
            }
        }
    }

    public static void exportarPujasResueltasCSV(List<Puja> listaPujas, Stage stage) {
        // Configurar el FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos CSV", "*.csv"));

        // Mostrar el diálogo para que el usuario elija la ubicación y el nombre del archivo
        File archivoSeleccionado = fileChooser.showSaveDialog(stage);

        if (archivoSeleccionado != null) {
            // Filtrar solo las pujas con estado RESUELTA
            List<Puja> pujasResueltas = mfm.getListaPujasResueltas(listaPujas);

            // Escribir la información de las pujas RESUELTAS en el archivo CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSeleccionado))) {
                // Escribir el encabezado del CSV
                writer.write("Estado,Comprador,Anuncio,ValorInicial,Fecha");
                writer.newLine();

                // Escribir cada puja RESUELTA en una línea del CSV
                for (Puja puja : pujasResueltas) {
                    String linea = String.format("%s,%s,%s,%s,%s",
                            puja.getEstado(), puja.getComprador().getNombre(), puja.getAnuncio().getCodigo(),
                            puja.getValorInicial(), puja.getFecha());
                    writer.write(linea);
                    writer.newLine();
                }

                mfm.mostrarMensajeAlerta("Archivo CSV", "Pujas RESUELTAS","Archivo CSV de Pujas RESUELTAS creado exitosamente.", Alert.AlertType.INFORMATION);
            } catch (IOException e) {
                e.printStackTrace();
                mfm.mostrarMensajeAlerta("Archivo CSV", "ERROR", "Archivo CSV de Pujas RESUELTAS no ha sido creado ", Alert.AlertType.ERROR);
            }
        }
    }
}
