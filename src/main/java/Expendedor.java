import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Expendedor{
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVuelto;
    private int precio;

    public Expendedor(int howmany, int precio){
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        monVuelto = new Deposito<Moneda>();

        this.precio=precio;

        for (int i=0; i<howmany; i++){
            coca.addElement(new CocaCola(100+i));
            sprite.addElement(new Sprite(200+i));
        }
    }
    public Bebida comprarBebida(Moneda m, int type) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        //devuelve bebida
        Bebida myBeb=null;
        if (m!=null) {
            if (m.getValor() >= precio) {
                if (type == 1)
                    myBeb = coca.getElement();
                else if (type == 2)
                    myBeb = sprite.getElement();

                if (myBeb==null)
                    throw new NoHayProductoException(type);
                else{
                    //añade monedas
                    int monedas = (m.getValor() - precio) / 100;
                    for (int i = 0; i < monedas; i++) {
                        monVuelto.addElement(new Moneda100());
                    }
                }
            } else {
                monVuelto.addElement(m);
                throw new PagoInsuficienteException(m.getValor(), precio);
            }
        } else {
            throw new PagoIncorrectoException();
        }

        return myBeb;
    }
    public Moneda getVuelto(){
        return monVuelto.getElement();
    }
}