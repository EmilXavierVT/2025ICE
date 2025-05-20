package dk.emilxaviervt._2025ice.Items;

public class Item {

    private int id;
    private String name;
    private String description;
    private boolean consumable;
    private boolean equippable;
    private boolean potions;
    private int potency;


    public Item(int id, String name, String description, boolean consumable, boolean equippable, boolean potions, int potency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.consumable = consumable;
        this.equippable = equippable;
        this.potions = potions;
        this.potency = potency;
    }

    //    Getters And Setters
    public int getDamagePoints() {
        return 0;
    }

    ;

    public void setDamagePoints(int damagePoints) {
    }

    ;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public void setEquippable(boolean equippable) {
        this.equippable = equippable;
    }

    public boolean isPotions() {
        return potions;
    }

    public void setPotions(boolean potions) {
        this.potions = potions;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
