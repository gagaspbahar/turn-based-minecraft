package com.aetherwars.util.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.AetherWars;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.CharType;

public class CharacterConfig implements BaseConfig, ManaConfig {
  
  private List<String[]> characters;
  private String path;

  public CharacterConfig(String path){
    this.characters = new ArrayList<String[]>();
    this.path = path;
  }

  public void loadData() throws URISyntaxException, IOException {
    File characterCSVFile = new File(AetherWars.class.getClassLoader().getResource(this.path).toURI());
    CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
    characterReader.setSkipHeader(true);
    this.characters = characterReader.read();
  }

  public String getNameFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return character[1];
      }
    }
    return null;
  }

  public CardType getCardTypeFromID(int id){
    return CardType.CHARACTER;
  }

  
  public String getDescriptionFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return character[3];
      }
    }
    return null;
  }

  public String getImagePathFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return character[4];
      }
    }
    return null;
  }

  public int getManaFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return Integer.parseInt(character[7]);
      }
    }
    return 0;
  }

  public CharType getCharTypeFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return CharType.valueOf(character[2]);
      }
    }
    return null;
  }
  
  public int getAttackFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return Integer.parseInt(character[5]);
      }
    }
    return 0;
  }
  
  public int getHealthFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return Integer.parseInt(character[6]);
      }
    }
    return 0;
  }
  
  public int getAttackUpFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return Integer.parseInt(character[8]);
      }
    }
    return 0;
  }
  
  public int getHealthUpFromID(int id){
    for(String[] character : this.characters){
      if(Integer.parseInt(character[0]) == id){
        return Integer.parseInt(character[9]);
      }
    }
    return 0;
  }
}
