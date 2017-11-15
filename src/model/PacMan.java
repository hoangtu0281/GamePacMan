package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HoangTu on 07/07/2017.
 */
public class PacMan extends Pac {
    Random random = new Random();
    public PacMan(int x, int y) {
        super(x, y,DOWN);
        imageLeft = new Image[]{
                new ImageIcon(getClass().getResource("/images/pacman_left_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_left_2.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_left_3.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_0.1.png")).getImage(),
        };
        imageRight = new Image[]{
                new ImageIcon(getClass().getResource("/images/pacman_right_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_right_2.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_right_3.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_0.1.png")).getImage(),
        };
        imageUp = new Image[]{
                new ImageIcon(getClass().getResource("/images/pacman_top_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_top_2.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_top_3.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_0.1.png")).getImage(),
        };
        imageDown = new Image[]{
                new ImageIcon(getClass().getResource("/images/pacman_down_1.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_down_2.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_down_3.png")).getImage(),
                new ImageIcon(getClass().getResource("/images/pacman_0.1.png")).getImage(),
        };
       orient  = LEFT;   }
}
