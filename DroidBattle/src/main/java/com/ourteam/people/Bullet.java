package com.ourteam.people;

import com.ourteam.controllers.iDrawable;
import com.ourteam.controllers.iMovable;
import com.ourteam.maps.Map;
import com.ourteam.maps.Position;
import com.ourteam.maps.Screen;

/**
 *
 */
public class Bullet implements iMovable , iDrawable{
    private boolean direction;
    private Position position;

    public Bullet(boolean direction, Position position){
        this.direction = direction;
        this.position = position;
    }
    public boolean getDirection(){
        return this.direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Checks the bullet is not out of screen
     *
     * @return true if bullet is in screen range, false - otherwise
     */
    public boolean isAlive() {
        if (this.getPosition().getX() + 1 >= Screen.getInstance().getWidth())
            return false;
        return true;
    }

    @Override
    public void move() {
        clearBullet();
        if(this.getPosition().getX() + 1 >= Screen.getInstance().getWidth())
            return;

        switch (Map.getInstance().getScheme()[this.getPosition().getY()][this.getPosition().getX() + 1]) {
            case 0:
                this.draw(new Position(this.getPosition().getY(),this.getPosition().getX() + 1));
                this.setPosition(new Position(this.getPosition().getY(),this.getPosition().getX() + 1));
                break;
            case 1:
            case 2:
                break;
            case 3:
                new Enemy().clearEnemy(new Position(this.getPosition().getY(),this.getPosition().getX() + 1));
                break;
            case 4:
                new Enemy().clearEnemy(new Position(this.getPosition().getY() - 1,this.getPosition().getX() + 3));
                break;
            case 5:
                new Enemy().clearEnemy(new Position(this.getPosition().getY() - 2,this.getPosition().getX() + 1));
                break;
            case 6:
                new Enemy().clearEnemy(new Position(this.getPosition().getY() - 3,this.getPosition().getX() + 1));
                break;
        }
    }

    @Override
    public void draw(Position pos) {
        Screen.getInstance().getScreen()[pos.getY()][pos.getX()] = '*';
    }
    public void clearBullet(){
        Screen.getInstance().getScreen()[this.getPosition().getY()][this.getPosition().getX()] = ' ';

    }
}
