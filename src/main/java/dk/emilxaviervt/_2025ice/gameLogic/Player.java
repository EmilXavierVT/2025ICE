package dk.emilxaviervt._2025ice.gameLogic;

import dk.emilxaviervt._2025ice.Items.Item;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    String name;
    //Player stats
    int currentHealth;
    int currentAttack;
    int currentLuck;
    int maxHealth;
    int maxAttack;
    int maxLuck;


    int goldCoins;
    int foodRations;
    int starterPotion;


    //player inventory
    boolean isEquipped;
    ArrayList<Item> inventory = new ArrayList<>();
    String inventoryReference;

    //player state
    int playerLocation;

    //constructor used to create new player
//    Player (String name, int health,int attack,int luck){
//        this.name = name;
//
//        //player stats
//        this.maxHealth = health;
//        this.currentHealth = health;
//        this.maxAttack = attack;
//        this.currentAttack = attack;
//        this.currentLuck = luck;
//        this.maxLuck = luck;
//
//    }
    //constructor used when player is loaded
    public Player(String name, int health, int attack, int luck,
                  int maxHealth, int maxAttack, int maxLuck,
                  boolean isEquipped, String inventoryReference, int location,
                  int goldCoins, int foodRations, int starterPotion) {
        this.name = name;
        this.currentHealth = health;
        this.currentAttack = attack;
        this.currentLuck = luck;
        this.maxHealth = maxHealth;
        this.maxAttack = maxAttack;
        this.maxLuck = maxLuck;
        this.isEquipped = isEquipped;
        this.inventoryReference = inventoryReference;
        this.playerLocation = location;
        this.goldCoins = goldCoins;
        this.foodRations = foodRations;
        this.starterPotion = starterPotion;
    }

    //used to change player health value
    public void changeHealth(int change) {
        currentHealth += change;
    }

    //used to change player attack value
    public void changeAttack(int change) {
        currentAttack += change;
    }


    // luck change when luck is used
    public void useLuck() {
        currentLuck -= 1;
    }


    //luck change when luck is alternated
    public void changeLuck(int change) {
        currentLuck += change;
    }


    //add an item to the players inventory
    public void addToInventory(Item item) {
        if (inventory != null) {
            inventory.add(item);
        }
    }


    //remove an item from the players inventory
    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }


    //change gold coins
    public void changeGoldCoins(int goldCoins) {
        this.goldCoins += goldCoins;
    }


    //change foodRations
    public void changeFoodRations(int newFoodRations) {
        this.foodRations += newFoodRations;
//       if (foodRations >= 100){
//           this.foodRations = 0;
//       }


    }

    public void removeOneItemFromInventory() {
        Random random = new Random();
        int rdm = random.nextInt(1, inventory.size());
        inventory.remove(rdm);
    }


    public void giveHealthBoost() {

        if (this.getCurrentHealth() < this.getMaxHealth()) {

            this.changeFoodRations(-1);
            this.changeHealth(4);
        }
        if (this.getCurrentHealth() > this.getMaxHealth()) {

            this.setCurrentHealth(this.getMaxHealth());


        }
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public int getCurrentLuck() {
        return currentLuck;
    }

    public void changeCurrentLuck(int luckChange) {
        this.currentLuck += luckChange;
    }

    public void setCurrentLuck(int currentLuck) {
        this.currentLuck = currentLuck;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public int getMaxLuck() {
        return maxLuck;
    }

    public void setMaxLuck(int maxLuck) {
        this.maxLuck = maxLuck;
    }

    public boolean getIsEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(int playerLocation) {
        this.playerLocation = playerLocation;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getFoodRations() {
        return foodRations;
    }

    public int getStarterPotion() {
        return starterPotion;
    }

    public void setStarterPotion(int starterPotion) {
        this.starterPotion = starterPotion;
    }


}