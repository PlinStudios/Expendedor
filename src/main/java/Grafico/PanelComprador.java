package Grafico;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    private ArrayList<Button> buttons;
    private PanelMonedero monedero;

    public PanelComprador(){
        this.setBackground(new Color(100,100,100));
        this.setSize(100,100);

        this.setLayout(new GridLayout(3,2));
        //botones para comprar
        buttons = new ArrayList<>();
        buttons.add(new Button("CocaCola"));
        buttons.add(new Button("Fanta"));
        buttons.add(new Button("Sprite"));
        buttons.add(new Button("Snickers"));
        buttons.add(new Button("Super8"));
        for (int i=0; i<5; i++) {
            this.add(buttons.get(i));
        }

        monedero=new PanelMonedero();
        this.add(monedero);

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
}
