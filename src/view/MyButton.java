package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HoangTu on 17/07/2017.
 */
public class MyButton extends JButton implements MouseListener {
    private Image imageButton1;
    private Image imageButton2;
    private Image imageButton;

    public MyButton(String imageButton1, String imageButton2) {
        this.imageButton1 = new ImageIcon(getClass().getResource("/images/"+imageButton1)).getImage();
        this.imageButton2 = new  ImageIcon(getClass().getResource("/images/"+imageButton2)).getImage();
        this.imageButton = this.imageButton2;
        setSize(imageButton.getWidth(null),imageButton.getHeight(null));
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(imageButton,0,0,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        imageButton = imageButton1;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        imageButton = imageButton2;
        repaint();
    }
}
