package com.aetherwars.util;


import java.io.IOException;
import java.net.URISyntaxException;

import com.aetherwars.model.type.CardType;
import com.aetherwars.util.config.*;

public class Config implements BaseConfig {
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String SPELL_MORPH_CSV_FILE_PATH = "card/data/spell_morph.csv";
  private static final String SPELL_PTN_CSV_FILE_PATH = "card/data/spell_ptn.csv";
  private static final String SPELL_SWAP_FILE_PATH = "card/data/spell_swap.csv";
  private static final String SPELL_LEVEL_FILE_PATH = "card/data/spell_level.csv";

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
  }
  
  public void loadData() throws IOException, URISyntaxException {
    this.characters.loadData();
    this.morphSpells.loadData();
    this.swapSpells.loadData();
    this.potionSpells.loadData();
  }

  public String getNameFromID(int id) {
    if (id / 100 == 0) {

    }
    else if (id / 100 == 1){

    }
    else if(id / 100 == 2){

    }
    else if(id / 100 == 3){

    }
    else if(id / 100 == 4){

    }
    else{
    }
    return "";
  }
  public String getDescriptionFromID(int id) {return "";}
  public String getImagePathFromID(int id) {return "";}
  public CardType getCardTypeFromID(int id) {return CardType.CHARACTER;}
  public int getManaFromID(int id) {return 0;}


}
