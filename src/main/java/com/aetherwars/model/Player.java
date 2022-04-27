package com.aetherwars.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import com.aetherwars.model.type.*;
import com.aetherwars.util.Config;

import static java.lang.Math.min;

public class Player {
    private int health;
    private String name;
    private int mana;
    private Character fieldCard[];
    private Boolean fieldCardStatus[];
    private Boolean fieldCardHasAttacked[];
    private Card hand[];
    private Boolean handStatus[];
    private List<Card> deck;
    private Config config;

    public Player() {
        this.name = "Epi";
        this.health = 80;
        this.mana = 1;
        this.fieldCard = new Character[]{null, null, null, null, null};
        this.fieldCardStatus = new Boolean[]{false, false, false, false, false};
        this.fieldCardHasAttacked = new Boolean[]{false, false, false, false, false};
        this.hand = new Card[]{null, null, null, null, null};
        this.handStatus = new Boolean[]{false, false, false, false, false};
        this.deck = new ArrayList<Card>(50);
        this.config = new Config();
//        try {
//            this.config.loadData();
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
    }

    public Player(String name) {
        this.name = name;
        this.health = 80;
        this.mana = 1;
        this.fieldCard = new Character[]{null, null, null, null, null};
        this.fieldCardStatus = new Boolean[]{false, false, false, false, false};
        this.fieldCardHasAttacked = new Boolean[]{false, false, false, false, false};
        this.hand = new Card[]{null, null, null, null, null};
        this.handStatus = new Boolean[]{false, false, false, false, false};
        this.deck = new ArrayList<Card>(50);
        this.config = new Config();
//        try {
//            this.config.loadData();
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMana() { return this.mana; }

    public List<Card> getDeck() {return this.deck; }

    public Card[] getHand() {return this.hand; }

    public Character[] getFieldCard() {return this.fieldCard; }

    public Boolean[] getHandStatus() {return this.handStatus; }

    public Boolean[] getFieldCardStatus() {return this.fieldCardStatus; }

    public Boolean[] getFieldCardHasAttacked() {return this.fieldCardHasAttacked; }

    public void setFieldCardHasAttackedFalse() {
        for (int i = 0; i < 5; i++) {
            this.fieldCardHasAttacked[i] = false;
        }
    }

    public int getFieldCardValue(){
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            if (this.fieldCardStatus[i]) {
                ans++;
            }
        }
        return ans;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setHealth(int i) {
        this.health = i;
    }

    public void setMana(int i) {
        this.mana = i;
    }

    public void resetMana(int giliran) {
        // Di awal permainan (giliran 1), jumlah mana yang dimiliki pemain adalah 1.
        // Mana akan
        // meningkat sebesar 1 setiap gilirannya dan terbatas pada 10.
        if (this.mana <= 10) {
            this.mana = giliran;
        } else {
            this.mana = 10;
        }
    }

    public void useMana(Character c) {
        if (this.getMana() > 0) {
            this.setMana(this.getMana() - 1);
            c.addExp(1);
        }
    }

    public void addCardToField(int i, int j) {
        if (this.fieldCardStatus[i] == false && this.handStatus[j] == true &&
                this.hand[j].getType() == CardType.CHARACTER && this.mana >= this.hand[j].getMana()) {
            this.mana -= this.hand[j].getMana();
            // Ubah card jadi character
            this.fieldCard[i] = (Character) this.hand[j];
            this.fieldCardStatus[i] = true;
            this.handStatus[j] = false;
        }
    }

    public void removeCardFromField(int i) {
        if (this.fieldCardStatus[i] == true) {
            this.fieldCardStatus[i] = false;
            this.fieldCard[i] = null;
        }
    }

    public void removeCardFromHand(int i) {
        if (this.handStatus[i] == true) {
            this.handStatus[i] = false;
            this.hand[i] = null;
        }
    }

    public void updateField() {
        for (int i = 0; i < 5; i++) {
            if (this.fieldCard[i].getHealth() <= 0) {
                this.fieldCard[i] = null;
                this.fieldCardStatus[i] = false;
            }
        }
    }

    public void initializeDeck() {
        // Inisialisasi deck pemain
        Random rand = new Random();
        for (int i = 0; i < 27; i++) {
            int id = rand.nextInt(18);
            id = id + 1;
//            Card card = new Card(1,"aam","aa","asdasd",CardType.CHARACTER,5);
            Card card = new Card(id, this.config.getNameFromID(id), this.config.getDescriptionFromID(id),
                    this.config.getImagePathFromID(id), CardType.CHARACTER, this.config.getManaFromID(id));
            Character c = new Character(card, this.config.characters.getCharTypeFromID(id),
                    this.config.characters.getAttackFromID(id), this.config.characters.getHealthFromID(id),
                    this.config.characters.getAttackUpFromID(id), this.config.characters.getHealthUpFromID(id));
            this.deck.add(c);
        }
        for (int i = 0; i < 5; i++) {
            int id = rand.nextInt(18);
            id = id + 101;
            Card card = new Card(id, this.config.getNameFromID(id), this.config.getDescriptionFromID(id),
                    this.config.getImagePathFromID(id), CardType.SPELL, this.config.getManaFromID(id));
            PotionSpell p = new PotionSpell(card, this.config.potionSpells.getAttackFromID(id),
                    this.config.potionSpells.getHPFromID(id), this.config.potionSpells.getDurationFromID(id));
            this.deck.add(p);
        }
        for (int i = 0; i < 5; i++) {
            int id = rand.nextInt(10);
            id = id + 201;
            Card card = new Card(id, this.config.getNameFromID(id), this.config.getDescriptionFromID(id),
                    this.config.getImagePathFromID(id), CardType.SPELL, this.config.getManaFromID(id));
            SwapSpell p = new SwapSpell(card, this.config.swapSpells.getDurationFromID(id));
            this.deck.add(p);
        }
        for (int i = 0; i < 5; i++) {
            int id = rand.nextInt(6);
            id = id + 301;
            Card card = new Card(id, this.config.getNameFromID(id), this.config.getDescriptionFromID(id),
                    this.config.getImagePathFromID(id), CardType.SPELL, this.config.getManaFromID(id));
            MorphSpell p = new MorphSpell(card, this.config.morphSpells.getTargetFromID(id));
            this.deck.add(p);
        }
        for (int i = 0; i < 5; i++) {
            int id = rand.nextInt(2);
            id = id + 401;
            Card card = new Card(id, this.config.getNameFromID(id), this.config.getDescriptionFromID(id),
                    this.config.getImagePathFromID(id), CardType.SPELL, this.config.getManaFromID(id));
            LevelSpell p = new LevelSpell(card);
            this.deck.add(p);
        }

        for (int i = 0; i < 3; i++) {
            int id = rand.nextInt(3);
            id = id + 501;
            Card card = new Card(id, this.config.getNameFromID(id), this.config.getDescriptionFromID(id),
                    this.config.getImagePathFromID(id), CardType.SPELL, this.config.getManaFromID(id));
            HealSpell p = new HealSpell(card, this.config.healSpells.getHPFromID(id));
            this.deck.add(p);
        }
        Collections.shuffle(this.deck);
    }
//    public void initializeDeck() {
//        // Inisialisasi deck pemain
//        Random rand = new Random();
//        for (int i = 0; i < 30; i++) {
//            int j = rand.nextInt(18);
//            j = j + 1;
//            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
//                    this.config.getImagePathFromID(j), CardType.CHARACTER, this.config.getManaFromID(j)));
//        }
//        for (int i = 0; i < 5; i++) {
//            int j = rand.nextInt(18);
//            j = j + 101;
//            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
//                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
//        }
//        for (int i = 0; i < 5; i++) {
//            int j = rand.nextInt(10);
//            j = j + 201;
//            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
//                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
//        }
//        for (int i = 0; i < 5; i++) {
//            int j = rand.nextInt(6);
//            j = j + 301;
//            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
//                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
//        }
//        for (int i = 0; i < 5; i++) {
//            int j = rand.nextInt(2);
//            j = j + 401;
//            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
//                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
//        }
//        Collections.shuffle(this.deck);
//    }

    public Card[] drawNcard() {
        Card[] cards = new Card[min(3, this.deck.size())];

        for (int i = 0; i < min(3, this.deck.size()); i++) {
            cards[i] = this.deck.get(0);
            this.deck.remove(0);
        }
        return cards;
    }

    // public boolean canDraw() {
    //     for (int i = 0; i < this.handStatus.length; i++) {
    //         if (this.handStatus[i] == false) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public int firstEmptyHand() {
        for (int i = 0; i < this.handStatus.length; i++) {
            if (this.handStatus[i] == false) {
                this.handStatus[i] = true;
                return i;
            }
        }
        return -1;
    }

    public void chooseCard(Card[] cards, int choice) {
        // Pemain memilih kartu yang akan ditambahkan ke field
        Card chosen = cards[choice];
        int id = chosen.getID();
        if (chosen.getType() == CardType.CHARACTER) {
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = (Character) chosen;
                this.handStatus[this.firstEmptyHand()] = true;
            }
        } else if (id >= 101 && id <= 118) {
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = (PotionSpell) chosen;
                this.handStatus[this.firstEmptyHand()] = true;
            }

        } else if (id >= 201 && id <= 210) {
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = (SwapSpell) chosen;
                this.handStatus[this.firstEmptyHand()] = true;
            }

        } else if (id >= 301 && id <= 306) {
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = (MorphSpell) chosen;
                this.handStatus[this.firstEmptyHand()] = true;
            }

        } else if (id >= 401 && id <= 402) {
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = (LevelSpell) chosen;
                this.handStatus[this.firstEmptyHand()] = true;
            }
        }
    }
//    public void chooseCard(Card[] cards, int choice) {
//        // Pemain memilih kartu yang akan ditambahkan ke field
//        Card chosen = cards[choice];
//        int id = chosen.getID();
//        if (chosen.getType() == CardType.CHARACTER) {
//            Character c = new Character(chosen, this.config.characters.getCharTypeFromID(id),
//                    this.config.characters.getAttackFromID(id), this.config.characters.getHealthFromID(id),
//                    this.config.characters.getAttackUpFromID(id), this.config.characters.getHealthUpFromID(id));
//            if(this.firstEmptyHand() != -1) {
//                this.hand[this.firstEmptyHand()] = c;
//                this.handStatus[this.firstEmptyHand()] = true;
//            }
//        } else if (id >= 101 && id <= 118) {
//            PotionSpell p = new PotionSpell(chosen, this.config.potionSpells.getAttackFromID(id),
//                    this.config.potionSpells.getHPFromID(id), this.config.potionSpells.getDurationFromID(id));
//            if(this.firstEmptyHand() != -1) {
//                this.hand[this.firstEmptyHand()] = p;
//                this.handStatus[this.firstEmptyHand()] = true;
//            }
//
//        } else if (id >= 201 && id <= 210) {
//            SwapSpell p = new SwapSpell(chosen, this.config.swapSpells.getDurationFromID(id));
//            if(this.firstEmptyHand() != -1) {
//                this.hand[this.firstEmptyHand()] = p;
//                this.handStatus[this.firstEmptyHand()] = true;
//            }
//
//        } else if (id >= 301 && id <= 306) {
//            MorphSpell p = new MorphSpell(chosen, this.config.morphSpells.getTargetFromID(id));
//            if(this.firstEmptyHand() != -1) {
//                this.hand[this.firstEmptyHand()] = p;
//                this.handStatus[this.firstEmptyHand()] = true;
//            }
//
//        } else if (id >= 401 && id <= 402) {
//            LevelSpell p = new LevelSpell(chosen);
//            if(this.firstEmptyHand() != -1) {
//                this.hand[this.firstEmptyHand()] = p;
//                this.handStatus[this.firstEmptyHand()] = true;
//            }
//        }
//    }
}