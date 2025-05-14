package dk.emilxaviervt._2025ice.userLogic;

import java.sql.Connection;

public class ActionPoint {
    private int ID;
    private String description;
    private int containItem;
    private int itemNeeded;
    private int goldCoins;
    private String availableActionPoints;
    private String containedCreature;
    private boolean isFinal;
    private boolean winnerActionPoint;
    private boolean luckRoll;
    private int changeAttackPoints;
    private int changeHealthPoints;
    private boolean dieRoll;
    private int event;

    Connection con;



    public ActionPoint(int ID, String description, int containItem, int itemNeeded, int goldCoins,
                       String availableActionPoints, String containedCreature, boolean isFinal, boolean winnerActionPoint,
                       boolean luckRoll, int changeAttackPoints, int changeHealthPoints, boolean dieRoll, int event) {
        this.ID = ID;
        this.description = description;
        this.containItem = containItem;
        this.itemNeeded = itemNeeded;
        this.goldCoins = goldCoins;
        this.availableActionPoints = availableActionPoints;
        this.containedCreature = containedCreature;
        this.isFinal = isFinal;
        this.winnerActionPoint = winnerActionPoint;
        this.luckRoll = luckRoll;
        this.changeAttackPoints = changeAttackPoints;
        this.changeHealthPoints = changeHealthPoints;
        this.dieRoll = dieRoll;
        this.event = event;
    }
    //METODER







    //console test

    public void printDescription() {

        System.out.println(description);
    }

    public void printGoldCoins() {

        System.out.println(goldCoins);
    }







//              GETTERS AND SETTERS
    public int getID() {return ID;}

    public String getDescription() {return description;}

    public int getContainItem() {return containItem;}

    public int isItemNeeded() {return itemNeeded;}

    public int getGoldCoins() {return goldCoins;}

    public String getAvailableActionPoints() {return availableActionPoints;}

    public String getContainedCreature() {return containedCreature;}

    public boolean isFinal() {return isFinal;}

    public boolean isWinnerActionPoint() {return winnerActionPoint;}

    public boolean isLuckRoll() {return luckRoll;}

    public int getChangeAttackPoints() {return changeAttackPoints;}

    public int getChangeHealthPoints() {return changeHealthPoints;}

    public boolean isDieRoll() {return dieRoll;}

    public int getEvent() {return event;}
}
