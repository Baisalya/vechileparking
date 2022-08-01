module com.lala.example.vechileparking {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    opens com.lala.example.vechileparking to javafx.fxml;
    exports com.lala.example.vechileparking;
}