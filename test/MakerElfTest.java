import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MakerElfTest {

    @Test
    void getEnergy() {
        MakerElf elf = new MakerElf(3);
        assertEquals(3, elf.getEnergy(), "MakerElf energy should be 3.");
    }

    @Test
    void cookieBreak() {
        MakerElf elf = new MakerElf(0);
        elf.cookieBreak();
        assertEquals(5, elf.getEnergy());
    }

    @Test
    void cookieBreak_AddToCurrent() {
        MakerElf elf = new MakerElf(1);
        elf.cookieBreak();
        assertEquals(6, elf.getEnergy());
    }

    @Test
    void weaveCotton() {
        MakerElf elf = new MakerElf();
        int prevEnergy = elf.getEnergy();
        Cotton cotton = elf.weaveCotton();
        int afterEnergy = elf.getEnergy();
        assertNotNull(cotton);
        assertEquals(1, prevEnergy-afterEnergy, "Weaving cotton should consume 1 unit of energy.");
    }

    @Test
    void chopWood() {
        MakerElf elf = new MakerElf();
        int prevEnergy = elf.getEnergy();
        Wood wood = elf.chopWood();
        int afterEnergy = elf.getEnergy();
        assertNotNull(wood);
        assertEquals(2, prevEnergy-afterEnergy, "Chopping wood should consume 2 units of energy.");
    }

    @Test
    public void testBuildWithNullMaterial()
    {
        MakerElf makerElf = new MakerElf(0);
        NullPointerException exception = assertThrows(NullPointerException.class, () -> makerElf.weaveCotton());
        assertEquals("Energy not enough to produce Cotton.", exception.getMessage());
    }
}