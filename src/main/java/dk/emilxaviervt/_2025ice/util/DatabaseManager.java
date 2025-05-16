package dk.emilxaviervt._2025ice.util;

import dk.emilxaviervt._2025ice.gameLogic.Player;
import dk.emilxaviervt._2025ice.userLogic.ActionPoint;
import javafx.scene.chart.ScatterChart;

import java.sql.*;


public class DatabaseManager  {
    Connection con ;

    public DatabaseManager() {
        connect();
    }


    public void connect() {
        try {
            //conect to the main databse
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
                if(rs.getString("name") == name ){
                    Player player = new Player(rs.getString("name"),
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
                return player;
                }
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void savePlayerToDatabase(Player player){
//        connect();
        String query = "INSERT INTO Players(name,currentHealth,currentAttack,currentLuck,maxHealth,maxAttack,maxLuck,isEquipped,inventory_id,currentActionPoint,goldCoin,foodRation,starterPotion) " +
                "VALUES(" +
               "'"     +
               player.getName() +"'" +","+
               player.getCurrentHealth() +  "," +
               player.getCurrentAttack() + "," +
               player.getCurrentLuck()   +  "," +
               player.getMaxHealth()   +  "," +
               player.getMaxAttack()  +  "," +
               player.getMaxLuck()   +  "," +
               player.isEquipped()  +  "," +  "'"+
               player.getName()  + "'" + "," +
               player.getPlayerLocation()+","+
                player.getGoldCoins()+","+
                player.getFoodRations()+","+
                player.getStarterPotion()+");";
              if(con != null){
            try {

                Statement statement = con.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException e){
                System.out.println("wonky error "+e.getMessage());
            }

        }

    }

    public void selectItems() {
        String query = "SELECT * FROM ItemList";

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
                    ActionPoint actionPoint = new ActionPoint(
                            rs.getInt("id"),
                            rs.getString("description"),
                            rs.getInt("containedItem"),
                            rs.getInt("itemNeeded"),
                            rs.getInt("goldCoins"),
                            rs.getString("availableActionPoints"),
                            rs.getString("containedCreatures"),
                            rs.getBoolean("isFinal"),
                            rs.getBoolean("winnerActionPoint"),
                            rs.getBoolean("luckRoll"),
                            rs.getInt("changeAttackPoints"),
                            rs.getInt("changeHealthPoints"),
                            rs.getBoolean("dieRoll"),
                            rs.getInt("event"));


                    return actionPoint;
                }

            }


        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /*
    public void getBalanceOfPlayer() {
        String query = "SELECT balance FROM Players WHERE name = '" +  + "'";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            int balance = rs.getInt("balance");
            System.out.println("Saldo: " + balance);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addPlayer(String name, int position, int balance) {
        String query = "INSERT INTO players(name, position, balance) VALUES('" + name + "', '" + position + "', '" + balance + "')";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);

            name = rs.getString("name");
            position = rs.getInt("position");
            balance = rs.getInt("balance");
            System.out.println("name: " + name + "position: " + position + "Saldo: " + balance);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

 */

}

