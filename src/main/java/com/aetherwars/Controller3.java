package com.aetherwars;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import com.aetherwars.model.Card;
import javafx.scene.shape.Rectangle;
import javafx.fxml.Initializable;
import com.aetherwars.Controller2;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller3 implements Initializable {
    private int throwChosenField = 0;

    @FXML
    private Rectangle drawcard1;

    @FXML
    private Rectangle drawcard2;

    @FXML
    private Rectangle drawcard3;

    @FXML
    private Rectangle drawcard4;

    @FXML
    private Rectangle drawcard5;

    @FXML
    private Rectangle drawcard6;

    @FXML
    private Label drawcardhand1;

    @FXML
    private Label drawcardhand2;

    @FXML
    private Label drawcardhand3;

    @FXML
    private Label drawcardhand4;

    @FXML
    private Label drawcardhand5;

    @FXML
    private Label drawcardhand6;

    @FXML
    private ImageView drawcardimage1;

    @FXML
    private ImageView drawcardimage2;

    @FXML
    private ImageView drawcardimage3;

    @FXML
    private ImageView drawcardimage4;

    @FXML
    private ImageView drawcardimage5;

    @FXML
    private ImageView drawcardimage6;

    @FXML
    private Label drawcardmana1;

    @FXML
    private Label drawcardmana2;

    @FXML
    private Label drawcardmana3;

    @FXML
    private Label drawcardmana4;

    @FXML
    private Label drawcardmana5;

    @FXML
    private Label drawcardmana6;

    @FXML
    private Button submitDrawButton;

    @FXML
    void card1Clicked(MouseEvent event) {
        drawcard1.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
        throwChosenField = 1;
        drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard6.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void card2Clicked(MouseEvent event) {
        drawcard2.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
        throwChosenField = 2;
        drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard6.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void card3Clicked(MouseEvent event) {
        drawcard3.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
        throwChosenField = 3;
        drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard6.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void card4Clicked(MouseEvent event) {
        drawcard4.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
        throwChosenField = 4;
        drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard6.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void card5Clicked(MouseEvent event) {
        drawcard5.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
        throwChosenField = 5;
        drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard6.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void card6Clicked(MouseEvent event) {
        drawcard6.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
        throwChosenField = 6;
        drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        drawcard5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void submitDraw(ActionEvent event) {
        if (throwChosenField > 0){
            if (throwChosenField < 6){
                if (AetherWars.playerTurn){
                    AetherWars.p1.getHand()[throwChosenField-1] = Controller2.sixthCard;
                }
                else{
                    AetherWars.p2.getHand()[throwChosenField-1] = Controller2.sixthCard;
                }
            }
            Stage popupwindow = (Stage) drawcard1.getScene().getWindow();
            popupwindow.close();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

        Card c1 = new Card();
        Card c2 = new Card();
        Card c3 = new Card();
        Card c4 = new Card();
        Card c5 = new Card();
        Card c6 = new Card();
        
        if (AetherWars.playerTurn){
            c1 = AetherWars.p1.getHand()[0];
            c2 = AetherWars.p1.getHand()[1];
            c3 = AetherWars.p1.getHand()[2];
            c4 = AetherWars.p1.getHand()[3];
            c5 = AetherWars.p1.getHand()[4];
            c6 = Controller2.sixthCard;
        }else{
            c1 = AetherWars.p2.getHand()[0];
            c2 = AetherWars.p2.getHand()[1];
            c3 = AetherWars.p2.getHand()[2];
            c4 = AetherWars.p2.getHand()[3];
            c5 = AetherWars.p2.getHand()[4];
            c6 = Controller2.sixthCard;
        }
        drawcardhand1.setText(c1.toString());
        drawcardmana1.setText("MANA " + String.valueOf(c1.getMana()));
        drawcardimage1.setImage(new Image("./com/aetherwars/" + c1.getImagePath())); 
        drawcardhand2.setText(c2.toString());
        drawcardmana2.setText("MANA " + String.valueOf(c2.getMana()));
        drawcardimage2.setImage(new Image("./com/aetherwars/" + c2.getImagePath())); 
        drawcardhand3.setText(c3.toString());
        drawcardmana3.setText("MANA " + String.valueOf(c3.getMana()));
        drawcardimage3.setImage(new Image("./com/aetherwars/" + c3.getImagePath()));
        drawcardhand4.setText(c4.toString());
        drawcardmana4.setText("MANA " + String.valueOf(c4.getMana()));
        drawcardimage4.setImage(new Image("./com/aetherwars/" + c4.getImagePath())); 
        drawcardhand5.setText(c5.toString());
        drawcardmana5.setText("MANA " + String.valueOf(c5.getMana()));
        drawcardimage5.setImage(new Image("./com/aetherwars/" + c5.getImagePath())); 
        drawcardhand6.setText(c6.toString());
        drawcardmana6.setText("MANA " + String.valueOf(c6.getMana()));
        drawcardimage6.setImage(new Image("./com/aetherwars/" + c6.getImagePath()));

    }

}
