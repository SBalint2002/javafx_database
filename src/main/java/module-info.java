module hu.petrik.adatbazisgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.petrik.adatbazisgui to javafx.fxml;
    exports hu.petrik.adatbazisgui;
}