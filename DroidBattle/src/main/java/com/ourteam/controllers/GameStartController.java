package com.ourteam.controllers;

import com.ourteam.gui.CustomConsole;
import com.ourteam.maps.Level;
import com.ourteam.maps.Map;
import com.ourteam.maps.Position;
import com.ourteam.maps.Screen;
import com.ourteam.people.Bullet;
import com.ourteam.people.Hero;

import java.awt.event.KeyListener;
import java.util.Objects;

public class GameStartController implements ITimeControl {
    private TimeController timeBulletController = null;
    private TimeController timeGameController = null;
    private BulletsController bulletsController = null;
    private HeroController heroController = null;

    private Map currentMap = null;
    private Level level = null;
    private Screen currentScreen = null;

    private Hero hero = null;

    private int bulletTimePeriod = 100;
    private int gameTimePeriod = 200;

    public GameStartController(CustomConsole customConsole) {
        timeBulletController = new TimeController(this, bulletTimePeriod);
        timeGameController = new TimeController(this, gameTimePeriod);
        bulletsController = new BulletsController();

        heroController = new HeroController(customConsole);

        level = new Level(1);
        Screen.getInstance().setCustomConsole(customConsole);
        Screen.getInstance().setWidth(level.returnLevel()[0].length);
        Screen.getInstance().setHeight(level.returnLevel().length);
        Screen.getInstance().setScreen(new char[level.returnLevel().length][level.returnLevel()[0].length]);

        customConsole.setKeyHandler(heroController.getKeyHandler());


        hero = new Hero();
        heroController.setHero(hero);
        Map.getInstance().setLevel(level);

        Map.getInstance().draw(null);
        hero.draw(new Position(Screen.getInstance().getHeight() - 5, 2));
        Screen.getInstance().print();
        timeBulletController.start();
        timeGameController.start();
    }

    @Override
    public void onTimeHasCome(int period) {
        if (period == this.bulletTimePeriod) {
            if (Objects.isNull(bulletsController) || Objects.isNull(hero)
                    || Objects.isNull(Map.getInstance()) || Objects.isNull(Screen.getInstance())) {
                return;
            }

            Bullet bullet = heroController.fire();
            if (bullet != null) {
                bulletsController.addBullet(bullet);
            }
            bulletsController.recalculate();
            Screen.getInstance().print();
        } else if (period == this.gameTimePeriod) {
            try {
                heroController.move();
            } catch (Exception e) {
                System.out.println("Exception caught in onTimeHasCome: " + e);
                e.printStackTrace();
            }
        }
    }


}
