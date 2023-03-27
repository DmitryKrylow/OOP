module com.example.lab_graphics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_graphics to javafx.fxml;
    exports com.example.lab_graphics;
}