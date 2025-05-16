package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import dk.emilxaviervt._2025ice.userLogic.ActionPoint;
import dk.emilxaviervt._2025ice.util.DatabaseManager;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Button goToActionPoint5;

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
        adventure.giveHealthBoost();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        ;
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

//    public void setButtons() {
//        ArrayList<Integer> actionPoints = adventure.getAp().getActionPointList();
//        if (actionPoints.size() == 1)
//            setButtonOne();
//        else if (actionPoints.size() == 2)
//            setButtonTwo();
//        else if (actionPoints.size() == 3)
//            setButtonThree();
//        else if (actionPoints.size() == 4)
//            setButtonFour();
//        else if (actionPoints.size() == 5)
//            setButtonFive();
//        else if (actionPoints.size() == 6)
//            setButtonSix();
//
//        }
        public void setButtonOne () {
            //button 1 visable
            // butten 2 3 4 5 6 unvisable
        }
        public void setButtonTwo () {
            //button 1 2 visable
            // butten  3 4 5 6 unvisable
        }
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
        descriptionLabel.setText(text);

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

}
