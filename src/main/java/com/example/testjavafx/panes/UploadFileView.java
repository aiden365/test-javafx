package com.example.testjavafx.panes;

import com.example.testjavafx.pojo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UploadFileView {

    @FXML
    private Label label;

    @FXML
    private Button button;

    public void initialize() {

        ObservableList<Person> list = FXCollections.observableArrayList();




    }

}
