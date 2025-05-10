module dk.emilxaviervt._2025ice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens dk.emilxaviervt._2025ice to javafx.fxml;
    exports dk.emilxaviervt._2025ice.VFX;
    exports dk.emilxaviervt._2025ice;
    opens dk.emilxaviervt._2025ice.VFX to javafx.fxml;

}