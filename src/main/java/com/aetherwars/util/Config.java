package com.aetherwars.util;
import java.net.*;

import java.io.IOException;
import java.net.URISyntaxException;

import com.aetherwars.AetherWars;
import com.aetherwars.model.type.CardType;
import com.aetherwars.util.config.*;

public class Config implements BaseConfig {
  private static final String CHARACTER_CSV_FILE_PATH = "./com/aetherwars/card/data/character.csv";
  private static final String SPELL_MORPH_CSV_FILE_PATH = "./com/aetherwars/card/data/spell_morph.csv";
  private static final String SPELL_PTN_CSV_FILE_PATH = "./com/aetherwars/card/data/spell_ptn.csv";
  private static final String SPELL_SWAP_FILE_PATH = "./com/aetherwars/card/data/spell_swap.csv";
  private static final String SPELL_LEVEL_FILE_PATH = "./com/aetherwars/card/data/spell_level.csv";

  public CharacterConfig characters;
  public MorphSpellConfig morphSpells;
  public PotionSpellConfig potionSpells;
  public SwapSpellConfig swapSpells;
  public LevelSpellConfig levelSpells;

  public Config() {
    this.characters = new CharacterConfig(CHARACTER_CSV_FILE_PATH);
    this.morphSpells = new MorphSpellConfig(SPELL_MORPH_CSV_FILE_PATH);
    this.levelSpells = new LevelSpellConfig(SPELL_LEVEL_FILE_PATH);
    this.swapSpells = new SwapSpellConfig(SPELL_SWAP_FILE_PATH);
    this.potionSpells = new PotionSpellConfig(SPELL_PTN_CSV_FILE_PATH);
    try {
      this.loadData();
    }
    catch (URISyntaxException e) {
      System.out.println("URL ERROR");
      e.printStackTrace();
    }
    catch (IOException e) {
      System.out.println("IO ERROR");
      e.printStackTrace();
    }
  }
  
  public void loadData() throws IOException, URISyntaxException {
    this.characters.loadData();
    this.morphSpells.loadData();
    this.levelSpells.loadData();
    this.swapSpells.loadData();
    this.potionSpells.loadData();
  }

  public String getNameFromID(int id) {
    String ans = "";

    if (id / 100 == 0) {  // Char
      ans = this.characters.getNameFromID(id);
    }
    else if (id / 100 == 1){ // Potion
      ans = this.potionSpells.getNameFromID(id);
    }
    else if (id / 100 == 2){ // Swap
      ans = this.swapSpells.getNameFromID(id);
    }
    else if (id / 100 == 3){ // Morph
      ans = this.morphSpells.getNameFromID(id);
    }
    else if (id / 100 == 4){ // Level
      ans = this.levelSpells.getNameFromID(id);
    }
    return ans;
  }
  public String getDescriptionFromID(int id) {
    String ans = "";

    if (id / 100 == 0) {  // Char
      ans = this.characters.getDescriptionFromID(id);
    }
    else if (id / 100 == 1){ // Potion
      ans = this.potionSpells.getDescriptionFromID(id);
    }
    else if (id / 100 == 2){ // Swap
      ans = this.swapSpells.getDescriptionFromID(id);
    }
    else if (id / 100 == 3){ // Morph
      ans = this.morphSpells.getDescriptionFromID(id);
    }
    else if (id / 100 == 4){ // Level
      ans = this.levelSpells.getDescriptionFromID(id);
    }
    return ans;
  }

  public String getImagePathFromID(int id) {
    String ans = "";

    if (id / 100 == 0) {  // Char
      ans = this.characters.getImagePathFromID(id);
    }
    else if (id / 100 == 1){ // Potion
      ans = this.potionSpells.getImagePathFromID(id);
    }
    else if (id / 100 == 2){ // Swap
      ans = this.swapSpells.getImagePathFromID(id);
    }
    else if (id / 100 == 3){ // Morph
      ans = this.morphSpells.getImagePathFromID(id);
    }
    else if (id / 100 == 4){ // Level
      ans = this.levelSpells.getImagePathFromID(id);
    }
    return ans;
  }
  public CardType getCardTypeFromID(int id) {
    CardType ans = CardType.CHARACTER;

    if (id / 100 == 0) {  // Char
      ans = this.characters.getCardTypeFromID(id);
    }
    else if (id / 100 == 1){ // Potion
      ans = this.potionSpells.getCardTypeFromID(id);
    }
    else if (id / 100 == 2){ // Swap
      ans = this.swapSpells.getCardTypeFromID(id);
    }
    else if (id / 100 == 3){ // Morph
      ans = this.morphSpells.getCardTypeFromID(id);
    }
    else if (id / 100 == 4){ // Level
      ans = this.levelSpells.getCardTypeFromID(id);
    }
    return ans;
  }
  public int getManaFromID(int id) {
    int ans = 0;

    if (id / 100 == 0) {  // Char
      ans = this.characters.getManaFromID(id);
    }
    else if (id / 100 == 1){ // Potion
      ans = this.potionSpells.getManaFromID(id);
    }
    else if (id / 100 == 2){ // Swap
      ans = this.swapSpells.getManaFromID(id);
    }
    else if (id / 100 == 3){ // Morph
      ans = this.morphSpells.getManaFromID(id);
    }
    else if (id / 100 == 4){ // Level (Cant be cast)
      ans = 0;
    }
    return ans;
  }
}
