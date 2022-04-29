package com.aetherwars.model;

import com.aetherwars.model.type.*;
import com.aetherwars.util.*;
import java.util.ArrayList;

public abstract class Spell extends Card {
  public Spell(){
    super();
  }
  public Spell(Card card){
    super(card.getID(), card.getName(), card.getDescription(), card.getImagePath(), card.getType(), card.getMana());
  }
  public abstract SpellType getSpellType();
  public abstract void cast(Character c, Player p);
}

// abstract class TempSpell extends Spell {
//   protected int duration;

//   public TempSpell(){
//     super();
//   }

//   public TempSpell(Card card){
//     super(card);
//   }

//   abstract int getDuration();
//   abstract void setDuration(int d);
// }


class PotionSpell extends Spell {
  private final SpellType spellType = SpellType.POTION;
  private int duration;
  private int healthChange;
  private int attackChange;

  public PotionSpell(){
    super();
    this.duration = 0;
    this.attackChange = 0;
    this.healthChange = 0;
  }

  public PotionSpell(Card card, int attackChange, int healthChange, int duration){
    super(card);
    this.duration = duration;
    this.attackChange = attackChange;
    this.healthChange = healthChange;
  }

  public PotionSpell(int duration, int attackChange, int healthChange){
    this.duration = duration;
    this.attackChange = attackChange;
    this.healthChange = healthChange;
  }

  public SpellType getSpellType(){
    return this.spellType;
  }
  
  @Override
  public void cast(Character c, Player p){
    if(p.getMana() >= this.getMana()){
      c.setHealth(c.getHealth() + this.getHealthChange());
      if(c.getAttack() + this.getAttackChange() < 0){
        c.setAttack(0);
      } else {
        c.setAttack(c.getAttack() + this.getAttackChange());
      }
      c.addSpellsEffect(this);
      p.setMana(p.getMana() - this.getMana());
    }
  }

  public int getDuration(){
    return this.duration;
  }

  public void setDuration(int d){
    this.duration = d;
  }

  public int getAttackChange(){
    return this.attackChange;
  }

  public int getHealthChange(){
    return this.healthChange;
  }

  public void setHealthChange(int healthChange){
    this.healthChange = healthChange;
  }

  @Override
  public String toString() {
    return "ATK +" + this.getAttackChange() + "/HP +" + this.getHealthChange();
  }

  public String getStat(){
    return this.getName() + "\nDURATION: " + this.getDuration() + "\nATK UP: " + this.getAttackChange() +"\nHP UP: " + this.getHealthChange() + "\nTYPE: " + this.getSpellType();
  }

}

class LevelSpell extends Spell {
  private final SpellType spellType = SpellType.LEVEL;
  
  public LevelSpell(){
    super();
  }

  public LevelSpell(Card card){
    super(card);
  }

  public SpellType getSpellType(){
    return this.spellType;
  }

  @Override
  public void cast(Character c, Player  p){
    if(this.getID() == 401){
      if(p.getMana() >= (c.getLevel()+1)/2 && c.getLevel() < 10){
        c.setLevel(c.getLevel() + 1);
        c.setEXP(0);
        p.setMana(p.getMana() - (c.getLevel()+1)/2);
        c.updateStats(c.getLevel()-1, c.getLevel());
      }
    } else if(this.getID() == 402 && c.getLevel() > 1){
      if(p.getMana() >= (c.getLevel()+1)/2){
        c.setLevel(c.getLevel() - 1);
        c.setEXP(0);
        p.setMana(p.getMana() - (c.getLevel()+1)/2);
        c.updateStats(c.getLevel()+1, c.getLevel());
      }
    }
  }

  @Override
  public String toString() {
    return this.getName();
  }
  public String getStat(){
    return this.getName() +"\nTYPE: " + this.getSpellType();
  }
}

class SwapSpell extends Spell {
  private final SpellType spellType = SpellType.SWAP;
  private int duration;

  public SwapSpell(){
    super();
  }

  public SwapSpell(Card card, int duration){
    super(card);
    this.duration = duration;
  }

  public SwapSpell(int duration) { this.duration = duration; }

  public SpellType getSpellType(){
    return this.spellType;
  }

  @Override
  public void cast(Character c, Player p){
    if(p.getMana() >= this.getMana()){
      if(c.getSwapDura() == -1){
        int newHealth = c.getAttack();
        int newAttack = c.getHealth();
        c.setHealth(newHealth);
        c.setAttack(newAttack);
        c.setSwapDura(this.getDuration());
      }
      else{
        c.setSwapDura(c.getSwapDura() + this.getDuration());
      }
      p.setMana(p.getMana() - this.getMana());
    }
  }

  public int getDuration(){
    return this.duration;
  }

  public void setDuration(int d){
    this.duration = d;
  }

  //Pastiin mekanisme swap dan potion terlebih dahulu
  @Override
  public String toString() {
    return "ATK <-> HP";
  }
  public String getStat(){
    return this.getName() + "\nDURATION: " + this.getDuration() + "\nTYPE: " + this.getSpellType();
  }
}

class MorphSpell extends Spell {
  private final SpellType spellType = SpellType.MORPH;
  private int targetid;
  private Config config;
  
  public MorphSpell(){
    super();
    this.targetid = 0;
    this.config = new Config();
  }

  public MorphSpell(Card card, int targetid){
    super(card);
    this.targetid = targetid;
    this.config = new Config();
  }

  public MorphSpell(int targetid) {this.targetid = targetid; }

  @Override
  public void cast(Character c, Player p){
    if(p.getMana() >= this.getMana()){
      int id = this.targetid;
      c.setName(config.getNameFromID(id));
      c.setDescription(config.getDescriptionFromID(id));
      c.setImagePath(config.getImagePathFromID(id));
      c.setMana(config.getManaFromID(id));
      c.setType(CardType.CHARACTER);
      c.setCharType(config.characters.getCharTypeFromID(id));
      c.setAttack(config.characters.getAttackFromID(id));
      c.setHealth(config.characters.getHealthFromID(id));
      c.setLevel(1);
      c.setEXP(0);
      c.setSwapDura(-1);
      c.setSpellsEffect(new ArrayList<PotionSpell>());
      c.setAttackUp(config.characters.getAttackUpFromID(id));
      c.setHealthUp(config.characters.getHealthUpFromID(id));
      p.setMana(p.getMana() - this.getMana());
    }
  }

  public SpellType getSpellType(){
    return this.spellType;
  }

  @Override
  public String toString() {
    return "MORPH";
  }

  public String getStat(){
    return this.getName() + "\nTARGET ID: " + this.targetid + "\nTYPE: " + this.getSpellType();
  }
}

class HealSpell extends Spell {
  private final SpellType spellType = SpellType.HEAL;
  private int health;
  
  public HealSpell(){
    super();
  }

  public HealSpell(Card card, int health){
    super(card);
    this.health = health;
  }

  public HealSpell(int health) {this.health = health; }

  public int getHealth(){
    return this.health;
  }

  @Override
  public void cast(Character c, Player p){
    if(p.getMana() >= this.getMana()){
      int temp = c.getHealth();
      c.setHealth(temp + this.getHealth());
      p.setMana(p.getMana() - this.getMana());
    }
  }

  public SpellType getSpellType(){
    return this.spellType;
  }

  @Override
  public String toString() {
    return "HEAL" + " (" + Integer.toString(this.getHealth()) + ")";
  }

  public String getStat(){
    return this.getName() + "\nHEALTH: " + this.getHealth() +"\nTYPE: " + this.getSpellType();
  }
}
