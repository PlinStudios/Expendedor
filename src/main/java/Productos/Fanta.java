package Productos;

public class Fanta extends Bebida {
    /**@param serie numero de serie asignado en la creación del objeto*/
    public Fanta(int serie){
        super(serie);
    }
    /**@return retorna string con nombre del producto*/
    @Override
    public String consumir(){
        return "fanta";
    }
}
