package dk.emilxaviervt._2025ice.VFX;

import dk.emilxaviervt._2025ice.gameLogic.Adventure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerFXTest {

    @Test
    void displayDescription() {
        ControllerFX cfx = new ControllerFX();
        cfx.setAdventure(new Adventure());

    }
}