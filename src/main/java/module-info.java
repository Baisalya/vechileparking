module com.lala.example.vechileparking {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.lala.example.vechileparking to javafx.fxml;
    exports com.lala.example.vechileparking;
}