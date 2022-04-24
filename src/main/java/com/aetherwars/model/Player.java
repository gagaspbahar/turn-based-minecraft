package com.aetherwars.model;

import java.util.*;
import com.aetherwars.model.type.*;

import static java.lang.Math.min;

class Player{
    private int health;
    private String name;
    private int mana;
    private List<Card> fieldCard;
    private List<Boolean> fieldCardStatus;
    private List<Card> hand;
    private List<Card> deck;

    public Player(){
        this.name = "Epi";
        this.health = 80;
        this.mana = 1;
        this.fieldCard = new ArrayList<Card>(5);
        this.hand = new ArrayList<Card>(5);
        this.deck = new ArrayList<Card>(40);
    }
    
    public Player(String name){
        this.name = name;
        this.health = 80;
        this.mana = 1;
        this.fieldCard = new ArrayList<Card>(5);
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

    public void setName(String s){
        this.name = s;
    }

    public void setHealth(int i){
        this.health = i;
    }

    public void setMana(int i){
        this.mana = i;
    }
    
    public void resetMana(int giliran){
        // Di awal permainan (giliran 1), jumlah mana yang dimiliki pemain adalah 1. Mana akan
        // meningkat sebesar 1 setiap gilirannya dan terbatas pada 10. 
        if (this.mana <= 10){
            this.mana = giliran;
        } else {
            this.mana = 10;
        }
    }

    public void initializeDeck(List<String[]> chars){
        // Inisialisasi deck pemain
        Random rand = new Random();
        for (int i = 0; i < 50; i++){
            int j = rand.nextInt(18);
            this.deck.add(new Card(CardType.CHARACTER, Integer.parseInt(chars.get(j)[0]), chars.get(j)[1], chars.get(j)[2], chars.get(j)[3]));
        }
        Collections.shuffle(this.deck);
    }

    public Card[] drawNcard(){
        Card[] cards = new Card[min(3,this.deck.size())];

        for (int i = 0; i < min(3,this.deck.size()); i++){
            cards[i] = this.deck.get(0);
            this.deck.remove(0);
        }
        return cards;
    }

    public boolean canDraw(){
        return this.hand.size() < 5;
    }

    public void chooseCard(Card[] cards, int choice){
        // Pemain memilih kartu yang akan ditambahkan ke field
        this.hand.add(cards[choice]);
    }
}