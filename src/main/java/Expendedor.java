import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Expendedor{
    //public static final int  COCA=1;   //placeholders antes de crear enum
    //public static final int  SPRITE=2;
    //public static final int  FANTA=3;
    //public static final int  SUPER8=4;
    //public static final int  SNICKER=5;

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snickers;
    private Deposito<Moneda> monVuelto;
    private int precio;

    public Expendedor(int howmany){
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        fanta = new Deposito<Producto>();
        super8 = new Deposito<Producto>();
        snickers = new Deposito<Producto>();
        monVuelto = new Deposito<Moneda>();

        for (int i=0; i<howmany; i++){
            coca.addElement(new CocaCola(100+i));
            sprite.addElement(new Sprite(200+i));
            fanta.addElement(new Fanta(300+i));
            super8.addElement(new Super8(400+i));
            snickers.addElement(new Snickers(500+i));
        }
    }

    public Producto comprarProducto(Moneda m, Precios type) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        //devuelve producto
        Producto mySnack=null;
        precio= type.getPrecio();
        if (m!=null) {
            if (m.getValor() >= precio) {
                switch(type) {
                    case COCA:
                        mySnack = coca.getElement();
                        break;
                    case SPRITE:
                        mySnack = sprite.getElement();
                        break;
                    case FANTA:
                        mySnack = fanta.getElement();
                        break;
                    case SUPER8:
                        mySnack = super8.getElement();
                        break;
                    case SNICKERS:
                        mySnack = snickers.getElement();
                        break;
                    default:
                        mySnack=null;
                        break;
                }
                if (mySnack==null)
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

        return mySnack;
    }
    public Moneda getVuelto(){
        return monVuelto.getElement();
    }
}