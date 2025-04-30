package Productos;

public class Sprite extends Bebida{
    /**@param serie numero de serie asignado en la creación del objeto*/
    public Sprite(int serie){
        super(serie);
    }
    /**@return retorna string con nombre del producto*/
    @Override
    public String consumir(){
        return "sprite";
    }
}
