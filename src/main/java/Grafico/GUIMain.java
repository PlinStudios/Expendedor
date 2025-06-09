package Grafico;

import java.awt.*;

public class GUIMain {
    private static Ventana v;
    public static void main(String[] args) {
        v = new Ventana();
        v.setSize(new Dimension(640,640));
        v.setResizable(false);
    }
}
