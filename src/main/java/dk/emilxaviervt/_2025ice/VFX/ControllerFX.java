package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import dk.emilxaviervt._2025ice.userLogic.ActionPoint;
import dk.emilxaviervt._2025ice.util.DatabaseManager;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class ControllerFX {
    @FXML
    private Label welcomeText;
    @FXML
    private Button eatButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button runButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button createNewPlayerButton;
    @FXML
    private TextField loginTextField;
    @FXML
    private Button GTButton1;
    @FXML
    private Button GTButton2;
    @FXML
    private Button GTButton3;
    @FXML
    private Button GTButton4;
    @FXML
    private Button GTButton5;
    @FXML
    private Button GTButton6;
    @FXML
    private Label descriptionLabel;

    private BooleanProperty loginIsCompleted = new SimpleBooleanProperty(false);
    public String playerName;


    Stage stage;
    Adventure adventure;
    ActionPoint actionPoint;

    public ControllerFX(Adventure adventure) {
        this.adventure = adventure;
        this.actionPoint = adventure.getAp();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void eatOneFood(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adventure.giveHealthBoost();
        System.out.println("det virker!");
    }

    @FXML
    private void exit(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adventure.savePlayerfromAdventure();
        System.out.println("player saved to database!");
        stage.close();

    }

    @FXML
    private void runFromFight(ActionEvent event) {

    }

    @FXML
    private void login(ActionEvent event) {
        String name = handleTextField(event);
        adventure.getCurrentPlayer().setName(name);
        loginIsCompleted.set(true);

    }

    @FXML
    private void createNewPlayer(ActionEvent event) {

    }

    @FXML
    private String handleTextField(ActionEvent event) {
        return loginTextField.getText();

    }

    public BooleanProperty loginCompletedProperty() {
        return loginIsCompleted;
    }


    public String returnTextLogin() {

        return playerName;
    }


    @FXML
    public void pressOfGoto(ActionEvent event) {
        setVisibilityonGTButons();
        Button sourceButton = (Button) event.getSource(); // Get the source and cast it to Button
        String buttonText = sourceButton.getText();
        int actionPointID = Integer.parseInt(buttonText);
        // Get the text on the button
        System.out.println(buttonText);
        displayDescription(actionPointID);// For demonstration
        adventure.actionPointEvents();


    }

    public ActionPoint displayDescription(int pressedAPID) {
        // description
        // hver gang vi klikker på en knap
        ActionPoint newAP = adventure.getDm().selectActionPoints(pressedAPID);
        setScrollPaneText(newAP.getDescription());
        setNameOfGTButtons(newAP);
        return newAP;


    }

    private void setScrollPaneText(String text) {
        //Sets the text to be invisible
        descriptionLabel.setOpacity(0.0);

        //Typing animation
        typingAnimation(descriptionLabel, text, 10);

        //Animates the text to be visible
        animateDescription(descriptionLabel);

    }

    private void setNameOfGTButtons(ActionPoint newAP) {
        ArrayList<Integer> AAPList = newAP.getActionPointList();

        for (int i = 0; i <AAPList.size(); i++) {
            setButtonName((i + 1), AAPList.get(i));


        }


    }

    private void setButtonName(int id, int displaymessage) {
        //
        switch (id) {
            case 1:
                GTButton1.setText(displaymessage + "");
                GTButton1.setVisible(true);
                break;
            case 2:

                GTButton2.setText(displaymessage + "");
                GTButton2.setVisible(true);
                break;
            case 3:
                GTButton3.setText(displaymessage + "");
                GTButton3.setVisible(true);
                break;
            case 4:
                GTButton4.setText(displaymessage + "");
                GTButton4.setVisible(true);
                break;
            case 5:
                GTButton5.setText(displaymessage + "");
                GTButton5.setVisible(true);
                break;
            case 6:
                GTButton6.setText(displaymessage + "");
                GTButton6.setVisible(true);
                break;
            default:
                System.out.println("Error at switch-case chain in setButtonName() in ControllerFX.java");
        }


//                    if(id == 1){
//                    );
//                    }
//                    else if (i == 2){
//                        setButtonValues2(nextPoints.get(i-1));
//                    }
//                    else if (i == 3){
//                        setButtonValues3(nextPoints.get(i-1));
//                    }
//                     else if (i == 4){
//                        setButtonValues4(nextPoints.get(i-1));
//                    } else if (i == 5){
//                        setButtonValues5(nextPoints.get(i-1));
//                    } else if (i == 6){
//                        setButtonValues6(nextPoints.get(i-1));
//                    }
//                    else {
//                        System.out.println("Error at else-if chain in fillNewButtons() in ControllerFX.java");
//                    }
//                }
//    }

    }
   private void setVisibilityonGTButons(){
        GTButton1.setVisible(false);
        GTButton2.setVisible(false);
        GTButton3.setVisible(false);
        GTButton4.setVisible(false);
        GTButton5.setVisible(false);
        GTButton6.setVisible(false);
   }



    private void animateDescription(Label label){
    FadeTransition fade = new FadeTransition(Duration.seconds(5),label);
    fade.setFromValue(0.0);
    fade.setToValue(1.0);
    fade.play();
    }
    private void typingAnimation(Label label, String text, double speed){
        label.setText("");

        Timeline timeline = new Timeline();
        int[] index = {0};

        KeyFrame keyframe = new KeyFrame(Duration.millis(speed), event ->  {
            if(index[0] < text.length()){
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            }
        });
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(text.length());
        timeline.play();
    }




}

