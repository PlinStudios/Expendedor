package Grafico;

import Logica.Deposito;
import Logica.Productos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Panel con productos disponibles a la compra
 */
public class PanelProducto extends PanelDeposito implements MouseListener, MouseMotionListener {
    private ArrayList<DibujarProducto> dibujos;
    int img;
    private ArrayList<Producto> Productos;
    private Deposito<Producto> deposito;

    /**
     *
     * @param x posición x del panel
     * @param y posición y del panel
     * @param w ancho del panel
     * @param h alto del panel
     * @param deposito con productos a mostrar
     * @param img numero que decide que imagen desplegar
     */
    public PanelProducto(int x, int y, int w, int h, Deposito deposito, int img){
        super(x,y,w,h);
        addMouseListener(this);
        addMouseMotionListener(this);
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

    /**
     * si se hace click el deposito se llena
     * @param e evento a ser procesado
     */
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
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Dependiendo de la posición del mouse, se desplega el número de serie del producto sobre el que está
     * @param e evento a ser procesado
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        Producto prod=null;
        int index=-1;
        if(6<=e.getX() & e.getX()<=54 & 10<=e.getY() & e.getY()<=65){
            index=0;
            this.revalidate();
        }
        else if(66<=e.getX() & e.getX()<=114 & 10<=e.getY() & e.getY()<=65){
            index=1;
            this.revalidate();
        }
        else if(126<=e.getX() & e.getX()<=174 & 10<=e.getY() & e.getY()<=65){
            index=2;
            this.revalidate();
        }
        else if(186<=e.getX() & e.getX()<=234 & 10<=e.getY() & e.getY()<=65){
            index=3;
            this.revalidate();
        }
        else if(246<=e.getX() & e.getX()<=294 & 10<=e.getY() & e.getY()<=65){
            index=4;
            this.revalidate();
        }

        if(index>=0 & Productos.size()>index) {prod = Productos.get(index);}

        if(prod!=null) {this.setToolTipText(prod.getSerie() + "");}
        else{this.setToolTipText(null);}
        ToolTipManager.sharedInstance().setInitialDelay(0);
        this.revalidate();
        this.repaint();

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
