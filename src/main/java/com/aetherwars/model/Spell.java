package com.aetherwars.model;

import com.aetherwars.model.type.*;

public abstract class Spell extends Card {
  public Spell(){
    super();
  }
  public Spell(Card card){
    super(card.getID(), card.getName(), card.getDescription(), card.getImagePath(), card.getType(), card.getMana());
  }
  abstract SpellType getSpellType();
  abstract void cast(Character c, Player p);
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
      c.setAttack(c.getAttack() + this.getAttackChange());
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
    if(p.getMana() >= (c.getLevel()+1)/2){
      c.setLevel(c.getLevel() + 1);
      c.setEXP(0);
      p.setMana(p.getMana() - (c.getLevel()+1)/2);
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
      if(c.getSwapDura() == 0){
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
  
  public MorphSpell(){
    super();
  }

  public MorphSpell(Card card, int targetid){
    super(card);
    this.targetid = targetid;
  }

  public MorphSpell(int targetid) {this.targetid = targetid; }

  @Override
  public void cast(Character c, Player p){
    
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
