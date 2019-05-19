package com.ourteam.menu;

import com.ourteam.ClassOrNotClass;
import com.ourteam.controllers.GameStartController;
import com.ourteam.gui.CustomConsole;

import java.awt.*;

public class StartEntry extends MenuEntry {
    private GameStartController starter = null;

    public StartEntry() {
        this.setExplanation("Start game");
    }

    public void run(CustomConsole customConsole) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameStartController(customConsole);
            }
        });
    }
}


