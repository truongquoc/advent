module com.example.advent2022 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advent2022 to javafx.fxml;
    exports com.example.advent2022;
}