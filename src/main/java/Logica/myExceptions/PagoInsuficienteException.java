package Logica.myExceptions;

public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(int pago, int precio){
        super("El pago de "+pago+" no es suficiente para comprar el producto de precio "+precio);
    }
}
