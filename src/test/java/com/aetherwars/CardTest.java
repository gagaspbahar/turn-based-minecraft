import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aetherwars.model.type.CardType;

import com.aetherwars.model.Card;

public class CardTest {
    
    @Test
    void constructorIDtest() {
        assertEquals(0, new Card().getID());
    }

    @Test
    void userDefinedConstructorNameTest() {
        assertEquals("Epi", new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10).getName());
    }

    @Test
    void userDefinedConstructorDescriptionTest() {
        assertEquals("cape nubes", new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10).getDescription());
    }

    @Test
    void userDefinedConstructorImagePathTest() {
        assertEquals("imagepath", new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10).getImagePath());
    }

    @Test
    void userDefinedConstructorTypeTest() {
        assertEquals(CardType.CHARACTER, new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10).getType());
    }

    @Test
    void userDefinedConstructorManaTest() {
        assertEquals(10, new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10).getMana());
    }

    @Test
    void userDefinedToStringTest(){
        assertEquals("Name: Epi\nDescription: cape nubes\nType: CHARACTER", new Card(0,"Epi","cape nubes","imagepath",CardType.CHARACTER,10).toString());
    }
}
