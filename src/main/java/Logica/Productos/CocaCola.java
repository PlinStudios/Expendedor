package Logica.Productos;

public class CocaCola extends Bebida{
    /**@param serie numero de serie asignado en la creación del objeto*/
    public CocaCola(int serie){
        super(serie);
    }

    /**@return retorna string con nombre del producto*/
    @Override
    public String consumir(){
        return "cocacola";
    }
}
