package dk.emilxaviervt._2025ice.gameLogic;

import dk.emilxaviervt._2025ice.userLogic.ActionPoint;
import dk.emilxaviervt._2025ice.util.DatabaseManager;

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
    private int starterRoom =dm.selectActionPoints(401).getID();

    public Adventure() {
        this.currentPlayer = new Player("test13", health, attack, luck, health, attack, luck, true, "Emil", 1,0,10,2);

        this.ap = dm.selectActionPoints(starterRoom);
    }

// metode til at skabe nye spilere

    private int rollHealth() {
        Random random = new Random();
        int rs = random.nextInt(1, 6);
        int rs2 = random.nextInt(1, 6);
        return rs +rs2+ 12;
    }

    private int rollAttackAndLuck() {
        Random random = new Random();
        int rs = random.nextInt(1, 6);
        return rs + 6;
    }


// vi får lavet en start værdei på spileren gennem en metode og en dertil liggende værdi som vi kan give spilleren


    private void combat(Creature creature) {

    }

    public void singleRoll() {

    }

    public void doubleRoll() {

    }

    public void giveHealthBoost() {


        if (currentPlayer.getCurrentHealth() < currentPlayer.getMaxHealth()) {

            currentPlayer.changeFoodRations(-1);
            currentPlayer.changeHealth(4);
        }  if (currentPlayer.getCurrentHealth() > currentPlayer.getMaxHealth()) {

            currentPlayer.setCurrentHealth(currentPlayer.getMaxHealth());


        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ActionPoint getAp() {
        return ap;
    }


    public void savePlayerfromAdventure() {
        dm.savePlayerToDatabase(currentPlayer);
    }
}






