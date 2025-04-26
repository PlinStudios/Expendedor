import Monedas.*;
import Productos.*;

public class Expendedor{
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    public static final int  SUPER8=3;
    public static final int  SNICKER=4;

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> super8;
    private Deposito<Producto> snickers;
    private Deposito<Moneda> monVuelto;
    private int precio;

    public Expendedor(int howmany, int precio){
        coca = new Deposito<Producto>();
        sprite = new Deposito<Producto>();
        super8 = new Deposito<Producto>();
        snickers = new Deposito<Producto>();
        monVuelto = new Deposito<Moneda>();

        this.precio=precio;

        for (int i=0; i<howmany; i++){
            coca.addElement(new CocaCola(100+i));
            sprite.addElement(new Sprite(200+i));
            super8.addElement(new Super8(300+i));
            snickers.addElement(new Snickers(400+i));
        }
    }
    public Producto comprarProducto(Moneda m, int type){
        //devuelve producto
        Producto mySnack=null;
        if (m!=null)
            if (m.getValor()>=precio)
                if (type==1)
                    mySnack = coca.getElement();
                else if (type==2)
                    mySnack = sprite.getElement();
                else if (type==3)
                    mySnack = super8.getElement();
                else if (type==4)
                    mySnack = snickers.getElement();

        //anade monedas
        if (mySnack!=null) {
            int monedas = (m.getValor() - precio) / 100;
            for (int i = 0; i < monedas; i++) {
                monVuelto.addElement(new Moneda100());
            }
        }else{
            monVuelto.addElement(m);
        }

        return mySnack;
    }
    public Moneda getVuelto(){
        return monVuelto.getElement();
    }
}