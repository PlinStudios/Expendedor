package Grafico;

import Logica.Deposito;
import Logica.Monedas.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelMonedero extends JPanel {
    private ArrayList<Moneda> monedas100;
    private ArrayList<Moneda> monedas500;
    private ArrayList<Moneda> monedas1000;
    private ArrayList<Moneda> monedas1500;
    private ArrayList<DibujarMoneda> dibujos;
    private int x,y,w,h;
    private int selection;
    public PanelMonedero(){
        this.setBackground(new Color(50,50,50));
        x=this.getX();y=this.getY();w=this.getWidth();h=this.getHeight();
        this.setLayout(new GridLayout(2,2));
        //this.setLayout(null);
        monedas100=new ArrayList<Moneda>();
        monedas500=new ArrayList<Moneda>();
        monedas1000=new ArrayList<Moneda>();
        monedas1500=new ArrayList<Moneda>();
        dibujos=new ArrayList<>();
        selection=-1;
        for(int i=0;i<5;i++){
            monedas100.add(new Moneda100());
            monedas500.add(new Moneda500());
            monedas1000.add(new Moneda1000());
            monedas1500.add(new Moneda1500());
        }
        for(int i=0; i<4; i++){
            DibujarMoneda dibujo=new DibujarMoneda(this,100,100,i);
            this.add(dibujo);
            dibujos.add(dibujo);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
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
                return monedas100.size();
            case 1:
                return monedas500.size();
            case 2:
                return monedas1000.size();
            case 3:
                return monedas1500.size();
            default:
                return 0;
        }
    }
    public Moneda getEfectivo(){
        Moneda out;
        switch (selection){
            case 0:
                out=monedas100.remove(0);
                break;
            case 1:
                out=monedas500.remove(0);
                break;
            case 2:
                out=monedas1000.remove(0);
                break;
            case 3:
                out=monedas1500.remove(0);
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
