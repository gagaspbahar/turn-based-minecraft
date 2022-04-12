package com.aetherwars.model;

public class Character extends Card {
  private TypeChar charType;
  private int attack;
  private int health;
  private int attackup;
  private int healthup;
  private int level;
  private int exp;
  private List<Spell> spellsEffect;

  public Character() {
    this.charType = TypeChar.OVERWORLD;
    this.attack = 0;
    this.health = 0;
    this.attackup = 0;
    this.healthup = 0;
    this.level = 1;
    this.exp = 0;
    this.spellsEffect = new ArrayList<Spell>();
  }

  public Character(TypeChar type, int attack, int health, int attackup, int healthup) {
    this.charType = type;
    this.attack = attack;
    this.health = health;
    this.attackup = attackup;
    this.healthup = healthup;
    this.level = 1;
    this.exp = 0;
    this.spellsEffect = new ArrayList<Spell>();
  }

  // GETTER
  public int getHealth(){
    return this.health;
  }

  public int getAttack(){
    return this.attack;
  }

  public String getCharType(){
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

  public List<Spell> getSpellsEffect(){
    return this.spellsEffect;
  }

  // SETTER
  public void setHealth(int health){
    this.health = health;
  }
  
  public void setAttack(int attack){
    this.attack = attack;
  }

  public void setType(TypeChar type){
    this.charType = type;
  }

  public void setLevel(int level){
    this.level = level;
  }

  public void setEXP(int exp){
    this.exp = exp;
  }

  public void addSpellsEffect(Spell spell){
    this.spellsEffect.add(spell);
  }
  
  public void attackChara(Character chara2) {
    if(this.getCharType() == TypeChar.OVERWORLD) {
      if(chara2.getCharType() == TypeChar.OVERWORLD) {
        chara2.setHealth(chara2.getHealth() - this.getAttack());
      }
      if(chara2.getCharType() == TypeChar.NETHER) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()/2);
      }
      if(chara2.getCharType() == TypeChar.END) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()*2);
      }
    } 
    else if(this.getCharType() == TypeChar.NETHER) {
      if(chara2.getCharType() == TypeChar.OVERWORLD) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()*2);
      }
      if(chara2.getCharType() == TypeChar.NETHER) {
        chara2.setHealth(chara2.getHealth() - this.getAttack());
      }
      if(chara2.getCharType() == TypeChar.END) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()/2);
      }
    } 
    else {
      if(chara2.getCharType() == TypeChar.END) {
        chara2.setHealth(chara2.getHealth() - this.getAttack());
      }
      if(chara2.getCharType() == TypeChar.OVERWORLD) {
        chara2.setHealth(chara2.getHealth() - this.getAttack()/2);
      }
      if(chara2.getCharType() == TypeChar.NETHER) {
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
    curExp = this.getExp();
    curLevel = this.getLevel();
    while(curExp + exp >= curLevel*2 -1){
      exp -= (curLevel*2 - 1 - curExp);
      curExp = 0;
      curLevel++;
    } 
    updateStats(this.getLevel(), curLevel);
    this.setExp(curExp + exp);
    this.setLevel(curLevel);
  }

  public void updateStats(int prevLevel, int newLevel) {
    newAttack = (newLevel - prevLevel)*this.getAttackup();
    newHealth = (newLevel - prevLevel)*this.getHealthup();
    this.setAttack(this.getAttack() + newAttack);
    this.setHealth(this.getHealth() + newHealth);
  }

  public void updateSpellsEffect(){
    //Pastiin mekanisme swap dan potion terlebih dahulu
    spells = this.getSpellsEffect();
    int i = 0;
    while(i < spells.size()){
      spells[i].setDuration(spells[i].getDuration() - 1);
      if(spells[i].getDuration() == 0){
        if(spells[i].getSpellType() == TypeSpell.POTION){
          this.setHealth(this.getHealth() - spells[i].getHealthChange());
          this.setAttack(this.getAttack() - spells[i].getAttackChange());
        }
        if(spells[i].getSpellType() == TypeSpell.SWAP){
          newHealth = this.getAttack();
          newAttack = this.getHealth();
          this.setHealth(newHealth);
          this.setAttack(newAttack);
        }
        spells.remove(i);
      }
      else{
        i++;
      }
    }
  }
  
  @Override
  public String toString() {
    return "Name: " + this.name + "\nDescription: " + this.description + "\nType: " + this.type;
  }
}
