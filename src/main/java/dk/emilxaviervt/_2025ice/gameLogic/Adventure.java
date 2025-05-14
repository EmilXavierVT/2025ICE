package dk.emilxaviervt._2025ice.gameLogic;

public class Adventure extends Thread{

//    DataBaseManager dm;
//    ClientFX clientFX;
    private Player currentPlayer;
    private int health = rollHealth();
    private int attack = rollAttackAndLuck();
    private int luck = rollAttackAndLuck();

    public Adventure() {
        this.currentPlayer = new Player("test12", health-10, attack, luck, health, attack, luck, true, "Emil", 1,0,10,2);
    }

// metode til at skabe nye spilere

    private int rollHealth() {
        Random random = new Random();
        int rs = random.nextInt(1, 12);
        return rs + 12;
    }

    private int rollAttackAndLuck() {
        Random random = new Random();
        int rs = random.nextInt(1, 6);
        return rs + 6;
    }


// vi får lavet en start værdei på spileren gennem en metode og en dertil liggende værdi som vi kan give spilleren


    private void combat(Creature creature) {

            }

            public void singleRoll(){

            }

            public void doubleRoll(){

            }

    public void giveHealthBoost() {
        if (currentPlayer != null) {
            currentPlayer.changeHealth(4);
        }

        if (currentPlayer.getCurrentHealth() > currentPlayer.getMaxHealth()) {

            currentPlayer.setCurrentHealth(currentPlayer.getMaxHealth());
            return;

        }else if (currentPlayer.getCurrentHealth() < currentPlayer.getMaxHealth()) {
            currentPlayer.changeFoodRations(-1);
        }

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}






