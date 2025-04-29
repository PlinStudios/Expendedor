import Monedas.*;
import Productos.*;
import myExceptions.*;

public class Expendedor{
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> super8;
    private Deposito<Producto> snickers;
    private Deposito<Moneda> monVuelto;

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
        if (m!=null) {
            if (m.getValor() >= type.getPrecio()) {
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
                    int monedas = (m.getValor() - type.getPrecio()) / 100;
                    for (int i = 0; i < monedas; i++) {
                        monVuelto.addElement(new Moneda100());
                    }
                }
            } else {
                monVuelto.addElement(m);
                throw new PagoInsuficienteException(m.getValor(), type.getPrecio());
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