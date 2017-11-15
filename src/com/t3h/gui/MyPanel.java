package com.t3h.gui;

import manager.GameManager;
import model.Pac;
import model.PacBoss;
import model.PacMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

/**
 * Created by HoangTu on 07/07/2017.
 */
public class MyPanel extends JPanel implements KeyListener,Runnable {

    private GameManager gameManager = new GameManager();
    private Boolean isRunning = true;
    private BitSet bitSet = new BitSet(256);
    private PanelGame panelGame;

    public MyPanel(PanelGame panelGame){
        this.panelGame=panelGame;
        setBackground(Color.BLACK);
        gameManager.initGame();
        setFocusable(true);

        addKeyListener(this);
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {
                requestFocusInWindow();
            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
        Thread thread = new Thread(this);
        thread.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        gameManager.draw(g2d);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        bitSet.set(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        bitSet.clear(e.getKeyCode());

    }

    @Override
    public void run() {
        while (isRunning){
                if (bitSet.get(KeyEvent.VK_LEFT)){
                    gameManager.playMove(Pac.LEFT);
                }else if (bitSet.get(KeyEvent.VK_RIGHT)){
                    gameManager.playMove(Pac.RIGHT);
                }else if (bitSet.get(KeyEvent.VK_UP)){
                    gameManager.playMove(Pac.UP);
                }else if (bitSet.get(KeyEvent.VK_DOWN)){
                    gameManager.playMove(Pac.DOWN);
                }
                isRunning=gameManager.AI();
                if (isRunning==false){
                int reult = JOptionPane.showConfirmDialog(null,"Do you want to replay? ","Game over",
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (reult == JOptionPane.YES_OPTION){
                    gameManager.initGame();
                    bitSet.clear();
                    isRunning = true;
                }
                else {
                    System.exit(0);
                }
            }
                repaint();
            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
