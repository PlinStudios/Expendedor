package Logica.Productos;

public class Snickers extends Dulce{
    /**@param serie numero de serie asignado en la creación del objeto*/
    public Snickers(int serie){
        super(serie);
    }
    /**@return retorna string con nombre del producto*/
    @Override
    public String consumir(){
        return "snickers";
    }
}
