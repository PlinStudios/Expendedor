package Grafico;

import Logica.Deposito;
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
    private String caida;

    public PanelExpendedor(Expendedor exp){
        this.setBackground(new Color(200,200,200));
        this.setSize(100,100);
        this.exp=exp;
        depositos = new ArrayList<>();
        Deposito<Producto> coca=exp.getCoca();
        Deposito<Producto> sprite=exp.getSprite();
        Deposito<Producto> fanta=exp.getFanta();
        Deposito<Producto> snickers=exp.getSnickers();
        Deposito<Producto> super8=exp.getSuper8();

        int d=10;
        int h=75;
        depositos.add(new PanelProducto(10,d,300,h,coca,1));
        depositos.add(new PanelProducto(10,2*d+h,300,h,sprite,2));
        depositos.add(new PanelProducto(10,2*(d+h)+d,300,h,fanta,3));
        depositos.add(new PanelProducto(10,3*(d+h)+d,300,h,snickers,4));
        depositos.add(new PanelProducto(10,4*(d+h)+d,300,h,super8,5));

        vuelto = new PanelVuelto(300-h,5*(d+h)+d,h,h);
        producto = new PanelCaida(20,5*(d+h)+d,300-h-3*d,h,caida);
        this.setLayout(null);
        for (int i=0; i<5; i++){
            this.add(depositos.get(i));
        }
        this.add(vuelto);
        this.add(producto);
    }
    public void setCaida(String caida){
        int d=10;
        int h=75;
        this.caida=caida;
        producto = new PanelCaida(20,5*(d+h)+d,300-h-3*d,h,caida);
        producto.revalidate();
        producto.repaint();
    }

    public String getff(){return caida;}
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        //depositos.get(0).paintComponent(g);
    }

}
