package dk.emilxaviervt._2025ice;

import dk.emilxaviervt._2025ice.VFX.ControllerFX;
import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLogin = new FXMLLoader(MainFX.class.getResource("/clienter/view-login.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/clienter/activeGameScreen.fxml"));

        ControllerFX controller = new ControllerFX();
        controller.setAdventure(new Adventure());
        fxmlLogin.setController(controller);
        fxmlLoader.setController(controller);
        Scene scene2 = new Scene(fxmlLogin.load(), 700, 450);

        Scene scene = new Scene(fxmlLoader.load(), 700, 450);

        stage.setTitle("Dødens Labyrint");


        stage.setScene(scene2);
        stage.show();

        controller.loginCompletedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                stage.setScene(scene);
            }


        });
    }


    public static void main(String[] args) {launch();}
}