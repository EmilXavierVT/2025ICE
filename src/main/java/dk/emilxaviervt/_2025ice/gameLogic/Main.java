package dk.emilxaviervt._2025ice.gameLogic;

import dk.emilxaviervt._2025ice.util.DatabaseManager;

public class Main {
//    public static void main(String[] args) {new Adventure().start();}

    public static void main(String[] args) {

        DatabaseManager db = new DatabaseManager();
//        db.connect();
        Player player =new Player("Emil",10,10,10,10,10,10,true,"Emil",1);
        db.savePlayerToDatabase(player);
    }
}
