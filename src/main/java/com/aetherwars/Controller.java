package com.aetherwars;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import com.aetherwars.model.Character;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.CharType;
import com.aetherwars.model.type.PhaseType;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// import card from folder model
import com.aetherwars.model.Card;

public class Controller {
    /** VARIABLE ZONE **/
    private int chosenHand = 0;
    private int chosenField = 0;
    private int chosenPlayer = 0;
    
    
/**** SAMPLE ZONE ****/

    @FXML
    private AnchorPane background;

    @FXML
    private Label chosenidx;

    @FXML
    private Label namatest;

    @FXML 
    private Label indextest;

    @FXML
    private Label movefieldtest;
    
    @FXML
    private Button proceedButton;
//
    
//asdasdsasda

    @FXML
    private Label deckSize;

    @FXML
    private Label manaSize;

    @FXML
    private Rectangle draw;

    @FXML
    private Button submit;

    @FXML
    private Label turn;

    /*** FIELD HOVER SECTION ***/
    // Text Handler
    @FXML
    private Label hand1;
    @FXML
    private Label hand2;
    @FXML
    private Label hand3;
    @FXML
    private Label hand4;
    @FXML
    private Label hand5;

    // Mana Text Handler
    @FXML
    private Label mana1;
    @FXML
    private Label mana2;
    @FXML
    private Label mana3;
    @FXML
    private Label mana4;
    @FXML
    private Label mana5;

    // Card Handler
    @FXML
    private Rectangle card1;
    @FXML
    private Rectangle card2;
    @FXML
    private Rectangle card3;
    @FXML
    private Rectangle card4;
    @FXML
    private Rectangle card5;

    // Hand Image Handler
    @FXML
    private ImageView cardImage1;
    @FXML
    private ImageView cardImage2;
    @FXML
    private ImageView cardImage3;
    @FXML
    private ImageView cardImage4;
    @FXML
    private ImageView cardImage5;

    // Card Field Handler
    @FXML
    private Rectangle field1Card1;
    @FXML
    private Rectangle field1Card2;
    @FXML
    private Rectangle field1Card3;
    @FXML
    private Rectangle field1Card4;
    @FXML
    private Rectangle field1Card5;
    @FXML
    private Rectangle field2Card1;
    @FXML
    private Rectangle field2Card2;
    @FXML
    private Rectangle field2Card3;
    @FXML
    private Rectangle field2Card4;
    @FXML
    private Rectangle field2Card5;

    // Attack Field Handler
    @FXML
    private Label field1Attack1;
    @FXML
    private Label field1Attack2;
    @FXML
    private Label field1Attack3;
    @FXML
    private Label field1Attack4;
    @FXML
    private Label field1Attack5;
    @FXML
    private Label field2Attack1;
    @FXML
    private Label field2Attack2;
    @FXML
    private Label field2Attack3;
    @FXML
    private Label field2Attack4;
    @FXML
    private Label field2Attack5;

    // Health Field Handler
    @FXML
    private Label field1Health1;
    @FXML
    private Label field1Health2;
    @FXML
    private Label field1Health3;
    @FXML
    private Label field1Health4;
    @FXML
    private Label field1Health5;
    @FXML
    private Label field2Health1;
    @FXML
    private Label field2Health2;
    @FXML
    private Label field2Health3;
    @FXML
    private Label field2Health4;
    @FXML
    private Label field2Health5;

    // Image Field Handler
    @FXML
    private ImageView field1Image1;
    @FXML
    private ImageView field1Image2;
    @FXML
    private ImageView field1Image3;
    @FXML
    private ImageView field1Image4;
    @FXML
    private ImageView field1Image5;
    @FXML
    private ImageView field2Image1;
    @FXML
    private ImageView field2Image2;
    @FXML
    private ImageView field2Image3;
    @FXML
    private ImageView field2Image4;
    @FXML
    private ImageView field2Image5;

    // Level Field Handler
    @FXML
    private Label field1Level1;
    @FXML
    private Label field1Level2;
    @FXML
    private Label field1Level3;
    @FXML
    private Label field1Level4;
    @FXML
    private Label field1Level5;
    @FXML
    private Label field2Level1;
    @FXML
    private Label field2Level2;
    @FXML
    private Label field2Level3;
    @FXML
    private Label field2Level4;
    @FXML
    private Label field2Level5;

    // Name Label Handler
    @FXML
    private Label player1text;
    @FXML
    private Label player2text;

    // Player Image Handler
    @FXML
    private ImageView player1image;
    @FXML
    private ImageView player2image;
    

    @FXML
    void drawCard(MouseEvent event)throws Exception {
        List<Label> handText = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
        List<Label> manaText = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));

        background.setStyle("-fx-background-color: grey");

        Stage popupwindow = new Stage();
        Pane drawcardPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./Draw3cards.fxml"));
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.initStyle(StageStyle.UNDECORATED);
        popupwindow.setTitle("Draw card");
        popupwindow.setScene(new Scene(drawcardPane));
        popupwindow.centerOnScreen();
        popupwindow.showAndWait();
        turn.setText("Turn " + String.valueOf(AetherWars.turn));

        if (AetherWars.playerTurn)  {
            AetherWars.p1.resetMana(AetherWars.turn);
            manaSize.setText(AetherWars.p1.getMana() + " / "+ AetherWars.turn);

            for(int i=0; i<5; i++){
                if (AetherWars.p1.getHand()[i] != null){
                    handText.get(i).setText(AetherWars.p1.getHand()[i].toString());
                    manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p1.getHand()[i].getMana()));
                    cardImage.get(i).setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[i].getImagePath())); 
                } else {
                    handText.get(i).setText("");
                    manaText.get(i).setText("");
                    cardImage.get(i).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                }
            }
            deckSize.setText((AetherWars.p1.getDeck().size()) + " / 50");
            AetherWars.playerTurn = false;            
        } else{
            AetherWars.p2.resetMana(AetherWars.turn);
            manaSize.setText(AetherWars.p2.getMana() + " / "+ AetherWars.turn);

            for(int i=0; i<5; i++){
                if(AetherWars.p2.getHand()[i] != null){
                    handText.get(i).setText(AetherWars.p2.getHand()[i].toString());
                    manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p2.getHand()[i].getMana()));
                    cardImage.get(i).setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[i].getImagePath())); 
                } else {
                    handText.get(i).setText("");
                    manaText.get(i).setText("");
                    cardImage.get(i).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                }
                
            }
            deckSize.setText((AetherWars.p2.getDeck().size()) + " / 50");
            AetherWars.playerTurn = true;
            AetherWars.turn++;
        }
        background.setStyle("-fx-background-color: white");
    }
//     Hover Handler
    @FXML
    void card1HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn && AetherWars.p1.getHand()[0] != null) {
            infoStat.setText(AetherWars.p1.getHand()[0].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[0].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[0].getImagePath()));
        }else if (AetherWars.playerTurn && AetherWars.p2.getHand()[0] != null) {
            infoStat.setText(AetherWars.p2.getHand()[0].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[0].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[0].getImagePath()));
        }
    }

    @FXML
    void card1HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }
    @FXML
    void card1Clicked(MouseEvent event){
        if((!AetherWars.playerTurn && AetherWars.p1.getHandStatus()[0]) || (AetherWars.playerTurn && AetherWars.p2.getHandStatus()[0])){
            if(chosenHand == 0){
                card1.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 1;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if(chosenHand == 1) {
                card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                cards.get(chosenHand-1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card1.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 1;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else{
            utilityWarningText.setText("Empty Hand!");
        }
    }

    @FXML
    void card2HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn && AetherWars.p1.getHand()[1] != null) {
            infoStat.setText(AetherWars.p1.getHand()[1].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[1].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[1].getImagePath()));
        }else if (AetherWars.playerTurn && AetherWars.p2.getHand()[1] != null) {
            infoStat.setText(AetherWars.p2.getHand()[1].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[1].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[1].getImagePath()));
        }
}

    @FXML
    void card2HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }
    @FXML
    void card2Clicked(MouseEvent event){
        if((!AetherWars.playerTurn && AetherWars.p1.getHandStatus()[1]) || (AetherWars.playerTurn && AetherWars.p2.getHandStatus()[1])){
            if(chosenHand == 0){
                card2.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 2;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if(chosenHand == 2) {
                card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                cards.get(chosenHand-1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card2.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 2;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else{
            utilityWarningText.setText("Empty Hand!");
        }
    }

    @FXML
    void card3HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn && AetherWars.p1.getHand()[2] != null) {
            infoStat.setText(AetherWars.p1.getHand()[2].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[2].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[2].getImagePath()));
        }else if (AetherWars.playerTurn && AetherWars.p2.getHand()[2] != null) {
            infoStat.setText(AetherWars.p2.getHand()[2].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[2].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[2].getImagePath()));
        }
    }

    @FXML
    void card3HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }
    @FXML
    void card3Clicked(MouseEvent event){
        if((!AetherWars.playerTurn && AetherWars.p1.getHandStatus()[2]) || (AetherWars.playerTurn && AetherWars.p2.getHandStatus()[2])){
            if(chosenHand == 0){
                card3.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 3;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if(chosenHand == 3) {
                card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                cards.get(chosenHand-1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card3.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 3;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else{
            utilityWarningText.setText("Empty Hand!");
        }
    }

    @FXML
    void card4HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn && AetherWars.p1.getHand()[3] != null) {
            infoStat.setText(AetherWars.p1.getHand()[3].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[3].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[3].getImagePath()));
        }else if (AetherWars.playerTurn && AetherWars.p2.getHand()[3] != null) {
            infoStat.setText(AetherWars.p2.getHand()[3].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[3].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[3].getImagePath()));
        }
    }

    @FXML
    void card4HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }
    @FXML
    void card4Clicked(MouseEvent event){
        if((!AetherWars.playerTurn && AetherWars.p1.getHandStatus()[3]) || (AetherWars.playerTurn && AetherWars.p2.getHandStatus()[3])){
            if(chosenHand == 0){
                card4.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 4;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if(chosenHand == 4) {
                card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                cards.get(chosenHand-1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card4.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 4;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else{
            utilityWarningText.setText("Empty Hand!");
        }

    }

    @FXML
    void card5HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn && AetherWars.p1.getHand()[4] != null) {
            infoStat.setText(AetherWars.p1.getHand()[4].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[4].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[4].getImagePath()));
        }else if (AetherWars.playerTurn && AetherWars.p2.getHand()[4] != null) {
            infoStat.setText(AetherWars.p2.getHand()[4].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[4].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[4].getImagePath()));
        }
    }

    @FXML
    void card5HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }
    
    @FXML
    void card5Clicked(MouseEvent event){
        if((!AetherWars.playerTurn && AetherWars.p1.getHandStatus()[4]) || (AetherWars.playerTurn && AetherWars.p2.getHandStatus()[4])){
            if(chosenHand == 0){
                card5.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 5;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if(chosenHand == 5) {
                card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                cards.get(chosenHand-1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card5.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 5;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else{
            utilityWarningText.setText("Empty Hand!");
        }
    }

    // HOVER FIELD CHARACTER
    @FXML 
    void field1Card1HoverIn(MouseEvent event) {
        if (AetherWars.p1.getFieldCard()[0] != null){
            infoStat.setText(AetherWars.p1.getFieldCard()[0].getStat());
            infoDescription.setText(AetherWars.p1.getFieldCard()[0].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[0].getImagePath()));
        }
    }

    @FXML
    void field1Card1HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field1Card2HoverIn(MouseEvent event) {
        if (AetherWars.p1.getFieldCard()[1] != null){
            infoStat.setText(AetherWars.p1.getFieldCard()[1].getStat());
            infoDescription.setText(AetherWars.p1.getFieldCard()[1].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[1].getImagePath()));
        }
    }

    @FXML
    void field1Card2HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field1Card3HoverIn(MouseEvent event) {
        if (AetherWars.p1.getFieldCard()[2] != null){
            infoStat.setText(AetherWars.p1.getFieldCard()[2].getStat());
            infoDescription.setText(AetherWars.p1.getFieldCard()[2].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[2].getImagePath()));
        }
    }

    @FXML
    void field1Card3HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field1Card4HoverIn(MouseEvent event) {
        if (AetherWars.p1.getFieldCard()[3] != null){
            infoStat.setText(AetherWars.p1.getFieldCard()[3].getStat());
            infoDescription.setText(AetherWars.p1.getFieldCard()[3].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[3].getImagePath()));
        }
    }

    @FXML
    void field1Card4HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field1Card5HoverIn(MouseEvent event) {
        if (AetherWars.p1.getFieldCard()[4] != null){
            infoStat.setText(AetherWars.p1.getFieldCard()[4].getStat());
            infoDescription.setText(AetherWars.p1.getFieldCard()[4].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[4].getImagePath()));
        }
    }

    @FXML
    void field1Card5HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field2Card1HoverIn(MouseEvent event) {
        if (AetherWars.p2.getFieldCard()[0] != null){
            infoStat.setText(AetherWars.p2.getFieldCard()[0].getStat());
            infoDescription.setText(AetherWars.p2.getFieldCard()[0].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getFieldCard()[0].getImagePath()));
        }
    }

    @FXML
    void field2Card1HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field2Card2HoverIn(MouseEvent event) {
        if (AetherWars.p2.getFieldCard()[1] != null){
            infoStat.setText(AetherWars.p2.getFieldCard()[1].getStat());
            infoDescription.setText(AetherWars.p2.getFieldCard()[1].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getFieldCard()[1].getImagePath()));
        }
    }

    @FXML
    void field2Card2HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field2Card3HoverIn(MouseEvent event) {
        if (AetherWars.p2.getFieldCard()[2] != null){
            infoStat.setText(AetherWars.p2.getFieldCard()[2].getStat());
            infoDescription.setText(AetherWars.p2.getFieldCard()[2].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getFieldCard()[2].getImagePath()));
        }
    }

    @FXML
    void field2Card3HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field2Card4HoverIn(MouseEvent event) {
        if (AetherWars.p2.getFieldCard()[3] != null){
            infoStat.setText(AetherWars.p2.getFieldCard()[3].getStat());
            infoDescription.setText(AetherWars.p2.getFieldCard()[3].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getFieldCard()[3].getImagePath()));
        }
    }

    @FXML
    void field2Card4HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    @FXML 
    void field2Card5HoverIn(MouseEvent event) {
        if (AetherWars.p2.getFieldCard()[4] != null){
            infoStat.setText(AetherWars.p2.getFieldCard()[4].getStat());
            infoDescription.setText(AetherWars.p2.getFieldCard()[4].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getFieldCard()[4].getImagePath()));
        }
    }

    @FXML
    void field2Card5HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
    }

    /*** CARD INFORMATION SECTION ***/
    @FXML
    private ImageView infoImage;
    @FXML
    private Label infoStat;
    @FXML
    private Label infoDescription;

    /*** UTILITY BUTTON ***/
    @FXML
    private Button removeButton;
    @FXML
    private Button addXPbutton;
    @FXML
    private Label utilityWarningText;

    @FXML
    void removeCard(MouseEvent event) {
        List<Label> handText = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
        List<Label> manaText = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
        
        List<Label> attackText1 = new ArrayList<Label>(Arrays.asList(field1Attack1,field1Attack2,field1Attack3,field1Attack4,field1Attack5));
        List<Label> healthText1 = new ArrayList<Label>(Arrays.asList(field1Health1,field1Health2,field1Health3,field1Health4,field1Health5));
        List<ImageView> fieldImage1 = new ArrayList<ImageView>(Arrays.asList(field1Image1,field1Image2,field1Image3,field1Image4,field1Image5));
        List<Label> levelText1 = new ArrayList<Label>(Arrays.asList(field1Level1,field1Level2,field1Level3,field1Level4,field1Level5));

        List<Label> attackText2 = new ArrayList<Label>(Arrays.asList(field2Attack1,field2Attack2,field2Attack3,field2Attack4,field2Attack5));
        List<Label> healthText2 = new ArrayList<Label>(Arrays.asList(field2Health1,field2Health2,field2Health3,field2Health4,field2Health5));
        List<ImageView> fieldImage2 = new ArrayList<ImageView>(Arrays.asList(field2Image1,field2Image2,field2Image3,field2Image4,field2Image5));
        List<Label> levelText2 = new ArrayList<Label>(Arrays.asList(field2Level1,field2Level2,field2Level3,field2Level4,field2Level5));

        List<Rectangle> fieldCards1 = new ArrayList<Rectangle>(Arrays.asList(field1Card1,field1Card2,field1Card3,field1Card4,field1Card5));
        List<Rectangle> fieldCards2 = new ArrayList<Rectangle>(Arrays.asList(field2Card1,field2Card2,field2Card3,field2Card4,field2Card5));
        if (chosenHand != 0) {
            List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
            cards.get(chosenHand-1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenidx.setText(String.valueOf(chosenHand));
            if(!AetherWars.playerTurn) {
                AetherWars.p1.removeCardFromHand(chosenHand-1);
            }else{
                AetherWars.p2.removeCardFromHand(chosenHand-1);
            }
            handText.get(chosenHand-1).setText("");
            manaText.get(chosenHand-1).setText("");
            cardImage.get(chosenHand-1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
            chosenHand = 0;
            utilityWarningText.setText("");
        } else if(chosenField != 0){
            utilityWarningText.setText(AetherWars.playerTurn +" " +String.valueOf(chosenField));
            if(!AetherWars.playerTurn) {
                fieldCards1.get(chosenField - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                attackText1.get(chosenField - 1).setText("?");
                healthText1.get(chosenField - 1).setText("?");
                levelText1.get(chosenField - 1).setText("0/0 [0]");
                fieldImage1.get(chosenField - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                AetherWars.p1.removeCardFromField(chosenField-1);
                
            } else{
                fieldCards2.get(chosenField - 6).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                attackText2.get(chosenField - 6).setText("?");
                healthText2.get(chosenField - 6).setText("?");
                levelText2.get(chosenField - 6).setText("0/0 [0]");
                fieldImage2.get(chosenField - 6).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                AetherWars.p2.removeCardFromField(chosenField-6);
            }
            chosenField = 0;
            utilityWarningText.setText("");
        } 
        else{
            utilityWarningText.setText("Choose card to remove!");
        }
    }
    @FXML
    void addFieldXP(MouseEvent event) {
        // TODO: SAADSA
    }


    /*** SUBMIT BUTTON SECTION ***/
    @FXML
    void submitHoverIn(MouseEvent event) {
        submit.setStyle("-fx-background-color: #000000;");
        submit.setTextFill(Color.WHITE);
    }

    @FXML
    void submitHoverOut(MouseEvent event) {
        submit.setStyle("-fx-background-color: #dfdfdf;");
        submit.setTextFill(Color.BLACK);
    }

    @FXML
    void submitClicked(MouseEvent event) {
        // TODO : change phase
        turn.setText("Phase 2");
    }


    @FXML
    void clickField1Card1(MouseEvent event) {
        if(chosenField == 1){
            field1Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p1.getFieldCardStatus()[0]){
                    chosenField = 1;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card1.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(!AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p1.getFieldCardStatus()[0]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p1.getHand()[chosenHand - 1];
                        AetherWars.p1.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p1.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 1);
                        chosenHand = 0;
        
                        AetherWars.p1.getFieldCard()[0] = c;
                        AetherWars.p1.getFieldCardStatus()[0] = true;
                        field1Attack1.setText(String.valueOf(c.getAttack()));
                        field1Health1.setText(String.valueOf(c.getHealth()));
                        field1Image1.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field1Level1.setText(c.getExpLevel());
                        AetherWars.p1.setMana(AetherWars.p1.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p1.getMana() + " / "+ AetherWars.turn);
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card2(MouseEvent event) {
        if(chosenField == 2){
            field1Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p1.getFieldCardStatus()[1]){
                    chosenField = 2;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card2.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(!AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p1.getFieldCardStatus()[1]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p1.getHand()[chosenHand - 1];
                        AetherWars.p1.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p1.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 2);
                        chosenHand = 0;
        
                        AetherWars.p1.getFieldCard()[1] = c;
                        AetherWars.p1.getFieldCardStatus()[1] = true;
                        field1Attack2.setText(String.valueOf(c.getAttack()));
                        field1Health2.setText(String.valueOf(c.getHealth()));
                        field1Image2.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field1Level2.setText(c.getExpLevel());
                        AetherWars.p1.setMana(AetherWars.p1.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p1.getMana() + " / "+ AetherWars.turn);
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card3(MouseEvent event) {
        if(chosenField == 3){
            field1Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p1.getFieldCardStatus()[2]){
                    chosenField = 3;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card3.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(!AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p1.getFieldCardStatus()[2]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p1.getHand()[chosenHand - 1];
                        AetherWars.p1.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p1.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 3);
                        chosenHand = 0;
        
                        AetherWars.p1.getFieldCard()[2] = c;
                        AetherWars.p1.getFieldCardStatus()[2] = true;
                        field1Attack3.setText(String.valueOf(c.getAttack()));
                        field1Health3.setText(String.valueOf(c.getHealth()));
                        field1Image3.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field1Level3.setText(c.getExpLevel());
                        AetherWars.p1.setMana(AetherWars.p1.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p1.getMana() + " / "+ AetherWars.turn);
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card4(MouseEvent event) {
        if(chosenField == 4){
            field1Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p1.getFieldCardStatus()[3]){
                    chosenField = 4;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card4.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(!AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p1.getFieldCardStatus()[3]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p1.getHand()[chosenHand - 1];
                        AetherWars.p1.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p1.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 4);
                        chosenHand = 0;
        
                        AetherWars.p1.getFieldCard()[3] = c;
                        AetherWars.p1.getFieldCardStatus()[3] = true;
                        field1Attack4.setText(String.valueOf(c.getAttack()));
                        field1Health4.setText(String.valueOf(c.getHealth()));
                        field1Image4.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field1Level4.setText(c.getExpLevel());
                        AetherWars.p1.setMana(AetherWars.p1.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p1.getMana() + " / "+ AetherWars.turn);
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card5(MouseEvent event) {
        if(chosenField == 5){
            field1Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p1.getFieldCardStatus()[4]){
                    chosenField = 5;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card5.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(!AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p1.getFieldCardStatus()[4]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p1.getHand()[chosenHand - 1];
                        AetherWars.p1.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p1.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 1);
                        chosenHand = 0;
        
                        AetherWars.p1.getFieldCard()[4] = c;
                        AetherWars.p1.getFieldCardStatus()[4] = true;
                        field1Attack5.setText(String.valueOf(c.getAttack()));
                        field1Health5.setText(String.valueOf(c.getHealth()));
                        field1Image5.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field1Level5.setText(c.getExpLevel());
                        AetherWars.p1.setMana(AetherWars.p1.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p1.getMana() + " / "+ AetherWars.turn);
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card1(MouseEvent event) {
        if(chosenField == 6){
            field2Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p2.getFieldCardStatus()[0]){
                    chosenField = 6;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card1.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p2.getFieldCardStatus()[0]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p2.getHand()[chosenHand - 1];
                        AetherWars.p2.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p2.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 1);
                        chosenHand = 0;
        
                        AetherWars.p2.getFieldCard()[0] = c;
                        AetherWars.p2.getFieldCardStatus()[0] = true;
                        field2Attack1.setText(String.valueOf(c.getAttack()));
                        field2Health1.setText(String.valueOf(c.getHealth()));
                        field2Image1.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field2Level1.setText(c.getExpLevel());
                        AetherWars.p2.setMana(AetherWars.p2.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p2.getMana() + " / "+ (AetherWars.turn - 1));
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if(chosenField > 0 && chosenField < 6 && AetherWars.phase == PhaseType.ATTACK && AetherWars.playerTurn){
            // Attack
            // int source = chosenField;
            // if(AetherWars.p1.getFieldCardHasAttacked()[source-1]){
            //     utilityWarningText.setText("Character already attacked!");
            // }
            // else{
            //     if(AetherWars.p1.getFieldCardStatus()[source-1]){
            //         if(AetherWars.p2.getFieldCardStatus()[0]){
            //             chosenField = 6;
            //             movefieldtest.setText(String.valueOf(chosenField));
            //             // p1.get
            //         } else{
            //             utilityWarningText.setText("Empty Field!");
            //         }
            //     } else{
            //         utilityWarningText.setText("Empty Field!");
            //     }
            // }
        }
    }

    @FXML
    void clickField2Card2(MouseEvent event) {
        if(chosenField == 7){
            field2Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p2.getFieldCardStatus()[1]){
                    chosenField = 7;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card2.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p2.getFieldCardStatus()[1]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p2.getHand()[chosenHand - 1];
                        AetherWars.p2.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p2.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 2);
                        chosenHand = 0;
        
                        AetherWars.p2.getFieldCard()[1] = c;
                        AetherWars.p2.getFieldCardStatus()[1] = true;
                        field2Attack2.setText(String.valueOf(c.getAttack()));
                        field2Health2.setText(String.valueOf(c.getHealth()));
                        field2Image2.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field2Level2.setText(c.getExpLevel());
                        AetherWars.p2.setMana(AetherWars.p2.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p2.getMana() + " / "+ (AetherWars.turn - 1));
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card3(MouseEvent event) {
        if(chosenField == 8){
            field2Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p2.getFieldCardStatus()[2]){
                    chosenField = 8;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card3.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p2.getFieldCardStatus()[2]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p2.getHand()[chosenHand - 1];
                        AetherWars.p2.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p2.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 3);
                        chosenHand = 0;
        
                        AetherWars.p2.getFieldCard()[2] = c;
                        AetherWars.p2.getFieldCardStatus()[2] = true;
                        field2Attack3.setText(String.valueOf(c.getAttack()));
                        field2Health3.setText(String.valueOf(c.getHealth()));
                        field2Image3.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field2Level3.setText(c.getExpLevel());
                        AetherWars.p2.setMana(AetherWars.p2.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p2.getMana() + " / "+ (AetherWars.turn - 1));
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card4(MouseEvent event) {
        if(chosenField == 9){
            field2Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p2.getFieldCardStatus()[3]){
                    chosenField = 9;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card4.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p2.getFieldCardStatus()[3]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p2.getHand()[chosenHand - 1];
                        AetherWars.p2.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p2.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 4);
                        chosenHand = 0;
        
                        AetherWars.p2.getFieldCard()[3] = c;
                        AetherWars.p2.getFieldCardStatus()[3] = true;
                        field2Attack4.setText(String.valueOf(c.getAttack()));
                        field2Health4.setText(String.valueOf(c.getHealth()));
                        field2Image4.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field2Level4.setText(c.getExpLevel());
                        AetherWars.p2.setMana(AetherWars.p2.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p2.getMana() + " / "+ (AetherWars.turn - 1));
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card5(MouseEvent event) {
        if(chosenField == 10){
            field2Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if(chosenField == 0){
            if(chosenHand == 0){
                //ATTACK OR REMOVE CARD OR ADD EXP
                if(AetherWars.p2.getFieldCardStatus()[4]){
                    chosenField = 10;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card5.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else{
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if(AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER) {
                    if(AetherWars.p2.getFieldCardStatus()[4]){
                        utilityWarningText.setText("Field Not Empty!");
                    } 
                    else if(AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()){
                        utilityWarningText.setText("Not Enough Mana!");
                    } 
                    else{
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1,card2,card3,card4,card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        
                        // ambil sama kosongin hand yang kepilih
                        Character c = (Character) AetherWars.p2.getHand()[chosenHand - 1];
                        AetherWars.p2.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p2.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        
                        movefieldtest.setText(chosenHand + " ke " + 5);
                        chosenHand = 0;
        
                        AetherWars.p2.getFieldCard()[4] = c;
                        AetherWars.p2.getFieldCardStatus()[4] = true;
                        field2Attack5.setText(String.valueOf(c.getAttack()));
                        field2Health5.setText(String.valueOf(c.getHealth()));
                        field2Image5.setImage(new Image("./com/aetherwars/" + c.getImagePath()));
                        field2Level5.setText(c.getExpLevel());
                        AetherWars.p2.setMana(AetherWars.p2.getMana() - c.getMana());
                        manaSize.setText(AetherWars.p2.getMana() + " / "+ (AetherWars.turn - 1));
                    }
                } else{
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        }
    }

    @FXML
    void clickPlayer1Image(MouseEvent event) {
        if(AetherWars.p1.getFieldCardValue() == 0 && !AetherWars.playerTurn){
            if (chosenPlayer == 1){
                player1image.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenPlayer = 0;
                utilityWarningText.setText("");
            } else {
                
            }
        } else {
            utilityWarningText.setText("Please attack a character first!");
        }
    }

    @FXML
    void clickPlayer2Image(MouseEvent event) {

    }

}
