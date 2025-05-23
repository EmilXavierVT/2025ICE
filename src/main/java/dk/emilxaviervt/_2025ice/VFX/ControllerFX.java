package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.Items.Item;
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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ControllerFX {


//    the login and create new player scene buttons and text field

    @FXML
    private Button loginButton;
    @FXML
    private Button createNewPlayerButton;
    @FXML
    private TextField loginTextField;

//    the player and game changing buttons

    @FXML
    private Button eatButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button runButton;

//    The Goto Buttons

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

//    the Description of the ActionPoint is sent to this Label

    @FXML
    private Label descriptionLabel;

//    Dice faces for visual satisfaction of the dice roll

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

//    Labels for the player stats: Health - Attack - Luck - Gold coins


    @FXML
    private Label healthAmount;
    @FXML
    private Label attackAmount;
    @FXML
    private Label luckAmount;
    @FXML
    private Label goldAmount;
    @FXML
    private Label foodAmount;

//  Image to show the combat

    @FXML
    private ImageView combatSwordImage;

//   Labels for Inventory items

    @FXML
    private Label itemLabel0;
    @FXML
    private Label itemLabel1;
    @FXML
    private Label itemLabel2;
    @FXML
    private Label itemLabel3;
    @FXML
    private Label itemLabel4;
    @FXML
    private Label itemLabel5;
    @FXML
    private Label itemLabel6;
    @FXML
    private Label itemLabel7;
    @FXML
    private Label itemLabel8;
    @FXML
    private Label itemLabel9;

//    Buttons for dice

    @FXML
    private Button dice1Button;
    @FXML
    private Button dice2Button;

    //    Potion MenuItems
    @FXML
    private MenuItem attackPotionMenuItem;
    @FXML
    private MenuItem healthPotionMenuItem;
    @FXML
    private MenuItem luckPotionMenuItem;

//    Login boolean to skip from the login page to the game scene

    private BooleanProperty loginIsCompleted = new SimpleBooleanProperty(false);

//    The name the user inputs in the login scene

    private String playerName;

//    Declaration used for the current ActionPoint

    private ActionPoint actionPoint;
    private Adventure adventure;
    Stage stage;


    public ControllerFX() {

    }


    @FXML
    private void eatOneFood(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (adventure.getCurrentPlayer().getFoodRations() > 0) {
            if (adventure.getCurrentPlayer().getCurrentHealth() < adventure.getCurrentPlayer().getMaxHealth()) {
                if (adventure.getAp().getContainedCreatures().isEmpty()) {
                    adventure.getCurrentPlayer().giveHealthBoost();
                    adventure.getCurrentPlayer().changeFoodRations(-1);
                    setStatsAmount();

                }
            }
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        showDeathPopUp();

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


    @FXML
    private void dice1ButtonPress(ActionEvent event) {
        if (!adventure.getAp().getDieRoll()) {
            rollDice(1);
        }


    }

    @FXML
    private void dice2ButtonPress(ActionEvent event) {
        if (!actionPoint.getDieRoll()) {
            rollDice(2);
        }
    }

    @FXML
    private void healthPotionPress(ActionEvent event) {
        if (adventure.getCurrentPlayer().getCurrentHealth() < adventure.getCurrentPlayer().getMaxHealth()) {
            adventure.getCurrentPlayer().setCurrentHealth(adventure.getCurrentPlayer().getMaxHealth());
            adventure.getCurrentPlayer().setStarterPotion(0);
        }
        setStatsAmount();
    }

    @FXML
    private void luckPotionPress(ActionEvent event) {
        if (adventure.getCurrentPlayer().getCurrentLuck() < adventure.getCurrentPlayer().getMaxLuck()) {
            adventure.getCurrentPlayer().setCurrentLuck(adventure.getCurrentPlayer().getMaxLuck());
            adventure.getCurrentPlayer().setStarterPotion(0);
        }
    }

    @FXML
    private void attackPotionPress(ActionEvent event) {
        if (adventure.getCurrentPlayer().getCurrentAttack() < adventure.getCurrentPlayer().getMaxAttack()) {
            adventure.getCurrentPlayer().setCurrentAttack(adventure.getCurrentPlayer().getMaxAttack());
            adventure.getCurrentPlayer().setStarterPotion(0);
        }
    }


    @FXML
    private void changeGT1visibility(ActionEvent event, boolean visible) {
        GTButton1.setVisible(visible);
    }

    @FXML
    private void combatSwordPress(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (!adventure.getAp().getContainedCreatures().isEmpty()) {
            System.out.println("test mouseClick");
            combat();
        }
    }

    public int rollDice(int numberOfDice) {
        Random random = new Random();
        int rdm = 0;

        if (numberOfDice == 1) {
            rdm = random.nextInt(1, 7);
            animateDiceRoll();
            showDice(rdm);

        } else if (numberOfDice == 2) {
            rdm = random.nextInt(2, 13);
            animateTwoDiceRoll();
            showTwoDice(rdm);
        }

        return rdm;

    }

    private void showDice(int diceNumber) {

        setDiceInvisible();

        switch (diceNumber) {
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
                System.out.println("something went wrong in showDice() in ControllerFX.java, Show one dice :");
        }

    }

    private void showTwoDice(int diceNumber) {

        setDiceInvisible();
        switch (diceNumber) {
            case 1:
                dice1.setVisible(true);
                break;
            case 2:
                dice1.setVisible(true);
                dice7.setVisible(true);
                break;
            case 3:
                dice2.setVisible(true);
                dice7.setVisible(true);
                break;
            case 4:
                dice2.setVisible(true);
                dice8.setVisible(true);
                break;
            case 5:
                dice3.setVisible(true);
                dice8.setVisible(true);
                break;
            case 6:
                dice3.setVisible(true);
                dice9.setVisible(true);
                break;
            case 7:
                dice4.setVisible(true);
                dice9.setVisible(true);
                break;
            case 8:
                dice6.setVisible(true);
                dice8.setVisible(true);
                break;
            case 9:
                dice5.setVisible(true);
                dice10.setVisible(true);
                break;
            case 10:
                dice5.setVisible(true);
                dice11.setVisible(true);
                break;
            case 11:
                dice5.setVisible(true);
                dice12.setVisible(true);
                break;
            case 12:
                dice6.setVisible(true);
                dice12.setVisible(true);
                break;
            default:
                System.out.println("something went wrong in showDice() in ControllerFX.java, show two dice:");
        }

    }


    public void setPlayersStarterPointVFX(int potionID) {

        attackPotionMenuItem.setVisible(false);
        healthPotionMenuItem.setVisible(false);
        luckPotionMenuItem.setVisible(false);

        if (potionID == 1) {
            attackPotionMenuItem.setVisible(true);
        }
        if (potionID == 2) {
            healthPotionMenuItem.setVisible(true);
        }
        if (potionID == 3) {
            luckPotionMenuItem.setVisible(true);
        }

    }


    private void displayInventory() {
        setItemLabelInvisible();
        if (!adventure.getCurrentPlayer().getInventory().isEmpty()) {
            for (int i = 0; i < adventure.getCurrentPlayer().getInventory().size(); i++) {
                displayItemLabel(i);
            }
        }
    }


    private void displayItemLabel(int i) {
        ArrayList<Item> inventory = adventure.getCurrentPlayer().getInventory();
        if (i == 0) {
            itemLabel0.setText(inventory.getFirst().getName());
            itemLabel0.setVisible(true);
        }
        if (i == 1) {
            itemLabel1.setText(inventory.get(1).getName());
            itemLabel1.setVisible(true);
        }
        if (i == 2) {
            itemLabel2.setText(inventory.get(2).getName());
            itemLabel2.setVisible(true);
        }
        if (i == 3) {
            itemLabel3.setText(inventory.get(3).getName());
            itemLabel3.setVisible(true);
        }
        if (i == 4) {
            itemLabel4.setText(inventory.get(4).getName());
            itemLabel4.setVisible(true);
        }
        if (i == 5) {
            itemLabel5.setText(inventory.get(5).getName());
            itemLabel5.setVisible(true);
        }
        if (i == 6) {
            itemLabel6.setText(inventory.get(6).getName());
            itemLabel6.setVisible(true);
        }
        if (i == 7) {
            itemLabel7.setText(inventory.get(7).getName());
            itemLabel7.setVisible(true);
        }
        if (i == 8) {
            itemLabel8.setText(inventory.get(8).getName());
            itemLabel8.setVisible(true);
        }
        if (i == 9) {
            itemLabel9.setText(inventory.get(9).getName());
            itemLabel9.setVisible(true);
        }

    }

    private void setItemLabelInvisible() {
        itemLabel0.setVisible(false);
        itemLabel1.setVisible(false);
        itemLabel2.setVisible(false);
        itemLabel3.setVisible(false);
        itemLabel4.setVisible(false);
        itemLabel5.setVisible(false);
        itemLabel6.setVisible(false);
        itemLabel7.setVisible(false);
        itemLabel8.setVisible(false);
        itemLabel9.setVisible(false);
    }


    private void setDiceInvisible() {
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


    private void animateDiceRoll() {
        final int animationFrames = 20;         // Number of frames
        final int frameIntervalMs = 60;         // Milliseconds between frames
        final Random random = new Random();
        Timeline timeline = new Timeline();

        for (int i = 0; i < animationFrames; i++) {
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(i * frameIntervalMs),
                            e -> {
                                int face = 1 + random.nextInt(6);
                                showDice(face);
                            })
            );
        }

        timeline.play();
    }

    private void animateTwoDiceRoll() {
        final int animationFrames = 20;
        final int frameIntervalMs = 60;         // Milliseconds between frames
        final Random random = new Random();
        Timeline timeline = new Timeline();

        for (int i = 0; i < animationFrames; i++) {
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(i * frameIntervalMs), e -> {
                        int face = 1 + random.nextInt(2, 12);
                        showTwoDice(face);
                    })
            );
        }

        timeline.play();
    }


    public BooleanProperty loginCompletedProperty() {
        return loginIsCompleted;
    }




    @FXML
    public void pressOfGoto(ActionEvent event) {
        int actionPointID = getPressedAPID(event);
        if (actionPointID == 1) {
            choosePotion();
        }
        if(adventure.getAp().getID() ==91 && actionPointID==257){
            adventure.getCurrentPlayer().changeAttack(4);
        }
        setDiceInvisible();
        setVisibilityOnGTButtons();
        adventure.setAp(actionPointID);
        System.out.println(actionPointID);
        displayDescription(actionPointID);// dnfw.... srsly
        setStatsAmount();
        setActionPointToGUI();
//        displayDescription(actionPointID);


    }

    private int getPressedAPID(ActionEvent event) {
        Button sourceButton = (Button) event.getSource(); // Get the source and cast it to Button
        String buttonText = sourceButton.getText();
        return Integer.parseInt(buttonText);
    }

    public void setCombatSwordImagetoVisable() {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1.0), e -> combatSwordImage.setVisible(true)),
                new KeyFrame(Duration.seconds(2.0), e -> combatSwordImage.setVisible(false))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Create a timeline check to stop the animation
        Timeline checkCreatures = new Timeline(
                new KeyFrame(Duration.seconds(0.1), e -> {
                    if (adventure.getAp().getContainedCreatures().isEmpty()) {
                        timeline.stop();
                        combatSwordImage.setVisible(false);
                    }
                })
        );
        checkCreatures.setCycleCount(Timeline.INDEFINITE);
        checkCreatures.play();
    }


    private ActionPoint displayDescription(int pressedAPID) {
        // description
        // hver gang vi klikker på en knap
        ActionPoint newAP = adventure.getDm().selectActionPoints(pressedAPID);
        setScrollPaneText(newAP.getDescription());
        setNameOfGTButtons(newAP);
        return newAP;


    }


    private void setStatsAmount() {

        healthAmount.setText(adventure.getCurrentPlayer().getCurrentHealth() + "");
        attackAmount.setText(adventure.getCurrentPlayer().getCurrentAttack() + "");
        luckAmount.setText(adventure.getCurrentPlayer().getCurrentLuck() + "");
        goldAmount.setText(adventure.getCurrentPlayer().getGoldCoins() + "");
        foodAmount.setText(adventure.getCurrentPlayer().getFoodRations() + "");
        setPlayersStarterPointVFX(adventure.getCurrentPlayer().getStarterPotion());


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

        for (int i = 0; i < AAPList.size(); i++) {
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


    private void setVisibilityOnGTButtons() {
        GTButton1.setVisible(false);
        GTButton2.setVisible(false);
        GTButton3.setVisible(false);
        GTButton4.setVisible(false);
        GTButton5.setVisible(false);
        GTButton6.setVisible(false);
    }


    private void animateDescription(Label label) {
        FadeTransition fade = new FadeTransition(Duration.seconds(1), label);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.play();
    }


    private void typingAnimation(Label label, String text, double speed) {

        Timeline previousTimeline = (Timeline) label.getUserData();
        if (previousTimeline != null) {
            previousTimeline.stop();
        }

        label.setText("");

        Timeline timeline = new Timeline();
        int[] index = {0};

        KeyFrame keyframe = new KeyFrame(Duration.millis(speed), event -> {
            if (index[0] < text.length()) {
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            }
        });
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(text.length());
        timeline.setOnFinished(e -> label.setUserData(null)); // Clean up reference
        label.setUserData(timeline); // Store reference for next call

        timeline.play();
    }


    public Button getGTButton1() {
        return GTButton1;
    }


    public Button getGTButton2() {
        return GTButton2;
    }


    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
        this.actionPoint = adventure.getAp();

    }

    public void setActionPointToGUI() {
        ActionPoint ap = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();


        if (ap.getChangeHealthPoints() != 0) {
            currentPlayer.changeHealth(ap.getChangeHealthPoints());
        }
        if (ap.getChangeAttackPoints() != 0) {
            currentPlayer.changeAttack(ap.getChangeAttackPoints());
        }
        if (ap.getContainedCreatures() != null) {
//            combat();
            setCombatSwordImagetoVisable();
        }
        if (ap.getLuckRoll()) {
            rollForLuck();
        }

        if (adventure.getAp().getContainItem() != null) {
            if (adventure.getCurrentPlayer().getInventory() != null) {
                adventure.getCurrentPlayer().addToInventory(adventure.getAp().getContainItem());

            }
        }
        if (ap.getGoldCoins() != 0) {
            currentPlayer.changeGoldCoins(ap.getGoldCoins());
        }
        if (ap.getDieRoll()) {
            rollDice(2);
        }
        if (ap.getIsFinal()) {
            showDeathPopUp();
        }
        if (ap.getWinnerActionPoint()) {
            System.out.println("Congratz you won!");
        }

        if (currentPlayer.getCurrentHealth() < 0) {
            showDeathPopUp();
        }

        setPlayersStarterPointVFX(currentPlayer.getStarterPotion());
        adventure.actionPointEvents();


    }


    private int rollForLuck() {
        int rdm = rollDice(2);

        getGTButton1().setVisible(false);

        if (rdm < adventure.getCurrentPlayer().getCurrentLuck()) {
            adventure.getCurrentPlayer().changeCurrentLuck(-1);
            getGTButton1().setVisible(true);
        }

        showDice(rdm);
        return rdm;

    }

    private boolean rollForLuckBloodBeast() {
        return (rollForLuck() < adventure.getCurrentPlayer().getCurrentLuck());

    }


    public void combat() {
        ActionPoint ap = adventure.getAp();

        for (Creature creatureEvent : ap.getContainedCreatures()) {

            if (creatureEvent.getId() == 8) {
                combatGiantScorpion();
            } else if (creatureEvent.getId() == 14) {
                combatBloodBeast();
            } else if (creatureEvent.getId() == 24) {
                combatMirrorDemon();
                // } else if (creatureEvent.getId() == 1) {
                //canFlee
                //remove 2 health TBD
            } else if (creatureEvent.getId() == 19) {
                combatImitator();
            } else regularCombat();
        }
    }

    public void combatImitator() {


        for (Creature imitator : adventure.getAp().getContainedCreatures()) {
            setCombatSwordImagetoVisable();

            boolean notWonARound = true;

            while (notWonARound) {
                //while (adventure.getCurrentPlayer().getCurrentHealth() > 0 && bloodBeast.getCurrentHealth() > 0) {
                int playerAttack = adventure.getCurrentPlayer().getCurrentAttack() + adventure.dieRoll();
                int imitatorAttack = imitator.getCurrentAttack() + adventure.dieRoll();

                if (imitatorAttack > playerAttack) {
                    adventure.getCurrentPlayer().changeHealth(-2);

                }
                if (playerAttack > imitatorAttack) {
                    notWonARound = false;
                }
                if (adventure.getCurrentPlayer().getCurrentHealth() < 0) {
                    showDeathPopUp();
                }

            }
            int actionPointID = 314;

            setDiceInvisible();
            setVisibilityOnGTButtons();
            adventure.setAp(actionPointID);
            displayDescription(actionPointID);
            setStatsAmount();
            setActionPointToGUI();

            displayInventory();

        }
    }

    private void combatBloodBeast() {


        for (Creature bloodBeast : adventure.getAp().getContainedCreatures()) {
            setCombatSwordImagetoVisable();

            boolean notWonARound = true;

            while (notWonARound) {
                //while (adventure.getCurrentPlayer().getCurrentHealth() > 0 && bloodBeast.getCurrentHealth() > 0) {
                int playerAttack = adventure.getCurrentPlayer().getCurrentAttack() + adventure.dieRoll();
                int bloodBeastAttack = bloodBeast.getCurrentAttack() + adventure.dieRoll();

                if (bloodBeastAttack > playerAttack) {
                    adventure.getCurrentPlayer().changeHealth(-2);

                }
                if (playerAttack > bloodBeastAttack) {
                    notWonARound = false;
                }
                if (adventure.getCurrentPlayer().getCurrentHealth() < 0) {
                    showDeathPopUp();
                }

            }


            if (rollForLuckBloodBeast()) {

                int actionPointID = 97;

                setDiceInvisible();
                setVisibilityOnGTButtons();
                adventure.setAp(actionPointID);
                displayDescription(actionPointID);
                setStatsAmount();
                setActionPointToGUI();
                displayInventory();
            } else {
                int actionPointID = 21;

                setDiceInvisible();
                setVisibilityOnGTButtons();
                adventure.setAp(actionPointID);
                displayDescription(actionPointID);
                setStatsAmount();
                setActionPointToGUI();

                displayInventory();
            }


        }
    }

    public void combatBloodBeast2() {


        for (Creature bloodBeast : adventure.getAp().getContainedCreatures()) {
            setCombatSwordImagetoVisable();

            boolean notWonARound = true;

            while (notWonARound) {
                //while (adventure.getCurrentPlayer().getCurrentHealth() > 0 && bloodBeast.getCurrentHealth() > 0) {
                int playerAttack = adventure.getCurrentPlayer().getCurrentAttack() + adventure.dieRoll();
                int bloodBeastAttack = bloodBeast.getCurrentAttack() + adventure.dieRoll();

                if (bloodBeastAttack > playerAttack) {
                    adventure.getCurrentPlayer().changeHealth(-2);

                }
                if (playerAttack > bloodBeastAttack) {
                    notWonARound = false;
                }
                if (adventure.getCurrentPlayer().getCurrentHealth() < 0) {
                    showDeathPopUp();
                }

            }


            if (rollForLuckBloodBeast()) {

                int actionPointID = 97;

                setDiceInvisible();
                setVisibilityOnGTButtons();
                adventure.setAp(actionPointID);
                displayDescription(actionPointID);
                setStatsAmount();
                setActionPointToGUI();
                displayInventory();
            } else {
                int actionPointID = 116;

                setDiceInvisible();
                setVisibilityOnGTButtons();
                adventure.setAp(actionPointID);
                displayDescription(actionPointID);
                setStatsAmount();
                setActionPointToGUI();

                displayInventory();
            }
        }
    }


    private void combatMirrorDemon() {
        ActionPoint ap = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();

        for (Creature mirrorDemon : ap.getContainedCreatures()) {
            setCombatSwordImagetoVisable();

            int mirrorDemonHP = mirrorDemon.getCurrentHealth();

            while (mirrorDemonHP > 0) {

                int playerAttack = currentPlayer.getCurrentAttack() + adventure.dieRoll();
                int mirrorDemonAttack = mirrorDemon.getCurrentAttack() + adventure.dieRoll();

                if (mirrorDemonAttack > playerAttack) {
                    int actionPointID = 8;


                    setDiceInvisible();
                    setVisibilityOnGTButtons();
                    adventure.setAp(actionPointID);
                    displayDescription(actionPointID);
                    setActionPointToGUI();
                    setStatsAmount();
//                  adventure.actionPointEvents();
                    displayInventory();

                } else if (mirrorDemonAttack == playerAttack) {
                } else {
                    mirrorDemonHP -= 2;
                }
            }
        }
    }

    private void combatGiantScorpion() {
        ActionPoint ap = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();

        for (Creature creatureEvent2 : ap.getContainedCreatures()) {
            setCombatSwordImagetoVisable();
            while (currentPlayer.getCurrentHealth() > 0 && creatureEvent2.getCurrentHealth() > 0) {

                // Player attack
                int playerAttack = currentPlayer.getCurrentAttack() + adventure.dieRoll();
                int creatureAttack = creatureEvent2.getCurrentAttack() + adventure.dieRoll();
                int creatureAttack1 = creatureEvent2.getCurrentAttack() + adventure.dieRoll();


                if (playerAttack > creatureAttack && playerAttack > creatureAttack1) {
                    creatureEvent2.changeCurrentHealth(-2);
                } else if (creatureAttack > playerAttack || creatureAttack1 > playerAttack) {
                    currentPlayer.changeHealth(-2);

                } else if (currentPlayer.getCurrentHealth() <= 0) {
                    showDeathPopUp();
                }

                if (creatureAttack + creatureAttack1 == 22) {
                    int actionPointID = 2;


                    setDiceInvisible();
                    setVisibilityOnGTButtons();
                    adventure.setAp(actionPointID);
                    displayDescription(actionPointID);// dnfw.... srsly
                    setActionPointToGUI();
                    setStatsAmount();
                    displayInventory();


                }
                break;

            }
        }
    }

    private void regularCombat() {

        ActionPoint ap = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();

        ArrayList<Creature> creatures = ap.getContainedCreatures();
        setCombatSwordImagetoVisable();
        for (Creature creature : creatures) {


            while (currentPlayer.getCurrentHealth() > 0 && creature.getCurrentHealth() > 0) {
                //setCombatSwordImagetoVisable()

                // Player attack
                int playerAttack = currentPlayer.getCurrentAttack() + adventure.dieRoll();
                int creatureAttack = creature.getCurrentAttack() + adventure.dieRoll();

                if (playerAttack > creatureAttack) {
                    creature.changeCurrentHealth(-2);
                } else if (creatureAttack > playerAttack) {
                    currentPlayer.changeHealth(-2);
                } else if (currentPlayer.getCurrentHealth() <= 0) {
                    showDeathPopUp();
                }
                if (creature.getCurrentHealth() <= 0) { //Has error, but game runs anyway
                    creatures.remove(creature);
                }
            }
        }
    }


    private void choosePotion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("vælg en starterdrik!");
        alert.setContentText("");

        ButtonType leftButton = new ButtonType("Evnedrik!");
        ButtonType middleButton = new ButtonType("Udholdenhedrik!");
        ButtonType rightButton = new ButtonType("Helddrik!");
        alert.getButtonTypes().setAll(leftButton, middleButton, rightButton);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == leftButton) {
                adventure.getCurrentPlayer().setStarterPotion(1);


            }

            if (result.get() == middleButton) {
                adventure.getCurrentPlayer().setStarterPotion(2);


            }

            if (result.get() == rightButton) {


                adventure.getCurrentPlayer().setStarterPotion(3);
            }

        }
        setPlayersStarterPointVFX(adventure.getCurrentPlayer().getStarterPotion());
    }


    private void showDeathPopUp() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("dit eventyr slutter her!");
        alert.setContentText("vil du spille igen eller afslutte spillet her ? ");

// Set custom button types
        ButtonType leftButton = new ButtonType("Spil igen!");
        ButtonType rightButton = new ButtonType("Afslut spillet");

        alert.getButtonTypes().setAll(leftButton, rightButton);

// Show the alert and wait for a response
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == leftButton) {
                setVisibilityOnGTButtons();
                adventure.createNewPlayer();

                adventure.setAp(401);
                displayDescription(401);
            } else if (result.get() == rightButton) {
                adventure.savePlayerfromAdventure();
                Platform.exit();
            }
        }
    }
}
