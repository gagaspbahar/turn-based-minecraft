package com.aetherwars.model;

import com.aetherwars.model.type.*;
import java.util.ArrayList;

public class Character extends Card {
  private CharType charType;
  private int attack;
  private int health;
  private int attackup;
  private int healthup;
  private int level;
  private int exp;
  private int swapDura;
  private ArrayList<PotionSpell> spellsEffect;

  public Character() {
    this.charType = CharType.OVERWORLD;
    this.attack = 0;
    this.health = 0;
    this.attackup = 0;
    this.healthup = 0;
    this.level = 1;
    this.exp = 0;
    this.swapDura = -1;
    this.spellsEffect = new ArrayList<PotionSpell>();
  }

  public Character(Card card, CharType type, int attack, int health, int attackup, int healthup) {
    super(card.getID(), card.getName(), card.getDescription(), card.getImagePath(), card.getType(), card.getMana());
    this.charType = type;
    this.attack = attack;
    this.health = health;
    this.attackup = attackup;
    this.healthup = healthup;
    this.level = 1;
    this.exp = 0;
    this.swapDura = -1;
    this.spellsEffect = new ArrayList<PotionSpell>();
  }

  // GETTER
  public int getHealth(){
    return this.health;
  }

  public int getAttack(){
    return this.attack;
  }

  public CharType getCharType(){
    return this.charType;
  }

  public int getHealthUp(){
    return this.healthup;
  }
  
  public int getAttackUp(){
    return this.attackup;
  }

  public int getLevel(){
    return this.level;
  }

  public int getEXP(){
    return this.exp;
  }

  public int getSwapDura() { return this.swapDura; }

  public ArrayList<PotionSpell> getSpellsEffect(){
    return this.spellsEffect;
  }

  // SETTER
  public void setHealth(int health){
    this.health = health;
  }
  
  public void setAttack(int attack){
    this.attack = attack;
  }

  public void setType(CharType type){
    this.charType = type;
  }

  public void setLevel(int level){
    this.level = level;
  }

  public void setEXP(int exp){
    this.exp = exp;
  }

  public void setSwapDura(int dura) { this.swapDura = dura; }

  public void setAttackUp(int attackup) { this.attackup = attackup; }

  public void setHealthUp(int healthup) { this.healthup = healthup; }

  public void setCharType(CharType type){ this.charType = type; }

  public void setSpellsEffect(ArrayList<PotionSpell> spellsEffect) { this.spellsEffect = spellsEffect; }

  public void addSpellsEffect(PotionSpell spell){
    this.spellsEffect.add(spell);
  }
  
  public void attackChara(Character chara2) {
    if(this.getCharType() == CharType.OVERWORLD) {
      if(chara2.getCharType() == CharType.OVERWORLD) {
        chara2.setHealth(chara2.getHealth() - this.getAttack());
      }
      if(chara2.getCharType() == CharType.NETHER) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()/2);
      }
      if(chara2.getCharType() == CharType.END) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()*2);
      }
    } 
    else if(this.getCharType() == CharType.NETHER) {
      if(chara2.getCharType() == CharType.OVERWORLD) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()*2);
      }
      if(chara2.getCharType() == CharType.NETHER) {
        chara2.setHealth(chara2.getHealth() - this.getAttack());
      }
      if(chara2.getCharType() == CharType.END) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()/2);
      }
    } 
    else {
      if(chara2.getCharType() == CharType.END) {
        chara2.setHealth(chara2.getHealth() - this.getAttack());
      }
      if(chara2.getCharType() == CharType.OVERWORLD) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()/2);
      }
      if(chara2.getCharType() == CharType.NETHER) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()*2);
      }
    }

    if(chara2.getHealth() < 0){
      chara2.setHealth(0);
      this.addExp(chara2.getLevel());
    }
  }
  
  public void attackPlayer(Player player) {
    player.setHealth(player.getHealth() - this.getAttack());
  }

  public void addExp(int exp) {
    int curExp = this.getEXP();
    int curLevel = this.getLevel();
    while (curExp + exp >= curLevel*2 -1) {
      exp -= (curLevel*2 - 1 - curExp);
      curExp = 0;
      curLevel++;
    } 
    updateStats(this.getLevel(), curLevel);
    this.setEXP(curExp + exp);
    this.setLevel(curLevel);
  }

  public void updateStats(int prevLevel, int newLevel) {
    int newAttack = (newLevel - prevLevel)*this.getAttackUp();
    int newHealth = (newLevel - prevLevel)*this.getHealthUp();
    if(this.getAttack() + newAttack < 0){
      this.setAttack(0);
    }
    else {
      this.setAttack(this.getAttack() + newAttack);
    }

    if(this.getHealth() + newHealth < 0){
      this.setHealth(0);
    }
    else {
      this.setHealth(this.getHealth() + newHealth);
    }
  }

  public void updateSpellsEffect(){
    //Pastiin mekanisme swap dan potion terlebih dahulu
    ArrayList<PotionSpell> spells = this.getSpellsEffect();
    int i = 0;
    int newAttack;
    int newHealth;
    if(this.getSwapDura() > 0){
      this.setSwapDura(getSwapDura() - 1);
      if(this.getSwapDura() == 0){
        newHealth = this.getAttack();
        newAttack = this.getHealth();
        this.setHealth(newHealth);
        this.setAttack(newAttack);
        this.setSwapDura(-1);
      }
    }
    while(i < spells.size()){
      spells.get(i).setDuration(spells.get(i).getDuration() - 1);
      if(spells.get(i).getDuration() == 0) {
        PotionSpell potion = (PotionSpell) spells.get(i);
        this.setHealth(this.getHealth() - potion.getHealthChange());
        this.setAttack(this.getAttack() - potion.getAttackChange());
        spells.remove(i);
      }
      else{
        i++;
      }
    }
  }
  
  @Override
  public String toString() {
    return "ATK " + this.getAttack() + "/HP " + this.getHealth();
  }

  public String getStat(){
    return this.getName() + "\nATK: " + this.getAttack() + "\nHP: " + this.getHealth() +"\nLEVEL: " + this.getLevel() + "\nEXP: " + this.getEXP() +"/" + (this.getLevel()*2 - 1) + "\nTYPE: " + this.getCharType();
  }

  public String getExpLevel(){
    return this.getEXP() + "/" + (this.getLevel()*2 - 1) + " [" + this.getLevel() + "]";
  }
}
