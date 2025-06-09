package Grafico;

import Logica.Deposito;
import Logica.Expendedor;
import Logica.Productos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Expendedor con disitntos productos
 */
public class PanelExpendedor extends JPanel {
    private ArrayList<PanelProducto> depositos;
    private PanelDepositoMonedas depositoMonedas;
    private PanelVuelto vuelto;
    private PanelCaida producto;
    private Expendedor exp;

    /**
     * @param exp expendedor que estamos representando
     */
    public PanelExpendedor(Expendedor exp){
        this.setBackground(new Color(200,200,200));
        this.exp=exp;
        depositos = new ArrayList<>();
        Deposito<Producto> coca=exp.getCoca();
        Deposito<Producto> sprite=exp.getSprite();
        Deposito<Producto> fanta=exp.getFanta();
        Deposito<Producto> snickers=exp.getSnickers();
        Deposito<Producto> super8=exp.getSuper8();

        Deposito<Producto> monedas=exp.getDepositoMonedas();
        int d=10;
        int h=75;
        depositos.add(new PanelProducto(10,d,300,h,coca,1));
        depositos.add(new PanelProducto(10,2*d+h,300,h,sprite,2));
        depositos.add(new PanelProducto(10,2*(d+h)+d,300,h,fanta,3));
        depositos.add(new PanelProducto(10,3*(d+h)+d,300,h,snickers,5));
        depositos.add(new PanelProducto(10,4*(d+h)+d,300,h,super8,4));

        depositoMonedas = new PanelDepositoMonedas(10,6*(d+h)+d,300,h,monedas);

        vuelto = new PanelVuelto(300-h,5*(d+h)+d,h,h,exp);
        producto = new PanelCaida(20,5*(d+h)+d,300-h-3*d,h);

        this.setLayout(null);
        for (int i=0; i<5; i++){
            this.add(depositos.get(i));
        }
        this.add(depositoMonedas);
        this.add(vuelto);
        this.add(producto);
    }

    /**
     *
     * @param caida producto comprado que queremos mostrar
     */
    public void setCaida(Producto caida){
        producto.setType(caida);
        producto.revalidate();
        producto.repaint();
    }

    /**
     * se obtiene vuelto
     */
    public void rollVuelto(){
        vuelto.getVuelto();

        vuelto.revalidate();
        vuelto.repaint();
    }

    /**
     *
     * @param monedero monedero del comprador
     */
    public void setPanelMonedero(PanelMonedero monedero){
        vuelto.setPanelMonedero(monedero);
    }

    /**
     *
     * @return Producto comprado
     */
    public Producto getCaida(){
        return producto.getCaida();
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

    }

}
