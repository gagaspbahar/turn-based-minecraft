package com.aetherwars;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Controller5 {

    @FXML
    private Text goBack;

    @FXML
    private Rectangle gobackBox;

    @FXML
    private Text submitLoad;

    @FXML
    private Rectangle submitLoadBox;

    @FXML
    void goBackClicked(MouseEvent event) throws Exception {
        Stage popupwindow = (Stage) gobackBox.getScene().getWindow();
        Pane throwPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./Opening.fxml"));
        popupwindow.setScene(new Scene(throwPane));
        popupwindow.centerOnScreen();
    }

    @FXML
    void loadClicked(MouseEvent event) {

    }

}

