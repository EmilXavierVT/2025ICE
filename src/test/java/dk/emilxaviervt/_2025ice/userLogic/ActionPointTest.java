package dk.emilxaviervt._2025ice.userLogic;

import dk.emilxaviervt._2025ice.util.DatabaseManager;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ActionPointTest {

    @Test
    void printDescription() {


        DatabaseManager db = new DatabaseManager();
        db.connect();
        ActionPoint ap = db.selectActionPoints(270);
        ap.printDescription();
    }

    @Test
            void printGoldCoins() {
    DatabaseManager db = new DatabaseManager();
        db.connect();
    ActionPoint ap = db.selectActionPoints(270);
        ap.printGoldCoins();
}
}