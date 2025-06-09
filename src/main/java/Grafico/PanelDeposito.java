package Grafico;

import javax.swing.*;
import java.awt.*;

public abstract class PanelDeposito extends JPanel {
    /**
     *
     * @param x posición x del panel
     * @param y posición y del panel
     * @param w ancho del panel
     * @param h alot del panel
     */
    public PanelDeposito(int x, int y, int w, int h){
        this.setBackground(new Color(50,50,50));
        this.setBounds(x,y,w,h);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
