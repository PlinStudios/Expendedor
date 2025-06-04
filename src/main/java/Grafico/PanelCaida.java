package Grafico;

import javax.swing.*;
import java.awt.*;

public class PanelCaida extends JPanel{
    private int type;
    private DibujarProducto comida;
    public PanelCaida(int x, int y, int w, int h,String producto){
        setLayout(null);
        this.setBackground(new Color(103, 151, 141));
        this.setBounds(x,y,w,h);
        if(producto!=null) {
            if (producto == "cocacola") {
                type = 1;
            } else if (producto == "sprite") {
                type = 2;
            } else if (producto == "fanta") {
                type = 3;
            } else if (producto == "super8") {
                type = 4;
            } else if (producto == "snickers") {
                type = 5;
            }
            comida = new DibujarProducto((w / 6), h - 15, type);
            comida.setBounds((x/2)-(w/12), 10, (w / 6 ), h - 20);
            //comida.setActive(true);
            this.add(comida);
            this.revalidate();
            this.repaint();
        }

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if(comida!=null){comida.setActive(true);}
    }
}
