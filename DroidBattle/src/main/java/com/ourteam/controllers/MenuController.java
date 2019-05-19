package com.ourteam.controllers;

import com.ourteam.gui.AbstractKeyHandler;
import com.ourteam.gui.CustomConsole;
import com.ourteam.gui.Settings;
import com.ourteam.menu.*;

import java.awt.event.KeyEvent;

public class MenuController {
    private CustomConsole customConsole = null;

    private Menu menu = null;
    private MenuEntry selectedEntry;

    public MenuController(CustomConsole customConsole, Menu menu) {
        this.customConsole = customConsole;
        this.menu = menu;
    }

    private void start() {
            selectedEntry = new StartEntry();
            selectedEntry.run(customConsole);
    }

    private void selectLevel() {
            selectedEntry = new LevelEntry();
            selectedEntry.run(customConsole);
    }

    private void showControls() {
            selectedEntry = new ControlsEntry();
            selectedEntry.run(customConsole);
    }

    private void exit() {
            selectedEntry = new ExitEntry();
            selectedEntry.run(customConsole);
    }

    private void back() {
            customConsole.clearBuffer();
            menu.printMenu();
    }

    public AbstractKeyHandler getKeyHandler() {
        return new AbstractKeyHandler() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == Settings.startButton) {
                    start();
                }
                if (e.getKeyCode() == Settings.levelButton) {
                    selectLevel();
                }
                if (e.getKeyCode() == Settings.controlsButton) {
                    showControls();
                }
                if(e.getKeyCode() == Settings.exitButton) {
                    exit();
                }

                if(e.getKeyCode() == Settings.back) {
                    back();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

}
