package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.aetherwars.model.Type;
import com.aetherwars.model.Character;
import com.aetherwars.util.CSVReader;

public class AetherWars extends Application {
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SPELL_MORPH_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SPELL_PTN_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SPELL_CSV_FILE_PATH = "card/data/character.csv";
  public AetherWars() {
    super();
  }
  public void loadData(String path) throws IOException, URISyntaxException {
    File characterCSVFile = new File(getClass().getResource(path).toURI());
    CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
    characterReader.setSkipHeader(true);
    List<String[]> characterRows = characterReader.read();
    return characterRows;
    // for (String[] row : characterRows) {
    //   Character c = new Character(row[1], row[3], Type.valueOf(row[2]));
    //   System.out.println(c);
    // }
  }

  @Override
  public void start(Stage stage) {
    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    Group root = new Group();
    root.getChildren().add(text);

    Scene scene = new Scene(root, 1280, 720);

    stage.setTitle("Minecraft: Aether Wars");
    stage.setScene(scene);
    stage.show();

    try {
      this.loadCards();
      text.setText("Minecraft: Aether Wars!");
    } catch (Exception e) {
      text.setText("Failed to load cards: " + e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
