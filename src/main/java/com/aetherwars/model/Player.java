package com.aetherwars.model;

import java.util.*;
// import com.aetherwars.AetherWars;

public class Player{
    private int health;
    private String name;
    private int mana;
    private ArrayList<Pair<Card,boolean>> field;
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;

    public Player(){
        this.name = "Epi";
        this.health = 80;
        this.mana = 1;
        this.field = new ArrayList<Card>(5);
        this.hand = new ArrayList<Card>(5);
        this.deck = new ArrayList<Card>(40);
    }
    
    public Player(String name){
        this.name = name;
        this.health = 80;
        this.mana = 1;
        this.field = new ArrayList<Card>(5);
        this.hand = new ArrayList<Card>(5);
        this.deck = new ArrayList<Card>(40);
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public int getMana(){
        return this.mana;
    }

    public void setMana(int giliran){
        // Di awal permainan (giliran 1), jumlah mana yang dimiliki pemain adalah 1. Mana akan
        // meningkat sebesar 1 setiap gilirannya dan terbatas pada 10. 
        if (this.mana <= 10){
            this.mana = giliran;
        } else {
            this.mana = 10;
        }
    }

    public void initializeDeck(){
        
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }   

    public Card drawCard(){
        if (this.deck.size() < 5 && this.deck.size() > 0){
            Card card = this.deck.get(0);
            this.deck.remove(0);
            return card;
        }
    }


}