package com.aetherwars.util.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.SpellType;

public class SwapSpellConfig {
  
  private List<String[]> swapSpells;
  private String path;

  public SwapSpellConfig(String path){
    this.swapSpells = new ArrayList<String[]>();
    this.path = path;
  }

  public void loadData() throws URISyntaxException, IOException {
    File swapSpellCSVFile = new File(getClass().getResource(this.path).toURI());
    CSVReader swapSpellReader = new CSVReader(swapSpellCSVFile, "\t");
    swapSpellReader.setSkipHeader(true);
    this.swapSpells = swapSpellReader.read();
  }

  public String getNameFromID(int id){
    for(String[] swapSpell : this.swapSpells){
      if(Integer.parseInt(swapSpell[0]) == id){
        return swapSpell[1];
      }
    }
    return null;
  }

  public CardType getCardTypeFromID(int id){
    return CardType.SPELL;
  }

  
  public String getDescriptionFromID(int id){
    for(String[] swapSpell : this.swapSpells){
      if(Integer.parseInt(swapSpell[0]) == id){
        return swapSpell[2];
      }
    }
    return null;
  }

  public String getImagePathFromID(int id){
    for(String[] swapSpell : this.swapSpells){
      if(Integer.parseInt(swapSpell[0]) == id){
        return swapSpell[3];
      }
    }
    return null;
  }

  public int getManaFromID(int id){
    for(String[] swapSpell : this.swapSpells){
      if(Integer.parseInt(swapSpell[0]) == id){
        return Integer.parseInt(swapSpell[5]);
      }
    }
    return 0;
  }

  public int getDurationFromID(int id){
    for(String[] swapSpell : this.swapSpells){
      if(Integer.parseInt(swapSpell[0]) == id){
        return Integer.parseInt(swapSpell[4]);
      }
    }
    return 0;
  }

  public SpellType getSpellType(){
    return SpellType.SWAP;
  }
}
