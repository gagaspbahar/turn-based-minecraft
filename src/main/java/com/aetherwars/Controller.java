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

// import card from folder model
import com.aetherwars.model.Card;

public class Controller {
/**** SAMPLE ZONE ****/
    @FXML
    private Button proceedButton;
//
    @FXML
    void drawCard(MouseEvent event) {
        if (AetherWars.playerTurn) {
            Card c = AetherWars.p1.getDeck().remove(0);
            int idx = AetherWars.p1.firstEmptyHand();
            if (idx != -1) {
                AetherWars.p1.getHand()[idx] = c;
                if (idx == 0) {
                    hand1.setText(c.getName());
                    mana1.setText(Integer.toString(c.getMana()));
                } else if (idx == 1) {
                    hand2.setText(c.getName());
                    mana2.setText(Integer.toString(c.getMana()));
                } else if (idx == 2) {
                    hand3.setText(c.getName());
                    mana3.setText(Integer.toString(c.getMana()));
                } else if (idx == 3) {
                    hand4.setText(c.getName());
                    mana4.setText(Integer.toString(c.getMana()));
                } else if (idx == 4) {
                    hand5.setText(c.getName());
                    mana5.setText(Integer.toString(c.getMana()));
                }
                deckSize.setText((AetherWars.p2.getDeck().size()) + " / 50");
                AetherWars.playerTurn = false;
            }
        } else{
            Card c = AetherWars.p2.getDeck().remove(0);
            int idx = AetherWars.p2.firstEmptyHand();
            if (idx != -1) {
                AetherWars.p2.getHand()[idx] = c;
                if (idx == 0) {
                    hand1.setText(c.getName());
                    mana1.setText(Integer.toString(c.getMana()));
                } else if (idx == 1) {
                    hand2.setText(c.getName());
                    mana2.setText(Integer.toString(c.getMana()));
                } else if (idx == 2) {
                    hand3.setText(c.getName());
                    mana3.setText(Integer.toString(c.getMana()));
                } else if (idx == 3) {
                    hand4.setText(c.getName());
                    mana4.setText(Integer.toString(c.getMana()));
                } else if (idx == 4) {
                    hand5.setText(c.getName());
                    mana5.setText(Integer.toString(c.getMana()));
                }
                deckSize.setText((AetherWars.p2.getDeck().size()) + " / 50");
                AetherWars.playerTurn = true;
            }
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
            infoStat.setText(AetherWars.p1.getHand()[0].getName());
            infoDescription.setText(AetherWars.p1.getHand()[0].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[0].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[0].getName());
            infoDescription.setText(AetherWars.p2.getHand()[0].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[0].getImagePath()));
        }
    }

    @FXML
    void card1HoverOut(MouseEvent event) {
        infoStat.setText("(empty)");
        infoDescription.setText("(empty)");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
    }

    @FXML
    void card2HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[1].getName());
            infoDescription.setText(AetherWars.p1.getHand()[1].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[1].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[1].getName());
            infoDescription.setText(AetherWars.p2.getHand()[1].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[1].getImagePath()));
        }
}

@FXML
void card2HoverOut(MouseEvent event) {
infoStat.setText("(empty)");
        infoDescription.setText("(empty)");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
//        card1.setFill(Color.WHITE);

    }

    @FXML
    void card3HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[2].getName());
            infoDescription.setText(AetherWars.p1.getHand()[2].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[2].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[2].getName());
            infoDescription.setText(AetherWars.p2.getHand()[2].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[2].getImagePath()));
        }
    }

    @FXML
    void card3HoverOut(MouseEvent event) {
        infoStat.setText("(empty)");
        infoDescription.setText("(empty)");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
//        card1.setFill(Color.WHITE);

    }

    @FXML
    void card4HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[3].getName());
            infoDescription.setText(AetherWars.p1.getHand()[3].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[3].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[3].getName());
            infoDescription.setText(AetherWars.p2.getHand()[3].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[3].getImagePath()));
        }
    }

    @FXML
    void card4HoverOut(MouseEvent event) {
        infoStat.setText("(empty)");
        infoDescription.setText("(empty)");
        infoImage.setImage(new Image("./com/aetherwars/card/image/character/white.jpg"));
//        card1.setFill(Color.WHITE);

    }

    @FXML
    void card5HoverIn(MouseEvent event) {
        if (!AetherWars.playerTurn) {
            infoStat.setText(AetherWars.p1.getHand()[4].getName());
            infoDescription.setText(AetherWars.p1.getHand()[4].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[4].getImagePath()));
        }else{
            infoStat.setText(AetherWars.p2.getHand()[4].getName());
            infoDescription.setText(AetherWars.p2.getHand()[4].getDescription());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[4].getImagePath()));
        }
    }

    @FXML
    void card5HoverOut(MouseEvent event) {
        infoStat.setText("(empty)");
        infoDescription.setText("(empty)");
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
