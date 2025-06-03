package Grafico;

import Logica.Productos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelProducto extends PanelDeposito{
    ArrayList<DibujarProducto> dibujos;
    ArrayList<Producto> Productos;
    int img;
    public PanelProducto(int x, int y, int w, int h, ArrayList<Producto> Productos,int img){
        super(x,y,w,h);
        setLayout(null);
        this.img=img;
        this.Productos=Productos;
        dibujos=new ArrayList<>();

        int x1=0;
        for(Producto producto:Productos){
            DibujarProducto comida=new DibujarProducto((w/5)-12,h-20,img);
            comida.setBounds(6+x1*((w/5)), 10, (w / 5 )-12, h - 20);
            dibujos.add(comida);
            this.add(comida);
            x1++;
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i<5; i++){
            dibujos.get(i).setActive(i<Productos.size());
        }
    }
}
