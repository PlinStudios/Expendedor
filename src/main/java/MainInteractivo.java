import Monedas.*;
import Productos.Precios;
import myExceptions.NoHayProductoException;
import myExceptions.PagoIncorrectoException;
import myExceptions.PagoInsuficienteException;
import java.util.Scanner;

public class MainInteractivo {
    static void TryCompra(Moneda m, Precios type, Expendedor exp){
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
    static Moneda QueMoneda(int valor){
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
    static void TablaProductos(){
        System.out.println("Presione 0 para salir");
        System.out.println("1.- Coca Cola $1000\n2.- Sprite $900\n3.- Fanta $800\n4.- Snickers $1000\n5.- Super8 $300");
    }
    public static void main(String[] args){
        Precios[] escoger;
        escoger= new Precios[]{Precios.COCA, Precios.SPRITE, Precios.FANTA, Precios.SNICKERS, Precios.SUPER8};
        Moneda coin;
        int producto=1;
        int valor;
        Expendedor exp = new Expendedor(2);
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Scanner scanner2 = new Scanner(System.in);  // Create a Scanner object
        while(producto!=0) {
            TablaProductos();
            System.out.println("Ingrese número de producto: ");
            producto = scanner.nextInt();
            if (producto >= 1 & producto <= 5) {
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
