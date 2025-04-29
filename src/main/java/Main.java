import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Main {
    static void TryCompra(Moneda m, Precios type, Expendedor exp){
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
    public static void main(String[] args){
        Moneda coin = new Moneda500();
        Expendedor exp = new Expendedor(2);
        TryCompra(coin,Precios.SUPER8,exp);
        TryCompra(coin,Precios.FANTA,exp);
        TryCompra(coin,Precios.SNICKERS,exp);
        //al vuelto se suma lo de las compras fallidas
        TryCompra(coin,Precios.SUPER8,exp);
    }
}