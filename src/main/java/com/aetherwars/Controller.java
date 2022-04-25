package com.aetherwars;

import com.aetherwars.model.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// import card from folder model
import com.aetherwars.model.Card;

public class Controller {
/**** SAMPLE ZONE ****/
    @FXML
    private Label namatest;

    @FXML 
    private Label indextest;

    @FXML
    private Button proceedButton;
//
    @FXML
    void drawCard(MouseEvent event) {
        List<Label> handText = new ArrayList<Label>(Arrays.asList(hand1,hand2,hand3,hand4,hand5));
        List<Label> manaText = new ArrayList<Label>(Arrays.asList(mana1,mana2,mana3,mana4,mana5));
        List<ImageView> cardImage = new ArrayList<ImageView>(Arrays.asList(cardImage1,cardImage2,cardImage3,cardImage4,cardImage5));

        if (AetherWars.playerTurn) {
            Card c = AetherWars.p1.getDeck().remove(0);
            int idx = AetherWars.p1.firstEmptyHand();
            indextest.setText(String.valueOf(idx));
            namatest.setText(c.getName());

            if (idx != -1){
                AetherWars.p1.getHand()[idx] = c;
            }
            for(int i=0; i<5; i++){
                if (AetherWars.p1.getHand()[i] != null){
                    handText.get(i).setText(AetherWars.p1.getHand()[i].toString());
                    manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p1.getHand()[i].getMana()));
                    cardImage.get(i).setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[i].getImagePath())); 
                }
            }
            deckSize.setText((AetherWars.p1.getDeck().size()) + " / 50");
            AetherWars.playerTurn = false;
            
        } else{
            Card c = AetherWars.p2.getDeck().remove(0);
            int idx = AetherWars.p2.firstEmptyHand();
            indextest.setText(String.valueOf(idx));
            namatest.setText(c.getName());
            if (idx != -1){
                AetherWars.p2.getHand()[idx] = c;
            }
            for(int i=0; i<5; i++){
                if(AetherWars.p2.getHand()[i] != null){
                    handText.get(i).setText(AetherWars.p2.getHand()[i].toString());
                    manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p2.getHand()[i].getMana()));
                    cardImage.get(i).setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[i].getImagePath())); 
                }
            }
            deckSize.setText((AetherWars.p2.getDeck().size()) + " / 50");
            AetherWars.playerTurn = true;
        }
    }
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


//     Hover Handler
    @FXML
    void card1HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[0].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[0].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[0].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[0].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[0].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[0].getImagePath()));
        }
    }

    @FXML
    void card1HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
    }

    @FXML
    void card2HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[1].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[1].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[1].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[1].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[1].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[1].getImagePath()));
        }
}

    @FXML
    void card2HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
    }

    @FXML
    void card3HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[2].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[2].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[2].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[2].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[2].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[2].getImagePath()));
        }
    }

    @FXML
    void card3HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
    }

    @FXML
    void card4HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[3].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[3].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[3].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[3].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[3].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[3].getImagePath()));
        }
    }

    @FXML
    void card4HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
//        card1.setFill(Color.WHITE);

    }

    @FXML
    void card5HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[4].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[4].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[4].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[4].getStat());
            infoDescription.setText(AetherWars.p2.getHand()[4].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[4].getImagePath()));
        }
    }

    @FXML
    void card5HoverOut(MouseEvent event) {
        infoStat.setText("");
        infoDescription.setText("");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
    }


    /*** CARD INFORMATION SECTION ***/
    @FXML
    private ImageView infoImage;
    @FXML
    private Label infoStat;
    @FXML
    private Label infoDescription;


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
        // placeholder
        turn.setText("Phase 2");
    }
}
