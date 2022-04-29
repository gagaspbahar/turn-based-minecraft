import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aetherwars.model.Card;
import com.aetherwars.model.Player;
import com.aetherwars.model.Character;

public class PlayerTest {
    private Player player = new Player();

    @Test
    void getPlayerName() {
        assertEquals("Epi", this.player.getName());
    }

    @Test
    void getPlayerStartingHealth() {
        assertEquals(80, this.player.getHealth());
    }

    @Test
    void getPlayerStartingMana() {
        assertEquals(1, this.player.getMana());
    }

    @Test
    void getPlayerMana() {
        this.player.setMana(5);
        assertEquals(5, this.player.getMana());
    }

    @Test
    void getPlayerHealth() {
        this.player.setHealth(50);
        assertEquals(50, this.player.getHealth());
    }

    @Test
    void getPlayerAddEXPtoCharacter() {
        this.player.setMana(5);
        Character c = new Character();
        this.player.useMana(c);
        assertEquals(4, this.player.getMana());
    }

    @Test
    void getPlayerHandStatus() {
        this.player.getHandStatus()[1] = true;
        assertEquals(true, this.player.getHandStatus()[1]);
    }

    @Test
    void getPlayerHand() {
        assertEquals(null, this.player.getHand()[0]);
    }

    @Test
    void getPlayerFieldCard() {
        assertEquals(null, this.player.getFieldCard()[3]);
    }

    @Test
    void getPlayerFieldCardStatus() {
        this.player.getFieldCardStatus()[4] = true;
        assertEquals(true, this.player.getFieldCardStatus()[4]);
    }

    @Test
    void getPlayerFieldCardHasAttacked() {
        this.player.getFieldCardHasAttacked()[2] = true;
        assertEquals(true, this.player.getFieldCardHasAttacked()[2]);
    }

    @Test
    void getPlayerDeck() {
        this.player.addDeckFromID(1);
        this.player.addDeckFromID(101);
        this.player.addDeckFromID(201);
        assertEquals(3, this.player.getDeck().size());
    }

    @Test
    void getPlayerDeckCardName() {
        this.player.addDeckFromID(1);
        this.player.addDeckFromID(101);
        this.player.addDeckFromID(201);
        assertEquals("Creeper", this.player.getDeck().get(0).getName());
    }

    @Test
    void getPlayerDeckCardDesc() {
        this.player.addDeckFromID(1);
        this.player.addDeckFromID(101);
        this.player.addDeckFromID(201);
        assertEquals("The magic that is deadly", this.player.getDeck().get(1).getDescription());
    }


    @Test
    void EmptyDeckTest() {
        this.player.emptyDeck();
        assertEquals(0, this.player.getDeck().size());
    }

    @Test
    void InitializeDeckTest() {
        this.player.initializeDeck();
        assertEquals(50, this.player.getDeck().size());
    }

    @Test
    void firstEmptyHandTest() {
        this.player.getHandStatus()[0] = true;
        assertEquals(1, this.player.firstEmptyHand());
    }

}