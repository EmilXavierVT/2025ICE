package dk.emilxaviervt._2025ice.VFX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerFX {
    @FXML
    private Label welcomeText;
    private Button notes;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

//    @FXML
//    protected void onClickNotesButton(){ notes.;}
}