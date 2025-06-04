package Grafico;

import javax.swing.*;
import java.awt.*;

public class PanelCaida extends JPanel{
    private DibujarProducto comida;
    public PanelCaida(int x, int y, int w, int h){
        setLayout(null);
        this.setBackground(new Color(103, 151, 141));
        this.setBounds(x,y,w,h);

        comida = new DibujarProducto((w / 6), h - 15, 0);
        comida.setBounds((x/2)-(w/12), 10, (w / 6 ), h - 20);
        comida.setActive(false);
        this.add(comida);
    }

    public void setType(String producto){
        int type = 0;
        if (producto==null) {
            comida.setActive(false);
            return;
        } else if (producto == "cocacola") {
            type = 1;
        } else if (producto == "sprite") {
            type = 2;
        } else if (producto == "fanta") {
            type = 3;
        } else if (producto == "snickers") {
            type = 4;
        } else if (producto == "super8") {
            type = 5;
        }

        comida.setImage(type);
        comida.setActive(true);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
