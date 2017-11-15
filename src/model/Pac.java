package model;

import audio.SoundManager;
import com.t3h.gui.MyFrame;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HoangTu on 07/07/2017.
 */
public class Pac {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    protected Image[] imageLeft;
    protected Image[] imageRight;
    protected Image[] imageUp;
    protected Image[] imageDown;
    protected Image[] images;

    public int index;
    public int x;
    public int y;
    protected int orient;
    private int countMove = 0;
    private long lastime;

    public Pac(int x, int y, int orient) {
        super();
        this.x = x;
        this.y = y;
        this.orient = orient;
    }
    private void changeIndex() {
        if (images == null) {
            return;
        }
        index++;
        if (index >= images.length) {
            index = 0;
        }
    }
    protected Image[] getImages() {
        switch (orient) {
            case LEFT:
                return imageLeft;
            case RIGHT:
                return imageRight;
            case UP:
                return imageUp;
            case DOWN:
                return imageDown;
            default:
                return null;
        }
    }
    public void draw(Graphics2D g2d) {
        images = getImages();
        g2d.drawImage(images[index], x, y, null);
    }
    public void changeOrient(int newOrient) {
        if (newOrient != orient) {
            index = 0;
        }
        orient = newOrient;
    }
    public void move(ArrayList<Map> arrMap) {
        countMove++;// tăng số lần contMove nếu lớn hơn thì đổi ảnh
        if (countMove >= 4) {
            changeIndex();
            countMove = 0;
        }
        int speed = 1;
        int xR = x;
        int yR = y;
        switch (orient) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
        if (x >= MyFrame.W_FRAME) {
            x = 0;
        }
        if (x < 0) {
            x = MyFrame.W_FRAME;
        }
        if (y >= MyFrame.H_FRAME) {
            y = 0;
        }
        if (y < 0) {
            y = MyFrame.H_FRAME;
        }
        boolean check = checkMap(arrMap);
        if (check == false) {
            x = xR;
            y = yR;
        }
    }
    private boolean checkMap(ArrayList<Map> arrMap) {
        for (Map map : arrMap) {
            Rectangle rect = getRect().intersection(map.getRect());
            if (map.getBit() != 2) {
                if (!rect.isEmpty()) {
                    return false;
                }
            }
                if (rect.isEmpty() == false && !(this instanceof PacBoss) && !(this instanceof PacBoss1) && !(this instanceof PacBoss2) &&
                        !(this instanceof PacBoss3)) {
                    Clip clip = SoundManager.getSound("sound_114.wav");
                    clip.start();
                    arrMap.remove(map);
                    return false;
                }
            }
        return true;
    }

    public Rectangle getRect() {
        images = getImages();
        int w = images[index].getWidth(null);
        int h = images[index].getHeight(null);
        if (orient == UP || orient == DOWN) {
            w -= 3;
            h -= 3;
        } else if (orient == LEFT || orient == RIGHT) {
            h -= 3;
            w -= 3;
        }
        Rectangle rectangle = new Rectangle(x, y, w, h);
        return rectangle;
    }
    public boolean checkdie(ArrayList<PacBoss> arrBoss,ArrayList<PacBoss1> arrBoss1,ArrayList<PacBoss2> arrBoss2,
                            ArrayList<PacBoss3> arrBoss3){
        for (PacBoss pacBoss: arrBoss){
            Rectangle rectangle = getRect().intersection(pacBoss.getRect());
            if(rectangle.isEmpty()==false && this instanceof PacMan) {
                arrBoss.remove(pacBoss);
                Clip clip = SoundManager.getSound("sound_112.wav");
                clip.start();
                return false;
            }
        }
        for (PacBoss1 pacBoss1: arrBoss1){
            Rectangle rectangle = getRect().intersection(pacBoss1.getRect());
            if(rectangle.isEmpty()==false && this instanceof PacMan) {
                arrBoss1.remove(pacBoss1);
                Clip clip = SoundManager.getSound("sound_112.wav");
                clip.start();
                return false;
            }
        }
        for (PacBoss2 pacBoss2: arrBoss2){
            Rectangle rectangle = getRect().intersection(pacBoss2.getRect());
            if(rectangle.isEmpty()==false && this instanceof PacMan) {
                arrBoss2.remove(pacBoss2);
                Clip clip = SoundManager.getSound("sound_112.wav");
                clip.start();
                return false;
            }
        }
        for (PacBoss3 pacBoss3: arrBoss3){
            Rectangle rectangle = getRect().intersection(pacBoss3.getRect());
            if(rectangle.isEmpty()==false && this instanceof PacMan) {
                arrBoss3.remove(pacBoss3);
                Clip clip = SoundManager.getSound("sound_112.wav");
                clip.start();
                return false;
            }
        }
        return true;
    }
}

