package Grafico;

public class HayProductoSinRecogerException extends Exception {
    public HayProductoSinRecogerException() {
        super("Hay un producto sin recoger, recógalo antes de intentar nueva compra");
    }
}
