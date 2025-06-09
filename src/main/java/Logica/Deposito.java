package Logica;

import Logica.Productos.*;
import Logica.Monedas.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> al;
    private int type;
    private Class<?>[] classes;
    private Class<?>[] monedas;

    public Deposito(){
        al = new ArrayList<T>();
        classes = new Class[]{CocaCola.class, Sprite.class, Fanta.class, Super8.class, Snickers.class};
        monedas = new Class[]{Moneda100.class, Moneda500.class, Moneda1000.class, Moneda1500.class};
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
        else if(b instanceof Moneda100){type=5;}
        else if(b instanceof Moneda500){type=6;}
        else if(b instanceof Moneda1000){type=7;}
        else if(b instanceof Moneda1500){type=8;}


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
            if(type<5) {
                Class<?> clazz = classes[type];
                Constructor<?> constructor = clazz.getDeclaredConstructor(int.class);
                if (al.size() < max) {
                    while (al.size() < max) {
                        Object instance = constructor.newInstance(150 + 100 * type + add);
                        T producto = (T) instance;
                        al.add(producto);
                        add++;
                    }
                }
            }
            else{
                Class<?> clazz = monedas[type-5];
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                 if (al.size() < max) {
                    while (al.size() < max) {
                        Object instance = constructor.newInstance();
                        T producto = (T) instance;
                        al.add(producto);
                    }
                 }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }
}

