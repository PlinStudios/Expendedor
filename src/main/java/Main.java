import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Main {
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda coin = new Moneda500();
        Expendedor exp = new Expendedor(1,300);
        Comprador cmp = new Comprador(coin,Expendedor.SPRITE,exp);
        System.out.println(cmp.queBebiste());
        System.out.println(cmp.cuantoVuelto());
        cmp = new Comprador(coin,Expendedor.SPRITE,exp);
        System.out.println(cmp.queBebiste());
        System.out.println(cmp.cuantoVuelto());
    }
}