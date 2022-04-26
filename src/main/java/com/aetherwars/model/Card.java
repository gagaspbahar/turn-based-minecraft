package com.aetherwars.model;

import com.aetherwars.model.type.*;

public class Card {
  private int id;
  private String name;
  private String description;
  private String imagepath;
  private CardType type;
  private int mana;

  public Card() {
    this.id = 0;
    this.name = "";
    this.description = "";
    this.imagepath = "";
    this.type = CardType.CHARACTER;
    this.mana = 0;
  }

  public Card(int id, String name, String description, String imagepath, CardType type, int mana) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imagepath = imagepath;
    this.type = type;
    this.mana = mana;
  }

  // GETTER
  public int getID(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getDescription(){
    return this.description;
  }

  public String getDescriptionNewlineFormat(){
    String temp = "";
    String finalString = "";
    for(int i = 0; i < this.description.length(); i++){
      temp += this.description.charAt(i);
      if(temp.length() == 15){
        finalString += temp + "\n";
        temp = "";
      }
    }
    return finalString;
  }

  public String getImagePath(){
    return this.imagepath;
  }

  public CardType getType(){
    return this.type;
  }

  public int getMana(){
    return this.mana;
  }

  // SETTER
  public void setID(int id){
    this.id = id;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public void setImagePath(String imagepath){
    this.imagepath = imagepath;
  }

  public void setType(CardType type){
    this.type = type;
  }

  public void setMana(int mana){
    this.mana = mana;
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\nDescription: " + this.getDescription() + "\nType: " + this.getType();
  }

  public String getStat(){
    return "Nama: " + this.getName();
  }
}
