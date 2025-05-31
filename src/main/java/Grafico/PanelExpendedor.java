package Grafico;

import Logica.Expendedor;
import Logica.Productos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    private ArrayList<PanelProducto> depositos;
    private PanelVuelto vuelto;
    private PanelCaida producto;
    private Expendedor exp;

    public PanelExpendedor(){
        this.setBackground(new Color(200,200,200));
        this.setSize(100,100);

        exp=new Expendedor(5);
        depositos = new ArrayList<>();
        ArrayList<Producto> coca=exp.getCoca().getDeposito();
        ArrayList<Producto> sprite=exp.getSprite().getDeposito();
        ArrayList<Producto> fanta=exp.getFanta().getDeposito();
        ArrayList<Producto> snickers=exp.getSnickers().getDeposito();
        ArrayList<Producto> super8=exp.getSuper8().getDeposito();

        int d=10;
        int h=75;
        depositos.add(new PanelProducto(10,d,300,h,coca));
        depositos.add(new PanelProducto(10,2*d+h,300,h,sprite));
        depositos.add(new PanelProducto(10,2*(d+h)+d,300,h,fanta));
        depositos.add(new PanelProducto(10,3*(d+h)+d,300,h,snickers));
        depositos.add(new PanelProducto(10,4*(d+h)+d,300,h,super8));

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
