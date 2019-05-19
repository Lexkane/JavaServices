package com.ourteam.menu;

import com.ourteam.gui.CustomConsole;

public class ControlsEntry extends MenuEntry {

  private String controls;

  public ControlsEntry() {
    this.setExplanation("Controls");
    this.controls = "W - Jump \n"
        + "D - Move right \n"
        + "A - Move left \n"
        + "S - Sit \n"
        + "Space - Fire \n"
        + "B - Back to main menu \n"
        + "Enjoy your game!";
  }

  public void run(CustomConsole customConsole) {
    customConsole.setText(controls);
  }
}
