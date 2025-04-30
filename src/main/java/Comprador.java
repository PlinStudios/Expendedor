import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Comprador{
    private String sonido;
    private int vuelto=0;

    public Comprador(Moneda m, Precios cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        try {
            Producto mySnack = exp.comprarProducto(m, cualProducto);
            if (mySnack != null)
                sonido = mySnack.consumir();

            while (true) {
                Moneda monedas_vuelto = exp.getVuelto();
                if (monedas_vuelto != null)
                    vuelto += monedas_vuelto.getValor();
                else
                    break;
            }
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
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queConsumiste(){
        return sonido;
    }
}