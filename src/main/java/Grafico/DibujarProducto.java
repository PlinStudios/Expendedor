package Grafico;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class DibujarProducto extends JComponent {
    private int h,w;
    private BufferedImage image;
    public DibujarProducto(int w, int h, int img){
        image=null;
        this.w=w;
        this.h=h;
        try {
            if(img==1){image = ImageIO.read(new File("src/main/resources/Coca.png"));}
            else if(img==2){image = ImageIO.read(new File("src/main/resources/Sprite.png"));}
            else if(img==3){image = ImageIO.read(new File("src/main/resources/Fanta.png"));}
            else if(img==5){image = ImageIO.read(new File("src/main/resources/Super8.png"));}
            else if(img==4){image = ImageIO.read(new File("src/main/resources/Snickers.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(50,50,50));
        g.fillRect(0, 0, w, h);
        if (image != null) {
            g2d.drawImage(image, 0, 0, w, h, this);
        }
    }
}

