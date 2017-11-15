package manager;

import audio.SoundManager;
import model.*;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

/**
 * Created by HoangTu on 07/07/2017.
 */
public class GameManager {
    public PacMan pacMan;
    private ArrayList<PacBoss> arrBoss;
    private ArrayList<PacBoss1> arrBoss1;
    private ArrayList<PacBoss2> arrBoss2;
    private ArrayList<PacBoss3> arrBoss3;
    private ArrayList<Map> arrMap;

    Random random = new Random();

    private void ReadMap(String map) {
        arrMap = new ArrayList<>();
        File file = new File("src/map/" + map);
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int row = 0;
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    int x = i * 20;
                    int y = row * 20;
                    int bit = Integer.parseInt(line.charAt(i) + "");
                    if (bit != 0) {
                        arrMap.add(new Map(x, y, bit));
                    }
                }
                row++;
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void initGame() {
        Clip clip = SoundManager.getSound("pacman_beginning.wav");
        clip.start();
        pacMan = new PacMan(200, 300);
        arrBoss = new ArrayList<>();
        arrBoss1 = new ArrayList<>();
        arrBoss2 = new ArrayList<>();
        arrBoss3 = new ArrayList<>();
        initBoss();
        ReadMap("map.txt");
    }

    private void initBoss() {
        PacBoss pacBoss = new PacBoss(300, 200);
        arrBoss.add(pacBoss);
        PacBoss1 pacBoss1 = new PacBoss1(100, 380);
        arrBoss1.add(pacBoss1);
        PacBoss2 pacBoss2 = new PacBoss2(200, 220);
        arrBoss2.add(pacBoss2);
        PacBoss3 pacBoss3 = new PacBoss3(300, 380);
        arrBoss3.add(pacBoss3);
    }

    public void draw(Graphics2D g2d) {

        try {
            for (Map map : arrMap) {
                map.draw(g2d);
            }
            for (PacBoss pacBoss : arrBoss) {
                pacBoss.draw(g2d);
            }
            for (PacBoss1 pacBoss1:arrBoss1){
                pacBoss1.draw(g2d);
            }
            for (PacBoss2 pacBoss2:arrBoss2){
                pacBoss2.draw(g2d);
            }
            for (PacBoss3 pacBoss3:arrBoss3){
                pacBoss3.draw(g2d);
            }
            pacMan.draw(g2d);

        } catch (ConcurrentModificationException ex) {
        }
    }

    public void playMove(int newOrient)
    {
        pacMan.changeOrient(newOrient);
    }

    public boolean AI() {
        pacMan.move(arrMap);
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).move(arrMap);
            boolean check = arrBoss.get(i).checkdie(arrBoss,arrBoss1,arrBoss2,arrBoss3);
            if (check == false){
                arrBoss.remove(i);
            }
        }
        for (int i = arrBoss1.size() - 1; i >= 0; i--) {
            arrBoss1.get(i).move(arrMap);
            boolean check = arrBoss1.get(i).checkdie(arrBoss,arrBoss1,arrBoss2,arrBoss3);
            if (check == false){
                arrBoss1.remove(i);
            }
        }
        for (int i = arrBoss2.size() - 1; i >= 0; i--) {
            arrBoss2.get(i).move(arrMap);
            boolean check = arrBoss2.get(i).checkdie(arrBoss,arrBoss1,arrBoss2,arrBoss3);
            if (check == false){
                arrBoss2.remove(i);
            }
        }
        for (int i = arrBoss3.size() - 1; i >= 0; i--) {
            arrBoss3.get(i).move(arrMap);
            boolean check = arrBoss3.get(i).checkdie(arrBoss,arrBoss1,arrBoss2,arrBoss3);
            if (check == false){
                arrBoss3.remove(i);
            }
        }
        return pacMan.checkdie(arrBoss,arrBoss1,arrBoss2,arrBoss3);
    }
}


