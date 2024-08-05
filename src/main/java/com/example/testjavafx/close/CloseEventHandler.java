package com.example.testjavafx.close;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.WindowEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class CloseEventHandler implements EventHandler<WindowEvent> {

    @Override
    public void handle(WindowEvent event) {
        event.consume();
        log.info("点击关闭....");



        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认一下");
        alert.setHeaderText(null);
        //alert.setContentText("你要关闭这个对话框吗？？？");
        DialogPane dialogPane = alert.getDialogPane();


        Label label = new Label();
        label.setText("你要关闭这个对话框吗");
        label.setFont(Font.font("宋体", FontWeight.BLACK, 15));
        //必须设置setHeaderText(null);
        dialogPane.setContent(label);



        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().equals(ButtonType.OK)){
            Platform.exit();
        }
    }
}
