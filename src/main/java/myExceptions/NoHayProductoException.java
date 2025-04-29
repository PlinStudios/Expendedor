package myExceptions;
import Productos.*;
public class NoHayProductoException extends Exception {
    public NoHayProductoException(Precios product){
        super("El producto de indice "+product+" esta agotado");
    }
}
