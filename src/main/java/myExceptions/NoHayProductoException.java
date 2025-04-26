package myExceptions;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(String product){
        super("El producto "+product+" esta agotado");
    }
}
