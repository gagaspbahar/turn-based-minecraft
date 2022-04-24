package com.aetherwars.model;

import java.util.*;
import com.aetherwars.model.type.*;
import com.aetherwars.util.Config;

import static java.lang.Math.min;

class Player {
    private int health;
    private String name;
    private int mana;
    private Character fieldCard[];
    private Boolean fieldCardStatus[];
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
        this.hand = new Card[]{null, null, null, null, null};
        this.handStatus = new Boolean[]{false, false, false, false, false};
        this.deck = new ArrayList<Card>(50);
    }

    public Player(String name) {
        this.name = name;
        this.health = 80;
        this.mana = 1;
        this.fieldCard = new Character[]{null, null, null, null, null};
        this.fieldCardStatus = new Boolean[]{false, false, false, false, false};
        this.hand = new Card[]{null, null, null, null, null};
        this.handStatus = new Boolean[]{false, false, false, false, false};
        this.deck = new ArrayList<Card>(50);
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
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
        for (int i = 0; i < 30; i++) {
            int j = rand.nextInt(18);
            j = j + 1;
            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
                    this.config.getImagePathFromID(j), CardType.CHARACTER, this.config.getManaFromID(j)));
        }
        for (int i = 0; i < 5; i++) {
            int j = rand.nextInt(18);
            j = j + 101;
            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
        }
        for (int i = 0; i < 5; i++) {
            int j = rand.nextInt(10);
            j = j + 201;
            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
        }
        for (int i = 0; i < 5; i++) {
            int j = rand.nextInt(6);
            j = j + 301;
            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
        }
        for (int i = 0; i < 5; i++) {
            int j = rand.nextInt(2);
            j = j + 401;
            this.deck.add(new Card(j, this.config.getNameFromID(j), this.config.getDescriptionFromID(j),
                    this.config.getImagePathFromID(j), CardType.SPELL, this.config.getManaFromID(j)));
        }
        Collections.shuffle(this.deck);
    }

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
            Character c = new Character(chosen, this.config.characters.getCharTypeFromID(id),
                    this.config.characters.getAttackFromID(id), this.config.characters.getHealthFromID(id),
                    this.config.characters.getAttackUpFromID(id), this.config.characters.getHealthUpFromID(id));
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = c;
                this.handStatus[this.firstEmptyHand()] = true;
            }
        } else if (id >= 101 && id <= 118) {
            PotionSpell p = new PotionSpell(chosen, this.config.potionSpells.getAttackFromID(id),
                    this.config.potionSpells.getHPFromID(id), this.config.potionSpells.getDurationFromID(id));
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = p;
                this.handStatus[this.firstEmptyHand()] = true;
            }

        } else if (id >= 201 && id <= 210) {
            SwapSpell p = new SwapSpell(chosen, this.config.swapSpells.getDurationFromID(id));
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = p;
                this.handStatus[this.firstEmptyHand()] = true;
            }

        } else if (id >= 301 && id <= 306) {
            MorphSpell p = new MorphSpell(chosen, this.config.morphSpells.getTargetFromID(id));
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = p;
                this.handStatus[this.firstEmptyHand()] = true;
            }

        } else if (id >= 401 && id <= 402) {
            LevelSpell p = new LevelSpell(chosen);
            if(this.firstEmptyHand() != -1) {
                this.hand[this.firstEmptyHand()] = p;
                this.handStatus[this.firstEmptyHand()] = true;
            }
        }
    }
}