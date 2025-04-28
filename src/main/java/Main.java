import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Main {
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda coin = new Moneda500();
        Expendedor exp = new Expendedor(1,300);
        Comprador cmp = new Comprador(coin,Expendedor.SPRITE,exp);
        System.out.println(cmp.queConsumiste());
        System.out.println(cmp.cuantoVuelto());
        cmp = new Comprador(coin,Expendedor.SPRITE,exp);
        System.out.println(cmp.queConsumiste());
        System.out.println(cmp.cuantoVuelto());
        cmp = new Comprador(coin,Expendedor.COCA,exp);
        System.out.println(cmp.queConsumiste());
        System.out.println(cmp.cuantoVuelto());
        cmp = new Comprador(coin,Expendedor.SNICKER,exp);
        System.out.println(cmp.queConsumiste());
        System.out.println(cmp.cuantoVuelto());
        coin=new Moneda100();
        cmp = new Comprador(coin,Expendedor.SUPER8,exp);
        System.out.println(cmp.queConsumiste());
        System.out.println(cmp.cuantoVuelto());
        coin=new Moneda1000();
        cmp = new Comprador(coin,Expendedor.SUPER8,exp);
        System.out.println(cmp.queConsumiste());
        System.out.println(cmp.cuantoVuelto());
    }
}