
package com.ourteam.menu;

//import org.apache.commons.lang3.StringUtils;

import com.ourteam.gui.CustomConsole;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private CustomConsole customConsole;
    private ArrayList<MenuEntry> entries;

    public Menu(CustomConsole customConsole) {
        entries = new ArrayList<>();
        this.customConsole = customConsole;
    }

    public final void initializeEntries() {
        entries.add(new StartEntry());
        entries.add(new LevelEntry());
        entries.add(new ControlsEntry());
        entries.add(new ExitEntry());
    }

    public final void printMenu() {
            StringBuilder menuEntries = new StringBuilder();
            menuEntries.append("Choose, what you want to do:\n");

            for (int i = 0; i < entries.size(); i++) {
                menuEntries.append((i + 1 + ") " + entries.get(i).getExplanation() + "\n"));
            }

            customConsole.setText(menuEntries.toString());

    }
}
