package Grafico;

import javax.swing.*;
import java.awt.*;

public class PanelCaida extends JPanel{
    public PanelCaida(int x, int y, int w, int h){
        this.setBackground(new Color(103, 151, 141));
        this.setBounds(x,y,w,h);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
