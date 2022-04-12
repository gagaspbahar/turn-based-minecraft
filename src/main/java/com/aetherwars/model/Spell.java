package com.aetherwars.model;

import com.aetherwars.model.type.*;

public abstract class Spell extends Card {
  abstract SpellType getSpellType();
  abstract void cast(Character c);
}

abstract class TempSpell extends Spell {
  protected int duration;

  abstract int getDuration();
  abstract void setDuration(int d);
}


class PotionSpell extends TempSpell {
  private final SpellType spellType = SpellType.POTION;
  private int healthChange;
  
  private int attackChange;
  public PotionSpell(){
    this.duration = 0;
    this.attackChange = 0;
    this.healthChange = 0;
  }

  @Override
  public SpellType getSpellType(){
    return this.spellType;
  }
  
  @Override
  public void cast(Character c){

  }

  @Override
  public int getDuration(){
    return this.duration;
  }

  @Override
  public void setDuration(int d){
    this.duration = d;
  }

  public int getAttackChange(){
    return this.attackChange;
  }

  public int getHealthChange(){
    return this.healthChange;
  }
  //Pastiin mekanisme swap dan potion terlebih dahulu

}

class LevelSpell extends Spell {
  private final SpellType spellType = SpellType.LEVEL;
  private int levelChange;
  
  public LevelSpell(){
    this.levelChange = 0;
  }

  public SpellType getSpellType(){
    return this.spellType;
  }

  @Override
  public void cast(Character c){
    
  }

}

class SwapSpell extends TempSpell {
  private final SpellType spellType = SpellType.SWAP;

  public SwapSpell(){
    this.duration = 0;
  }

  public SpellType getSpellType(){
    return this.spellType;
  }

  @Override
  public void cast(Character c){
    
  }

  @Override
  public int getDuration(){
    return this.duration;
  }

  @Override
  public void setDuration(int d){
    this.duration = d;
  }

  //Pastiin mekanisme swap dan potion terlebih dahulu
}

class MorphSpell extends Spell {
  private final SpellType spellType = SpellType.MORPH;
  private int targetid;
  
  public MorphSpell(){
    this.targetid = 0;
  }

  @Override
  public void cast(Character c){
    
  }

  public SpellType getSpellType(){
    return this.spellType;
  }
}
