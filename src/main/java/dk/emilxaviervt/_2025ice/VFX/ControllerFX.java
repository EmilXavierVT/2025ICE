package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import dk.emilxaviervt._2025ice.gameLogic.ActionPoint;
import dk.emilxaviervt._2025ice.gameLogic.Creature;
import dk.emilxaviervt._2025ice.gameLogic.Player;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

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
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView dice2;
    @FXML
    private ImageView dice3;
    @FXML
    private ImageView dice4;
    @FXML
    private ImageView dice5;
    @FXML
    private ImageView dice6;
    @FXML
    private ImageView dice7;
    @FXML
    private ImageView dice8;
    @FXML
    private ImageView dice9;
    @FXML
    private ImageView dice10;
    @FXML
    private ImageView dice11;
    @FXML
    private ImageView dice12;
    @FXML
    private Label healthAmount;
    @FXML
    private Label attackAmount;
    @FXML
    private Label luckAmount;
    @FXML
    private ImageView combatSwordImage;
    @FXML
    private Label goldAmount;
    private BooleanProperty loginIsCompleted = new SimpleBooleanProperty(false);
    public String playerName;
    ActionPoint actionPoint;
    Adventure adventure;
    Stage stage;



    public ControllerFX() {

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void eatOneFood(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adventure.giveHealthBoost();
        setStatsAmount();
        System.out.println("Eat Button has been pressed, player health boosted!");
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

    public int rollDice(int numberOfDice){
        Random random = new Random();
        int rdm=0;


        if(numberOfDice == 1){
            rdm = random.nextInt(1, 7);
            for(int i= 0; i< 8;i++){
                showDice(random.nextInt(1, 7));
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
            showDice(rdm);
        }else if(numberOfDice == 2) {
            rdm = random.nextInt(2, 13);
            for(int i= 0; i< 8;i++){
                showDice(random.nextInt(1, 7));
                showDice(random.nextInt(7, 13));
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

            }
            showDice(rdm);
        }
        return rdm;

    }
    private void showDice(int diceNumber){




        switch (diceNumber){
            case 1:
                dice1.setVisible(true);
                break;
            case 2:
                dice2.setVisible(true);
                break;
            case 3:
                dice3.setVisible(true);
                break;
            case 4:
                dice4.setVisible(true);
                break;
            case 5:
                dice5.setVisible(true);
                break;
            case 6:
                dice6.setVisible(true);
                break;
            case 7:
                dice6.setVisible(true);
                dice7.setVisible(true);
                break;
            case 8:
                dice6.setVisible(true);
                dice8.setVisible(true);
                break;
            case 9:
                dice6.setVisible(true);
                dice9.setVisible(true);
                break;
            case 10:
                dice6.setVisible(true);
                dice10.setVisible(true);
                break;
            case 11:
                dice6.setVisible(true);
                dice11.setVisible(true);
                break;
            case 12:
                dice6.setVisible(true);
                dice12.setVisible(true);
                break;
            default:
                    System.out.println("something went wrong in showDice() in ControllerFX.java, diceNumber:");
        }

    }



    private void setDiceInvisible(){
        dice1.setVisible(false);
        dice2.setVisible(false);
        dice3.setVisible(false);
        dice4.setVisible(false);
        dice5.setVisible(false);
        dice6.setVisible(false);
        dice7.setVisible(false);
        dice8.setVisible(false);
        dice9.setVisible(false);
        dice10.setVisible(false);
        dice11.setVisible(false);
        dice12.setVisible(false);
    }

    public BooleanProperty loginCompletedProperty() {
        return loginIsCompleted;
    }


    public String returnTextLogin() {

        return playerName;
    }


    @FXML
    public void pressOfGoto(ActionEvent event) {

        setDiceInvisible();
//        setCombatSwordImagetoInvisible();
        setVisibilityonGTButons();
        Button sourceButton = (Button) event.getSource(); // Get the source and cast it to Button
        String buttonText = sourceButton.getText();
        int actionPointID = Integer.parseInt(buttonText);
        adventure.setAp(actionPointID);

      setActionPointToGUI();


        setStatsAmount();
        adventure.actionPointEvents();

        // Get the text on the button
//        System.out.println(buttonText);
//        System.out.println(adventure.getDm().selectActionPoints(actionPointID).getDescription());
        displayDescription(actionPointID);// dnfw.... srsly



    }

    public void setCombatSwordImagetoVisable(){
        combatSwordImage.setVisible(true);
    }
    public void setCombatSwordImagetoInvisible(){
        combatSwordImage.setVisible(false);
    }



    public ActionPoint displayDescription(int pressedAPID) {
        // description
        // hver gang vi klikker på en knap
        ActionPoint newAP = adventure.getDm().selectActionPoints(pressedAPID);
        setScrollPaneText(newAP.getDescription());
        setNameOfGTButtons(newAP);
        return newAP;


    }


    private void setStatsAmount(){

        healthAmount.setText(adventure.getCurrentPlayer().getCurrentHealth() + "");
        attackAmount.setText(adventure.getCurrentPlayer().getCurrentAttack() + "");
        luckAmount.setText(adventure.getCurrentPlayer().getCurrentLuck() + "");
        goldAmount.setText(adventure.getCurrentPlayer().getGoldCoins()+"");


    }

    private void setScrollPaneText(String text) {
        //Sets the text to be invisible
        descriptionLabel.setOpacity(0.0);

        //Typing animation
        typingAnimation(descriptionLabel, text, 1);

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
        label.setText(" ");

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


    public Button getGTButton1() {
        return GTButton1;
    }

    public void setGTButton1(Button GTButton1) {
        this.GTButton1 = GTButton1;
    }

    public Button getGTButton2() {
        return GTButton2;
    }

    public void setGTButton2(Button GTButton2) {
        this.GTButton2 = GTButton2;
    }


    @FXML
    private void changeGT1visibility(ActionEvent event, boolean visible) {
        GTButton1.setVisible(visible);
    }


    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
        this.actionPoint = adventure.getAp();

    }
    public void setActionPointToGUI(){
        ActionPoint ap = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();

        if (ap.getChangeHealthPoints() != 0) {adventure.getCurrentPlayer().changeHealth(ap.getChangeHealthPoints());}
        if (ap.getChangeAttackPoints() != 0) {currentPlayer.changeAttack(ap.getChangeAttackPoints());}
        if (ap.getContainedCreatures() !=null) {combat();}
        if (ap.getLuckRoll()) {

            getGTButton1().setVisible(false);
            int rdm =rollDice(2);

            if(rdm < currentPlayer.getCurrentLuck()){getGTButton1().setVisible(true);};

//                gui interface

        }
        if (ap.getContainItem() != null) {
            if (currentPlayer.getInventory() != null) {
                currentPlayer.addToInventory(ap.getContainItem());
                System.out.println("Item added to inventory"+currentPlayer.getInventory());
            }
        }
        if (ap.getGoldCoins() != 0) {
            currentPlayer.changeGoldCoins(ap.getGoldCoins());
        }
        if (ap.getDieRoll()) {
            rollDice(2);
//                GUI interface
        }
        if (ap.getIsFinal()) {

//                end game GUI interface
        }
        if (ap.getWinnerActionPoint()) {
            System.out.println("Congratz you won!");
        }
        adventure.actionPointEvents();

    }

    public void combat() {
        int combatRound = 0;

        ActionPoint ap = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();


        for (Creature creature : ap.getContainedCreatures()) {
            setCombatSwordImagetoVisable();
            while (currentPlayer.getCurrentHealth() > 0 && creature.getCurrentHealth() > 0) {

                // Player attack
                int playerAttack = currentPlayer.getCurrentAttack() + adventure.dieRoll();
                int creatureAttack = creature.getCurrentAttack() + adventure.dieRoll();



                if (playerAttack > creatureAttack) {
                    creature.changeCurrentHealth(-2);
                } else if (creatureAttack > playerAttack) {
                    currentPlayer.changeHealth(-2);

                }
                combatRound++;
            }

            System.out.println( "Combat started "+ creature.getCreatureName()+"     Creature Health: "+creature.getCurrentHealth() + " \n" +
                    "Player health" + currentPlayer.getCurrentHealth() + " " + combatRound);
        }
        combatRound = 0;


    }













}

