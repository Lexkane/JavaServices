package com.ourteam.people;

import com.ourteam.controllers.*;
import com.ourteam.maps.*;

public class Hero extends Man implements iMovable, iDrawable {
  //змінна яка допомагає перевірити чи можна пригнути або впасти
  //  зміщення від голови

  private final int JUMP_LENGTH = 4;
  private int healthPoints;

  public Hero() {
    this.healthPoints = 3;
  }

  public void draw(Position position) {
    this.setPos(position);
    Screen.getInstance().getScreen()[position.getY()][position.getX()] = '☺';
    Screen.getInstance().getScreen()[position.getY() + 1][position.getX() - 2] = '︻';
    Screen.getInstance().getScreen()[position.getY() + 1][position.getX() - 1] = '╦';
    Screen.getInstance().getScreen()[position.getY() + 1][position.getX()] = '╤';
    Screen.getInstance().getScreen()[position.getY() + 1][position.getX() + 1] = '─';
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX() - 1] = '|';
    Screen.getInstance().getScreen()[position.getY() + 3][position.getX() - 1] = '/';
    Screen.getInstance().getScreen()[position.getY() + 3][position.getX()] = '\\';
  }

  private void drawSit(Position position) {
    this.setPos(position);
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX()
        - 2] = '◢';
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX()
        - 1] = '╦';
    Screen.getInstance().getScreen()[position.getY() + 2][position
        .getX()] = '╤';
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX()
        + 1] = '─';
    Screen.getInstance().getScreen()[position.getY() + 1][position
        .getX()] = '☺';
  }

  private void clearSittingHero(Position position) {
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX()
        - 2] = ' ';
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX()
        - 1] = ' ';
    Screen.getInstance().getScreen()[position.getY() + 2][position
        .getX()] = ' ';
    Screen.getInstance().getScreen()[position.getY() + 2][position.getX()
        + 1] = ' ';
    Screen.getInstance().getScreen()[position.getY() + 1][position
        .getX()] = ' ';
  }

  private void clearHero() {
    Screen.getInstance().getScreen()[this.getPos().getY() + 3][
        this.getPos().getX()
            - 1] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY() + 3][this.getPos()
        .getX()] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY() + 1][
        this.getPos().getX()
            - 2] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY() + 1][
        this.getPos().getX()
            - 1] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY() + 1][this.getPos()
        .getX()] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY() + 1][
        this.getPos().getX()
            + 1] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY()][this.getPos()
        .getX()] = ' ';
    Screen.getInstance().getScreen()[this.getPos().getY() + 2][
        this.getPos().getX()
            - 1] = ' ';
  }

  public void move() {
    if (getPos().getX() + 3 >= Screen.getInstance().getWidth()) {
      return;
    }
    if (Map.getInstance().getCurrentPos() + Screen.getInstance().getWidth() + 1
        > Map.getInstance()
        .getScheme()[0].length) {

      if (canMove()) {
        clearHero();
        draw(new Position(this.getPos().getY(), this.getPos().getX() + 1));
        while (canFall()) {
          clearHero();
          draw(new Position(this.getPos().getY() + 1, this.getPos().getX()));
          Screen.getInstance().print();
        }
        return;
      }
    }
    if (canMove()) {
      Map.getInstance().setCurrentPos(Map.getInstance().getCurrentPos() + 1);
//      screen.print();
    }
  }

  public void moveLeft() {
    if (getPos().getX() - 2 <= 0) {
      return;
    }
    if (Map.getInstance().getCurrentPos() +
        Screen.getInstance().getWidth() + 1 >
        Map.getInstance().getScheme()[0].length) {

      if (canMoveLeft()) {
        clearHero();
        draw(new Position(this.getPos().getY(), this.getPos().getX() - 1));

        while (canFall()) {
          clearHero();
          draw(new Position(this.getPos().getY() + 1, this.getPos().getX()));

          Screen.getInstance().print();
        }
        return;
      }
    }
    if (canMoveLeft()) {
      Map.getInstance().setCurrentPos(Map.getInstance().getCurrentPos() - 1);
//      screen.print();
    }
  }

  public void jump(Position pos) throws Exception {
    if (getPos().getX() + 3 >= Screen.getInstance().getWidth()) {
      return;
    }
    if ((pos.getY() - 1) < 0) {
      return;
    }
    if (canJumpUp(pos)) {
      clearHero();
      draw(new Position(this.getPos().getY() - 1, this.getPos().getX()));
      Screen.getInstance().print();
      Thread.sleep(100);
      if (Map.getInstance().cellIsEmpty(
          new Position(this.getPos().getY() + 4, this.getPos().getX() + 1))) {
        for (int i = 0; i < 2; i++) {
          if (canMove()) {
            clearHero();
            draw(new Position(this.getPos().getY(), this.getPos().getX() + 1));
            Screen.getInstance().print();
            Thread.sleep(100);
          }
        }
      } else {
        clearHero();
        draw(new Position(this.getPos().getY(), this.getPos().getX() + 1));
        Screen.getInstance().print();
        Thread.sleep(100);
      }
      while (canFall()) {
        clearHero();
        draw(new Position(this.getPos().getY() + 1, this.getPos().getX()));
        Screen.getInstance().print();
      }
    }
  }

  public Bullet fire() {
    return new Bullet(true,
        new Position(this.getPos().getY() + 1, this.getPos().getX() + 2));
  }

  public void standUp(Position position) {
    clearSittingHero(position);
    draw(new Position(position.getY() - 1, position.getX()));
  }

  public void sit(Position pos) {
    if (canSit()) {
      this.clearHero();
      this.drawSit(new Position(pos.getY() + 1, pos.getX()));
    }
  }

  private boolean canFall() {
    if (Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + JUMP_LENGTH,
            this.getPos().getX()))) {
      if (Map.getInstance().cellIsEmpty(
          new Position(this.getPos().getY() + JUMP_LENGTH,
              this.getPos().getX() - 1))) {
        if (Map.getInstance().cellIsEmpty(
            new Position(this.getPos().getY() + 2, this.getPos().getX() - 2))) {
          if ((Map.getInstance().cellIsEmpty(
              new Position(this.getPos().getY() + 2,
                  this.getPos().getX() + 2)))) {
            if ((Map.getInstance().cellIsEmpty(
                new Position(this.getPos().getY() + 2,
                    this.getPos().getX() + 1)))) {
              if ((Map.getInstance().cellIsEmpty(
                  new Position(this.getPos().getY() + 2,
                      this.getPos().getX())))) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean canMoveLeft() {
    if (Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 3, this.getPos().getX() - 2))) {
      if (Map.getInstance().cellIsEmpty(
          new Position(this.getPos().getY() + 2, this.getPos().getX() - 2))) {
        if (Map.getInstance().cellIsEmpty(
            new Position(this.getPos().getY() + 1, this.getPos().getX() - 3))) {
          if (Map.getInstance().cellIsEmpty(
              new Position(this.getPos().getY(), this.getPos().getX() - 1))) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean canMove() {
    if (Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 3, this.getPos().getX() + 1))) {
      if (Map.getInstance().cellIsEmpty(
          new Position(this.getPos().getY() + 2, this.getPos().getX() + 1))) {
        if (Map.getInstance().cellIsEmpty(
            new Position(this.getPos().getY() + 1, this.getPos().getX() + 3))) {
          if (Map.getInstance().cellIsEmpty(
              new Position(this.getPos().getY(), this.getPos().getX() + 1))) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public void setHealthPoints(int hp) {
    this.healthPoints = hp;
  }

  public int getHealthPoints() {
    return this.healthPoints;
  }

  private boolean canJumpUp(Position pos) {
    if (Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() - 1, this.getPos().getX()))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY(), this.getPos().getX() + 1))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 2, this.getPos().getX()))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY(), this.getPos().getX() + 2))) {
      return true;
    } else {
      return false;
    }
  }

  private boolean canSit() {
    if (Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 3, this.getPos().getX() - 2))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 3, this.getPos().getX() + 1))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 2, this.getPos().getX() - 2))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 2, this.getPos().getX()))
        && Map.getInstance().cellIsEmpty(
        new Position(this.getPos().getY() + 2, this.getPos().getX() + 1))) {
      return true;
    }
    return false;
  }
}


