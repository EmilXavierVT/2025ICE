package dk.emilxaviervt._2025ice;

import dk.emilxaviervt._2025ice.VFX.ControllerFX;
import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
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

        Parent rootGame = fxmlLoader.load();
        Parent root = fxmlLogin.load();

        Scene sceneLogin = new Scene(root, designWidth, designHeight);

        Scene sceneGame = new Scene(rootGame, designWidth, designHeight);

        stage.setTitle("Dødens Labyrint");


        stage.setScene(scene2);
        stage.show();

        controller.loginCompletedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                controller.setLoadedPlayer();
                stage.setScene(sceneGame);

            }
        });

    }


    public static void main(String[] args) {launch();}
}