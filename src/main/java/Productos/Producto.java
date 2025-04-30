package Productos;


public abstract class Producto {
    private int serie;

    /**@param serie numero de serie del producto asignado al crearse*/
    public Producto(int serie){
        this.serie=serie;
    }

    /**@return retorna int con numero de serie*/
    public int getSerie(){
        return serie;
    }

    /**@return una vez instanciado retornará String con nombre del producto*/
    public abstract String consumir();
}
