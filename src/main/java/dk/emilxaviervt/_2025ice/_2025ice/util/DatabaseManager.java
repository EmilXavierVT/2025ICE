package dk.emilxaviervt._2025ice._2025ice.util;

import java.sql.*;


public class DatabaseManager {
    Connection con;


    public void connect(String url) {
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void selectPlayers() {
        String query = "SELECT * FROM Player";

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

    public void createInventory(int object1,int object2 ,int object3,int object4,int object5) {

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

    public void getBalanceOfPlayer(String name) {
        String query = "SELECT balance FROM Players WHERE name = '" + name + "'";
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
        String query = "INSERT INTO players(name, position, balance) VALUES('" + name + "', " + position + ", " + balance + ")";
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
}
