import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aetherwars.model.Card;
import com.aetherwars.model.Character;
import com.aetherwars.model.Player;
import com.aetherwars.model.type.CardType;
import com.aetherwars.model.type.CharType;

public class CharacterTest {
    private Character emptyChar = new Character();
    private Character definedChar = new Character(new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10), CharType.END , 12, 50, 2, 3);

    @Test
    void emptyCharTypeTest(){
        assertEquals(emptyChar.getType(), CardType.CHARACTER);
    }

    @Test
    void definedCharTypeTest(){
        assertEquals(definedChar.getCharType(), CharType.END);
    }

    @Test
    void emptyCharHealthTest(){
        assertEquals(emptyChar.getHealth(), 0);
    }

    @Test
    void attackCharacterTest(){
        Character c1 = new Character(new Card(), CharType.END , 1, 5, 2, 3);
        Character c2 = new Character(new Card(), CharType.END , 1, 7, 2, 3);
        c1.attackChara(c2);
        assertEquals(c2.getHealth(), 6);
    }

    @Test
    void attackPlayerTest(){
        Player p1 = new Player();
        Character c1 = new Character(new Card(), CharType.END , 1, 5, 2, 3);
        c1.attackPlayer(p1);
        assertEquals(p1.getHealth(), 79);
    }

    @Test 
    void levelUpCharacterTest(){
        Character c1 = new Character(new Card(), CharType.END , 1, 5, 2, 3);
        c1.addExp(1);
        assertEquals(c1.getLevel(), 2);
    } 

    @Test
    void definedCharToStringTest(){
        assertEquals(definedChar.toString(), "ATK 12/HP 50");
    }

    @Test
    void definedCharGetStatTest(){
        assertEquals(definedChar.getStat(), "Epi\nATK: 12\nHP: 50\nLEVEL: 1\nEXP: 0/1\nTYPE: END");
    }

}
