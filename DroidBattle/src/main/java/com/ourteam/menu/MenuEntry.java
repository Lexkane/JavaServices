package com.ourteam.menu;

import com.ourteam.gui.CustomConsole;

public abstract class MenuEntry {
    private String explanation;

    public abstract void run(CustomConsole customConsole);

    final String getExplanation() {
        return explanation;
    }

    final void setExplanation(final String exp) {
        this.explanation = exp;
    }
}
