package com.ourteam.controllers;

import com.ourteam.maps.Map;
import com.ourteam.maps.Screen;
import com.ourteam.people.Bullet;

import java.util.ArrayList;
import java.util.List;

public class BulletsController {

    List<Bullet> bulletList = null;

    public BulletsController() {
        bulletList = new ArrayList<>();
    }

    public void recalculate() {
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = bulletList.get(i);
            if (!bullet.isAlive()) {
                bullet.clearBullet();
                removeBullet(bullet);
            }
        }
        bulletList.forEach(i -> i.move());
    }

    public void addBullet(Bullet bullet) {
        bulletList.add(bullet);
    }

    public void removeBullet(Bullet bullet) {
        bulletList.remove(bullet);
    }
}
