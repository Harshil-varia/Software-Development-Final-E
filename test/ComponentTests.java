import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComponentTests {

    @Test
    void componentTest0() {
        assertTrue(true, "Yay I compile!");
    }

    @Test
    void componentTest1() throws Exception {
        Workshop workshop = new Workshop(2, 1);
        int numRounds = 10;
        int expectedToys = 7;
        int expectedMaterials = 7;
        for (int i = 0; i < numRounds; ++i) {
            workshop.nextRound();
        }

        int actualToys = workshop.buildCount();
        int actualMaterials = workshop.materialCount();
        assertEquals(expectedToys, actualToys, "With 2 makers and 1 builder, should have produced 7 toys after 10 rounds.");
        assertEquals(expectedMaterials, actualMaterials, "With 2 makers and 1 builder, should have 7 leftover materials.");
    }

    @Test
    void componentTest2() throws Exception {
        Workshop workshop = new Workshop(3, 4);
        int numRounds = 10;
        int expectedToys = 21;
        int expectedMaterials = 0;
        for (int i = 0; i < numRounds; ++i) {
            workshop.nextRound();
        }

        int actualToys = workshop.buildCount();
        int actualMaterials = workshop.materialCount();
        assertEquals(expectedToys, actualToys, "With 3 makers and 4 builders, should have produced 21 toys after 10 rounds.");
        assertEquals(expectedMaterials, actualMaterials, "With 3 makers and 4 builders, should have 0 leftover materials.");
    }

    @Test
    void componentTest3() throws Exception {
        Workshop workshop = new Workshop(2, 10);
        int numRounds = 12;
        int expectedToys = 16;
        int expectedMaterials = 0;
        for (int i = 0; i < numRounds; ++i) {
            workshop.nextRound();
        }

        int actualToys = workshop.buildCount();
        int actualMaterials = workshop.materialCount();
        assertEquals(expectedToys, actualToys, "With 2 makers and 10 builders, should have produced 16 toys after 10 rounds.");
        assertEquals(expectedMaterials, actualMaterials, "With 2 makers and 10 builders, should have 0 leftover materials.");
    }

    @Test
    void componentTest4() throws Exception {
        Workshop workshop = new Workshop(10, 9);
        int numRounds = 20;
        int expectedToys = 126;
        int expectedMaterials = 14;
        for (int i = 0; i < numRounds; ++i) {
            workshop.nextRound();
        }

        int actualToys = workshop.buildCount();
        int actualMaterials = workshop.materialCount();
        assertEquals(expectedToys, actualToys, "With 10 makers and 9 builders, should have produced 126 toys after 20 rounds.");
        assertEquals(expectedMaterials, actualMaterials, "With 10 makers and 9 builders, should have have 14 leftover materials.");
    }

    @Test
    public void NegativeNumMaker() {

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> new Workshop(-1, 2));
        assertEquals("Number of Builder/maker cannot be negative", exception.getMessage());
    }
    @Test
    public void NegativeNumBuilder() {

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> new Workshop(2, -2));
        assertEquals("Number of Builder/maker cannot be negative", exception.getMessage());
    }

}
