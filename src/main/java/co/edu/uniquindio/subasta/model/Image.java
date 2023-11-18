package co.edu.uniquindio.subasta.model;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private byte[] imageBytes;
    
    public Image() {}

    public Image(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public Image(ByteArrayInputStream bais) {
    }

    public static Image createImage(Image image) {
        Image imagen = new Image();
        
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", baos);
            //imagen.setImageBytes(baos.toByteArray());
        
        return imagen;
    }

    public Image getImage() {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        return new Image(bais);
    }

    /*
    public void seleccionarImagen(){
        // Crear un FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de imagen", "*.png"));

        // Mostrar el diálogo para seleccionar un archivo
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        // Verificar si se seleccionó un archivo
        if (selectedFile != null) {
            // Imprimir la ruta del archivo seleccionado (puedes utilizar esta ruta como desees)
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

     */
}
