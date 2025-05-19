package dk.emilxaviervt._2025ice.util;

import dk.emilxaviervt._2025ice.Items.Item;
import dk.emilxaviervt._2025ice.gameLogic.Creature;
import dk.emilxaviervt._2025ice.gameLogic.Player;
import dk.emilxaviervt._2025ice.gameLogic.ActionPoint;

import java.sql.*;
import java.util.ArrayList;


public class DatabaseManager  {
    Connection con ;

    public DatabaseManager() {
        connect();
    }


    public void connect() {
        try {
            //Connect to the main database
            con = DriverManager.getConnection("jdbc:sqlite:AdventureDataBase");
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public Player selectPlayers(String name) {
        String query = "SELECT * FROM Players";

        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                if(rs.getString("name").equals(name) ){
                    return new Player(rs.getString("name"),
                            rs.getInt("currentHealth"),
                            rs.getInt("currentAttack"),
                            rs.getInt("currentLuck"),
                            rs.getInt("maxHealth"),
                            rs.getInt("maxAttack"),
                            rs.getInt("maxLuck"),
                            rs.getBoolean("isEquipped"),
                            rs.getString("inventory_id"),
                            rs.getInt("currentActionPoint"),
                            rs.getInt("goldCoin"),
                            rs.getInt("foodRation"),
                            rs.getInt("starterPotion")
                    );

                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void savePlayerToDatabase(Player player) {
//        connect();
        final String query = "INSERT INTO Players(name,currentHealth,currentAttack,currentLuck,maxHealth,maxAttack,maxLuck,isEquipped,inventory_id,currentActionPoint,goldCoin,foodRation,starterPotion) " +
                "VALUES(" +
                "'" +
                player.getName() + "'" + "," +
                player.getCurrentHealth() + "," +
                player.getCurrentAttack() + "," +
                player.getCurrentLuck() + "," +
                player.getMaxHealth() + "," +
                player.getMaxAttack() + "," +
                player.getMaxLuck() + "," +
                player.getIsEquipped() + "," + "'" +
                player.getName() + "'" + "," +
                player.getPlayerLocation() + "," +
                player.getGoldCoins() + "," +
                player.getFoodRations() + "," +
                player.getStarterPotion() + ");";
        if (con != null) {
            try {

                Statement statement = con.createStatement();

                statement.executeUpdate(query);


            } catch (SQLException e) {
                System.out.println("wonky error " + e.getMessage());
            }

        }
    }


    // Learning curve for mig, daniel
//    du skal tage alle items fra ItemList table du skal bruge SQL for at tage dem ud af databasen.
//

//    For at gøre dette skal du lave en metode der returnerer en arraylist af items.
//    Du skal også lave en constructor til items så du kan retuner et Item af items fra databasen.
//    Din metode skal retuner et Item af items fra databasen.
//    Se selectPlayerFromDatabase


//     senere skal du lave en metode som kalder denne metode i adventure eller actionPoint class og laver en Array liste som vi kan manipulere i adventure eller actionPoint class.




    public Item selectItems(int id) {
        String query = "SELECT * FROM ItemList";

        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                if (rs.getInt("id") == id) {
                   return new Item(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getString("name"),
                            rs.getBoolean("consumable"),
                            rs.getBoolean("equipable"),
                            rs.getBoolean("potions"),
                            rs.getInt("potency")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public ArrayList<Item> getAllItemsInArrayList() {
        String query = "SELECT * FROM ItemList";
        ArrayList<Item> itemArrayList = new ArrayList<>();

        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                    Item item = new Item(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getString("name"),
                            rs.getBoolean("consumable"),
                            rs.getBoolean("equipable"),
                            rs.getBoolean("potions"),
                            rs.getInt("potency")
                    );
                    itemArrayList.add(item);
                }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return itemArrayList;
    }


    //Prøve at indsætte en inventory i databasen.
    public void createInventory(int object1, int object2, int object3, int object4, int object5) {

        String query = "INSERT INTO inventory(item1,item2,item3,item4,item5) VALUES(object1,object2,object3,object4,object5)";

        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public ActionPoint selectActionPoints(int caseId) {
        String query = "SELECT * FROM ActionPoints";
        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt("id") == caseId ){
               return new ActionPoint(
                            rs.getInt("id"),
                            rs.getString("description"),
                            selectItem(rs.getInt("containedItem")),
                            rs.getInt("itemNeeded"),
                            rs.getInt("goldCoins"),
                            rs.getString("availableActionPoints"),
                            creatureListFromString(rs.getString("containedCreatures")),
                            rs.getBoolean("isFinal"),
                            rs.getBoolean("winnerActionPoint"),
                            rs.getBoolean("luckRoll"),
                            rs.getInt("changeAttackPoints"),
                            rs.getInt("changeHealthPoints"),
                            rs.getBoolean("dieRoll"),
                            rs.getInt("event"));



                }

            }


        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }


    public Creature selectCreature(int caseId) {
        String query = "SELECT * FROM Creatures";
        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt("id") == caseId ){


                    return new Creature(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("endurance"),
                            rs.getInt("combatPower"));
                }
            }


        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }



    private ArrayList<Creature> creatureListFromString(String list) {
        ArrayList<Creature> creatureArrayList = new ArrayList<>();

        if (list != null && !list.trim().isEmpty()) {
            String[] values = list.split(",");
            for (String s : values) {
                s = s.trim();
                if (!s.isEmpty()) {
                    try {
                        creatureArrayList.add(selectCreature(Integer.parseInt(s)));
                    } catch (NumberFormatException e) {

                        System.err.println("Warning: Invalid action point ID '" + s + "' in availableActionPoints.");
                    }
                }
            }
        }
        return creatureArrayList;
    }







    public Item selectItem(int caseID){
        String query = "SELECT * FROM ITEMLIST";
        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt("id") == caseID ){

                    return new Item(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getString("name"),
                            rs.getBoolean("consumable"),
                            rs.getBoolean("equipable"),
                            rs.getBoolean("potions"),
                            rs.getInt("potency"));
                }

            }

        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }




}

