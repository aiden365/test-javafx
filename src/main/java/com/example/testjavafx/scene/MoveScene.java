package com.example.testjavafx.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.List;

public class MoveScene{


    public static Scene scene() {

        AnchorPane anchorPane = new AnchorPane();
        


        Image image = new Image("img/title.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        imageView.setX(100);




        Button button = new Button();
        button.setText("点击或按键");
        button.setLayoutX(200);
        button.setLayoutY(300);

        button.setOnAction(event -> {
            imageView.setLayoutY(imageView.getLayoutY() - 5);
        });
        anchorPane.getChildren().addAll(button, imageView );

        Scene scene = getScene(anchorPane, imageView);


        return scene;
    }

    private static Scene getScene(AnchorPane anchorPane, ImageView imageView) {
        Scene scene = new Scene(anchorPane, 500, 500);
        scene.setOnKeyReleased(event -> {

            KeyCode code = event.getCode();
            if(KeyCode.UP.equals(code)){
                imageView.setLayoutY(imageView.getLayoutY() + 5);
            }
            else if(KeyCode.DOWN.equals(code)){
                imageView.setLayoutY(imageView.getLayoutY() - 5);
            }

        });

        scene.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.ANY);
        });
        scene.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            List<File> files = dragboard.getFiles();
            String string = dragboard.getString();

            System.out.println();

        });
        return scene;
    }


}
