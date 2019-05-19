package com.ourteam;

import com.ourteam.controllers.MenuController;
import com.ourteam.gui.CustomConsole;
import com.ourteam.menu.Menu;

public class MenuTest {
    private static CustomConsole customConsole = null;

    public static void main(String[] args) {

        customConsole = new CustomConsole();
        customConsole.setVisible(true);

        Menu menu = new Menu(customConsole);
        menu.initializeEntries();
        menu.printMenu();

        MenuController menuController = new MenuController(customConsole, menu);

        customConsole.setKeyHandler(menuController.getKeyHandler());
    }
}
