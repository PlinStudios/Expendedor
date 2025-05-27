package Logica.Productos;

public class Super8 extends Dulce{
    /**@param serie numero de serie asignado en la creación del objeto*/
    public Super8(int serie){
        super(serie);
    }
    /**@return retorna string con nombre del producto*/
    @Override
    public String consumir(){
        return "super8";
    }
}
