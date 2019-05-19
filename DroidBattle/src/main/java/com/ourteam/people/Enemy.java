package com.ourteam.people;

import com.ourteam.maps.Map;
import com.ourteam.maps.Position;
import com.ourteam.maps.Screen;

public class Enemy extends Man {

    @Override
    public void draw(Position position) {
        this.setPos(position);

        Screen.getInstance().getScreen()[position.getY() + 3][position.getX()] = '/';
        Screen.getInstance().getScreen()[position.getY() + 3][position.getX() + 1] = '\\';
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX() + 1] = '︻';
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX()] = '╦';
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX() - 1] = '╤';
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX() - 2] = '─';
        Screen.getInstance().getScreen()[position.getY()][position.getX()] = '☻'; // 3 1
        Screen.getInstance().getScreen()[position.getY() + 2][position.getX()] = ' ';
        Screen.getInstance().getScreen()[position.getY() + 2][position.getX()] = '|';
    }

    public void clearEnemy(Position position){
        int [][] arr = Map.getInstance().getScheme();
        Screen.getInstance().getScreen()[position.getY() + 3][position.getX()] = ' ';
        arr[position.getY() + 3][position.getX() + Map.getInstance().getCurrentPos()] = 0;
        Screen.getInstance().getScreen()[position.getY() + 3][position.getX() + 1] = ' ';
        arr[position.getY() + 3][position.getX() + 1 + Map.getInstance().getCurrentPos()] = 0;
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX() + 1] = ' ';
        arr[position.getY() + 1][position.getX() + 1 + Map.getInstance().getCurrentPos()] = 0;
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX()] = ' ';
        arr[position.getY() + 1][position.getX() + Map.getInstance().getCurrentPos()] = 0;
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX() - 1] = ' ';
        arr[position.getY() + 1][position.getX() - 1 + Map.getInstance().getCurrentPos()] = 0;
        Screen.getInstance().getScreen()[position.getY() + 1][position.getX() - 2] = ' ';
        arr[position.getY() + 1][position.getX() - 2 + Map.getInstance().getCurrentPos()] = 0;

        Screen.getInstance().getScreen()[position.getY()][position.getX()] = ' ';
        arr[position.getY()][position.getX() + Map.getInstance().getCurrentPos()] = 0;
        Screen.getInstance().getScreen()[position.getY() + 2][position.getX()] = ' ';
        arr[position.getY() + 2][position.getX() + Map.getInstance().getCurrentPos()] = 0;

        Map.getInstance().setScheme(arr);
    }
}
