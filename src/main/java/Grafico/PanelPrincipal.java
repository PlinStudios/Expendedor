package Grafico;

import Logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador com;
    private PanelExpendedor exp;
    private Expendedor expp;
    public PanelPrincipal () {
        expp=new Expendedor(5);
        exp = new PanelExpendedor(expp);
        com = new PanelComprador(expp,exp);
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