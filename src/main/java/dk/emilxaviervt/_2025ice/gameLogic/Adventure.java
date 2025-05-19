package dk.emilxaviervt._2025ice.gameLogic;

import dk.emilxaviervt._2025ice.Items.Item;
import dk.emilxaviervt._2025ice.MainFX;
import dk.emilxaviervt._2025ice.VFX.ControllerFX;
import dk.emilxaviervt._2025ice.util.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Adventure {
    //    DataBaseManager dm;
//    ClientFX clientFX;
    private Player currentPlayer;
    private int health = rollHealth();
    private int attack = rollAttackAndLuck();
    private int luck = rollAttackAndLuck();
    private ActionPoint ap;
    private DatabaseManager dm = new DatabaseManager();
    private ControllerFX cfx;
    
    
    
    ArrayList<Item> allItems = dm.getAllItemsInArrayList();
    
    public Adventure() {
        this.currentPlayer = new Player("test13", health, attack, luck,health, attack, luck, true, "Emil", 1,0,10,2);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/clienter/activeGameScreen.fxml"));
        loader.setController(new ControllerFX());

        try {
            Parent root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.cfx =loader.getController();

        this.cfx.setAdventure(this);
        this.ap = dm.selectActionPoints(401);
    }


    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void createNewPlayer(){

        int newHealth = rollHealth();
        int newAttack = rollAttackAndLuck();
        int newLuck = rollAttackAndLuck();

        this.currentPlayer = new Player(currentPlayer.getName(), newHealth, newAttack, newLuck, newHealth, newAttack, newLuck, true, currentPlayer.getName(), 1,0,10,2);
    }

    public void actionPointEvents() {
        Random random = new Random();


        if (ap.getEvent() != 0) {
            switch (ap.getEvent()) {
                case 1:

                    cfx.rollDice(1);
                    break;
                case 2:
                    cfx.rollDice(2);
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
                    currentPlayer.removeFromInventory(allItems.get(15)); // index starter på 0 vi starter på 1 i db
                    break;
                case 7:
                    currentPlayer.changeHealth(-dieRoll()+dieRoll());
                    currentPlayer.changeLuck(-2);
                    break;
                case 8:
                    cfx.getGTButton1().setVisible(false);
                    if (currentPlayer.getInventory().contains(allItems.get(33))) {
//                        set visibility of GTButton1 to visible
                        cfx.getGTButton1().setVisible(true);
                    }
                    break;
                case 9:

                    if (currentPlayer.getInventory().contains(allItems.get(16))) {
                        currentPlayer.removeFromInventory(allItems.get(16));
                    }
                    break;
                case 10:
                    cfx.getGTButton2().setVisible(false);
                    if (currentPlayer.getIsEquipped()) {
                        cfx.getGTButton2().setVisible(true);
                    }
                    break;
                case 11:
                    currentPlayer.changeFoodRations(-2);
                    break;
                case 12:
                    int rs = dieRoll() + 1;
                    currentPlayer.changeHealth(rs);
                    break;
                case 13:
                    rs = dieRoll() + dieRoll();
                    currentPlayer.changeHealth(rs);
                    break;
                case 14:
                    cfx.combat();
                    break;
                case 15:
//                    kræver combat
                    break;
                case 16:
                    int rdm = random.nextInt(1, 4);
                    int juvel = rdm;
                    if (rdm == 1) {
                        juvel = 12;
                    } else if (rdm == 2) {
                        juvel = 21;
                    } else if (rdm == 3) {
                        juvel = 23;
                    }
                    if (ap.getID() == 357) {
                        currentPlayer.getInventory().remove(allItems.get(juvel));
                    }
                    if (ap.getID() == 332) {
                        currentPlayer.getInventory().remove(allItems.get(juvel));
                    }
                    if (ap.getID() == 271) {
                        currentPlayer.getInventory().remove(allItems.get(16));
                    }
                    if (ap.getID() == 261) {
                        currentPlayer.getInventory().remove(allItems.get(31));
                    }

                    break;
                case 17:
                    cfx.getGTButton1().setVisible(false);
                    if (dieRoll() + dieRoll() == 8) {
                        cfx.getGTButton1().setVisible(true);
                    }

                    break;
                case 18:
                    ap.getLuckRoll();
                    break;
                case 19:

                    currentPlayer.removeOneItemFromInventory();
                    currentPlayer.changeLuck(-1);
                    break;
                case 20:
                    ArrayList<Item> inventory = currentPlayer.getInventory();
                    for (Item i : inventory) {
                        currentPlayer.removeFromInventory(i);
                    }
                    currentPlayer.changeLuck(-2);
                    currentPlayer.changeFoodRations(-10);
                    break;
                case 21:
//                    Jeg tror ikke der skal ske noget her ? det er kun case 157 der bruger den og den skal ikke bruge en metode?
//                    currentPlayer.addToInventory(allItems.get(31));
//                    currentPlayer.changeLuck(1);
                    break;
                case 22:
                    currentPlayer.changeLuck(1);
                    currentPlayer.addToInventory(allItems.get(11));
                    currentPlayer.addToInventory(allItems.get(6));
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
                    currentPlayer.changeHealth(dieRoll() * -1);
                    break;
                case 27:
                    rdm = random.nextInt(1, 3);
                    if (rdm == 1) {
                        currentPlayer.changeGoldCoins(-1);
                    }
                    if (rdm == 2) {
                        currentPlayer.changeFoodRations(-1);
                    }
                    if (rdm == 3) {
                        currentPlayer.removeOneItemFromInventory();
                    }
                    break;
                case 28:
                    cfx.getGTButton1().setVisible(false);
                    currentPlayer.changeLuck(-2);
                    if (dieRoll() + dieRoll() <= currentPlayer.currentHealth) {
                        cfx.getGTButton1().setVisible(true);
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
                    currentPlayer.changeHealth(dieRoll() * -2);
                    break;
                case 32:
                    currentPlayer.changeLuck(1);
                    break;
                case 33:
                    currentPlayer.changeHealth((dieRoll() + 2) * -1);
                    break;
                case 34:
                    currentPlayer.addToInventory(allItems.get(24));
                    currentPlayer.addToInventory(allItems.get(25));
                    break;
                default:
                    System.out.println("Error at switch-case chain in actionPointEvents() in Adventure.java");
                    break;


            }

        }

    }






public void setAp(int id) {
        this.ap = dm.selectActionPoints(id);;
}



// metode til at skabe nye spilere

    private int rollHealth() {
        Random random = new Random();
        int rs = random.nextInt(1, 7);
        int rs2 = random.nextInt(1, 7);
        return rs +rs2+ 12;
    }

    private int rollAttackAndLuck() {
        Random random = new Random();
        int rs = random.nextInt(1, 7);
        return rs + 6;
    }

    public int dieRoll(){
        Random random = new Random();
        int rs = random.nextInt(1, 7);
        return rs;
    }



// vi får lavet en start værdei på spileren gennem en metode og en dertil liggende værdi som vi kan give spilleren










    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ActionPoint getAp() {
        return ap;
    }


    public void savePlayerfromAdventure() {
        dm.savePlayerToDatabase(currentPlayer);
    }

    public DatabaseManager getDm() {
        return dm;
    }
}






