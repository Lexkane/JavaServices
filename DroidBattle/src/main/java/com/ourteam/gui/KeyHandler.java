package com.ourteam.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Realisation ot this class is used in CustomConsole.setKeyHandler()
 *
 * @version 1.0
 */
public abstract class KeyHandler extends KeyAdapter {

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);
}
