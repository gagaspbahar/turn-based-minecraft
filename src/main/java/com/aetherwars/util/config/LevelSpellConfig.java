package com.aetherwars.util.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.AetherWars;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.SpellType;

public class LevelSpellConfig implements BaseConfig {

  private List<String[]> levelSpells;
  private String path;

  public LevelSpellConfig(String path){
    this.levelSpells = new ArrayList<String[]>();
    this.path = path;
  }

  public void loadData() throws URISyntaxException, IOException {
    File levelSpellCSVFile = new File(AetherWars.class.getClassLoader().getResource(this.path).toURI());
    CSVReader levelSpellReader = new CSVReader(levelSpellCSVFile, "\t");
    levelSpellReader.setSkipHeader(true);
    this.levelSpells = levelSpellReader.read();
  }

  public String getNameFromID(int id){
    for(String[] levelSpell : this.levelSpells){
      if(Integer.parseInt(levelSpell[0]) == id){
        return levelSpell[1];
      }
    }
    return null;
  }

  public CardType getCardTypeFromID(int id){
    return CardType.SPELL;
  }

  public String getDescriptionFromID(int id){
    for(String[] levelSpell : this.levelSpells){
      if(Integer.parseInt(levelSpell[0]) == id){
        return levelSpell[2];
      }
    }
    return null;
  }

  public String getImagePathFromID(int id){
    for(String[] levelSpell : this.levelSpells){
      if(Integer.parseInt(levelSpell[0]) == id){
        return levelSpell[3];
      }
    }
    return null;
  }

  public SpellType getSpellType(){
    return SpellType.LEVEL;
  }
}
