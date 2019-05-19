package com.ourteam.maps;

import com.ourteam.gui.CustomConsole;

public class Screen {

    private static Screen instance;

    public static Screen getInstance(){
        if(instance == null){
            instance = new Screen(10, 20);
        }

        return instance;
    }

    private int width;
    private int height;
    private char[][] screen;

    private CustomConsole customConsole = null;

    private Screen(CustomConsole customConsole, int width, int height) {
        this(height, width);
        this.customConsole = customConsole;
    }

    private Screen(int height, int width){
        this.height = height;
        this.width = width;

        this.screen = new char[height][width];
    }

    public CustomConsole getCustomConsole() {
        return customConsole;
    }

    public void setCustomConsole(CustomConsole customConsole) {
        this.customConsole = customConsole;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getScreen() {
        return screen;
    }

    public void setScreen(char[][] screen) {
        this.screen = screen;
    }

    /**
     * Adapted method for using with with System.out.console and CustomConsole
     */
    public void print(){
        if (customConsole == null) {
            for (char[] arr : this.screen) {
                for (char el : arr) {
                    System.out.print(el);
                }
                System.out.println();
            }
        } else {
            customConsole.clearBuffer();
            for (char[] arr : this.screen) {
                customConsole.println(new String(arr) + "\n");
            }
            customConsole.repaint();
        }
    }
}