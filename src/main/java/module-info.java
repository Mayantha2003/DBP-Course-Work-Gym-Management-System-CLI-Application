module lk.ijse.gymmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens lk.ijse.gymmanagement.controller to javafx.fxml;
    opens lk.ijse.gymmanagement.dto to java.base;
    exports lk.ijse.gymmanagement;
    exports lk.ijse.gymmanagement.controller;
    exports lk.ijse.gymmanagement.dto;
    
    
}
