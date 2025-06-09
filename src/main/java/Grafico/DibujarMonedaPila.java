package Grafico;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class DibujarMonedaPila extends JComponent implements MouseListener {
    private int h,w;
    private BufferedImage image;
    int type;
    private PanelMonedero monedero;
    private JLabel texto=new JLabel("inicio");

    public DibujarMonedaPila(PanelMonedero monedero, int w, int h, int type){
        image=null;
        setLayout(null);
        this.w=w;
        this.h=h;
        addMouseListener(this);
        this.monedero=monedero;
        this.type=type;
        setImage(type);
        this.add(texto);
    }

    /**
     *
     * @param type dependiendo del numero establece la imagen a desplegar
     */
    public void setImage(int type){
        try {
            if(type==0){image = ImageIO.read(new File("src/main/resources/Moneda100.png"));}
            else if(type==1){image = ImageIO.read(new File("src/main/resources/Moneda500.png"));}
            else if(type==2){image = ImageIO.read(new File("src/main/resources/Moneda1000.png"));}
            else if(type==3){image = ImageIO.read(new File("src/main/resources/Moneda1500.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //al ser seleccionada la moneda tiene un circulo rodeándola
        if (image != null) {
            if (monedero.isSelected(type)) {
                Ellipse2D.Double circle = new Ellipse2D.Double(20, 20, w - 40, h - 40);
                g2d.setColor(Color.yellow);
                g2d.fill(circle);
            }
            g2d.drawImage(image, 0, 0, w, h,this);
            texto.setText("x"+monedero.getPilaSize(type));  //despliega cantidad de monedas
            texto.setOpaque(true);
            texto.setBackground(new Color(50,50,50));
            texto.setForeground(Color.BLUE);
            texto.setBounds(w/2-10,h-30,20,15);
        }
    }

    /** si el elemento es clickeado se selecciona para la futura compra
     * @param e evento a procesar
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int cantidad=monedero.getPilaSize(type);
        if (cantidad!=0) {
            monedero.changeSelection(type);
            texto.setText("x"+cantidad);
            this.revalidate();
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}

