package Grafico;

import Logica.Productos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelProducto extends PanelDeposito{
    DibujarProducto comida;
    public PanelProducto(int x, int y, int w, int h, ArrayList<Producto> Productos){
        super(x,y,w,h);
        setLayout(null);
        int x1=0;
        for(Producto producto:Productos){
            comida=new DibujarProducto(w,h);
            comida.setBounds(6+x1*((w/5)), 10, (w / 5 )-12, h - 20);
            this.add(comida);
            x1++;
        }

    }
}
