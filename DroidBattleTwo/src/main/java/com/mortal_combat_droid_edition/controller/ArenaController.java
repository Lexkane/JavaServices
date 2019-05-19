package com.mortal_combat_droid_edition.controller;

import com.mortal_combat_droid_edition.model.Droid;
import com.mortal_combat_droid_edition.model.SideSwipe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.text.Text;

public class ArenaController {


    protected static Droid droid1;
    protected static Droid droid2;

    protected static boolean checkVbox1;
    protected static boolean checkVbox2;

    protected static int round;

    public VBox vBox1;
    public VBox vBox2;

    public Label droid1Status;
    public Label droid2Status;

    public Text firstDroidName;
    public Text secondDroidName;

    public TextArea textArea;

    public void initDroids(Droid firstDroid, Droid secondDroid) {

        droid1 = firstDroid;
        droid2 = secondDroid;

        droid1Status.setText(droid1.droidStatus());
        droid2Status.setText(droid2.droidStatus());

        firstDroidName.setText(droid1.getClass().getSimpleName());
        secondDroidName.setText(droid2.getClass().getSimpleName());


        ButtonBuilder buttonBuilder = new ButtonBuilder();
        buttonBuilder.arenaController = this;

        for (String name : buttonBuilder.getNameList()) {
            if (firstDroid.getClass().getSimpleName().equals(name)) {
                setvBox1(buttonBuilder.getCurrentButtons(name, firstDroid, secondDroid));
            }
            if (secondDroid.getClass().getSimpleName().equals(name)) {
                setvBox2(buttonBuilder.getCurrentButtons(name, secondDroid, firstDroid));
            }
        }

    }


    public void setvBox1(ArrayList<Button> list) {

        for (Button button : list) {
            vBox1.getChildren().add(button);
        }

    }

    public void setvBox2(ArrayList<Button> list) {

        for (Button button : list) {
            vBox2.getChildren().add(button);
        }

    }

    public void refreshStatus() {

        droid1Status.setText(droid1.droidStatus());
        droid2Status.setText(droid2.droidStatus());
    }


    public void determineWinner() {

        if (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            return;
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Winner");
        alert.setHeaderText("And we have a winner!");
        alert.setGraphic(null);

        if (droid1.getHealth() <= 0) {
            alert.setContentText("Congratulations, " + droid2.getClass().getSimpleName());
        } else if (droid2.getHealth() <= 0) {
            alert.setContentText("Congratulations, " + droid1.getClass().getSimpleName());
        }

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            System.exit(0);
        }

    }


    public void setHistory(String history) {
        textArea.setText(history);
        textArea.appendText("");
    }
}

