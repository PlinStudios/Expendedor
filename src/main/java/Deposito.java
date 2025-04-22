import java.util.ArrayList;

public class Deposito<T>{
    private ArrayList<T> al;

    public Deposito(){
        al = new ArrayList<T>();
    }
    public void addElement(T b){
        al.add(b);
    }
    public T getElement(){
        if (al.size()==0)
            return null;
        return al.remove(0);
    }
}

