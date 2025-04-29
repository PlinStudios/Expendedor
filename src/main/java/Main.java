import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Main {
    public static void main(String[] args){
        try {
            Moneda coin = new Moneda500();
            Expendedor exp = new Expendedor(1);
            Comprador cmp = new Comprador(coin, Precios.SPRITE, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
            cmp = new Comprador(coin, Precios.FANTA, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
            cmp = new Comprador(coin, Precios.SPRITE, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
            cmp = new Comprador(coin, Precios.COCA, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
            cmp = new Comprador(coin, Precios.SNICKERS, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
            coin = new Moneda100();
            cmp = new Comprador(coin, Precios.SUPER8, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
            coin = new Moneda1000();
            cmp = new Comprador(coin, Precios.SUPER8, exp);
            System.out.println(cmp.queConsumiste());
            System.out.println(cmp.cuantoVuelto());
        }catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        }catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}