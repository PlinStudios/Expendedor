package Grafico;

import Logica.Productos.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelCaida extends JPanel implements MouseListener {
    private DibujarProducto comida;
    private Producto prod;
    public PanelCaida(int x, int y, int w, int h){
        setLayout(null);
        this.setBackground(new Color(103, 151, 141));
        this.setBounds(x,y,w,h);

        comida = new DibujarProducto(h-15,h-15, 0);
        comida.setBounds((w-(h-15))/2,15/2,h, h);
        comida.setActive(false);
        this.add(comida);

        addMouseListener(this);
    }

    public void setType(Producto pro){
        int type = 0;
        prod=pro;
        String producto =null;
        if(pro!=null){producto=pro.consumir();}
        if (producto==null) {
            comida.setActive(false);
            return;
        } else if (producto == "cocacola") {
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

        comida.setImage(type);
        comida.setActive(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setType(null);
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
        if(prod!=null) {this.setToolTipText(prod.getSerie() + "");}
        else{this.setToolTipText(null);}
        ToolTipManager.sharedInstance().setInitialDelay(0);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
