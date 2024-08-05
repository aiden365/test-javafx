package com.example.testjavafx;

import cn.hutool.core.io.resource.ClassPathResource;
import com.example.testjavafx.close.CloseEventHandler;
import com.example.testjavafx.controller.CanvasImageController;
import com.example.testjavafx.controller.CircleController;
import com.example.testjavafx.controller.TableController;
import com.example.testjavafx.scene.MoveScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Optional;

@Slf4j
public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setResizable(true);
        primaryStage.setTitle("hello");
        ObservableList<Image> icons = primaryStage.getIcons();
        Image image = new Image("img/title.png", 500, 500, false, false);
        icons.add(image);


        //Scene scene = TableController.init();
        //Scene scene = CircleController.init();
        Scene scene = CanvasImageController.init();

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setOnCloseRequest(new CloseEventHandler());

        primaryStage.show();

    }

    public HelloApplication() {
        super();
        log.info("HelloApplication()");
    }

    @Override
    public void init() throws Exception {
        super.init();
        //注销关闭按钮退出程序事件
        Platform.setImplicitExit(false);
        log.info("HelloApplication.init()");
    }

    @Override
    public void stop() throws Exception {
        log.info("HelloApplication.stop()");
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }

}