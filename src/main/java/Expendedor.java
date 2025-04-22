import Monedas.*;
import Productos.*;

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
    public Bebida comprarBebida(Moneda m, int type){
        //devuelve bebida
        Bebida myBeb=null;
        if (m!=null)
            if (m.getValor()>=precio)
                if (type==1)
                    myBeb = coca.getElement();
                else if (type==2)
                    myBeb = sprite.getElement();

        //anade monedas
        if (myBeb!=null) {
            int monedas = (m.getValor() - precio) / 100;
            for (int i = 0; i < monedas; i++) {
                monVuelto.addElement(new Moneda100());
            }
        }else{
            monVuelto.addElement(m);
        }

        return myBeb;
    }
    public Moneda getVuelto(){
        return monVuelto.getElement();
    }
}