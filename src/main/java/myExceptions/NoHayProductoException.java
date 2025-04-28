package myExceptions;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(int product){
        super("El producto de indice "+product+" esta agotado");
    }
}
