package Grafico;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador com;
    private PanelExpendedor exp;
    public PanelPrincipal () {
        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1,2));
        this.add(exp);
        this.add(com);
    }
    public void paintComponent (Graphics g) { //todo se dibuja a partir de este método
        super.paintComponent(g); //llama al método paint al que hace override en la super clase
        //el de la super clase solo pinta el fondo (background)
        com.paintComponent(g); //llama al metodo paintComponent definido en el PanelComprador
        exp.paintComponent(g); //llama al metodo paintComponent definido en el PanelExpendedor
    }
}