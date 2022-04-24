package com.aetherwars.util.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.AetherWars;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.SpellType;

public class PotionSpellConfig {
  
  private List<String[]> potionSpells;
  private String path;

  public PotionSpellConfig(String path){
    this.potionSpells = new ArrayList<String[]>();
    this.path = path;
  }

  public void loadData() throws URISyntaxException, IOException {
    File potionSpellCSVFile = new File(AetherWars.class.getClassLoader().getResource(this.path).toURI());
    CSVReader potionSpellReader = new CSVReader(potionSpellCSVFile, "\t");
    potionSpellReader.setSkipHeader(true);
    this.potionSpells = potionSpellReader.read();
  }

  public String getNameFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return potionSpell[1];
      }
    }
    return null;
  }

  public CardType getCardTypeFromID(int id){
    return CardType.SPELL;
  }

  
  public String getDescriptionFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return potionSpell[2];
      }
    }
    return null;
  }

  public String getImagePathFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return potionSpell[3];
      }
    }
    return null;
  }

  public int getManaFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return Integer.parseInt(potionSpell[6]);
      }
    }
    return 0;
  }

  public SpellType getSpellType(){
    return SpellType.POTION;
  }

  public int getAttackFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return Integer.parseInt(potionSpell[4]);
      }
    }
    return 0;
  }

  public int getHPFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return Integer.parseInt(potionSpell[5]);
      }
    }
    return 0;
  }

  public int getDurationFromID(int id){
    for(String[] potionSpell : this.potionSpells){
      if(Integer.parseInt(potionSpell[0]) == id){
        return Integer.parseInt(potionSpell[7]);
      }
    }
    return 0;
  }
}
