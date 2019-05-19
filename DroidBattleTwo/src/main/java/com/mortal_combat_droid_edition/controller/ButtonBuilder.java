package com.mortal_combat_droid_edition.controller;

import javafx.scene.control.Alert;

import com.mortal_combat_droid_edition.model.Droid;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mortal_combat_droid_edition.controller.ArenaController.*;


public class ButtonBuilder {

    protected ArenaController arenaController;
    private ArrayList<Button> list;
    private static String history = "";
    private static Object tempHash;

    public ArrayList<Button> getCurrentButtons(String name, Droid attackDroid, Droid defenseDroid) {
        switch (name) {
            case "SideSwipe":
                return getSideSwipeButtons(attackDroid, defenseDroid);
            case "HealerDroid":
                return getHealerDroidButtons(attackDroid, defenseDroid);
            case "K2So":
                return getK2SoButtons(attackDroid, defenseDroid);
            case "StrikerDroid":
                return getStrikeDroidButtons(attackDroid, defenseDroid);
            case "Neo":
                return getNeoButtons(attackDroid, defenseDroid);
            case "UltronDroid":
                return getUltronDroidButtons(attackDroid, defenseDroid);
            default:
                break;
        }
        return null;
    }

    private ArrayList<Button> getSideSwipeButtons(Droid attackDroid, Droid defenseDroid) {
        list = new ArrayList<Button>();
        Button temp = customizeButton("Attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(1, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }
            roundChecker();


        });
        list.add(temp);
        temp = customizeButton("Rocket Launch");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(2, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }
            roundChecker();


        });
        list.add(temp);

        temp = customizeButton("Immortality");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(3, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();

        });
        list.add(temp);

        return list;
    }

    private ArrayList<Button> getHealerDroidButtons(Droid attackDroid, Droid defenseDroid) {
        list = new ArrayList<Button>();

        Button temp = customizeButton("Attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(1, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }
            roundChecker();


        });
        list.add(temp);

        temp = customizeButton("Block attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(2, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();


        });
        list.add(temp);

        return list;
    }

    private ArrayList<Button> getK2SoButtons(Droid attackDroid, Droid defenseDroid) {
        list = new ArrayList<Button>();

        Button temp = customizeButton("Attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(1, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }
            roundChecker();


        });
        list.add(temp);

        temp = customizeButton("ItDependsOnYourAccuracy Combo");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(2, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + " use ItDependsOnYourAccuracy Combo\n");
            }

            roundChecker();


        });
        list.add(temp);
        temp = customizeButton("It`sYourDead Combo");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(3, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();


        });
        list.add(temp);

        return list;
    }

    private ArrayList<Button> getStrikeDroidButtons(Droid attackDroid, Droid defenseDroid) {
        list = new ArrayList<Button>();

        Button temp = customizeButton("Attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(1, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();

        });

        list.add(temp);

        temp = customizeButton("Super Blade");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(2, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();


        });
        list.add(temp);

        return list;
    }

    private ArrayList<Button> getNeoButtons(Droid attackDroid, Droid defenseDroid) {
        list = new ArrayList<Button>();

        Button temp = customizeButton("Attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(1, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }
            roundChecker();

        });
        list.add(temp);

        temp = customizeButton("Increase reaction");
        temp.setOnAction((event) -> {


            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(2, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();

        });
        list.add(temp);

        return list;
    }

    private ArrayList<Button> getUltronDroidButtons(Droid attackDroid, Droid defenseDroid) {
        list = new ArrayList<Button>();

        Button temp = customizeButton("Attack");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(1, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }

            roundChecker();


        });
        list.add(temp);

        temp = customizeButton("Paralyze");
        temp.setOnAction((event) -> {

            if (setCheckCVBox(attackDroid)) {
                attackDroid.beginRound(2, defenseDroid);
                getHistory(attackDroid.getClass().getSimpleName() + attackDroid.getHistory());
            }
            roundChecker();


        });
        list.add(temp);

        return list;
    }

    private Button customizeButton(String name) {
        Button button = new Button(name);
        button.setPrefSize(250, 40);

        return button;
    }

    public List<String> getNameList() {
        String[] str = {"SideSwipe", "HealerDroid", "K2So", "StrikerDroid", "Neo",
                "UltronDroid"};
        return Arrays.asList(str);
    }

    private boolean setCheckCVBox(Droid droid) {
        if (tempHash == null) {
            tempHash = droid;
            checkVbox1 = true;
            return true;
        } else if (tempHash == droid) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not your");
            alert.setHeaderText(
                    "You pick in this round " +
                            "\nknow turn another player"
            );
            alert.setGraphic(null);
            alert.setContentText("");
            alert.showAndWait();
            return false;
        } else {
            checkVbox2 = true;
            return true;
        }


    }


    private void roundChecker() {
        if (checkVbox1 && checkVbox2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Round");
            alert.setHeaderText(" Round  " + (++round));
            alert.setGraphic(null);
            alert.setContentText("");
            alert.showAndWait();

            checkVbox1 = false;
            checkVbox2 = false;
            tempHash = null;

            arenaController.refreshStatus();
            arenaController.determineWinner();
            arenaController.setHistory(history);
        }

    }

    private void getHistory(String info) {
        history += info;
    }
}
