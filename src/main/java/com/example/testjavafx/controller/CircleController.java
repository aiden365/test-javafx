package com.example.testjavafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cn.hutool.core.io.resource.ClassPathResource;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class CircleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle circle;


    @FXML
    void initialize() {
        assert circle != null : "fx:id=\"circle\" was not injected: check your FXML file '无标题'.";

    }

    public void circleLocationBind(Scene scene){

        this.circle.centerXProperty().bind(scene.widthProperty().divide(2));
        this.circle.centerYProperty().bind(scene.heightProperty().divide(2));


    }

    public static Scene init() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("fxml/circle-view.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classPathResource.getUrl());

        AnchorPane pane = fxmlLoader.load();
        Scene scene = new Scene(pane, 500, 500);

        CircleController controller = fxmlLoader.getController();

        controller.circleLocationBind(scene);


        return scene;
    }

}
