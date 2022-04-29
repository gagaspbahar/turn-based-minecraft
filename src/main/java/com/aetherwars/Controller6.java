package com.aetherwars;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.net.URL;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import com.aetherwars.model.Player;

public class Controller6 {

    @FXML
    private Text VictoryText;

    @FXML
    private Text mainlagi;

    @FXML
    private Rectangle mainlagibox;

    @FXML
    void mainLagiClicked(MouseEvent event) throws Exception{
        AetherWars.p1 = new Player();
        AetherWars.p2 = new Player();
        Stage popupwindow = (Stage) mainlagibox.getScene().getWindow();
        popupwindow.close();
    }

public void initialize(URL location, ResourceBundle resources) {
        if (Controller.siapaMenang == 1){
            VictoryText.setText("Player 1 wins, Player 2 lose :(");
        }
        else if (Controller.siapaMenang == 2){
            VictoryText.setText("Player 2 wins, Player 1 lose :(");
        }
        else {
            VictoryText.setText("");
        }
    }
}
