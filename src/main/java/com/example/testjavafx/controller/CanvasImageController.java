package com.example.testjavafx.controller;

import cn.hutool.core.io.resource.ClassPathResource;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuItem;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
public class CanvasImageController {

    private static String suffix = "PNG";

    @javafx.fxml.FXML
    private MenuItem fileOpen;
    @javafx.fxml.FXML
    private MenuItem fileSave;
    @javafx.fxml.FXML
    private Canvas canvas;

    private double x;
    private double y;

    @SneakyThrows
    @javafx.fxml.FXML
    public void onFileSave(ActionEvent actionEvent) {
        log.info("保存文件");



        WritableImage writableImage = canvas.snapshot(null, null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存canvas图片");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(suffix, ".".concat(suffix.toLowerCase())));
        File file = fileChooser.showSaveDialog(canvas.getScene().getWindow());
        if(file != null){
            ImageIO.write(bufferedImage, suffix, file);
        }


    }
    @javafx.fxml.FXML
    public void canvasOnMousePressed(MouseEvent event) {


        double x1 = event.getX();
        double y1 = event.getY();
        x = x1;
        y = y1;


    }

    @javafx.fxml.FXML
    public void canvasOnMouseDragged(MouseEvent event) {

        double x1 = event.getX();
        double y1 = event.getY();
        canvas.getGraphicsContext2D().strokeLine(x, y, x1, y1);
        x = x1;
        y = y1;

    }

    public void initialize(){



    }



    public static Scene init() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("fxml/canvas-image-view.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classPathResource.getUrl());

        AnchorPane pane = fxmlLoader.load();
        Scene scene = new Scene(pane, 500, 500);


        return scene;
    }
}
