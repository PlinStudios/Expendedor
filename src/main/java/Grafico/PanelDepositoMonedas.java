package Grafico;

import Logica.Deposito;
import Logica.Monedas.Moneda;
import Logica.Productos.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static java.util.Collections.sort;

/**
 * Deposito que almacena las monedas de compras exitosas
 */
public class PanelDepositoMonedas extends PanelDeposito implements MouseListener,MouseMotionListener {
    private ArrayList<DibujarMoneda> dibujos;
    int w,h;
    int img;
    private ArrayList<Moneda> Monedas;
    private Deposito<Moneda> deposito;

    /**
     *
     * @param x posición x del panel
     * @param y posición y del panel
     * @param w ancho del panel
     * @param h alot del panel
     * @param deposito deposito a representar
     */
    public PanelDepositoMonedas(int x, int y, int w, int h, Deposito deposito){
        super(x,y,w,h);
        this.w=w;
        this.h=h;
        addMouseListener(this);
        addMouseMotionListener(this);
        setLayout(null);
        this.img=img;
        dibujos=new ArrayList<>();

        Monedas=deposito.getDeposito();
        this.deposito=deposito;

    }

    /**
     * si se hace click las monedas se ordenan de menor a mayor
     * @param e evento a ser procesado
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        sort(Monedas);
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

    /**
     * si se pasa por encima de la moneda se muestra numera de serie
     * @param e evento a ser procesado
     */
    @Override
    public void mouseMoved(MouseEvent e){
        Moneda money=null;
        int index=-1;
        for(DibujarMoneda cashin: dibujos){
            if(cashin.getX()<=e.getX() & e.getX()<=(cashin.getX()+cashin.getWidth()) & cashin.getY()<=e.getY() & e.getY()<=(cashin.getY()+cashin.getHeight())){
                index=dibujos.indexOf(cashin);
            }
        }

        if(index>=0 & Monedas.size()>index) {money = Monedas.get(index);}

        if(money!=null) {this.setToolTipText(money.getSerie() + "");}
        else{this.setToolTipText(null);}
        ToolTipManager.sharedInstance().setInitialDelay(0);
        this.revalidate();
        this.repaint();


    }
    @Override
    public void mouseDragged(MouseEvent e){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Monedas.size()>dibujos.size()) {
            for (int i = dibujos.size() - 1; i < Monedas.size(); i++) {
                DibujarMoneda cash = new DibujarMoneda((w / 5), (w / 5), 0);
                dibujos.add(cash);
                this.add(cash);
            }
        }
        for (int i=0; i<dibujos.size(); i++){
            DibujarMoneda dibujo=dibujos.get(i);
            if (Monedas.size()!=0) {
                dibujo.setBounds(6 + i * ((w / Monedas.size())), 0, (w / 5), (w / 5));
            }
            if (i>=Monedas.size()){
                dibujo.setActive(false);
                continue;
            }
            Moneda m = Monedas.get(i);
            if (m.getValor()==100) {
                dibujo.setImage(0);
            }else if (m.getValor()==500) {
                dibujo.setImage(1);
            }else if (m.getValor()==1000) {
                dibujo.setImage(2);
            }else if (m.getValor()==1500) {
                dibujo.setImage(3);
            }
            dibujo.setActive(true);
        }
    }

}
