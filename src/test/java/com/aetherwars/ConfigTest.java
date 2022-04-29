import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.aetherwars.util.Config;
import com.aetherwars.model.type.CardType;

// import com.aetherwars.card.*;

public class ConfigTest {

    private Config config = new Config();

    @Test
    void getNameFromIDTes1() {
        assertEquals(config.getNameFromID(1), "Creeper");
    }

    @Test
    void getNameFromIDTes2() {
        assertEquals(config.getNameFromID(303), "Sugondese");
    }

    @Test
    void getDescriptionFromIDTes1() {
        assertEquals(config.getDescriptionFromID(13), "A piglin brute is a hostile and stronger variant of piglins that appears in all types of bastion remnants.");
    }

    @Test
    void getDescriptionFromIDTes2() {
        assertEquals(config.getDescriptionFromID(107), "A bottle of a bee secretion");
    }

    @Test
    void getImageFromIDTes1() {
        assertEquals(config.getImagePathFromID(210), "card/image/spell/swap/Bone Marrow.png");
    }

    @Test
    void getImageFromIDTes2() {
        assertEquals(config.getImagePathFromID(113), "card/image/spell/potion/Contract of Living Space.png");
    }

    @Test
    void getManaFromIDTes1() {
        assertEquals(config.getManaFromID(502), 5);
    }

    @Test
    void getManaFromIDTes2() {
        assertEquals(config.getManaFromID(301), 4);
    }

    @Test
    void getTypeFromIDTes1() {
        assertEquals(config.getCardTypeFromID(201), CardType.SPELL);
    }

    @Test
    void getTypeFromIDTes2() {
        assertEquals(config.getCardTypeFromID(10), CardType.CHARACTER);
    }

    @Test
    void getAttackCharactertes() {
        assertEquals(config.characters.getHealthFromID(2), 1);
    }

    @Test
    void getManaCharactertes() {
        assertEquals(config.characters.getAttackFromID(3), 3);
    }

    @Test
    void getHealthCharactertes() {
        assertEquals(config.characters.getAttackFromID(4), 4);
    }

}