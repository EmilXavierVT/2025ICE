package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.Items.Item;
import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import dk.emilxaviervt._2025ice.gameLogic.Player;
import dk.emilxaviervt._2025ice.gameLogic.ActionPoint;
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

    public int rollDice(int numberOfDice){
        Random random = new Random();
        int rdm=0;
        if(numberOfDice == 1){
            rdm = random.nextInt(1, 7);
            showDice(rdm);
        }else if(numberOfDice == 2) {
            rdm = random.nextInt(2, 13);
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
        setStatsAmount();
        setDiceInvisible();

        setVisibilityonGTButons();
        Button sourceButton = (Button) event.getSource(); // Get the source and cast it to Button
        String buttonText = sourceButton.getText();
        int actionPointID = Integer.parseInt(buttonText);
        if(adventure.getDm().selectActionPoints(actionPointID).getLuckRoll()){
            rollDice(2);
        } else if (adventure.getDm().selectActionPoints(actionPointID).getEvent()==1) {
            rollDice(1);
        } else if (adventure.getDm().selectActionPoints(actionPointID).getEvent()==2) {
            rollDice(2);
        }
        if(adventure.getDm().selectActionPoints(actionPointID).getDieRoll()){
            rollDice(2);
        }
        // Get the text on the button
        System.out.println(buttonText);
        System.out.println(adventure.getDm().selectActionPoints(actionPointID).getDescription());
        displayDescription(actionPointID);// dnfw.... srsly
        actionPointEvents();


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


    public void actionPointEvents() {
        Random random = new Random();
        ActionPoint currentActionPoint = adventure.getAp();
        Player currentPlayer = adventure.getCurrentPlayer();
        DatabaseManager dm = adventure.getDm();

//        Metode der behandler alle forskelligheder på actionPoint objektet
//        hvis et AP har et luck roll, et monster osv
        if (currentActionPoint.getItemNeeded() != 0) {
        }
        if (currentActionPoint.getEvent() != 0) {
            switch (currentActionPoint.getEvent()) {
                case 1:

                    rollDice(1);
                    break;
                case 2:
                    rollDice(2);
                    break;
                case 3:
                    currentPlayer.changeFoodRations(-100);
                    break;
                case 4:
                    currentPlayer.changeFoodRations(-10);
                    currentPlayer.removeOneItemFromInventory();
                    break;
                case 5:
                    currentPlayer.changeFoodRations(-1);
                    break;
                case 6:
                    currentPlayer.removeFromInventory(dm.selectItem(17));
                    break;
                case 7:
                    currentPlayer.changeHealth(dieRoll()+dieRoll());
                    currentPlayer.changeLuck(-2);
                    break;
                case 8:
                    changeGT1visibility(new ActionEvent(),false);
                    if(currentPlayer.getInventory().contains(dm.selectItem(35))) {
//                        set visibility of currentActionPoint to visible

                        changeGT1visibility(new ActionEvent(), true);
                    }
                    break;
                case 9:

                    if (currentPlayer.getInventory().contains(dm.selectItem(17))){
                        currentPlayer.removeFromInventory(dm.selectItem(17));
                    }
                    break;
                case 10:

                    changeGT1visibility(new ActionEvent(),false);
                    if(currentPlayer.isEquipped()) {

                        changeGT1visibility(new ActionEvent(), true);}
                    break;
                case 11:
                    currentPlayer.changeFoodRations(-2);
                    break;
                case 12:
                    int rs = dieRoll()+1;
                    currentPlayer.changeHealth(rs);
                    break;
                case 13:
                    rs = dieRoll()+dieRoll();
                    currentPlayer.changeHealth(rs);
                    break;
                case 14:
                    adventure.combat(currentActionPoint.getContainedCreatures());
                    break;
                case 15:
//                    kræver combat
                    break;
                case 16:
                    int rdm = random.nextInt(1, 3);
                    int juvel=rdm;
                    if(rdm==1){juvel=13;}
                    else if(rdm==2){juvel=23;}
                    else if(rdm==3){juvel=25;}
                    if(currentActionPoint.getID() ==357){currentPlayer.getInventory().remove(dm.selectItem(juvel));}
                    if(currentActionPoint.getID()==332){currentPlayer.getInventory().remove(dm.selectItem(juvel));}
                    if(currentActionPoint.getID()==271){currentPlayer.getInventory().remove(dm.selectItem(17));}
                    if(currentActionPoint.getID()==261){currentPlayer.getInventory().remove(dm.selectItem(32));}

                    break;
                case 17:

                    changeGT1visibility(new ActionEvent(),false);
                    if (dieRoll() +dieRoll() == 8) {
                        changeGT1visibility(new ActionEvent(), true);
                    }

                    break;
                case 18:
                    currentActionPoint.getLuckRoll();
                    break;
                case 19:

                    currentPlayer.removeOneItemFromInventory();
                    currentPlayer.changeLuck(-1);
                    break;
                case 20:
                    ArrayList<Item> inventory = currentPlayer.getInventory();
                    for(Item i : inventory){
                        currentPlayer.removeFromInventory(i);
                    }
                    currentPlayer.changeLuck(-2);
                    currentPlayer.changeFoodRations(-10);
                    break;
                case 21:
                    currentPlayer.addToInvertory(dm.selectItem(33));
                    currentPlayer.changeLuck(1);
                    break;
                case 22:
                    currentPlayer.changeLuck(1);
                    currentPlayer.addToInvertory(dm.selectItem(12));
                    currentPlayer.addToInvertory(dm.selectItem(7));
                    break;
                case 23:
                    //Combat metode her (hvis spejldæmon vinder 1 gang over player, gå til AP 8)
                    break;
                case 24:
                    currentPlayer.changeLuck(-2);
                    break;
                case 25:
                    currentPlayer.changeLuck(2);
                    break;
                case 26:
                    currentPlayer.changeHealth(dieRoll()*-1);
                    break;
                case 27:
                    rdm = random.nextInt(1, 3);
                    if(rdm==1){currentPlayer.changeGoldCoins(-1);}
                    if(rdm==2){currentPlayer.changeFoodRations(-1);}
                    if(rdm==3){currentPlayer.removeOneItemFromInventory();}
                    break;
                case 28:
                    changeGT1visibility(new ActionEvent(),false);
                    currentPlayer.changeLuck(-2);
                    if(dieRoll()+dieRoll()<= currentPlayer.getCurrentHealth()){
                    changeGT1visibility(new ActionEvent(), true);
                        //55
                    }

                    break;
                case 29:
//                    no need for Method
                    break;
                case 30:
                    currentPlayer.removeOneItemFromInventory();
                    break;
                case 31:
                    currentPlayer.changeLuck(-1);
                    currentPlayer.changeHealth(dieRoll()*-2);
                    break;
                case 32:
                    currentPlayer.changeLuck(1);
                    break;
                case 33:
                    currentPlayer.changeHealth((dieRoll()+2)*-1);
                    break;
                case 34:
                    currentPlayer.addToInvertory(dm.selectItem(26));
                    currentPlayer.addToInvertory(dm.selectItem(27));
                    break;
                default:
                    System.out.println("Error at switch-case chain in actionPointEvents() in Adventure.java");
                    break;

            }
            if (currentActionPoint.getChangeHealthPoints() != 0) {
                currentPlayer.changeHealth(currentActionPoint.getChangeHealthPoints());
            }
            if (currentActionPoint.getChangeAttackPoints() != 0) {
                currentPlayer.changeAttack(currentActionPoint.getChangeAttackPoints());
            }
            if (currentActionPoint.getContainedCreatures() != null) {
                adventure.combat(currentActionPoint.getContainedCreatures());


            }

            if (currentActionPoint.getLuckRoll() == true) {

                changeGT1visibility(new ActionEvent(),false);
                int rdm =rollDice(2);

                if(rdm < currentPlayer.getCurrentLuck()){changeGT1visibility(new ActionEvent(), true);}

//                gui interface

            }
            if (currentActionPoint.getContainItem() != 0) {
                currentPlayer.addToInvertory(dm.selectItem(currentActionPoint.getContainItem()));
            }
            if (currentActionPoint.getGoldCoins() != 0) {
                currentPlayer.changeGoldCoins(currentActionPoint.getGoldCoins());
            }
            if (currentActionPoint.getDieRoll() == true) {
//                GUI interface
            }
            if (currentActionPoint.getIsFinal() == true) {

//                end game GUI interface
            }
            if (currentActionPoint.getWinnerActionPoint() == true) {
                System.out.println("Congratz you won!");
            }

        }
    }

    public int dieRoll(){
        Random random = new Random();
        int rs = random.nextInt(1, 7);
        return rs;
    }


}

