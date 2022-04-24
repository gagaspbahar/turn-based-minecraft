package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import com.aetherwars.model.Card;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.aetherwars.model.type.*;
import com.aetherwars.util.config.CSVReader;
import com.aetherwars.model.*;
import com.aetherwars.model.Character;

public class AetherWars extends Application {
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SPELL_MORPH_CSV_FILE_PATH = "card/data/spell_morph.csv";
  private static final String SPELL_PTN_CSV_FILE_PATH = "card/data/spell_ptn.csv";
  private static final String SPELL_SWAP_FILE_PATH = "card/data/spell_swap.csv";
//  private static boolean playerTurn;

  public AetherWars() {
    super();
//    playerTurn = true;
  }

//  public static boolean getPlayerTurn() {
//    return playerTurn;
//  }

  public List<String[]> loadData(String path) throws IOException, URISyntaxException {
    File characterCSVFile = new File(getClass().getResource(path).toURI());
    CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
    characterReader.setSkipHeader(true);
    return characterReader.read();
  }

  @Override
  public void start(Stage stage) throws Exception {

    Pane mainPane = FXMLLoader.load(AetherWars.class.getClassLoader().getResource("./Sample.fxml"));
      stage.setScene(new Scene(mainPane));
      stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
