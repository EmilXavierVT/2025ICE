package dk.emilxaviervt._2025ice.userLogic;

import dk.emilxaviervt._2025ice.gameLogic.ActionPoint;
import dk.emilxaviervt._2025ice.util.DatabaseManager;
import org.junit.jupiter.api.Test;

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