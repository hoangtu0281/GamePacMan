package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HoangTu on 20/07/2017.
 */
public class PacBoss3 extends Pac {
    Random random = new Random();
    public PacBoss3(int x, int y) {
        super(x, y, UP);
        imageLeft = new Image[]{
                new ImageIcon(getClass().getResource("/images/pinky_7.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pinky_8.png")).getImage(),

        };
        imageRight = new Image[]{
                new ImageIcon(getClass().getResource("/images/pinky_3.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pinky_4.png")).getImage(),

        };
        imageUp = new Image[]{
                new ImageIcon(getClass().getResource("/images/pinky_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pinky_2.png")).getImage(),

        };
        imageDown = new Image[]{
                new ImageIcon(getClass().getResource("/images/pinky_5.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pinky_6.png")).getImage(),

        };
        orient = RIGHT;
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
