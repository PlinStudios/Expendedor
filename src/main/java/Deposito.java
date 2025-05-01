import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> al;

    public Deposito(){
        al = new ArrayList<T>();
    }

    /** Ingresa un elemento
     *
     * @param b Elemento a ingresar
     */
    public void addElement(T b){
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
}

