package dk.emilxaviervt._2025ice.gameLogic;

import dk.emilxaviervt._2025ice.Items.Item;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Player {
    String name;
    //Player stats
    int currentHealth;
    int currentAttack;
    int currentLuck;
    int maxHealth;
    int maxAttack;
    int maxLuck;

    //player inventory
    boolean isEquipped;
    ArrayList<Item> inventory;
    String inventoryReference;

    //player state
    int playerLocation;

    //construckter used to create new player
    Player (String name, int health,int attack,int luck){
        this.name = name;

        //player stats
        this.maxHealth = health;
        this.currentHealth = health;
        this.maxAttack = attack;
        this.currentAttack = attack;
        this.currentLuck = luck;
        this.maxLuck = luck;
    }
    //constructor used when player is loaded
   public Player (String name, int health, int attack, int luck,
            int maxHealth, int maxAttack, int maxLuck,
            boolean isEquipped, String inventoryReference, int location){
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
    }
    //used to change player health value
    public void changeHealth(int change){
        currentHealth += change;
    }
    //used to change player attack value
    public void changeAttack(int change){
        currentAttack += change;
    }
    // luck change when luck is used
    public void useLuck(){
        currentLuck -=1;
    }
    //luck change when luck is alternated
    public void changeLuck(int change){
        currentLuck += change;
    }
    //add an item to the players inventory
    public void addToInvertory(Item item){
        inventory.add(item);
    }
    //remove an item from the players inventory
    public void removeFromInventory(Item item){
        inventory.remove(item);
    }
//    public void consumeItem(Consumable potion){
//
//        int potionID = potion.getID();
//        //health potion
//        if (potionID == 3) {
//            this.currentHealth = this.maxHealth;
//        }
//        //power potion
//        else if (potionID == 4){
//            this.currentAttack = this.maxAttack;
//            }
//        //luck potion
//        else if (potionID == 2){
//            maxLuck++;
//            this.currentLuck = this.maxLuck;
//        }
//        inventory.remove(potion);
//
//    }

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

    public boolean isEquipped() {
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
}