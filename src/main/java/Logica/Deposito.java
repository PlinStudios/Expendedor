package Logica;

import Logica.Productos.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> al;
    private int type;
    private Class<?>[] classes;

    public Deposito(){
        al = new ArrayList<T>();
        classes = new Class[]{CocaCola.class, Sprite.class, Fanta.class, Super8.class, Snickers.class};
    }

    /** Ingresa un elemento
     *
     * @param b Elemento a ingresar
     */
    public void addElement(T b){
        if(b instanceof CocaCola){type=0;}
        else if(b instanceof Sprite){type=1;}
        else if(b instanceof Fanta){type=2;}
        else if(b instanceof Super8){type=3;}
        else if(b instanceof Snickers){type=4;}

        al.add(b);
    }

    /** Saca un elemento del deposito
     *
     * @return El primer elemento ingresado
     */
    public T getElement(){
        if (al.size()==0)
            return null;
        return al.remove(0);
    }
    public ArrayList getDeposito(){
        return al;
    }

    public void rellenarDeposito(int max){
        int add=0;
        try {
            Class<?> clazz = classes[type];
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class);
            if (al.size() <= max) {
                while (al.size() <= max) {
                    Object instance = constructor.newInstance(50+100*type+add);
                    T producto=(T) instance;
                    System.out.println(producto);
                    al.add(producto);
                    add++;
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }
}

