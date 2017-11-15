package com.t3h.gui;

import com.sun.xml.internal.ws.handler.HandlerException;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by HoangTu on 07/07/2017.
 */
public class MyFrame extends JFrame implements WindowListener {
    public static final int W_FRAME = 427;
    public static final int H_FRAME = 451;
    public MyPanel myPanel;
    public PanelGame panelGame;

    public MyFrame()throws HandlerException{
        setTitle("PacMan");
        setSize(W_FRAME,H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        //PanelMenu panelMenu = new PanelMenu();
       //add(panelMenu);
        panelGame = new PanelGame();
        add(panelGame);
//        myPanel = new MyPanel();
//        add(myPanel);
        setVisible(true);

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Ban muon that chuong trinh ?",
                "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
