module de.lubowiecki.gui.plaintodo {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lubowiecki.gui.plaintodo to javafx.fxml;
    exports de.lubowiecki.gui.plaintodo;
}