package Grafico;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import Logica.Monedas.*;

import static javax.swing.SwingConstants.CENTER;

public class DibujarMoneda extends JComponent implements MouseListener {
    private int h,w;
    private BufferedImage image;
    private ArrayList<Moneda> monedero;
    private Moneda efectivo;
    private int cantidad;
    private JLabel texto=new JLabel("inicio");

    public DibujarMoneda(int w, int h, ArrayList<Moneda> monederito){
        image=null;
        setLayout(null);
        this.w=w;
        this.h=h;
        addMouseListener(this);
        this.monedero=monederito;
        cantidad=monedero.size();
        efectivo=null;
        if(cantidad!=0){
            int valor=monedero.get(0).getValor();
            setImage(valor);
        }
    }

    public void setImage(int valor){
        try {
            if(valor==100){image = ImageIO.read(new File("src/main/resources/Moneda100.png"));}
            else if(valor==500){image = ImageIO.read(new File("src/main/resources/Moneda500.png"));}
            else if(valor==1000){image = ImageIO.read(new File("src/main/resources/Moneda1000.png"));}
            else if(valor==1500){image = ImageIO.read(new File("src/main/resources/Moneda1500.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null) {
            g2d.drawImage(image, 0, 0, w, h-15,this);
            texto.setText("x"+this.cantidad);
            texto.setOpaque(true);
            texto.setBackground(new Color(50,50,50));
            texto.setForeground(Color.BLUE);
            texto.setBounds(w/2-8,h-30,15,15);
            this.add(texto);
        }
    }

    public Moneda getEfectivo(){
        return efectivo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (cantidad!=0) {
            efectivo = monedero.get((cantidad-1));
            this.monedero.remove(efectivo);
            this.cantidad--;
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

