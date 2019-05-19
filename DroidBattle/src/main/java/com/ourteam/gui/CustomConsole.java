package com.ourteam.gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

/**
 * Class which creates the console-like frame
 *
 * @author Андрiй
 * @version 1.0
 * @since 1.0
 */
public class CustomConsole extends JFrame {

    private CustomTextArea customTextArea = null;
    private AbstractKeyHandler keyHandler = null;

    private int charWidth = 0;

    public CustomConsole() {
        super(Settings.GAME_NAME);
        setSize(new Dimension(Settings.FRAME_WIDTH, Settings.FRAME_HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        customTextArea = new CustomTextArea();
        getContentPane()
                .add(customTextArea);

        charWidth = getFontMetrics(customTextArea.getFont()).charWidth(' ');
    }

    public void setKeyHandler(AbstractKeyHandler keyHandler) {
        customTextArea.removeKeyListener(this.keyHandler);
        this.keyHandler = keyHandler;
        customTextArea.addKeyListener(this.keyHandler);
    }

    public AbstractKeyHandler getKeyHandler() {
        return keyHandler;
    }

    /**
     * Clears the console
     */
    public void clear() {
        customTextArea.clear();
    }

    /**
     * Changes text on the console
     *
     * @param text
     */
    public void setText(String text) {
        customTextArea.setText(text + "\n");
    }

    /**
     * Method stores the value to the buffer. To print the whole text use <code>repaint()</code>
     * @see #repaint()
     * @param s line
     */
    public void println(String s) {
        customTextArea.println(s);
    }

    /**
     * This method prints out the text stored in buffer. Buffer filling via <code>println</code>
     * @see #println(String)
     */
    public void repaint() {
        customTextArea.paintText();
    }

    /**
     * Clears string buffer
     */
    public void clearBuffer() {
        customTextArea.clearBuffer();
    }

    final class CustomTextArea extends JTextArea {

        /**
         * Buffer for building and saving string
         */
        StringBuilder stringBuilder = new StringBuilder();
        int chars = 0;

        CustomTextArea() {
            super();
            setBackground(Color.WHITE);
            setEditable(false);
            setFont(Font.decode("Consolas").deriveFont(Settings.fontSize));
        }

        void clear() {
            super.setText("");
        }

        void println(String s) {
            chars = s.length();
            stringBuilder.append(s);
        }

        void clearBuffer() {
            stringBuilder.setLength(0);
        }

        void paintText() {
            CustomConsole.this.setSize(chars * charWidth, CustomConsole.this.getSize().height);
            try {
                this.getDocument().insertString(0, stringBuilder.toString(), null);
            } catch (BadLocationException e) {
                System.out.println("An exception caught in CustomConsole.CustomTextArea.paintText: " + e);
            }
        }
    }
}
