package dk.emilxaviervt._2025ice.gameLogic;

import dk.emilxaviervt._2025ice.VFX.ControllerFX;
import dk.emilxaviervt._2025ice.util.DatabaseManager;

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
    private int starterRoom =dm.selectActionPoints(401).getID();
    ControllerFX cfx = new ControllerFX(this);

    public Adventure() {
        this.currentPlayer = new Player("test13", health, attack, luck, health, attack, luck, true, "Emil", 1,0,10,2);

        this.ap = dm.selectActionPoints(starterRoom);
    }
//    public void actionPointEvents() {
//        Random random = new Random();
////        Metode der behandler alle forskelligheder på actionPoint objektet
////        hvis et AP har et luck roll, et monster osv
//        if (ap.getItemNeeded() != 0) {
//        }
//        if (ap.getEvent() != 0) {
//            switch (ap.getEvent()) {
//                case 1:
//
//                    cfx.rollDice(1);
//                    break;
//                case 2:
//                    cfx.rollDice(2);
//                    break;
//                case 3:
//                    currentPlayer.changeFoodRations(-100);
//                    break;
//                case 4:
//                    currentPlayer.changeFoodRations(-10);
//                    currentPlayer.removeOneItemFromInventory();
//                    break;
//                case 5:
//                    currentPlayer.changeFoodRations(-1);
//                    break;
//                case 6:
//                    currentPlayer.removeFromInventory(dm.selectItem(17));
//                    break;
//                case 7:
//                   currentPlayer.changeHealth(dieRoll()+dieRoll());
//                    currentPlayer.changeLuck(-2);
//                    break;
//                case 8:
//                    cfx.getGTButton1().setVisible(false);
//                    if(currentPlayer.getInventory().contains(dm.selectItem(35))) {
////                        set visibility of GTButton1 to visible
//                        cfx.getGTButton1().setVisible(true);
//                    }
//                    break;
//                case 9:
//
//                    if (currentPlayer.getInventory().contains(dm.selectItem(17))){
//                        currentPlayer.removeFromInventory(dm.selectItem(17));
//                    }
//                    break;
//                case 10:
//                    cfx.getGTButton2().setVisible(false);
//                    if(currentPlayer.isEquipped) {
//                        cfx.getGTButton2().setVisible(true);}
//                    break;
//                case 11:
//                    currentPlayer.changeFoodRations(-2);
//                    break;
//                case 12:
//                     int rs = dieRoll()+1;
//                    currentPlayer.changeHealth(rs);
//                    break;
//                case 13:
//                    rs = dieRoll()+dieRoll();
//                    currentPlayer.changeHealth(rs);
//                    break;
//                case 14:
//                    combat(ap.getContainedCreatures());
//                    break;
//                case 15:
////                    kræver combat
//                    break;
//                case 16:
//                    int rdm = random.nextInt(1, 3);
//                    int juvel=rdm;
//                    if(rdm==1){juvel=13;}
//                    else if(rdm==2){juvel=23;}
//                    else if(rdm==3){juvel=25;}
//                    if(ap.getID() ==357){currentPlayer.getInventory().remove(dm.selectItem(juvel));}
//                    if(ap.getID()==332){currentPlayer.getInventory().remove(dm.selectItem(juvel));}
//                    if(ap.getID()==271){currentPlayer.getInventory().remove(dm.selectItem(17));}
//                    if(ap.getID()==261){currentPlayer.getInventory().remove(dm.selectItem(32));}
//
//                    break;
//                case 17:
//cfx.getGTButton1().setVisible(false);
//                if (dieRoll() +dieRoll() == 8) {
//                      cfx.getGTButton1().setVisible(true);
//                    }
//
//                    break;
//                case 18:
//                    ap.getLuckRoll();
//                    break;
//                case 19:
//
//                    currentPlayer.removeOneItemFromInventory();
//                    currentPlayer.changeLuck(-1);
//                    break;
//                case 20:
//                    ArrayList<Item> inventory = currentPlayer.getInventory();
//                    for(Item i : inventory){
//                        currentPlayer.removeFromInventory(i);
//                    }
//                    currentPlayer.changeLuck(-2);
//                    currentPlayer.changeFoodRations(-10);
//                    break;
//                case 21:
//                    currentPlayer.addToInvertory(dm.selectItem(33));
//                    currentPlayer.changeLuck(1);
//                    break;
//                case 22:
//                    currentPlayer.changeLuck(1);
//                    currentPlayer.addToInvertory(dm.selectItem(12));
//                    currentPlayer.addToInvertory(dm.selectItem(7));
//                    break;
//                case 23:
//                    //Combat metode her (hvis spejldæmon vinder 1 gang over player, gå til AP 8)
//                    break;
//                case 24:
//                    currentPlayer.changeLuck(-2);
//                    break;
//                case 25:
//                    currentPlayer.changeLuck(2);
//                    break;
//                case 26:
//                    currentPlayer.changeHealth(dieRoll()*-1);
//                    break;
//                case 27:
//                    rdm = random.nextInt(1, 3);
//                    if(rdm==1){currentPlayer.changeGoldCoins(-1);}
//                    if(rdm==2){currentPlayer.changeFoodRations(-1);}
//                    if(rdm==3){currentPlayer.removeOneItemFromInventory();}
//                    break;
//                case 28:
//                    cfx.getGTButton1().setVisible(false);
//                    currentPlayer.changeLuck(-2);
//                    if(dieRoll()+dieRoll()<= currentPlayer.currentHealth){
//                        cfx.getGTButton1().setVisible(true);
//                        //55
//                        }
//
//                    break;
//                case 29:
////                    no need for Method
//                    break;
//                case 30:
//                    currentPlayer.removeOneItemFromInventory();
//                    break;
//                case 31:
//                    currentPlayer.changeLuck(-1);
//                    currentPlayer.changeHealth(dieRoll()*-2);
//                    break;
//                case 32:
//                    currentPlayer.changeLuck(1);
//                    break;
//                case 33:
//                    currentPlayer.changeHealth((dieRoll()+2)*-1);
//                    break;
//                case 34:
//                    currentPlayer.addToInvertory(dm.selectItem(26));
//                    currentPlayer.addToInvertory(dm.selectItem(27));
//                    break;
//                default:
//                    System.out.println("Error at switch-case chain in actionPointEvents() in Adventure.java");
//                    break;
//
//            }
//            if (ap.getChangeHealthPoints() != 0) {
//                currentPlayer.changeHealth(ap.getChangeHealthPoints());
//            }
//            if (ap.getChangeAttackPoints() != 0) {
//                currentPlayer.changeAttack(ap.getChangeAttackPoints());
//            }
//            if (ap.getContainedCreatures() != null) {
//                    combat(ap.getContainedCreatures());
//
//
//            }
//
//            if (ap.getLuckRoll() == true) {
//
//                cfx.getGTButton1().setVisible(false);
//                int rdm =cfx.rollDice(2);
//
//                if(rdm < currentPlayer.getCurrentLuck()){cfx.getGTButton1().setVisible(true);};
//
////                gui interface
//
//            }
//            if (ap.getContainItem() != 0) {
//                currentPlayer.addToInvertory(dm.selectItem(ap.getContainItem()));
//            }
//            if (ap.getGoldCoins() != 0) {
//                currentPlayer.changeGoldCoins(ap.getGoldCoins());
//            }
//            if (ap.getDieRoll() == true) {
////                GUI interface
//            }
//            if (ap.getIsFinal() == true) {
//
////                end game GUI interface
//            }
//            if (ap.getWinnerActionPoint() == true) {
//                System.out.println("Congratz you won!");
//            }
//
//        }
//    }
//



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

private int combatRound;


    public boolean combat(ArrayList<Creature> creatures) {
        for (Creature creature : creatures) {
        while (currentPlayer.getCurrentHealth() > 0 && creature.getCurrentHealth() > 0) {
            // Player attack
            int playerAttack = currentPlayer.getCurrentAttack() + dieRoll();
            int creatureAttack = creature.getCurrentAttack() + dieRoll();



                if (playerAttack > creatureAttack) {
                    creature.changeCurrentHealth(-2);
                } else if (creatureAttack > playerAttack) {
                    currentPlayer.changeHealth(-2);

                }
                combatRound++;
            }
            combatRound = 0;
        }
        return currentPlayer.getCurrentHealth() > 0;
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

    public DatabaseManager getDm() {
        return dm;
    }
}






