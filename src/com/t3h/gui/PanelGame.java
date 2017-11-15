package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HoangTu on 19/07/2017.
 */
public class PanelGame extends JPanel {
    public static final String TAG_GAME = "game";
    public static final String TAG_MENU = "menu";
    private MyPanel myPanel;
    private PanelMenu panelMenu;
    private CardLayout cardLayout = new CardLayout();
    public PanelGame(){
        setLayout(cardLayout);
        setBackground(Color.BLACK);
        panelMenu = new PanelMenu(this);
        myPanel = new MyPanel(this);
        add(panelMenu,TAG_MENU);
        add(myPanel,TAG_GAME);
        cardLayout.show(this,TAG_MENU);
    }
    public void switchPanel(String tag){
        cardLayout.show(this,tag);
    }
}
