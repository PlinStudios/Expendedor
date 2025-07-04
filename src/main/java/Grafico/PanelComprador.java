package Grafico;

import Logica.Comprador;
import Logica.Expendedor;
import Logica.Monedas.*;
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
    private Moneda efectivo;

    /**
     *
     * @param exp expendedor del que comprará cosas
     * @param panel panel del expendedor del que comprará cosas
     */
    public PanelComprador(Expendedor exp, PanelExpendedor panel){
        this.setBackground(new Color(100,100,100));
        this.setSize(100,100);
        this.exp=exp;
        this.setLayout(new GridLayout(3,2));
        efectivo=null;
        ArrayList<Precios> tipo=new ArrayList<Precios>(Arrays.asList(Precios.COCA,Precios.FANTA,Precios.SPRITE,Precios.SUPER8,Precios.SNICKERS));
        //botones para comprar
        buttons = new ArrayList<>();
        buttons.add(new Button("CocaCola $"+Precios.COCA.getPrecio()));
        //buttons.add(new Button( String.format("<html>CocaCola<br/>$%d</html>",Precios.COCA.getPrecio())));
        buttons.add(new Button("Fanta $"+Precios.FANTA.getPrecio()));
        buttons.add(new Button("Sprite $"+Precios.SPRITE.getPrecio()));
        buttons.add(new Button("Super8 $"+Precios.SUPER8.getPrecio()));
        buttons.add(new Button("Snickers $"+Precios.SNICKERS.getPrecio()));
        monedero=new PanelMonedero();
        for (int i=0; i<5; i++) {
            this.add(buttons.get(i));
        }
        this.add(monedero);
        for(int i=0;i<5;i++){
            int j=i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        try {
                            if (panel.getCaida()==null) {
                                efectivo = monedero.getEfectivo();
                                cmp = new Comprador(efectivo, tipo.get(j), exp);
                                panel.setCaida(cmp.queProducto());
                                panel.rollVuelto();
                                panel.revalidate();
                                panel.repaint();
                            }
                            else {
                                throw new HayProductoSinRecogerException();
                            }
                        } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException | HayProductoSinRecogerException w) {
                            JOptionPane.showMessageDialog(null, w, "Excepción", JOptionPane.INFORMATION_MESSAGE);
                            panel.rollVuelto();
                            panel.revalidate();
                            panel.repaint();
                        }
                    }
                });
        }


    }

    /**
     *
     * @return panel que contiene al monedero
     */
    public PanelMonedero getPanelMonedero() {
        return monedero;
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
