package Productos;

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
    public int getPrecio(){
        return precio;
    }
}
