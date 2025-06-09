package Grafico;

import Logica.Expendedor;
import Logica.Monedas.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Panel del que se saca el vuelto
 */
public class PanelVuelto extends PanelDeposito implements MouseListener, MouseMotionListener {
    private DibujarMoneda dibujo;
    private Expendedor exp;
    private Moneda moneda=null;
    private PanelMonedero monedero;

    /**
     * @param x posición x del panel
     * @param y posición y del panel
     * @param w ancho del panel
     * @param h alto del panel
     * @param exp expendedor del que se recible el vuelto
     */
    public PanelVuelto(int x,int y,int w,int h, Expendedor exp){
        super(x,y,w,h);
        setLayout(null);
        this.setBounds(x,y,w,h);

        dibujo = new DibujarMoneda(h,h, 0);
        dibujo.setBounds(0,0,h, h);
        dibujo.setActive(false);
        this.add(dibujo);

        this.exp=exp;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     *
     * @param precio valor de la moneda que define imagen a desplegar
     */
    public void setType(int precio){
        int type = 0;
        if (precio == 100) {
            type = 0;
        } else if (precio == 500) {
            type = 1;
        } else if (precio == 1000) {
            type = 2;
        } else if (precio == 1500) {
            type = 3;
        }else{
            dibujo.setActive(false);
            return;
        }

        dibujo.setImage(type);
        dibujo.setActive(true);
    }

    /**
     * Obtencion del vuelto
     */
    public void getVuelto(){
        if (monedero!=null) {
            monedero.addMoneda(moneda);
        }
        moneda = exp.getVuelto();
        if (moneda!=null) {
            setType(moneda.getValor());
        }else {
            dibujo.setActive(false);
        }
    }

    /**
     *
     * @param monedero al que le entregaremos el vuelto
     */
    public void setPanelMonedero(PanelMonedero monedero){
        this.monedero=monedero;
    }

    /**
     * si hacemos click nuesto vuelto se guarda, moneda a moneda
     * @param e evento a ser procesado
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        getVuelto();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * si el mouse pasa por encima de la moneda se despliega numero de serie
     * @param e evento s der procesado
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        if(moneda!=null){
            this.setToolTipText(moneda.getSerie()+"");}
        else{this.setToolTipText(null);}
        ToolTipManager.sharedInstance().setInitialDelay(0);
        this.revalidate();
        this.repaint();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
