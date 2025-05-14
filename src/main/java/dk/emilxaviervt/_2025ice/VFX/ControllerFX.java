package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import dk.emilxaviervt._2025ice.util.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerFX {
    @FXML
    private Label welcomeText;
    @FXML
    private Button eatButton;
    @FXML
    private Button exitButton;

    Stage stage;
    Adventure adventure;

    public ControllerFX(Adventure adventure) {
        this.adventure = new Adventure();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void eatOneFood(ActionEvent event) {
        adventure.giveHealthBoost();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("det virker!");
    }

    @FXML
    private void exit(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        DatabaseManager db = new DatabaseManager();
        db.savePlayerToDatabase(adventure.getCurrentPlayer());
        stage.close();

    }

}


