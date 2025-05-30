package Grafico;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    private ArrayList<PanelProducto> depositos;
    private PanelVuelto vuelto;
    private PanelCaida producto;

    public PanelExpendedor(){
        this.setBackground(new Color(200,200,200));
        this.setSize(100,100);

        depositos = new ArrayList<>();
        int d=10;
        int h=75;
        depositos.add(new PanelProducto(10,d,300,h));
        depositos.add(new PanelProducto(10,2*d+h,300,h));
        depositos.add(new PanelProducto(10,2*(d+h)+d,300,h));
        depositos.add(new PanelProducto(10,3*(d+h)+d,300,h));
        depositos.add(new PanelProducto(10,4*(d+h)+d,300,h));

        vuelto = new PanelVuelto(300-h,5*(d+h)+d,h,h);
        producto = new PanelCaida(20,5*(d+h)+d,300-h-3*d,h);
        this.setLayout(null);
        for (int i=0; i<5; i++){
            this.add(depositos.get(i));
        }
        this.add(vuelto);
        this.add(producto);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        //depositos.get(0).paintComponent(g);
    }
}
