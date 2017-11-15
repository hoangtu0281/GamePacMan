package com.t3h.gui;

import view.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HoangTu on 17/07/2017.
 */
public class PanelMenu extends JPanel implements ActionListener {
    private MyPanel myPanel;
    private MyButton btplay;
    private MyButton bthighScore;
    private MyButton btAbout;
    private PanelGame panelGame;
    public PanelMenu(PanelGame panelGame){
        this.panelGame= panelGame;
        setLayout(null);
        setLocation(0,0);
        setBackground(Color.BLACK);
        initCompoents();
    }

    private void initCompoents() {
        btplay = new MyButton("play-game_1.png","play-game_2.png");
        btplay.setLocation(130,270);
        btplay.addActionListener(this);
        add(btplay);

        bthighScore = new MyButton("high-score_1.png","high-score_2.png");
        bthighScore.setLocation(127,315);
        bthighScore.addActionListener(this);
        add(bthighScore);

        btAbout = new MyButton("button_1.png","button_2.png");
        btAbout.setLocation(153,360);
        btAbout.addActionListener(this);
        add(btAbout);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btplay)){
            panelGame.switchPanel(panelGame.TAG_GAME);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        Image images = new ImageIcon(getClass().getResource("/images/menu.jpg")).getImage();
        g2d.drawImage(images,9,9,null);
    }
}
