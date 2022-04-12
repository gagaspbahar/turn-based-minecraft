public interface Spell extends Card {
  private TypeSpell spellType;

  public TypeSpell getSpellType();
  public void setSpellType(TypeSpell t);
  public void useSpell(Character c);

}

public class PotionSpell implements Spell {
  private int duration;
  private int attackChange;
  private int healthChange;

  public PotionSpell(){
    this.spellType = TypeSpell.POTION;
    this.duration = 0;
    this.attackChange = 0;
    this.healthChange = 0;
  }

  public TypeSpell getSpellType(){
    return this.spellType;
  }

  public void setSpellType(TypeSpell t){
    this.spellType = t;
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

}

public class LevelSpell implements Spell {
  private int levelChange;
  
  public LevelSpell(){
    this.spellType = TypeSpell.LEVEL;
    this.levelChange = 0;
  }

  public TypeSpell getSpellType(){
    return this.spellType;
  }

  public void setSpellType(TypeSpell t){
    this.spellType = t;
  }

}

public class SwapSpell implements Spell {
  private int duration;

  public SwapSpell(){
    this.spellType = TypeSpell.SWAP;
    this.duration = 0;
  }

  public TypeSpell getSpellType(){
    return this.spellType;
  }

  public void setSpellType(TypeSpell t){
    this.spellType = t;
  }

  public int getDuration(){
    return this.duration;
  }

  public void setDuration(int d){
    this.duration = d;
  }
}

public class MorphSpell implements Spell {
  private int targetid;

  public MorphSpell(){
    this.spellType = TypeSpell.MORPH;
    this.targetid = 0;
  }
}
