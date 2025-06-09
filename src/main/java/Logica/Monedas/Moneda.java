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

    /**
     *
     * @param m el objeto a comparar.
     * @return la diferenica entera entre este objeto y el ingresado
     */
    @Override
    public int compareTo(Moneda m){
        return this.getValor() - m.getValor();
    }
}
