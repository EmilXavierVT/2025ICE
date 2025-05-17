package dk.emilxaviervt._2025ice.gameLogic;

public class Creature {
    private int id;
    private String creatureName;
    private int currentHealth;
    private int currentAttack;

    public Creature(int id, String name, int currentHealth, int currentAttack){
        this.id = id;
        this.creatureName = name;
        this.currentHealth = currentHealth;
        this.currentAttack = currentAttack;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatureName() {
        return creatureName;
    }

    public void setCreatureName(String name) {
        this.creatureName = name;
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

    public void changeCurrentHealth(int i) {
        this.currentHealth += i;
    }
}


