import Monedas.*;
import Productos.*;
import myExceptions.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**Usa try-catch para hacer una compra y mostrar los errores si es que hay
     *
     * @param m Moneda con la que se intenta hacer la compra
     * @param type tipo de producto seleccionado
     * @param exp Expendedor con el que interactuaremos
     */
    public static void TryCompra(Moneda m, Precios type, Expendedor exp){
        try {
        Comprador cmp = new Comprador(m, type, exp);
        System.out.println("El Producto es "+cmp.queConsumiste());
        System.out.println("El vuelto es de "+cmp.cuantoVuelto()+" pesos");
        }catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        }catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    /**Main que prueba comprar y los distintos errores que pueden ocurrir,
     * ademas prueba la posibilidad de ordenar monedas por valor
     */
    public static void main(String[] args){
        Moneda coin = new Moneda500();
        Expendedor exp = new Expendedor(2);
        TryCompra(coin,Precios.SUPER8,exp);
        //pago insuficiento
        TryCompra(coin,Precios.FANTA,exp);
        TryCompra(coin,Precios.SNICKERS,exp);
        //cuando falla la compra toma el vuelto, asi que no se suma
        TryCompra(coin,Precios.SUPER8,exp);
        Moneda coin2 = new Moneda1500();
        //agotado
        TryCompra(coin2,Precios.SUPER8,exp);
        TryCompra(coin2,Precios.FANTA,exp);
        //pago incorrecto
        TryCompra(null,Precios.SUPER8,exp);

        //prueba ordenado de monedas
        ArrayList<Moneda> monedero = new ArrayList<Moneda>();
        monedero.add(new Moneda1500());
        monedero.add(new Moneda1000());
        monedero.add(new Moneda100());
        monedero.add(new Moneda500());
        monedero.add(new Moneda500());
        monedero.add(new Moneda100());
        System.out.println("Monedas sin ordenar");
        System.out.println(monedero);
        System.out.println("Ordenadas por valor");
        Collections.sort(monedero);
        System.out.println(monedero);
    }
}