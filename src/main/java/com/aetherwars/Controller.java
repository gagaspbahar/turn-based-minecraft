package com.aetherwars;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;
import com.aetherwars.model.Spell;
import com.aetherwars.model.Character;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.CharType;
import com.aetherwars.model.type.PhaseType;
import com.aetherwars.model.type.SpellType;

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
    private boolean hasDrawn = false;

    /**** SAMPLE ZONE ****/
    @FXML
    private Label attack1;
    @FXML
    private Label health1;
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

    @FXML
    private Button reduceHP;
    //

    // asdasdsasda

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

    // Player HP Handler
    @FXML
    private Rectangle HPPlayer1;

    @FXML
    private Rectangle HPPlayer2;

    @FXML
    private Rectangle drawRectangle;
    @FXML
    private Rectangle planRectangle;
    @FXML
    private Rectangle attackRectangle;
    @FXML
    private Rectangle endRectangle;

    @FXML
    void drawCard(MouseEvent event) throws Exception {
        if (AetherWars.phase == PhaseType.DRAW && !hasDrawn) {
            List<Label> handText = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
            List<Label> manaText = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
            List<ImageView> cardImage = new ArrayList<ImageView>(
                    Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));

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

            if (AetherWars.playerTurn) {
                AetherWars.p1.resetMana(AetherWars.turn);
                manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);

                for (int i = 0; i < 5; i++) {
                    if (AetherWars.p1.getHand()[i] != null) {
                        handText.get(i).setText(AetherWars.p1.getHand()[i].toString());
                        manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p1.getHand()[i].getMana()));
                        cardImage.get(i)
                                .setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[i].getImagePath()));
                    } else {
                        handText.get(i).setText("");
                        manaText.get(i).setText("");
                        cardImage.get(i).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                    }
                }
                deckSize.setText((AetherWars.p1.getDeck().size()) + " / 50");
                // AetherWars.playerTurn = false;
            } else {
                AetherWars.p2.resetMana(AetherWars.turn);
                manaSize.setText(AetherWars.p2.getMana() + " / " + AetherWars.turn);

                for (int i = 0; i < 5; i++) {
                    if (AetherWars.p2.getHand()[i] != null) {
                        handText.get(i).setText(AetherWars.p2.getHand()[i].toString());
                        manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p2.getHand()[i].getMana()));
                        cardImage.get(i)
                                .setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[i].getImagePath()));
                    } else {
                        handText.get(i).setText("");
                        manaText.get(i).setText("");
                        cardImage.get(i).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                    }

                }
                deckSize.setText((AetherWars.p2.getDeck().size()) + " / 50");
                // AetherWars.playerTurn = true;
                // AetherWars.turn++;
            }
            background.setStyle("-fx-background-color: white");
            hasDrawn = true;
            utilityWarningText.setText("");
        } else if (hasDrawn) {
            utilityWarningText.setText("You have drawn a card");
        } else {
            utilityWarningText.setText("You're not in draw phase");
        }
    }

    @FXML
    void refreshHand() {
        List<Label> handText = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
        List<Label> manaText = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
        List<ImageView> cardImage = new ArrayList<ImageView>(
                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));

        if (AetherWars.playerTurn) {
            AetherWars.p1.resetMana(AetherWars.turn);
            manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);

            for (int i = 0; i < 5; i++) {
                if (AetherWars.p1.getHand()[i] != null) {
                    handText.get(i).setText(AetherWars.p1.getHand()[i].toString());
                    manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p1.getHand()[i].getMana()));
                    cardImage.get(i)
                            .setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[i].getImagePath()));
                } else {
                    handText.get(i).setText("");
                    manaText.get(i).setText("");
                    cardImage.get(i).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                }
            }
            deckSize.setText((AetherWars.p1.getDeck().size()) + " / 50");
            // AetherWars.playerTurn = false;
        } else {
            AetherWars.p2.resetMana(AetherWars.turn);
            manaSize.setText(AetherWars.p2.getMana() + " / " + AetherWars.turn);

            for (int i = 0; i < 5; i++) {
                if (AetherWars.p2.getHand()[i] != null) {
                    handText.get(i).setText(AetherWars.p2.getHand()[i].toString());
                    manaText.get(i).setText("MANA " + String.valueOf(AetherWars.p2.getHand()[i].getMana()));
                    cardImage.get(i)
                            .setImage(new Image("./com/aetherwars/" + AetherWars.p2.getHand()[i].getImagePath()));
                } else {
                    handText.get(i).setText("");
                    manaText.get(i).setText("");
                    cardImage.get(i).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                }

            }
            deckSize.setText((AetherWars.p2.getDeck().size()) + " / 50");
            // AetherWars.playerTurn = true;
            // AetherWars.turn++;
        }
        background.setStyle("-fx-background-color: white");
        utilityWarningText.setText("");
    }

    // Hover Handler
    @FXML
    void card1HoverIn(MouseEvent event) {
        if (AetherWars.playerTurn && AetherWars.p1.getHand()[0] != null) {
            infoStat.setText(AetherWars.p1.getHand()[0].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[0].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[0].getImagePath()));
        } else if (!AetherWars.playerTurn && AetherWars.p2.getHand()[0] != null) {
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
    void card1Clicked(MouseEvent event) {
        if ((AetherWars.playerTurn && AetherWars.p1.getHandStatus()[0])
                || (!AetherWars.playerTurn && AetherWars.p2.getHandStatus()[0])) {
            if (chosenHand == 0) {
                card1.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 1;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if (chosenHand == 1) {
                card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1, card2, card3, card4, card5));
                cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card1.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 1;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else {
            utilityWarningText.setText("Empty Hand!");
        }
    }

    @FXML
    void card2HoverIn(MouseEvent event) {
        if (AetherWars.playerTurn && AetherWars.p1.getHand()[1] != null) {
            infoStat.setText(AetherWars.p1.getHand()[1].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[1].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[1].getImagePath()));
        } else if (!AetherWars.playerTurn && AetherWars.p2.getHand()[1] != null) {
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
    void card2Clicked(MouseEvent event) {
        if ((AetherWars.playerTurn && AetherWars.p1.getHandStatus()[1])
                || (!AetherWars.playerTurn && AetherWars.p2.getHandStatus()[1])) {
            if (chosenHand == 0) {
                card2.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 2;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if (chosenHand == 2) {
                card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1, card2, card3, card4, card5));
                cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card2.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 2;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else {
            utilityWarningText.setText("Empty Hand!");
        }
    }

    @FXML
    void card3HoverIn(MouseEvent event) {
        if (AetherWars.playerTurn && AetherWars.p1.getHand()[2] != null) {
            infoStat.setText(AetherWars.p1.getHand()[2].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[2].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[2].getImagePath()));
        } else if (!AetherWars.playerTurn && AetherWars.p2.getHand()[2] != null) {
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
    void card3Clicked(MouseEvent event) {
        if ((AetherWars.playerTurn && AetherWars.p1.getHandStatus()[2])
                || (!AetherWars.playerTurn && AetherWars.p2.getHandStatus()[2])) {
            if (chosenHand == 0) {
                card3.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 3;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if (chosenHand == 3) {
                card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1, card2, card3, card4, card5));
                cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card3.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 3;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else {
            utilityWarningText.setText("Empty Hand!");
        }
    }

    @FXML
    void card4HoverIn(MouseEvent event) {
        if (AetherWars.playerTurn && AetherWars.p1.getHand()[3] != null) {
            infoStat.setText(AetherWars.p1.getHand()[3].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[3].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[3].getImagePath()));
        } else if (!AetherWars.playerTurn && AetherWars.p2.getHand()[3] != null) {
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
    void card4Clicked(MouseEvent event) {
        if ((AetherWars.playerTurn && AetherWars.p1.getHandStatus()[3])
                || (!AetherWars.playerTurn && AetherWars.p2.getHandStatus()[3])) {
            if (chosenHand == 0) {
                card4.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 4;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if (chosenHand == 4) {
                card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1, card2, card3, card4, card5));
                cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card4.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 4;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else {
            utilityWarningText.setText("Empty Hand!");
        }

    }

    @FXML
    void card5HoverIn(MouseEvent event) {
        if (AetherWars.playerTurn && AetherWars.p1.getHand()[4] != null) {
            infoStat.setText(AetherWars.p1.getHand()[4].getStat());
            infoDescription.setText(AetherWars.p1.getHand()[4].getDescriptionNewlineFormat());
            infoImage.setImage(new Image("./com/aetherwars/" + AetherWars.p1.getHand()[4].getImagePath()));
        } else if (!AetherWars.playerTurn && AetherWars.p2.getHand()[4] != null) {
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
    void card5Clicked(MouseEvent event) {
        if ((AetherWars.playerTurn && AetherWars.p1.getHandStatus()[4])
                || (!AetherWars.playerTurn && AetherWars.p2.getHandStatus()[4])) {
            if (chosenHand == 0) {
                card5.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 5;
                chosenidx.setText(String.valueOf(chosenHand));
            } else if (chosenHand == 5) {
                card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                chosenHand = 0;
                chosenidx.setText(String.valueOf(chosenHand));
            } else {
                List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1, card2, card3, card4, card5));
                cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                card5.setStyle("-fx-stroke: orange; -fx-stroke-width: 5;");
                chosenHand = 5;
                chosenidx.setText(String.valueOf(chosenHand));
            }
            utilityWarningText.setText("");
        } else {
            utilityWarningText.setText("Empty Hand!");
        }
    }

    // HOVER FIELD CHARACTER
    @FXML
    void field1Card1HoverIn(MouseEvent event) {
        if (AetherWars.p1.getFieldCard()[0] != null) {
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
        if (AetherWars.p1.getFieldCard()[1] != null) {
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
        if (AetherWars.p1.getFieldCard()[2] != null) {
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
        if (AetherWars.p1.getFieldCard()[3] != null) {
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
        if (AetherWars.p1.getFieldCard()[4] != null) {
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
        if (AetherWars.p2.getFieldCard()[0] != null) {
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
        if (AetherWars.p2.getFieldCard()[1] != null) {
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
        if (AetherWars.p2.getFieldCard()[2] != null) {
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
        if (AetherWars.p2.getFieldCard()[3] != null) {
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
        if (AetherWars.p2.getFieldCard()[4] != null) {
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
        List<Label> handText = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
        List<Label> manaText = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
        List<ImageView> cardImage = new ArrayList<ImageView>(
                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));

        List<Label> attackText1 = new ArrayList<Label>(
                Arrays.asList(field1Attack1, field1Attack2, field1Attack3, field1Attack4, field1Attack5));
        List<Label> healthText1 = new ArrayList<Label>(
                Arrays.asList(field1Health1, field1Health2, field1Health3, field1Health4, field1Health5));
        List<ImageView> fieldImage1 = new ArrayList<ImageView>(
                Arrays.asList(field1Image1, field1Image2, field1Image3, field1Image4, field1Image5));
        List<Label> levelText1 = new ArrayList<Label>(
                Arrays.asList(field1Level1, field1Level2, field1Level3, field1Level4, field1Level5));

        List<Label> attackText2 = new ArrayList<Label>(
                Arrays.asList(field2Attack1, field2Attack2, field2Attack3, field2Attack4, field2Attack5));
        List<Label> healthText2 = new ArrayList<Label>(
                Arrays.asList(field2Health1, field2Health2, field2Health3, field2Health4, field2Health5));
        List<ImageView> fieldImage2 = new ArrayList<ImageView>(
                Arrays.asList(field2Image1, field2Image2, field2Image3, field2Image4, field2Image5));
        List<Label> levelText2 = new ArrayList<Label>(
                Arrays.asList(field2Level1, field2Level2, field2Level3, field2Level4, field2Level5));

        List<Rectangle> fieldCards1 = new ArrayList<Rectangle>(
                Arrays.asList(field1Card1, field1Card2, field1Card3, field1Card4, field1Card5));
        List<Rectangle> fieldCards2 = new ArrayList<Rectangle>(
                Arrays.asList(field2Card1, field2Card2, field2Card3, field2Card4, field2Card5));
        if (chosenHand != 0) {
            List<Rectangle> cards = new ArrayList<Rectangle>(Arrays.asList(card1, card2, card3, card4, card5));
            cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenidx.setText(String.valueOf(chosenHand));
            if (!AetherWars.playerTurn) {
                AetherWars.p1.removeCardFromHand(chosenHand - 1);
            } else {
                AetherWars.p2.removeCardFromHand(chosenHand - 1);
            }
            handText.get(chosenHand - 1).setText("");
            manaText.get(chosenHand - 1).setText("");
            cardImage.get(chosenHand - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
            chosenHand = 0;
            utilityWarningText.setText("");
        } else if (chosenField != 0) {
            utilityWarningText.setText(AetherWars.playerTurn + " " + String.valueOf(chosenField));
            if (!AetherWars.playerTurn) {
                fieldCards1.get(chosenField - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                attackText1.get(chosenField - 1).setText("?");
                healthText1.get(chosenField - 1).setText("?");
                levelText1.get(chosenField - 1).setText("0/0 [0]");
                fieldImage1.get(chosenField - 1).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                AetherWars.p1.removeCardFromField(chosenField - 1);

            } else {
                fieldCards2.get(chosenField - 6).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                attackText2.get(chosenField - 6).setText("?");
                healthText2.get(chosenField - 6).setText("?");
                levelText2.get(chosenField - 6).setText("0/0 [0]");
                fieldImage2.get(chosenField - 6).setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                AetherWars.p2.removeCardFromField(chosenField - 6);
            }
            chosenField = 0;
            utilityWarningText.setText("");
        } else {
            utilityWarningText.setText("Choose card to remove!");
        }
    }

    @FXML
    void addFieldXP(MouseEvent event) {
        List<Label> attackText = new ArrayList<Label>(
                Arrays.asList(field1Attack1, field1Attack2, field1Attack3, field1Attack4, field1Attack5,
                        field2Attack1, field2Attack2, field2Attack3, field2Attack4, field2Attack5));
        List<Label> healthText = new ArrayList<Label>(
                Arrays.asList(field1Health1, field1Health2, field1Health3, field1Health4, field1Health5,
                        field2Health1, field2Health2, field2Health3, field2Health4, field2Health5));
        List<Label> levelText = new ArrayList<Label>(
                Arrays.asList(field1Level1, field1Level2, field1Level3, field1Level4, field1Level5,
                        field2Level1, field2Level2, field2Level3, field2Level4, field2Level5));
        // chosenField 0 gbs milih
        if (chosenField == 0) {
            utilityWarningText.setText("Choose field slot to add XP!");
        }
        // Kalo chosenField 1 sampai 5 dan playerTurn false
        // if mana > 0
        else if (chosenField >= 1 && chosenField <= 5 && !AetherWars.playerTurn) {
            if (AetherWars.p1.getMana() > 0) {
                AetherWars.p1.getFieldCard()[chosenField - 1].addExp(1);
                AetherWars.p1.setMana(AetherWars.p1.getMana() - 1);
                attackText.get(chosenField - 1)
                        .setText(String.valueOf(AetherWars.p1.getFieldCard()[chosenField - 1].getAttack()));
                healthText.get(chosenField - 1)
                        .setText(String.valueOf(AetherWars.p1.getFieldCard()[chosenField - 1].getHealth()));
                levelText.get(chosenField - 1)
                        .setText(String.valueOf(AetherWars.p1.getFieldCard()[chosenField - 1].getExpLevel()));
                manaSize.setText(String.valueOf(AetherWars.p1.getMana()) + "/" + AetherWars.turn);
            } else {
                utilityWarningText.setText("Not Enough Mana!");
            }
        }
        // kalo chosenField 6 sampai 10 dan playerTurn true
        else if (chosenField >= 6 && chosenField <= 10 && AetherWars.playerTurn && AetherWars.p2.getMana() > 0) {
            if (AetherWars.p2.getMana() > 0) {
                AetherWars.p2.getFieldCard()[chosenField - 6].addExp(1);
                AetherWars.p2.setMana(AetherWars.p2.getMana() - 1);
                attackText.get(chosenField - 1)
                        .setText(String.valueOf(AetherWars.p2.getFieldCard()[chosenField - 6].getAttack()));
                healthText.get(chosenField - 1)
                        .setText(String.valueOf(AetherWars.p2.getFieldCard()[chosenField - 6].getHealth()));
                levelText.get(chosenField - 1)
                        .setText(String.valueOf(AetherWars.p2.getFieldCard()[chosenField - 6].getExpLevel()));
                manaSize.setText(String.valueOf(AetherWars.p2.getMana()) + "/" + AetherWars.turn);
            } else {
                utilityWarningText.setText("Not Enough Mana!");
            }
        } else {
            utilityWarningText.setText("case aneh!");
        }
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
        if (AetherWars.phase == PhaseType.DRAW) {
            drawRectangle.setFill(Color.valueOf("#dfdfdf"));
            planRectangle.setFill(Color.valueOf("#ff8c00"));
            AetherWars.phase = PhaseType.PLAN;
        } else if (AetherWars.phase == PhaseType.PLAN) {
            planRectangle.setFill(Color.valueOf("#dfdfdf"));
            attackRectangle.setFill(Color.valueOf("#ff8c00"));
            AetherWars.phase = PhaseType.ATTACK;
        } else if (AetherWars.phase == PhaseType.ATTACK) {
            attackRectangle.setFill(Color.valueOf("#dfdfdf"));
            endRectangle.setFill(Color.valueOf("#ff8c00"));
            AetherWars.phase = PhaseType.END;
            updateFieldColorEndAttackPhase();
        } else {
            if (!AetherWars.playerTurn) {
                player1text.setStyle("-fx-background-color: #ad2517;");
                player1text.setTextFill(Color.WHITE);
                player2text.setStyle("-fx-background-color: #dfdfdf;");
                player2text.setTextFill(Color.BLACK);
                AetherWars.p2.setFieldCardHasAttackedFalse();
            } else {
                player2text.setStyle("-fx-background-color: #ad2517");
                player2text.setTextFill(Color.WHITE);
                player1text.setStyle("-fx-background-color: #dfdfdf;");
                player1text.setTextFill(Color.BLACK);
                AetherWars.p1.setFieldCardHasAttackedFalse();
            }
            endRectangle.setFill(Color.valueOf("#dfdfdf"));
            drawRectangle.setFill(Color.valueOf("#ff8c00"));
            AetherWars.phase = PhaseType.DRAW;
            AetherWars.playerTurn = !AetherWars.playerTurn;
            if (AetherWars.playerTurn) {
                AetherWars.turn += 1;
            }
            turn.setText("Turn " + String.valueOf(AetherWars.turn));
            hasDrawn = false;
            refreshHand();
            chosenField = 0;
            resetFieldBorder();
        }
    }

    @FXML
    void resetFieldBorder() {
        field1Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field1Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field1Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field1Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field1Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field2Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field2Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field2Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field2Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
        field2Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }

    @FXML
    void updateLevelAfterAttack(int field) {
        if (field == 1) {
            field1Level1.setText(AetherWars.p1.getFieldCard()[0].getExpLevel());
        } else if (field == 2) {
            field1Level2.setText(AetherWars.p1.getFieldCard()[1].getExpLevel());
        } else if (field == 3) {
            field1Level3.setText(AetherWars.p1.getFieldCard()[2].getExpLevel());
        } else if (field == 4) {
            field1Level4.setText(AetherWars.p1.getFieldCard()[3].getExpLevel());
        } else if (field == 5) {
            field1Level5.setText(AetherWars.p1.getFieldCard()[4].getExpLevel());
        } else if (field == 6) {
            field2Level1.setText(AetherWars.p2.getFieldCard()[0].getExpLevel());
        } else if (field == 7) {
            field2Level2.setText(AetherWars.p2.getFieldCard()[1].getExpLevel());
        } else if (field == 8) {
            field2Level3.setText(AetherWars.p2.getFieldCard()[2].getExpLevel());
        } else if (field == 9) {
            field2Level4.setText(AetherWars.p2.getFieldCard()[3].getExpLevel());
        } else if (field == 10) {
            field2Level5.setText(AetherWars.p2.getFieldCard()[4].getExpLevel());
        }
    }

    @FXML
    void updateFieldColorAfterAttack(int field) {
        System.out.println(field);
        if (field == 1) {
            field1Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field1Card1.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 2) {
            field1Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field1Card2.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 3) {
            field1Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field1Card3.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 4) {
            field1Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field1Card4.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 5) {
            field1Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field1Card5.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 6) {
            field2Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field2Card1.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 7) {
            field2Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field2Card2.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 8) {
            field2Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field2Card3.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 9) {
            field2Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field2Card4.setFill(Color.valueOf("#ff00003e"));
        } else if (field == 10) {
            field2Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            field2Card5.setFill(Color.valueOf("#ff00003e"));
        }
    }

    @FXML
    void updateFieldColorEndAttackPhase() {
        field1Card1.setFill(Color.TRANSPARENT);
        field1Card2.setFill(Color.TRANSPARENT);
        field1Card3.setFill(Color.TRANSPARENT);
        field1Card4.setFill(Color.TRANSPARENT);
        field1Card5.setFill(Color.TRANSPARENT);
        field2Card1.setFill(Color.TRANSPARENT);
        field2Card2.setFill(Color.TRANSPARENT);
        field2Card3.setFill(Color.TRANSPARENT);
        field2Card4.setFill(Color.TRANSPARENT);
        field2Card5.setFill(Color.TRANSPARENT);
    }

    @FXML
    void clickField1Card1(MouseEvent event) {
        if (chosenField == 1) {
            field1Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p1.getFieldCardStatus()[0]) {
                    chosenField = 1;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card1.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p1.getFieldCardStatus()[0]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);
                    }
                } else if (!AetherWars.playerTurn
                        && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.SPELL) {
                    if (!AetherWars.p1.getFieldCardStatus()[0]) {
                        utilityWarningText.setText("Can't add spell to Empty Field!");
                    } else if (AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        // Pakein Spell
                        Spell s = (Spell) AetherWars.p1.getHand()[chosenHand - 1];
                        s.cast(AetherWars.p1.getFieldCard()[0], AetherWars.p1);

                        // Check if card is dead
                        if (AetherWars.p1.getFieldCard()[0].getHealth() <= 0) {
                            field1Attack1.setText("?");
                            field1Health1.setText("?");
                            field1Level1.setText("0/0 [0]");
                            field1Image1.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            AetherWars.p1.removeCardFromField(0);
                        } else {
                            // re-Render Field
                            field1Attack1.setText(String.valueOf(AetherWars.p1.getFieldCard()[0].getAttack()));
                            field1Health1.setText(String.valueOf(AetherWars.p1.getFieldCard()[0].getHealth()));
                            field1Level1.setText(AetherWars.p1.getFieldCard()[0].getExpLevel());
                            field1Image1.setImage(
                                    new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[0].getImagePath()));
                        }
                        manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);
                        // Hapus Spell dari Hand
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                        AetherWars.p1.getHandStatus()[chosenHand - 1] = false;
                        AetherWars.p1.getHand()[chosenHand - 1] = null;
                        cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                    }
                } else if (AetherWars.playerTurn
                        && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.SPELL) {
                    Spell s = (Spell) AetherWars.p2.getHand()[chosenHand - 1];
                    if (s.getSpellType() == SpellType.MORPH) {
                        if (!AetherWars.p1.getFieldCardStatus()[0]) {
                            utilityWarningText.setText("Can't add spell to Empty Field!");
                        } else if (AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()) {
                            utilityWarningText.setText("Not Enough Mana!");
                        } else {
                            s.cast(AetherWars.p1.getFieldCard()[0], AetherWars.p2);

                            // re-Render field
                            field1Attack1.setText(String.valueOf(AetherWars.p1.getFieldCard()[0].getAttack()));
                            field1Health1.setText(String.valueOf(AetherWars.p1.getFieldCard()[0].getHealth()));
                            field1Level1.setText(AetherWars.p1.getFieldCard()[0].getExpLevel());
                            field1Image1.setImage(
                                    new Image("./com/aetherwars/" + AetherWars.p1.getFieldCard()[0].getImagePath()));
                            manaSize.setText(AetherWars.p2.getMana() + " / " + AetherWars.turn);

                            // Hapus Spell dari Hand
                            List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                            List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                            List<ImageView> cardImage = new ArrayList<ImageView>(
                                    Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                            List<Rectangle> cards = new ArrayList<Rectangle>(
                                    Arrays.asList(card1, card2, card3, card4, card5));
                            hand.get(chosenHand - 1).setText("");
                            mana.get(chosenHand - 1).setText("");
                            cardImage.get(chosenHand - 1)
                                    .setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            AetherWars.p2.getHandStatus()[chosenHand - 1] = false;
                            AetherWars.p2.getHand()[chosenHand - 1] = null;
                            cards.get(chosenHand - 1).setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                        }
                    } else {
                        utilityWarningText.setText("You can only cast MORPH spell to opponent!");
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 5 && chosenField < 11 && AetherWars.phase == PhaseType.ATTACK
                && !AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 0;
            if (AetherWars.p2.getFieldCardHasAttacked()[source - 6]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p2.getFieldCardStatus()[source - 6]) {
                    if (AetherWars.p1.getFieldCardStatus()[target]) {
                        chosenField = 1;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p2.getFieldCard()[source - 6].attackChara(AetherWars.p1.getFieldCard()[target]);
                        field1Health1.setText(String.valueOf(AetherWars.p1.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p2.getFieldCard()[source - 6].getName() + " attack "
                                + AetherWars.p1.getFieldCard()[target].getName();
                        if (AetherWars.p1.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field1Image1.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field1Attack1.setText("?");
                            field1Health1.setText("?");
                            field1Level1.setText("0/0 [0]");
                            AetherWars.p1.getFieldCardStatus()[target] = false;
                            AetherWars.p1.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                        chosenField = 0;
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card2(MouseEvent event) {
        if (chosenField == 2) {
            field1Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p1.getFieldCardStatus()[1]) {
                    chosenField = 2;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card2.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p1.getFieldCardStatus()[1]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 5 && chosenField < 11 && AetherWars.phase == PhaseType.ATTACK
                && !AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 1;
            if (AetherWars.p2.getFieldCardHasAttacked()[source - 6]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p2.getFieldCardStatus()[source - 6]) {
                    if (AetherWars.p1.getFieldCardStatus()[target]) {
                        chosenField = 2;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p2.getFieldCard()[source - 6].attackChara(AetherWars.p1.getFieldCard()[target]);
                        field1Health2.setText(String.valueOf(AetherWars.p1.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p2.getFieldCard()[source - 6].getName() + " attack "
                                + AetherWars.p1.getFieldCard()[target].getName();
                        if (AetherWars.p1.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field1Image2.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field1Attack2.setText("?");
                            field1Health2.setText("?");
                            field1Level2.setText("0/0 [0]");
                            AetherWars.p1.getFieldCardStatus()[target] = false;
                            AetherWars.p1.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card3(MouseEvent event) {
        if (chosenField == 3) {
            field1Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p1.getFieldCardStatus()[2]) {
                    chosenField = 3;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card3.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p1.getFieldCardStatus()[2]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 5 && chosenField < 11 && AetherWars.phase == PhaseType.ATTACK
                && !AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 2;
            if (AetherWars.p2.getFieldCardHasAttacked()[source - 6]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p2.getFieldCardStatus()[source - 6]) {
                    if (AetherWars.p1.getFieldCardStatus()[target]) {
                        chosenField = 2;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p2.getFieldCard()[source - 6].attackChara(AetherWars.p1.getFieldCard()[target]);
                        field1Health3.setText(String.valueOf(AetherWars.p1.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p2.getFieldCard()[source - 6].getName() + " attack "
                                + AetherWars.p1.getFieldCard()[target].getName();
                        if (AetherWars.p1.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field1Image3.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field1Attack3.setText("?");
                            field1Health3.setText("?");
                            field1Level3.setText("0/0 [0]");
                            AetherWars.p1.getFieldCardStatus()[target] = false;
                            AetherWars.p1.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card4(MouseEvent event) {
        if (chosenField == 4) {
            field1Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p1.getFieldCardStatus()[3]) {
                    chosenField = 4;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card4.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p1.getFieldCardStatus()[3]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 5 && chosenField < 11 && AetherWars.phase == PhaseType.ATTACK
                && !AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 3;
            if (AetherWars.p2.getFieldCardHasAttacked()[source - 6]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p2.getFieldCardStatus()[source - 6]) {
                    if (AetherWars.p1.getFieldCardStatus()[target]) {
                        chosenField = 4;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p2.getFieldCard()[source - 6].attackChara(AetherWars.p1.getFieldCard()[target]);
                        field1Health4.setText(String.valueOf(AetherWars.p1.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p2.getFieldCard()[source - 6].getName() + " attack "
                                + AetherWars.p1.getFieldCard()[target].getName();
                        if (AetherWars.p1.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field1Image4.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field1Attack4.setText("?");
                            field1Health4.setText("?");
                            field1Level4.setText("0/0 [0]");
                            AetherWars.p1.getFieldCardStatus()[target] = false;
                            AetherWars.p1.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField1Card5(MouseEvent event) {
        if (chosenField == 5) {
            field1Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p1.getFieldCardStatus()[4]) {
                    chosenField = 5;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field1Card5.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (AetherWars.playerTurn && AetherWars.p1.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p1.getFieldCardStatus()[4]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p1.getMana() < AetherWars.p1.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p1.getMana() + " / " + AetherWars.turn);
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 5 && chosenField < 11 && AetherWars.phase == PhaseType.ATTACK
                && !AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 4;
            if (AetherWars.p2.getFieldCardHasAttacked()[source - 6]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p2.getFieldCardStatus()[source - 6]) {
                    if (AetherWars.p1.getFieldCardStatus()[target]) {
                        chosenField = 5;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p2.getFieldCard()[source - 6].attackChara(AetherWars.p1.getFieldCard()[target]);
                        field1Health5.setText(String.valueOf(AetherWars.p1.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p2.getFieldCard()[source - 6].getName() + " attack "
                                + AetherWars.p1.getFieldCard()[target].getName();
                        if (AetherWars.p1.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field1Image5.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field1Attack5.setText("?");
                            field1Health5.setText("?");
                            field1Level5.setText("0/0 [0]");
                            AetherWars.p1.getFieldCardStatus()[target] = false;
                            AetherWars.p1.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card1(MouseEvent event) {
        if (chosenField == 6) {
            field2Card1.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p2.getFieldCardStatus()[0]) {
                    chosenField = 6;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card1.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (!AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p2.getFieldCardStatus()[0]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p2.getMana() + " / " + (AetherWars.turn - 1));
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 0 && chosenField < 6 && AetherWars.phase == PhaseType.ATTACK
                && AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 0;
            if (AetherWars.p1.getFieldCardHasAttacked()[source - 1]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p1.getFieldCardStatus()[source - 1]) {
                    if (AetherWars.p2.getFieldCardStatus()[target]) {
                        chosenField = 6;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p1.getFieldCard()[source - 1].attackChara(AetherWars.p2.getFieldCard()[target]);
                        field2Health1.setText(String.valueOf(AetherWars.p2.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p1.getFieldCard()[source - 1].getName() + " attack "
                                + AetherWars.p2.getFieldCard()[target].getName();
                        if (AetherWars.p2.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field2Image1.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field2Attack1.setText("?");
                            field2Health1.setText("?");
                            field2Level1.setText("0/0 [0]");
                            AetherWars.p2.getFieldCardStatus()[target] = false;
                            AetherWars.p2.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card2(MouseEvent event) {
        if (chosenField == 7) {
            field2Card2.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p2.getFieldCardStatus()[1]) {
                    chosenField = 7;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card2.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (!AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p2.getFieldCardStatus()[1]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p2.getMana() + " / " + (AetherWars.turn - 1));
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 0 && chosenField < 6 && AetherWars.phase == PhaseType.ATTACK
                && AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 1;
            if (AetherWars.p1.getFieldCardHasAttacked()[source - 1]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p1.getFieldCardStatus()[source - 1]) {
                    if (AetherWars.p2.getFieldCardStatus()[target]) {
                        chosenField = 7;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p1.getFieldCard()[source - 1].attackChara(AetherWars.p2.getFieldCard()[target]);
                        field2Health2.setText(String.valueOf(AetherWars.p2.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p1.getFieldCard()[source - 1].getName() + " attack "
                                + AetherWars.p2.getFieldCard()[target].getName();
                        if (AetherWars.p2.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field2Image2.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field2Attack2.setText("?");
                            field2Health2.setText("?");
                            field2Level2.setText("0/0 [0]");
                            AetherWars.p2.getFieldCardStatus()[target] = false;
                            AetherWars.p2.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card3(MouseEvent event) {
        if (chosenField == 8) {
            field2Card3.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p2.getFieldCardStatus()[2]) {
                    chosenField = 8;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card3.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (!AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p2.getFieldCardStatus()[2]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p2.getMana() + " / " + (AetherWars.turn - 1));
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 0 && chosenField < 6 && AetherWars.phase == PhaseType.ATTACK
                && AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 2;
            if (AetherWars.p1.getFieldCardHasAttacked()[source - 1]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p1.getFieldCardStatus()[source - 1]) {
                    if (AetherWars.p2.getFieldCardStatus()[target]) {
                        chosenField = 8;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p1.getFieldCard()[source - 1].attackChara(AetherWars.p2.getFieldCard()[target]);
                        field2Health3.setText(String.valueOf(AetherWars.p2.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p1.getFieldCard()[source - 1].getName() + " attack "
                                + AetherWars.p2.getFieldCard()[target].getName();
                        if (AetherWars.p2.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field2Image3.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field2Attack3.setText("?");
                            field2Health3.setText("?");
                            field2Level3.setText("0/0 [0]");
                            AetherWars.p2.getFieldCardStatus()[target] = false;
                            AetherWars.p2.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card4(MouseEvent event) {
        if (chosenField == 9) {
            field2Card4.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p2.getFieldCardStatus()[3]) {
                    chosenField = 9;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card4.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (!AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p2.getFieldCardStatus()[3]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p2.getMana() + " / " + (AetherWars.turn - 1));
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 0 && chosenField < 6 && AetherWars.phase == PhaseType.ATTACK
                && AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 3;
            if (AetherWars.p1.getFieldCardHasAttacked()[source - 1]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p1.getFieldCardStatus()[source - 1]) {
                    if (AetherWars.p2.getFieldCardStatus()[target]) {
                        chosenField = 9;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p1.getFieldCard()[source - 1].attackChara(AetherWars.p2.getFieldCard()[target]);
                        field2Health4.setText(String.valueOf(AetherWars.p2.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p1.getFieldCard()[source - 1].getName() + " attack "
                                + AetherWars.p2.getFieldCard()[target].getName();
                        if (AetherWars.p2.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field2Image4.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field2Attack4.setText("?");
                            field2Health4.setText("?");
                            field2Level4.setText("0/0 [0]");
                            AetherWars.p2.getFieldCardStatus()[target] = false;
                            AetherWars.p2.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickField2Card5(MouseEvent event) {
        if (chosenField == 10) {
            field2Card5.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
            chosenField = 0;
            movefieldtest.setText(String.valueOf(0));
            utilityWarningText.setText("");
        } else if (chosenField == 0) {
            if (chosenHand == 0) {
                // ATTACK OR REMOVE CARD OR ADD EXP
                if (AetherWars.p2.getFieldCardStatus()[4]) {
                    chosenField = 10;
                    movefieldtest.setText(String.valueOf(chosenField));
                    field2Card5.setStyle("-fx-stroke: blue; -fx-stroke-width: 2;");
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            } else {
                // MOVE FROM HAND TO FIELD , APPLY SPELL
                if (!AetherWars.playerTurn && AetherWars.p2.getHand()[chosenHand - 1].getType() == CardType.CHARACTER
                        && AetherWars.phase == PhaseType.PLAN) {
                    if (AetherWars.p2.getFieldCardStatus()[4]) {
                        utilityWarningText.setText("Field Not Empty!");
                    } else if (AetherWars.p2.getMana() < AetherWars.p2.getHand()[chosenHand - 1].getMana()) {
                        utilityWarningText.setText("Not Enough Mana!");
                    } else {
                        List<Label> hand = new ArrayList<Label>(Arrays.asList(hand1, hand2, hand3, hand4, hand5));
                        List<Label> mana = new ArrayList<Label>(Arrays.asList(mana1, mana2, mana3, mana4, mana5));
                        List<ImageView> cardImage = new ArrayList<ImageView>(
                                Arrays.asList(cardImage1, cardImage2, cardImage3, cardImage4, cardImage5));
                        List<Rectangle> cards = new ArrayList<Rectangle>(
                                Arrays.asList(card1, card2, card3, card4, card5));
                        hand.get(chosenHand - 1).setText("");
                        mana.get(chosenHand - 1).setText("");
                        cardImage.get(chosenHand - 1)
                                .setImage(new Image("./com/aetherwars/card/image/character/base.png"));

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
                        manaSize.setText(AetherWars.p2.getMana() + " / " + (AetherWars.turn - 1));
                    }
                } else {
                    utilityWarningText.setText("Can't spawn to Opponent's Field!");
                }
            }
        } else if (chosenField > 0 && chosenField < 6 && AetherWars.phase == PhaseType.ATTACK
                && AetherWars.playerTurn) {

            // Attack
            int source = chosenField;
            int target = 4;
            if (AetherWars.p1.getFieldCardHasAttacked()[source - 1]) {
                utilityWarningText.setText("Character already attacked!");
            } else {
                if (AetherWars.p1.getFieldCardStatus()[source - 1]) {
                    if (AetherWars.p2.getFieldCardStatus()[target]) {
                        chosenField = 10;
                        movefieldtest.setText(String.valueOf(chosenField));
                        AetherWars.p1.getFieldCard()[source - 1].attackChara(AetherWars.p2.getFieldCard()[target]);
                        field2Health5.setText(String.valueOf(AetherWars.p2.getFieldCard()[target].getHealth()));
                        String text = AetherWars.p1.getFieldCard()[source - 1].getName() + " attack "
                                + AetherWars.p2.getFieldCard()[target].getName();
                        if (AetherWars.p2.getFieldCard()[target].getHealth() <= 0) {
                            text += " and died";
                            field2Image5.setImage(new Image("./com/aetherwars/card/image/character/base.png"));
                            field2Attack5.setText("?");
                            field2Health5.setText("?");
                            field2Level5.setText("0/0 [0]");
                            AetherWars.p2.getFieldCardStatus()[target] = false;
                            AetherWars.p2.getFieldCard()[target] = null;
                            updateLevelAfterAttack(source);

                        }
                        chosenField = 0;
                        updateFieldColorAfterAttack(source);
                        utilityWarningText.setText(text);
                    } else {
                        utilityWarningText.setText("Empty Field!");
                    }
                } else {
                    utilityWarningText.setText("Empty Field!");
                }
            }
        }
    }

    @FXML
    void clickPlayer1Image(MouseEvent event) {
        if (!AetherWars.playerTurn && AetherWars.phase == PhaseType.ATTACK) {
            if (AetherWars.p1.getFieldCardValue() == 0) {
                if (chosenPlayer == 1) {
                    player1image.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                    chosenPlayer = 0;
                    utilityWarningText.setText("");
                } else if (chosenPlayer == 0) {
                    // ATTACK LAWAN TAPI BELUM PENCET KARAKTER
                    if (chosenField == 0) {
                        utilityWarningText.setText("Pick your character first!");
                        // ATTACK LAWAN DAN SUDAH PILIH KARAKTER
                    } else if (chosenField > 5 && chosenField <= 10) {
                        // KASUS BELUM PERNAH ATTACK
                        if (!AetherWars.p2.getFieldCardHasAttacked()[chosenField - 6]) {
                            // SET ATTACK STATUS
                            String charName = AetherWars.p2.getFieldCard()[chosenField - 6].getName();
                            String player = AetherWars.p1.getName();
                            String attackStatus = String.format("%s vs %s", charName, player);
                            utilityWarningText.setText(attackStatus);
                            // KURANGIN HP LAWAN
                            AetherWars.p2.getFieldCard()[chosenField - 6].attackPlayer(AetherWars.p1);
                            reducePlayer1HP(AetherWars.p2.getFieldCard()[chosenField - 6].getAttack());
                            // SET KARAKTER UDAH ATTACK
                            AetherWars.p2.getFieldCardHasAttacked()[chosenField - 6] = true;
                            updateFieldColorAfterAttack(chosenField);
                            chosenField = 0;
                        }
                        // KASUS UDAH PERNAH ATTACK
                        else {
                            utilityWarningText.setText("Pick another character!");
                        }
                    }
                }
            } else {
                utilityWarningText.setText("Please attack a character first!");
            }
        }
    }

    @FXML
    void clickPlayer2Image(MouseEvent event) {
        if (AetherWars.playerTurn && AetherWars.phase == PhaseType.ATTACK) {
            if (AetherWars.p2.getFieldCardValue() == 0) {
                if (chosenPlayer == 2) {
                    player1image.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                    chosenPlayer = 0;
                    utilityWarningText.setText("");
                } else if (chosenPlayer == 0) {
                    // ATTACK LAWAN TAPI BELUM PENCET KARAKTER
                    if (chosenField == 0) {
                        utilityWarningText.setText("Pick your character first!");
                        // ATTACK LAWAN DAN SUDAH PILIH KARAKTER
                    } else if (chosenField > 0 && chosenField <= 5) {
                        // KASUS BELUM PERNAH ATTACK
                        if (!AetherWars.p1.getFieldCardHasAttacked()[chosenField - 1]) {
                            // SET ATTACK STATUS
                            String charName = AetherWars.p1.getFieldCard()[chosenField - 1].getName();
                            String player = AetherWars.p2.getName();
                            String attackStatus = String.format("%s vs %s", charName, player);
                            utilityWarningText.setText(attackStatus);
                            // KURANGIN HP LAWAN
                            AetherWars.p1.getFieldCard()[chosenField - 1].attackPlayer(AetherWars.p1);
                            reducePlayer2HP(AetherWars.p1.getFieldCard()[chosenField - 1].getAttack());
                            // SET KARAKTER UDAH ATTACK
                            AetherWars.p1.getFieldCardHasAttacked()[chosenField - 1] = true;
                            updateFieldColorAfterAttack(chosenField);
                            chosenField = 0;
                        }
                        // KASUS UDAH PERNAH ATTACK
                        else {
                            utilityWarningText.setText("Pick another character!");
                        }
                    }
                }
            } else {
                utilityWarningText.setText("Please attack a character first!");
            }
        }
    }

    @FXML
    void clickReduceHP(MouseEvent event) {
        double width = HPPlayer1.getWidth();
        System.out.println("width: " + width);
        if (width > 0) {
            double hpLama = (width / 302) * 80;
            System.out.println("hpLama: " + hpLama);
            double hpBaru = (hpLama - 5);
            System.out.println("hpBaru: " + hpBaru);
            double newWidth = (hpBaru / 80) * 302;
            System.out.println("newWidth: " + newWidth);
            String hp = String.format("Sebelum = %f, Setelah = %f", width, newWidth);
            utilityWarningText.setText(hp);
            HPPlayer1.setWidth(newWidth);
        }
    }

    void reducePlayer1HP(int attack) {
        double width = HPPlayer1.getWidth();
        if (width > 0) {
            double newWidth = ((width / 302) * 80 - attack) / 80 * 302;
            HPPlayer1.setWidth(newWidth);
        }
    }

    void reducePlayer2HP(int attack) {
        double width = HPPlayer2.getWidth();
        if (width > 0) {
            double newWidth = ((width / 302) * 80 - attack) / 80 * 302;
            HPPlayer2.setWidth(newWidth);
        }
    }

}
