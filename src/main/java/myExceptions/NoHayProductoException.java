package myExceptions;
import Productos.*;
public class NoHayProductoException extends Exception {
    public NoHayProductoException(Precios product){
        super("El producto "+product+" esta agotado");
    }
}
