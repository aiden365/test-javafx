module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires lombok;
    requires org.slf4j;
    requires com.google.guice;

    requires cn.hutool;
    requires java.sql;

    opens com.example.testjavafx to javafx.fxml;
    opens img;
    opens fxml;
    opens com.example.testjavafx.controller to javafx.fxml;
    opens com.example.testjavafx.pojo to javafx.base;

    exports com.example.testjavafx.comment;
    exports com.example.testjavafx;
}