package com.aetherwars.util.config;

import com.aetherwars.model.type.CardType;

public interface BaseConfig {
  public String getNameFromID(int id);
  public String getDescriptionFromID(int id);
  public String getImagePathFromID(int id);
  public CardType getCardTypeFromID(int id);
  public int getManaFromID(int id);
}
