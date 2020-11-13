package aplicaciónmp3;

/**
 *
 * @author Daniel
 */
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {
    private String Nombre;
    public Imagen(String Name, int ancho, int largo) {
        this.setSize(ancho, largo); 
        this.Nombre = Name;
    }
    
    public void paint(Graphics grafico) {
        Dimension height = getSize();
        ImageIcon Img = new ImageIcon(getClass().getResource(Nombre)); 
        grafico.drawImage(Img.getImage(), -10, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
}
