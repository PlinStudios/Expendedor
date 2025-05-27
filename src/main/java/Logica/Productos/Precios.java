package Logica.Productos;
/**Precios constantes que serán aplicados a productos*/
public enum Precios {
    COCA(1000),
    SPRITE(900),
    FANTA(800),
    SNICKERS(1000),
    SUPER8(300);
    private final int precio;
    Precios(int precio) {
        this.precio= precio;
    }

    /**Obtiene el precio del producto
     * @return retorna precio asociado al producto*/
    public int getPrecio(){
        return precio;
    }
}
