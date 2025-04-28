import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Comprador{
    private String sonido;
    private int vuelto=0;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto mySnack=exp.comprarProducto(m,cualProducto);
        if (mySnack!=null)
            sonido=mySnack.consumir();

        while (true) {
            Moneda monedas_vuelto = exp.getVuelto();
            if (monedas_vuelto!=null)
                vuelto += monedas_vuelto.getValor();
            else
                break;
        }

    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queConsumiste(){
        return sonido;
    }
}