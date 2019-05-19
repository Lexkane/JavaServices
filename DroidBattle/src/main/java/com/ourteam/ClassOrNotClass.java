package com.ourteam;

import com.ourteam.controllers.BulletsController;
import com.ourteam.controllers.HeroController;
import com.ourteam.controllers.ITimeControl;
import com.ourteam.controllers.TimeController;
import com.ourteam.gui.CustomConsole;
import com.ourteam.maps.Level;
import com.ourteam.maps.Map;
import com.ourteam.maps.Position;
import com.ourteam.maps.Screen;
import com.ourteam.people.Bullet;
import com.ourteam.people.Hero;

import java.awt.*;
import java.util.Objects;

/**
 * Class for testing.
 *
 * @author Андрiй
 */
public class ClassOrNotClass implements ITimeControl {

    private TimeController timeBulletController = null;
    private TimeController timeGameController = null;
    private BulletsController bulletsController = null;
    private HeroController heroController = null;

    private CustomConsole customConsole = null;

    private Level level = null;
    private Hero hero = null;

    private int bulletTimePeriod = 100;
    private int gameTimePeriod = 200;

    public ClassOrNotClass() {
        timeBulletController = new TimeController(this, bulletTimePeriod);
        timeGameController = new TimeController(this, gameTimePeriod);
        bulletsController = new BulletsController();
        heroController = new HeroController(customConsole);

        customConsole = new CustomConsole();
        customConsole.setKeyHandler(heroController.getKeyHandler());
        customConsole.setVisible(true);

        level = new Level(1);

//        currentScreen = new Screen(10, 20);
        hero = new Hero();
        heroController.setHero(hero);
        Map.getInstance().setLevel(level);

        Map.getInstance().draw(null);
        hero.draw(new Position(Screen.getInstance().getHeight() - 5, 2));
        Screen.getInstance().print();

        timeBulletController.start();
        timeGameController.start();
    }

    /**
     * Bullets timer
     */
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
//            heroController.sitOrStand(currentMap, currentScreen);
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

    public static void main(String[] args) {
        EventQueue.invokeLater(ClassOrNotClass::new);
    }
}
