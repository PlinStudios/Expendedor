package Grafico;
import java.awt.*;
import javax.swing.*;
public class DibujarProducto extends JComponent {
    private int h,w;
    public DibujarProducto(int w, int h){
        this.w=w;
        this.h=h;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, w, h);
    }
}
