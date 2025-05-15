package dk.emilxaviervt._2025ice.util;

import dk.emilxaviervt._2025ice.gameLogic.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    @Test
    void savePlayerToDatabase() {
        DatabaseManager db = new DatabaseManager();
        Player player =new Player("Emil",10,10,10,10,10,10,true,"Emil",1,1,10,1);
        db.savePlayerToDatabase(player);
    }
}