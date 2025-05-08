module dk.emilxaviervt._2025ice._2025ice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens dk.emilxaviervt._2025ice._2025ice to javafx.fxml;
    exports dk.emilxaviervt._2025ice._2025ice;
    exports VFX;
    opens VFX to javafx.fxml;
}