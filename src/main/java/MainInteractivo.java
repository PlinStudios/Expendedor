import Monedas.*;
import Productos.Precios;
import myExceptions.NoHayProductoException;
import myExceptions.PagoIncorrectoException;
import myExceptions.PagoInsuficienteException;
import java.util.Scanner;

public class MainInteractivo {
    /**Metodo que permite que reemplzada try-catch puestos manualmente,
     * se le entregan los paramétros requeridos por Comprador y este internamente lo llama y lanza y atrapa posibles excepciones
     *
     * @param m Moneda con la que se intenta hacer la compra
     * @param type tipo de producto seleccionado
     * @param exp Expendedor con el que interactuaremos
     */
    public static void TryCompra(Moneda m, Precios type, Expendedor exp){
        try {
            Comprador cmp = new Comprador(m, type, exp);
            System.out.println("El Producto es "+cmp.queConsumiste());
            System.out.println("El vuelto es de "+cmp.cuantoVuelto()+" pesos");
        }catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        }catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param valor valor de la Moneda con la que se quiere hacer la compra
     * @return retorna Moneda con valor deseado si el input corresponde con valor de monedas existentes,de lo contrario, retorna null
     */
    public static Moneda QueMoneda(int valor){
        Moneda coin;
        if(valor==100){coin=new Moneda100();}
        else if(valor==500){coin=new Moneda500();}
        else if(valor==1000){coin=new Moneda1000();}
        else if(valor==1500){coin=new Moneda1500();}
        else{
            System.out.println("Valor no válido, moneda tendrá valor null");
            coin=null;}
        return coin;
    }
    /**Metodo que imprime un "menú" con indices y precio de los productos*/
    public static void TablaProductos(){
        System.out.println("Presione 0 para salir");

        int i=0;
        for (Precios p : Precios.values()){
            i++;
            System.out.println(i+".- "+p+" $"+p.getPrecio());
        }
    }
    public static void main(String[] args){
        Precios[] escoger;
        escoger= new Precios[]{Precios.COCA, Precios.SPRITE, Precios.FANTA, Precios.SNICKERS, Precios.SUPER8};
        Moneda coin;
        int producto=1;   //inicializamos para no tener problemas con bucle
        int valor;       //valor moneda
        Expendedor exp = new Expendedor(2); //Creamos expendedor
        Scanner scanner = new Scanner(System.in);  // Scanner para ingresar indice
        Scanner scanner2 = new Scanner(System.in);  // Scanner para ingresar valor moneda
        while(producto!=0) {  //cuando producto es cero indicamos que queremos salir del programa
            TablaProductos();
            System.out.println("Ingrese número de producto: ");
            producto = scanner.nextInt();
            if (producto >= 1 & producto <= 5) {  //nos aseguramos que el indice no esté fuera de limites
                System.out.println("Ingrese el valor de su moneda: ");
                valor = scanner.nextInt();
                coin=QueMoneda(valor);
                TryCompra(coin, escoger[producto - 1], exp);
            }
            else if(producto!=0){
                System.out.println("Número NO válido, intente de nuevo: ");
                producto = scanner.nextInt();
                System.out.println("Ingrese el valor de su moneda: ");
                valor = scanner.nextInt();
                coin=QueMoneda(valor);
                TryCompra(coin, escoger[producto - 1], exp);
            }
        }
        if(producto==0){
            System.out.println("Saliendo del programa");
        }
        scanner.close();
        scanner2.close();
    }
}
