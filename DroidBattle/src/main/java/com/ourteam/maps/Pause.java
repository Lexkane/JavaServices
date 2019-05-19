package com.ourteam.maps;

import com.ourteam.gui.CustomConsole;
import com.ourteam.menu.Menu;

public class Pause {

  private int key;
  private int levelNumber;
  private Screen screen;

  private CustomConsole customConsole = null;
  private Level level = null;

  public Pause(CustomConsole customConsole, Screen screen, int key, int levelNumber) {
    this.customConsole = customConsole;
    this.screen = screen;
    this.key = key;
    this.levelNumber = levelNumber;
  }

  public void setkey(int key) {
    this.key = key;
  }

  public void pause() {
    System.out.println("********************");
    System.out.println("** Pause\t\t\t\t\t**");
    System.out.println("** 1. Resume\t\t\t**\n"
        + "** 2. New game\t\t**\n"
        + "** 3. Main menu\t\t**");
    System.out.println("********************");

    switch (key) {
      case 1:
        screen.print();
        break;
      case 2:
        level = new Level(levelNumber);
        Map.getInstance().setLevel(level);
        Map.getInstance().getScheme();
        break;
      case 3:
        new Menu(customConsole).printMenu();
        break;
      default:
        break;
    }
  }
}
