import com.mortal_combat_droid_edition.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class StartProject extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image image = new Image("file:background_image.jpg");
        ImageView iv = new ImageView(image);

        Parent root = FXMLLoader.load(getClass().getResource("/menu.fxml"));
        primaryStage.setTitle("Menu");
        root.setId("pane");
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setResizable(false);

        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
        MenuController.menuStage = primaryStage;

    }

    public static void main(String[] args) {
        launch(args);

    }
}
