package Logica.myExceptions;
import Logica.Productos.*;
public class NoHayProductoException extends Exception {
    public NoHayProductoException(Precios product){
        super("El producto "+product+" esta agotado");
    }
}
