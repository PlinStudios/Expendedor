package myExceptions;

public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(){
        super("No puedes pagar con null");
    }
}
