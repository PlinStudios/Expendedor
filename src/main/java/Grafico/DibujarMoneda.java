package Grafico;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class DibujarMoneda extends DibujarProducto {
    /**
     * @param w ancho de la moneda
     * @param h alto de la moneda
     * @param type tipo (valor) de moneda
     */
    public DibujarMoneda(int w, int h, int type) {
        super(w,h,type);
        image=null;
        this.w=w;
        this.h=h;
        setImage(type);
    }

    /**
     *
     * @param type dependiendo del numero establece la imagen a desplegar
     */
    public void setImage(int type){
        try {
            if(type==0){image = ImageIO.read(new File("src/main/resources/Moneda100.png"));}
            else if(type==1){image = ImageIO.read(new File("src/main/resources/Moneda500.png"));}
            else if(type==2){image = ImageIO.read(new File("src/main/resources/Moneda1000.png"));}
            else if(type==3){image = ImageIO.read(new File("src/main/resources/Moneda1500.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

