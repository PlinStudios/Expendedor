package Grafico;

import Logica.Deposito;
import Logica.Productos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class PanelProducto extends PanelDeposito implements MouseListener{
    private ArrayList<DibujarProducto> dibujos;
    int img;
    private ArrayList<Producto> Productos;
    private Deposito<Producto> deposito;
    public PanelProducto(int x, int y, int w, int h, Deposito deposito, int img){
        super(x,y,w,h);
        addMouseListener(this);
        setLayout(null);
        this.img=img;
        dibujos=new ArrayList<>();

        int x1=0;
        Productos=deposito.getDeposito();
        this.deposito=deposito;
        for(Producto producto:Productos){
            DibujarProducto comida=new DibujarProducto((w/5)-12,h-20,img);
            comida.setBounds(6+x1*((w/5)), 10, (w / 5 )-12, h - 20);
            dibujos.add(comida);
            this.add(comida);
            x1++;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        deposito.rellenarDeposito(5);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0; i<5; i++){
            dibujos.get(i).setActive(i<Productos.size());
        }
    }

}
