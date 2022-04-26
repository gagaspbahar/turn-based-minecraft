package com.aetherwars.util.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.AetherWars;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.SpellType;

public class HealSpellConfig {
  
  private List<String[]> healSpells;
  private String path;

  public HealSpellConfig(String path){
    this.healSpells = new ArrayList<String[]>();
    this.path = path;
  }

  public void loadData() throws URISyntaxException, IOException {
    File healSpellCSVFile = new File(AetherWars.class.getClassLoader().getResource(this.path).toURI());
    CSVReader healSpellReader = new CSVReader(healSpellCSVFile, "\t");
    healSpellReader.setSkipHeader(true);
    this.healSpells = healSpellReader.read();
    for(String[] healSpell : this.healSpells){
        healSpell[0] = healSpell[0].substring(1);
        healSpell[5] = healSpell[5].substring(0, healSpell[5].length() - 1);  
      }
    for(String[] healSpell : this.healSpells){
        System.out.println(healSpell[0]+ healSpell[1]+ healSpell[2]+ healSpell[3]+ healSpell[4]+ healSpell[5]);
      }
  }

  public String getNameFromID(int id){
    for(String[] healSpell : this.healSpells){
      if(Integer.parseInt(healSpell[0]) == id){
        return healSpell[1];
      }
    }
    return null;
  }

  public CardType getCardTypeFromID(int id){
    return CardType.SPELL;
  }

  
  public String getDescriptionFromID(int id){
    for(String[] healSpell : this.healSpells){
      if(Integer.parseInt(healSpell[0]) == id){
        return healSpell[2];
      }
    }
    return null;
  }

  public String getImagePathFromID(int id){
    for(String[] healSpell : this.healSpells){
      if(Integer.parseInt(healSpell[0]) == id){
        return healSpell[3];
      }
    }
    return null;
  }

  public int getManaFromID(int id){
    for(String[] healSpell : this.healSpells){
      if(Integer.parseInt(healSpell[0]) == id){
        return Integer.parseInt(healSpell[5]);
      }
    }
    return 0;
  }

  public SpellType getSpellType(){
    return SpellType.HEAL;
  }

  public int getHPFromID(int id){
    for(String[] healSpell : this.healSpells){
      if(Integer.parseInt(healSpell[0]) == id){
        return Integer.parseInt(healSpell[4]);
      }
    }
    return 0;
  }
}
