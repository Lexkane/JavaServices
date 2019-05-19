package com.ourteam.menu;

import com.ourteam.gui.CustomConsole;
import com.ourteam.maps.Level;

public class LevelEntry extends MenuEntry {
    private Level level;

    public LevelEntry() {
        this.setExplanation("Select level");
        level = null;
    }

    public void run(CustomConsole customConsole) {

    }
}
