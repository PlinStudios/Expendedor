package Grafico;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana que contiene nuestro PanelPrincipal con nuestro expendedor y comprador
 */
public class Ventana extends JFrame {
    public Ventana(){
        super();
        this.setTitle("El Expendedor");
        this.setLayout(new BorderLayout());

        this.add(new PanelPrincipal());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(640,640);
        //this.pack();
        this.setVisible(true);
    }
}
