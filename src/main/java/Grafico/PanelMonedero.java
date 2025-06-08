package Grafico;

import Logica.Comprador;
import Logica.Deposito;
import Logica.Monedas.*;
import Logica.myExceptions.NoHayProductoException;
import Logica.myExceptions.PagoIncorrectoException;
import Logica.myExceptions.PagoInsuficienteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelMonedero extends JPanel {
    private Deposito<Moneda> monedas100;
    private Deposito<Moneda> monedas500;
    private Deposito<Moneda> monedas1000;
    private Deposito<Moneda> monedas1500;
    private ArrayList<DibujarMoneda> dibujos;
    private JButton llenar;
    private JPanel este;
    private int x,y,w,h;
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

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        x=this.getX();y=this.getY();w=this.getWidth();h=this.getHeight();
        int j=0;
        for(int i=0; i<4; i++){
            if(i>=2){j=1;}
            DibujarMoneda dibujo=new DibujarMoneda(this,100,100,i);
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

    public void changeSelection(int selection){
        if (this.selection!=-1) {
            //refresca moneda anterior
            DibujarMoneda pila = dibujos.get(this.selection);
            pila.revalidate();
            pila.repaint();
        }
        //cambia seleccion
        this.selection=selection;
        if (selection!=-1) {
            //refresca moneda actual
            DibujarMoneda pila = dibujos.get(selection);
            pila.revalidate();
            pila.repaint();
        }
    }
    public boolean isSelected(int type){
        return type==selection;
    }
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
            DibujarMoneda pila = dibujos.get(selection);
            pila.revalidate();
            pila.repaint();
            changeSelection(-1);
        }

        return out;
    }
}
