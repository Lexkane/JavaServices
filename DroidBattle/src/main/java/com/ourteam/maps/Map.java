package com.ourteam.maps;

import com.ourteam.controllers.*;
import com.ourteam.people.Enemy;
import com.ourteam.people.Hero;

public class Map implements iDrawable {

    private static Map instance;

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    private Level level;
    private Hero hero;
    private int currentPos;
    private int[][] scheme;

    public void setLevel(Level level) {
        this.level = level;
        this.scheme = level.returnLevel();
    }

    public int[][] getScheme() {
        return scheme;
    }

    public void setScheme(int[][] scheme) {
        this.scheme = scheme;
    }

    public void draw(Position pos) {
        for (int i = 0; i < Screen.getInstance().getHeight(); i++) {

            for (int j = 0; j < Screen.getInstance().getWidth(); j++) {

                switch (getScheme()[i][j + this.currentPos]) {
                    case 0:
                        if (Screen.getInstance().getScreen()[i][j] != ' ') {
                            Screen.getInstance().getScreen()[i][j] = ' ';
                        }
                        break;
                    case 1:
                        Screen.getInstance().getScreen()[i][j] = '▀';
                        break;
                    case 2:
                        Screen.getInstance().getScreen()[i][j] = '░';
                        break;
                    case 3:
                        if (j + 1 < Screen.getInstance().getWidth()) {
                            new Enemy().draw(new Position(i, j));
                        }
                        break;
                    case 8:
                        Screen.getInstance().getScreen()[i][j] = '3';
                        break;
                    case 9:
                        Screen.getInstance().getScreen()[i][j] = '♥';
        }
            }
        }
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public boolean cellIsEmpty(Position pos) {
        if (getScheme()[pos.getY()][pos.getX() + this.currentPos] == 0) {
            return true;
        } else {
            return false;
        }
    }
}

//  public boolean cellIsFloor(Position pos) {
//    if (getScheme()[pos.getY()][pos.getX() + this.currentPos] == 1) {
//      return true;
//    } else {
//      return false;
//    }
//  }
//}
//
