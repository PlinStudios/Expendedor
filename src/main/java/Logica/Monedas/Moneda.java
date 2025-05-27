package Logica.Monedas;

public abstract class Moneda implements Comparable<Moneda>{
    public Moneda(){
    }

    /**@return retorna referencia a si mismo*/
    public Moneda getSerie(){
        return this;
    }

    /**@return una vez instanciado retorna valor de la Moneda*/
    public abstract int getValor();

    @Override
    public int compareTo(Moneda m){
        return this.getValor() - m.getValor();
    }
}
