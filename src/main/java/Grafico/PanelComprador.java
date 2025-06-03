package Grafico;

import Logica.Comprador;
import Logica.Expendedor;
import Logica.Monedas.Moneda1500;
import Logica.Productos.Precios;
import Logica.myExceptions.NoHayProductoException;
import Logica.myExceptions.PagoIncorrectoException;
import Logica.myExceptions.PagoInsuficienteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelComprador extends JPanel {
    private ArrayList<Button> buttons;
    private PanelMonedero monedero;
    private Expendedor exp;
    private Comprador cmp;

    public PanelComprador(Expendedor exp, PanelExpendedor panel){
        this.setBackground(new Color(100,100,100));
        this.setSize(100,100);
        this.exp=exp;
        this.setLayout(new GridLayout(3,2));
        //botones para comprar
        buttons = new ArrayList<>();
        buttons.add(new Button("CocaCola"));
        ArrayList<Precios> tipo=new ArrayList<Precios>(Arrays.asList(Precios.COCA,Precios.FANTA,Precios.SPRITE,Precios.SNICKERS,Precios.SUPER8));

        buttons.add(new Button("Fanta"));
        buttons.add(new Button("Sprite"));
        buttons.add(new Button("Snickers"));
        buttons.add(new Button("Super8"));
        for (int i=0; i<5; i++) {
            this.add(buttons.get(i));
        }
        for(int i=0;i<5;i++){
            int j=i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        cmp=new Comprador(new Moneda1500(), tipo.get(j),exp);
                        panel.revalidate();
                        panel.repaint();}
                    catch(NoHayProductoException|PagoIncorrectoException| PagoInsuficienteException w){
                        System.out.println(w);
                    }
                }});
        }

        monedero=new PanelMonedero();
        this.add(monedero);

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
