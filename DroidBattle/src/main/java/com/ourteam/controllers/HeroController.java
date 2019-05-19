package com.ourteam.controllers;

import com.ourteam.gui.AbstractKeyHandler;
import com.ourteam.gui.CustomConsole;
import com.ourteam.gui.Settings;
import com.ourteam.maps.Map;
import com.ourteam.maps.Position;
import com.ourteam.maps.Screen;
import com.ourteam.people.Bullet;
import com.ourteam.people.Hero;


import java.awt.*;
import java.awt.event.KeyEvent;

public class HeroController {

    private Hero hero = null;
    private CustomConsole customConsole;

    private boolean isJumpPressed;
    private boolean isMoveLeftPressed;
    private boolean isMoveBtnPressed;
    private boolean isFirePressed;
    private boolean isSat;

    public HeroController(CustomConsole customConsole) {
        this.customConsole = customConsole;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void move() throws Exception {
        if (isMoveBtnPressed) {
            hero.move();
        }

        if (isJumpPressed) {
            hero.jump(hero.getPos());
        }

        if(isMoveLeftPressed) {
            hero.moveLeft();
        }

    }

    public void sitOrStand() {
        if (isSat) {
            hero.sit(hero.getPos());
        } else {
            hero.standUp(hero.getPos());
            //hero.draw(new Position(hero.getPos().getY() - 2, hero.getPos().getX()));
        }

    }

    public Bullet fire() {
        if (isFirePressed)
            return hero.fire();
        else return null;
    }

    private void restart() {
        customConsole.clear();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameStartController(customConsole);
            }
        });
    }

    public AbstractKeyHandler getKeyHandler() {
        return new AbstractKeyHandler() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == Settings.jumpButton) {
                    isJumpPressed = true;
                }
                if (e.getKeyCode() == Settings.moveButton) {
                    isMoveBtnPressed = true;
                }
                if (e.getKeyCode() == Settings.sitButton) {
                    isSat = true;
                    sitOrStand();
                }
                if(e.getKeyCode() == Settings.moveLeftButton) {
                    isMoveLeftPressed = true;
                }
                if (e.getKeyCode() == Settings.fireButton) {
                    isFirePressed = true;
                }
                if (e.getKeyCode() == Settings.restartButton) {
                    restart();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == Settings.jumpButton) {
                    isJumpPressed = false;
                }
                if (e.getKeyCode() == Settings.moveButton) {
                    isMoveBtnPressed = false;
                }
                if(e.getKeyCode() == Settings.moveLeftButton) {
                    isMoveLeftPressed = false;
                }
                if (e.getKeyCode() == Settings.sitButton) {
                    isSat = false;
                    sitOrStand();
                }
                if (e.getKeyCode() == Settings.fireButton) {
                    isFirePressed = false;
                }
            }
        };
    }
}
