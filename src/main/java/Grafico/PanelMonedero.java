package Grafico;

import Logica.Deposito;
import Logica.Monedas.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelMonedero extends JPanel {
    private ArrayList<ArrayList<Moneda>> monedero;
    private ArrayList<Moneda> monedas100;
    private ArrayList<Moneda> monedas500;
    private ArrayList<Moneda> monedas1000;
    private ArrayList<Moneda> monedas1500;
    private DibujarMoneda dibujo;
    private int x,y,w,h;
    private Moneda efectivo;
    public PanelMonedero(){
        this.setBackground(new Color(50,50,50));
        x=this.getX();y=this.getY();w=this.getWidth();h=this.getHeight();
        this.setLayout(new GridLayout(2,2));
        //this.setLayout(null);
        monedas100=new ArrayList<Moneda>();
        monedas500=new ArrayList<Moneda>();
        monedas1000=new ArrayList<Moneda>();
        monedas1500=new ArrayList<Moneda>();
        for(int i=0;i<5;i++){
            monedas100.add(new Moneda100());
            monedas500.add(new Moneda500());
            monedas1000.add(new Moneda1000());
            monedas1500.add(new Moneda1500());
        }
        monedero=new ArrayList<ArrayList<Moneda>>(Arrays.asList(monedas100,monedas500,monedas1000,monedas1500));
        for(ArrayList<Moneda> mon : monedero){
            dibujo=new DibujarMoneda(100,100,mon);
            this.add(dibujo);
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }

    public Moneda getEfectivo(){return efectivo;}
}
