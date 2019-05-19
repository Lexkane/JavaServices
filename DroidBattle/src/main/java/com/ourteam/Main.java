package com.ourteam;

import com.ourteam.gui.CustomConsole;
import com.ourteam.maps.Level;
import com.ourteam.maps.Map;
import com.ourteam.maps.Pause;
import com.ourteam.maps.Position;
import com.ourteam.maps.Screen;
import com.ourteam.people.Bullet;
import com.ourteam.people.Hero;

public class Main {

    public static void main(String[] args) {

        int levelNumber = 1;
        CustomConsole customConsole = null;
        //Screen screen = new Screen(10, 68);
        Hero hero = new Hero();
        Level level = new Level(1);
        Map.getInstance().setLevel(level);
        Map.getInstance().draw(null);
        hero.draw(new Position(Screen.getInstance().getHeight() - 5, 2));
        new Pause(customConsole, Screen.getInstance(), 1, 2).pause();
        Screen.getInstance().print();
//        hero.move(map, screen);
//        map.draw(null, screen);
//        hero.draw(hero.getPos(), screen);
//        screen.print();
//        hero.move(map, screen);
//        map.draw(null, screen);
//        hero.draw(hero.getPos(), screen);
//        screen.print();
//        hero.move(map, screen);
//        map.draw(null, screen);
//        hero.draw(hero.getPos(), screen);
//        screen.print();
//        hero.move(map, screen);
//        map.draw(null, screen);
//        hero.draw(hero.getPos(), screen);
//        screen.print();
//        try {
//            hero.jump(map, hero.getPos(), screen);
//            hero.jump(map, hero.getPos(), screen);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Bullet bl = hero.fire(screen);
//        bl.draw(bl.getPosition(), screen);
//        screen.print();
//        try {
//            hero.jump(map, hero.getPos(), screen);
//
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//            Thread.sleep(1000);
//            bl.move(map, screen);
//            screen.print();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}