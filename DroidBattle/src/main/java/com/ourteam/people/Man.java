package com.ourteam.people;

import com.ourteam.controllers.iDrawable;
import com.ourteam.maps.Position;

public abstract class Man implements iDrawable {
    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}
