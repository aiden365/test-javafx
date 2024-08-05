package com.example.testjavafx.controller;

import cn.hutool.core.io.resource.ClassPathResource;
import com.example.testjavafx.pojo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TableController {

    @javafx.fxml.FXML
    private TableView<Person> tableView;
    @javafx.fxml.FXML
    private TableColumn<Person, String> name;
    @javafx.fxml.FXML
    private TableColumn<Person, String> age;

    public void initialize(){

        ObservableList<Person> list = FXCollections.observableArrayList();

        name.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));

        for (int i = 1; i <= 10; i++) {
            list.add(new Person().setName("用户" + i).setAge(i));
        }

        tableView.setItems(list);
    }


    public static Scene init() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("fxml/table-view.fxml");
        Pane pane = FXMLLoader.load(classPathResource.getUrl());
        Scene scene = new Scene(pane, 500, 500);

        return scene;
    }
}
