package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HoangTu on 12/07/2017.
 */
public class Map {
    private int x;
    private int y;
    public int bit;
    Image[] images = {
            new ImageIcon(getClass().getResource("/images/wall.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/bean_3_1.png")).getImage(),

    };
    public Map(int x, int y, int bit) {
        super();
        this.x = x;
        this.y = y;
        this.bit = bit;
    }
    public void draw(Graphics2D g2d) {
        if (bit > 0) {
            g2d.drawImage(images[bit - 1], x, y, null);
        }
    }
    public Rectangle getRect() {
        int w = images[bit - 1].getWidth(null);
        int h = images[bit - 1].getHeight(null);
        Rectangle rectangle = new Rectangle(x, y, w, h);
        return rectangle;
    }
    public int getBit() {
        return bit;
    }
}
