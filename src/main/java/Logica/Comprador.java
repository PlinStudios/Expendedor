package Logica;

import Logica.Monedas.*;
import Logica.Productos.*;
import Logica.myExceptions.*;

/**Hace una solo compra a un Logica.Expendedor
 */
public class Comprador{
    private String sonido;
    private int vuelto=0;
    private Producto mySnack;
    private Expendedor exp;

    /**Hace una compra a un Logica.Expendedor, pagando con una Moneda para conseguir un Producto y retira el vuelto
     *
     * @param m Moneda para pagar
     * @param cualProducto Producto a comprar
     * @param exp Logica.Expendedor al que va a comprar
     * @throws NoHayProductoException
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     */
    public Comprador(Moneda m, Precios cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        this.exp=exp;
        try {
            exp.comprarProducto(m, cualProducto);
            mySnack=exp.getProducto();
            if (mySnack != null)
                sonido = mySnack.consumir();
            /*
            while (true) {
                Moneda monedas_vuelto = exp.getVuelto();
                if (monedas_vuelto != null)
                    vuelto += monedas_vuelto.getValor();
                else
                    break;
            }*/
        }catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException e){
            while (true) {
                Moneda monedas_vuelto = exp.getVuelto();
                if (monedas_vuelto != null)
                    vuelto += monedas_vuelto.getValor();
                else
                    break;
            }
            throw e;
        }

    }

    /**
     * Saca vuelto de expendedor
     * @return moneda de vuelto
     */
    public Moneda sacarVuelto(){
        Moneda monedas_vuelto = exp.getVuelto();
        if (monedas_vuelto != null)
            vuelto += monedas_vuelto.getValor();
        return monedas_vuelto;
    }

    /**Cuanto vuelto obtuvo despues de la compra
     *
     * @return vuelto en numero entero
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    public Producto queProducto(){
        return mySnack;
    }

    /**Que producto se obtuvo de la compra
     *
     * @return string con el nombre del producto
     */
    public String queConsumiste(){
        return sonido;
    }
}