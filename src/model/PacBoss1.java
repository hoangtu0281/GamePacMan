package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HoangTu on 20/07/2017.
 */
public class PacBoss1 extends Pac {
    Random random = new Random();
    public PacBoss1(int x, int y) {
        super(x, y, DOWN);
        imageLeft = new Image[]{
                new ImageIcon(getClass().getResource("/images/clyde_7.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/clyde_8.png")).getImage(),

        };
        imageRight = new Image[]{
                new ImageIcon(getClass().getResource("/images/clyde_3.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/clyde_4.png")).getImage(),

        };
        imageUp = new Image[]{
                new ImageIcon(getClass().getResource("/images/clyde_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/clyde_2.png")).getImage(),

        };
        imageDown = new Image[]{
                new ImageIcon(getClass().getResource("/images/clyde_5.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/clyde_6.png")).getImage(),

        };
        orient =DOWN;
    }

    private void createOrient() {
        int persen = random.nextInt(101);//randon từ 0 - > 100;
        if (persen < 97) {
            return;
        }
        int newOrient = random.nextInt(4);// là giá trị giới hạn
        changeOrient(newOrient);
    }

    @Override
    public void move(ArrayList<Map> arrMap) {
        createOrient();
        super.move(arrMap);
    }
}
