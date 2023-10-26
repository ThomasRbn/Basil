module org.vasistas.basil {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.vasistas.basil to javafx.fxml;
    exports org.vasistas.basil;
}