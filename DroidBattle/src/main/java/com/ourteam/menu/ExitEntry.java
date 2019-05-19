package com.ourteam.menu;

import com.ourteam.gui.CustomConsole;

public class ExitEntry extends MenuEntry {

    public ExitEntry() {
        this.setExplanation("Exit the program");
    }

    public final void run(CustomConsole customConsole) {
        System.out.println("Successfully exited");
        Runtime.getRuntime().exit(0);
    }

}
