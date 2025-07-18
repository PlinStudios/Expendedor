package Logica;

import Logica.Monedas.*;
import Logica.Productos.*;
import Logica.myExceptions.*;

import java.util.ArrayList;

/**Expendedor que guarda productos y permite comprarlos
 */
public class Expendedor{
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snickers;
    private Deposito<Moneda> monVuelto;
    private Deposito<Moneda> depositoMonedas;

    private Producto depositoCaida;

    /**Crea los depositos para cada producto
     * y los llena con el producto correspondiente
     *
     * @param howmany Determina cuantos productos se crearan para cada Logica.Deposito
     */
    public Expendedor(int howmany){
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta = new Deposito<Producto>();
        super8 = new Deposito<Producto>();
        snickers = new Deposito<Producto>();
        monVuelto = new Deposito<Moneda>();
        depositoMonedas = new Deposito<Moneda>();

        for (int i=0; i<howmany; i++){
            coca.addElement(new CocaCola(100+i));
            sprite.addElement(new Sprite(200+i));
            fanta.addElement(new Fanta(300+i));
            super8.addElement(new Super8(400+i));
            snickers.addElement(new Snickers(500+i));
        }
    }

    /** Compra un producto desde el Expendedor y genera el vuelto
     *
     * @param m Moneda usada para comprar
     * @param type Tipo de producto a comprar
     * @throws PagoInsuficienteException Si el dinero no es suficiente para comprar el producto
     * @throws PagoIncorrectoException Si se intenta pagar sin una moneda
     * @throws NoHayProductoException Si el producto esta agotado
     */
    public void comprarProducto(Moneda m, Precios type) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        //devuelve producto
        Producto mySnack=null;
        if (m!=null) {
            if (m.getValor() >= type.getPrecio()) {
                switch(type) {
                    case COCA:
                        mySnack = coca.getElement();
                        break;
                    case SPRITE:
                        mySnack = sprite.getElement();
                        break;
                    case FANTA:
                        mySnack = fanta.getElement();
                        break;
                    case SUPER8:
                        mySnack = super8.getElement();
                        break;
                    case SNICKERS:
                        mySnack = snickers.getElement();
                        break;
                    default:
                        mySnack=null;
                        break;
                }
                if (mySnack==null) {
                    monVuelto.addElement(m);
                    throw new NoHayProductoException(type);
                }else{
                    //añade monedas
                    int monedas = (m.getValor() - type.getPrecio());
                    while (monedas!=0) {
                        if(monedas>=1500){
                            monVuelto.addElement(new Moneda1500());
                            monedas=monedas-1500;
                        }
                        else if(monedas>=1000){
                            monVuelto.addElement(new Moneda1000());
                            monedas=monedas-1000;
                        }
                        else if(monedas>=500){
                            monVuelto.addElement(new Moneda500());
                            monedas=monedas-500;
                        }
                        else if(monedas>=100){
                            monVuelto.addElement(new Moneda100());
                            monedas=monedas-100;
                        }
                    }
                    depositoMonedas.addElement(m);
                }
            } else {
                monVuelto.addElement(m);
                throw new PagoInsuficienteException(m.getValor(), type.getPrecio());
            }
        } else {
            throw new PagoIncorrectoException();
        }

        depositoCaida = mySnack;
    }

    /**Sirve para obtener una Moneda del deposito de vuelto,
     * es necesario llamarla hasta que retorne null
     *
     * @return Moneda de vuelto, null si ya no queda vuelto
     */
    public Moneda getVuelto(){
        return monVuelto.getElement();
    }

    /**
     * @return deposito de CocaCola
     */
    public Deposito getCoca(){
        return coca;
    }

    /**
     * @return deposito de Fanta
     */
    public Deposito getFanta(){
        return fanta;
    }

    /**
     * @return deposito de Sprite
     */
    public Deposito getSprite(){
        return sprite;
    }
    /**
     * @return deposito de Snickers
     */
    public Deposito getSnickers(){
        return snickers;
    }
    /**
     * @return deposito de Super8
     */
    public Deposito getSuper8(){
        return super8;
    }public Deposito getDepositoMonedas(){
        return depositoMonedas;
    }

    /**
     *
     * @return producto comprado y lo retira
     */
    public Producto getProducto(){
        Producto myproducto = depositoCaida;
        depositoCaida = null; //retira producto
        return myproducto;
    }
}