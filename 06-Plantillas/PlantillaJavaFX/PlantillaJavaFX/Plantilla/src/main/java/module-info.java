module org.example.plantilla {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.plantilla to javafx.fxml;
    exports org.example.plantilla;
}