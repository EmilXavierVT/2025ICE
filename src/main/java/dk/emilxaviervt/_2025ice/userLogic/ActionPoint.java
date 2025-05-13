package dk.emilxaviervt._2025ice.userLogic;

import java.sql.Connection;

public class ActionPoint {
    private int ID;
    private String description;
    private String containItem;
    private boolean itemNeeded;
    private int goldCoins;
    private int availableActionPoints;
    private int containedCreature;
    private boolean isFinal;
    private boolean winnerActionPoint;
    private boolean luckRoll;
    private int changeAttackPoints;
    private int changeHealthPoints;

    Connection con;


    public ActionPoint(){

    }

}
