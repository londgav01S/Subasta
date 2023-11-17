package co.edu.uniquindio.subasta.model;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

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
}
