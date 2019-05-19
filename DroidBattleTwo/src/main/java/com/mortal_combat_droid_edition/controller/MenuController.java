package com.mortal_combat_droid_edition.controller;

import com.mortal_combat_droid_edition.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MenuController {

    public static Stage menuStage;

    private Droid droid1;
    private Droid droid2;

    public Label info;
    public HBox hBox;
    private Button temp = getButtonConfig();
    private static int count = 0;

    public void getSideSwipeInfo(ActionEvent actionEvent) {

        info.setText(new SideSwipe().toString());

        isAlive(temp, new SideSwipe());


    }


    public void getHealerInfo(ActionEvent actionEvent) {


        info.setText(new HealerDroid().toString());

        isAlive(temp, new HealerDroid());

    }

    public void getK2SOInfo(ActionEvent actionEvent) {

        info.setText(new K2So().toString());

        isAlive(temp, new K2So());
    }

    public void getStrikeDroidInfo(ActionEvent actionEvent) {

        info.setText(new StrikerDroid().toString());

        isAlive(temp, new StrikerDroid());

    }

    public void getNeoInfo(ActionEvent actionEvent) {

        info.setText(new Neo().toString());

        isAlive(temp, new Neo());

    }

    public void getAltronInfo(ActionEvent actionEvent) {
        info.setText(new UltronDroid().toString());

        isAlive(temp, new UltronDroid());
    }


    private Button getButtonConfig() {
        temp = new Button();
        temp.setText("set");

        return temp;
    }


    private void setControl(String fxmlFile) throws Exception {

        if (count == 2) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root, 900, 600);
            stage.setTitle("Arena");
            stage.setScene(scene);
            ArenaController arenaController = fxmlLoader.getController();
            sendParametersToArena(arenaController);
            stage.show();
            count = 0;
            droid1 = null;
            droid2 = null;

            menuStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("You pick " + droid1.getClass().getSimpleName());
            alert.setGraphic(null);
            alert.setContentText("Choose second hero!!!");
            alert.showAndWait();
        }


    }

    private void setDroid(Droid droid) {
        if (droid1 == null) {
            droid1 = droid;
        } else if (droid2 == null) {
            droid2 = droid;
        }

    }

    private void isAlive(Button button, Droid droid) {

        temp.setOnAction((event) -> {
            try {
                count++;
                setDroid(droid);
                setControl("/arena.fxml");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Oops!");
            }
        });

        if (hBox.getChildren().contains(button) == true) {
            hBox.getChildren().remove(button);
            hBox.getChildren().add(button);
        } else {
            hBox.getChildren().add(button);
        }


    }

    private void sendParametersToArena(ArenaController arenaController) {
        arenaController.initDroids(droid1, droid2);

    }

}
