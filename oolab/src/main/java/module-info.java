module agh.ics.oop.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens agh.ics.oop.gui  to javafx.fxml;
    exports agh.ics.oop.gui ;
}