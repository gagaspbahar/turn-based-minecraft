package com.aetherwars.util.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.AetherWars;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.SpellType;

public class MorphSpellConfig {
  
  private List<String[]> morphSpells;
  private String path;

  public MorphSpellConfig(String path){
    this.morphSpells = new ArrayList<String[]>();
    this.path = path;
  }

  public void loadData() throws URISyntaxException, IOException {
    File morphSpellCSVFile = new File(AetherWars.class.getClassLoader().getResource(this.path).toURI());
    CSVReader morphSpellReader = new CSVReader(morphSpellCSVFile, "\t");
    morphSpellReader.setSkipHeader(true);
    this.morphSpells = morphSpellReader.read();
  }

  public String getNameFromID(int id){
    for(String[] morphSpell : this.morphSpells){
      if(Integer.parseInt(morphSpell[0]) == id){
        return morphSpell[1];
      }
    }
    return null;
  }

  public CardType getCardTypeFromID(int id){
    return CardType.SPELL;
  }

  
  public String getDescriptionFromID(int id){
    for(String[] morphSpell : this.morphSpells){
      if(Integer.parseInt(morphSpell[0]) == id){
        return morphSpell[2];
      }
    }
    return null;
  }

  public String getImagePathFromID(int id){
    for(String[] morphSpell : this.morphSpells){
      if(Integer.parseInt(morphSpell[0]) == id){
        return morphSpell[3];
      }
    }
    return null;
  }

  public int getManaFromID(int id){
    for(String[] morphSpell : this.morphSpells){
      if(Integer.parseInt(morphSpell[0]) == id){
        return Integer.parseInt(morphSpell[5]);
      }
    }
    return 0;
  }

  public SpellType getSpellType(){
    return SpellType.MORPH;
  }

  public int getTargetFromID(int id){
    for(String[] morphSpell : this.morphSpells){
      if(Integer.parseInt(morphSpell[0]) == id){
        return Integer.parseInt(morphSpell[4]);
      }
    }
    return 0;
  }
}
