package Grafico;

import Logica.Deposito;
import Logica.Monedas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * se representa el monedero del comprador
 */
public class PanelMonedero extends JPanel {
    private Deposito<Moneda> monedas100;
    private Deposito<Moneda> monedas500;
    private Deposito<Moneda> monedas1000;
    private Deposito<Moneda> monedas1500;
    private ArrayList<DibujarMonedaPila> dibujos;
    private JButton llenar;
    private JPanel este;
    private int w,h;
    private int selection;
    public PanelMonedero(){
        this.setBackground(new Color(50,50,50));
        //this.setLayout(new GridLayout(2,2));
        this.setLayout(null);
        monedas100=new Deposito<Moneda>();
        monedas500=new Deposito<Moneda>();
        monedas1000=new Deposito<Moneda>();
        monedas1500=new Deposito<Moneda>();
        dibujos=new ArrayList<>();
        selection=-1;
        for(int i=0;i<5;i++){
            monedas100.addElement(new Moneda100());
            monedas500.addElement(new Moneda500());
            monedas1000.addElement(new Moneda1000());
            monedas1500.addElement(new Moneda1500());
        }
        este=this;
    }

    /**
     *
     * @param m moneda que se agrega al monedero
     */
    public void addMoneda(Moneda m){
        if (m==null) {
            return;
        }else if (m.getValor()==100){
            monedas100.addElement(m);
        }else if (m.getValor()==500){
            monedas500.addElement(m);
        }else if (m.getValor()==1000){
            monedas1000.addElement(m);
        }else if (m.getValor()==1500){
            monedas1500.addElement(m);
        }

        this.revalidate();
        this.repaint();
    }

    /**
     *SE dibujan las monedas y si se apreta un botón el monedero se "llena"
     */
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        w=this.getWidth();h=this.getHeight();
        int j=0;
        for(int i=0; i<4; i++){
            if(i>=2){j=1;}
            DibujarMonedaPila dibujo=new DibujarMonedaPila(this,100,100,i);
            dibujo.setBounds((i%2)*(w/2),j*(w/2),w/2,h/2);
            this.add(dibujo);
            dibujos.add(dibujo);
        }
        llenar=new JButton("Llenar");
        llenar.setBounds(w/2-40,h-20,80,20);
        llenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monedas100.rellenarDeposito(5);
                monedas500.rellenarDeposito(5);
                monedas1000.rellenarDeposito(5);
                monedas1500.rellenarDeposito(5);
                este.revalidate();
                este.repaint();
            }});
        this.add(llenar);
    }

    /**
     *
     * @param selection se cambia moneda seleccionada para hacer una compra
     */
    public void changeSelection(int selection){
        if (this.selection!=-1) {
            //refresca moneda anterior
            DibujarMonedaPila pila = dibujos.get(this.selection);
            pila.revalidate();
            pila.repaint();
        }
        //cambia seleccion
        this.selection=selection;
        if (selection!=-1) {
            //refresca moneda actual
            DibujarMonedaPila pila = dibujos.get(selection);
            pila.revalidate();
            pila.repaint();
        }
    }

    /**
     *
     * @param type moneda que se quiere saber si está seleccionada
     * @return si está seleccionada o no
     */
    public boolean isSelected(int type){
        return type==selection;
    }

    /**
     *
     * @param type valor de la pila de monedas
     * @return tamaño de la pila de monedas
     */
    public int getPilaSize(int type){
        switch (type){
            case 0:
                return monedas100.getDeposito().size();
            case 1:
                return monedas500.getDeposito().size();
            case 2:
                return monedas1000.getDeposito().size();
            case 3:
                return monedas1500.getDeposito().size();
            default:
                return 0;
        }
    }

    /**
     *
     * @return moneda con la cual se hace la compra
     */
    public Moneda getEfectivo(){
        Moneda out;
        switch (selection){
            case 0:
                out=monedas100.getElement();
                break;
            case 1:
                out=monedas500.getElement();
                break;
            case 2:
                out=monedas1000.getElement();
                break;
            case 3:
                out=monedas1500.getElement();
                break;
            default:
                out=null;
                break;
        }
        if (out!=null) {
            DibujarMonedaPila pila = dibujos.get(selection);
            pila.revalidate();
            pila.repaint();
            changeSelection(-1);
        }

        return out;
    }
}
