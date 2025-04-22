import Monedas.*;
import Productos.*;

public class Main {
    public static void main(String[] args) {
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