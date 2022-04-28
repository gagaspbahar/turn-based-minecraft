package com.aetherwars;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Controller4 {

    @FXML
    private Rectangle loadBox;

    @FXML
    private Text loadText;

    @FXML
    private Rectangle newBox;

    @FXML
    private Text newText;

    @FXML
    void loadClicked(MouseEvent event) throws Exception {
        Stage popupwindow = (Stage) newBox.getScene().getWindow();
        Pane throwPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./ImportDeck.fxml"));
        popupwindow.setScene(new Scene(throwPane));
        popupwindow.centerOnScreen();
    }

    @FXML
    void newClicked(MouseEvent event) throws Exception {
        AetherWars.p1.initializeDeck();
        AetherWars.p2.initializeDeck();
        Stage popupwindow = (Stage) newBox.getScene().getWindow();
        Pane throwPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./Sample.fxml"));
        popupwindow.setScene(new Scene(throwPane));
        popupwindow.centerOnScreen();
    }

}
