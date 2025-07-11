package Grafico;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class DibujarProducto extends JComponent {
    protected int h,w;
    protected BufferedImage image;
    private boolean active=true;

    /**
     *
     * @param w ancho del producto
     * @param h alto del producto
     * @param type numero que define imagen a mostrar
     */
    public DibujarProducto(int w, int h, int type){
        image=null;
        this.w=w;
        this.h=h;
        setImage(type);
    }

    /**
     *
     * @param type numero que define imagen a desplegar
     */
    public void setImage(int type){
        try {
            if(type==1){image = ImageIO.read(new File("src/main/resources/Coca.png"));}
            else if(type==2){image = ImageIO.read(new File("src/main/resources/Sprite.png"));}
            else if(type==3){image = ImageIO.read(new File("src/main/resources/Fanta.png"));}
            else if(type==4){image = ImageIO.read(new File("src/main/resources/Super8.png"));}
            else if(type==5){image = ImageIO.read(new File("src/main/resources/Snickers.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null && active) {
            g2d.drawImage(image, 0, 0, w, h, this);
        }
    }

    /**
     *
     * @param active si es activo el elemento se hace visible
     */
    public void setActive(boolean active){
        this.active=active;
    }
}

