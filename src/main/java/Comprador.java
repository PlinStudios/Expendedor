import Monedas.*;
import Productos.*;

public class Comprador{
    private String sonido;
    private int vuelto=0;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida myBeb=exp.comprarBebida(m,cualBebida);
        if (myBeb!=null)
            sonido=myBeb.beber();

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
    public String queBebiste(){
        return sonido;
    }
}