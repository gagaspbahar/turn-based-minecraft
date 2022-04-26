package com.aetherwars;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.Collections;
import com.aetherwars.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.util.ResourceBundle;
import com.aetherwars.model.Card;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;

public class Controller2 implements Initializable {
    private int drawcardChosenField = 0;
    public static Card sixthCard = new Card();

    @FXML
    private Rectangle drawcard1;

    @FXML
    private Rectangle drawcard2;

    @FXML
    private Rectangle drawcard3;

    @FXML
    private Label drawcardhand1;

    @FXML
    private Label drawcardhand2;

    @FXML
    private Label drawcardhand3;

    @FXML
    private ImageView drawcardimage1;

    @FXML
    private ImageView drawcardimage2;

    @FXML
    private ImageView drawcardimage3;

    @FXML
    private Label drawcardmana1;

    @FXML
    private Label drawcardmana2;

    @FXML
    private Label drawcardmana3;

    private Button submitDrawButton;

    @FXML
    void card1Clicked(MouseEvent event) {
        if (drawcardhand1.getText() != ""){
            drawcard1.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
            drawcardChosenField = 1;
            if ((AetherWars.playerTurn && AetherWars.p1.getDeck().size() != 2) || (! AetherWars.playerTurn && AetherWars.p2.getDeck().size() != 2)){
                drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            }
            drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        }
    }

    @FXML
    void card2Clicked(MouseEvent event) {
        if (drawcardhand2.getText() != ""){
            drawcard2.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
            drawcardChosenField = 2;
            if ((AetherWars.playerTurn && AetherWars.p1.getDeck().size() != 1) || (! AetherWars.playerTurn && AetherWars.p2.getDeck().size() != 1)){
                drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                drawcard3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            }
        }
    }

    @FXML
    void card3clicked(MouseEvent event) {
        if (drawcardhand3.getText() != ""){
            drawcard3.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
            drawcardChosenField = 3;
            drawcard1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            if ((AetherWars.playerTurn && AetherWars.p1.getDeck().size() != 2) || (! AetherWars.playerTurn && AetherWars.p2.getDeck().size() != 2)){
                drawcard2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            }
        }
    }

    @FXML
    void submitDraw(ActionEvent event) throws Exception {
        int kosong;
        if (drawcardChosenField != 0){
            if (AetherWars.playerTurn){
                kosong = AetherWars.p1.firstEmptyHand();
                if (kosong != -1){
                    if (AetherWars.p1.getDeck().size() >= 3){
                        AetherWars.p1.getHand()[kosong] = AetherWars.p1.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p1.getDeck().size() == 2 && drawcardChosenField == 1){
                        AetherWars.p1.getHand()[kosong] = AetherWars.p1.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p1.getDeck().size() == 2 && drawcardChosenField == 3){
                        AetherWars.p1.getHand()[kosong] = AetherWars.p1.getDeck().get(drawcardChosenField - 2);
                    }
                    else if (AetherWars.p1.getDeck().size() == 1 && drawcardChosenField == 2){
                        AetherWars.p1.getHand()[kosong] = AetherWars.p1.getDeck().get(drawcardChosenField - 2);
                    }
                } else {
                    if (AetherWars.p1.getDeck().size() >= 3){
                        sixthCard = AetherWars.p1.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p1.getDeck().size() == 2 && drawcardChosenField == 1){
                        sixthCard = AetherWars.p1.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p1.getDeck().size() == 2 && drawcardChosenField == 3){
                        sixthCard = AetherWars.p1.getDeck().get(drawcardChosenField - 2);
                    }
                    else if (AetherWars.p1.getDeck().size() == 1 && drawcardChosenField == 2){
                        sixthCard = AetherWars.p1.getDeck().get(drawcardChosenField - 2);
                    }
                }
                if (AetherWars.p1.getDeck().size() >= 3){
                    AetherWars.p1.getDeck().remove(drawcardChosenField - 1);
                }
                else if (AetherWars.p1.getDeck().size() == 2 && drawcardChosenField == 1){
                    AetherWars.p1.getDeck().remove(drawcardChosenField - 1);
                }
                else if (AetherWars.p1.getDeck().size() == 2 && drawcardChosenField == 3){
                    AetherWars.p1.getDeck().remove(drawcardChosenField - 2);
                }
                else if (AetherWars.p1.getDeck().size() == 1 && drawcardChosenField == 2){
                    AetherWars.p1.getDeck().remove(drawcardChosenField - 2);
                }
                Collections.shuffle(AetherWars.p1.getDeck());
            }
            else{
                kosong = AetherWars.p2.firstEmptyHand();
                if (kosong != -1){
                    if (AetherWars.p2.getDeck().size() >= 3){
                        AetherWars.p2.getHand()[kosong] = AetherWars.p2.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p2.getDeck().size() == 2 && drawcardChosenField == 1){
                        AetherWars.p2.getHand()[kosong] = AetherWars.p2.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p2.getDeck().size() == 2 && drawcardChosenField == 3){
                        AetherWars.p2.getHand()[kosong] = AetherWars.p2.getDeck().get(drawcardChosenField - 2);
                    }
                    else if (AetherWars.p2.getDeck().size() == 1 && drawcardChosenField == 2){
                        AetherWars.p2.getHand()[kosong] = AetherWars.p2.getDeck().get(drawcardChosenField - 2);
                    }
                } else {
                    if (AetherWars.p2.getDeck().size() >= 3){
                        sixthCard = AetherWars.p2.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p2.getDeck().size() == 2 && drawcardChosenField == 1){
                        sixthCard = AetherWars.p2.getDeck().get(drawcardChosenField - 1);
                    }
                    else if (AetherWars.p2.getDeck().size() == 2 && drawcardChosenField == 3){
                        sixthCard = AetherWars.p2.getDeck().get(drawcardChosenField - 2);
                    }
                    else if (AetherWars.p2.getDeck().size() == 1 && drawcardChosenField == 2){
                        sixthCard = AetherWars.p2.getDeck().get(drawcardChosenField - 2);
                    }
                }
                if (AetherWars.p2.getDeck().size() >= 3){
                    AetherWars.p2.getDeck().remove(drawcardChosenField - 1);
                }
                else if (AetherWars.p2.getDeck().size() == 2 && drawcardChosenField == 1){
                    AetherWars.p2.getDeck().remove(drawcardChosenField - 1);
                }
                else if (AetherWars.p2.getDeck().size() == 2 && drawcardChosenField == 3){
                    AetherWars.p2.getDeck().remove(drawcardChosenField - 2);
                }
                else if (AetherWars.p2.getDeck().size() == 1 && drawcardChosenField == 2){
                    AetherWars.p2.getDeck().remove(drawcardChosenField - 2);
                }
                Collections.shuffle(AetherWars.p2.getDeck());  
            }
            Stage popupwindow = (Stage) drawcard1.getScene().getWindow();
            if (kosong == -1){
                Pane throwPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./ThrowCards.fxml"));
                popupwindow.setTitle("Throw card");
                popupwindow.setScene(new Scene(throwPane));
                popupwindow.centerOnScreen();
                //popupwindow.showAndWait();
            }else {
                popupwindow.close();
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

        Card c1 = new Card();
        Card c2 = new Card();
        Card c3 = new Card();

        if (AetherWars.playerTurn){
            if (AetherWars.p1.getDeck().size() >= 1){
                c1 = AetherWars.p1.getDeck().get(0);
            }
            if (AetherWars.p1.getDeck().size() >= 2){
                c2 = AetherWars.p1.getDeck().get(1);
            }
            if (AetherWars.p1.getDeck().size() >= 3){
                c3 = AetherWars.p1.getDeck().get(2);
            } 
        } else {
            if (AetherWars.p2.getDeck().size() >= 1){
                c1 = AetherWars.p2.getDeck().get(0);
            }
            if (AetherWars.p2.getDeck().size() >= 2){
                c2 = AetherWars.p2.getDeck().get(1);
            }
            if (AetherWars.p2.getDeck().size() >= 3){
                c3 = AetherWars.p2.getDeck().get(2);
            }   
        }
        
        if ((AetherWars.playerTurn && AetherWars.p1.getDeck().size() >= 3) || (! AetherWars.playerTurn && AetherWars.p2.getDeck().size() >= 3)){
            drawcardhand1.setText(c1.toString());
            drawcardmana1.setText("MANA " + String.valueOf(c1.getMana()));
            drawcardimage1.setImage(new Image("./com/aetherwars/" + c1.getImagePath())); 
            drawcardhand2.setText(c2.toString());
            drawcardmana2.setText("MANA " + String.valueOf(c2.getMana()));
            drawcardimage2.setImage(new Image("./com/aetherwars/" + c2.getImagePath())); 
            drawcardhand3.setText(c3.toString());
            drawcardmana3.setText("MANA " + String.valueOf(c3.getMana()));
            drawcardimage3.setImage(new Image("./com/aetherwars/" + c3.getImagePath()));
        }
        else if ((AetherWars.playerTurn && AetherWars.p1.getDeck().size() >= 2) || (! AetherWars.playerTurn && AetherWars.p2.getDeck().size() >= 2)){
            drawcardhand1.setText(c1.toString());
            drawcardmana1.setText("MANA " + String.valueOf(c1.getMana()));
            drawcardimage1.setImage(new Image("./com/aetherwars/" + c1.getImagePath())); 
            drawcardhand3.setText(c2.toString());
            drawcardmana3.setText("MANA " + String.valueOf(c2.getMana()));
            drawcardimage3.setImage(new Image("./com/aetherwars/" + c2.getImagePath()));
            drawcard2.setStyle("-fx-stroke: white; -fx-stroke-width: 0;");
        }
        else if ((AetherWars.playerTurn && AetherWars.p1.getDeck().size() >= 1) || (! AetherWars.playerTurn && AetherWars.p2.getDeck().size() >= 1)){
            drawcardhand2.setText(c1.toString());
            drawcardmana2.setText("MANA " + String.valueOf(c1.getMana()));
            drawcardimage2.setImage(new Image("./com/aetherwars/" + c1.getImagePath())); 
            drawcard1.setStyle("-fx-stroke: white; -fx-stroke-width: 0;");
            drawcard3.setStyle("-fx-stroke: white; -fx-stroke-width: 0;");
        }
        
        
    }

}

