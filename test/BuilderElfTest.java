import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BuilderElfTest {

    @Test
    void ConstructNewBuilder() {
        BuilderElf elf = new BuilderElf();
        assertEquals(2, elf.getEnergy(), "A new Builder with default constructor should have 2 Energy");
    }

    @Test
    void getEnergy() {
        BuilderElf elf = new BuilderElf(2);
        assertEquals(2, elf.getEnergy(), "BuilderElf energy should be 2.");
    }

    @Test
    void cookieBreak() {
        BuilderElf elf = new BuilderElf(0);
        elf.cookieBreak();
        assertEquals(2, elf.getEnergy());
    }

    @Test
    void cookieBreak_AddToCurrent() {
        BuilderElf elf = new BuilderElf(1);
        elf.cookieBreak();
        assertEquals(3, elf.getEnergy(), "Break does not add to current Energy which is > 0");
    }

    @Test
    void relax() {
        BuilderElf elf = new BuilderElf();
        int prevEnergy = elf.getEnergy();
        elf.relax();
        int afterEnergy = elf.getEnergy();
        assertEquals(1, afterEnergy - prevEnergy, "Relaxing should provide the elf with 1 extra unit of energy.");
    }

    @Test
    void build_wood() {
        BuilderElf elf = new BuilderElf();
        Wood wood = new Wood();
        int prevEnergy = elf.getEnergy();
        Train toy = elf.build(wood);
        int afterEnergy = elf.getEnergy();
        assertNotNull(toy);
        assertEquals(1, prevEnergy - afterEnergy, "Building a toy should consume 1 unit of energy.");
    }

    @Test
    void build_cotton() {
        BuilderElf elf = new BuilderElf();
        Cotton cotton = new Cotton();
        int prevEnergy = elf.getEnergy();
        StuffedAnimal toy = elf.build(cotton);
        int afterEnergy = elf.getEnergy();
        assertNotNull(toy);
        assertEquals(1, prevEnergy - afterEnergy, "Building a toy should consume 1 unit of energy.");
    }

    @Test
    public void testBuildWithInsufficientEnergy() {

        BuilderElf builderElf = new BuilderElf(0);
        Wood woodMaterial = new Wood();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> builderElf.build(woodMaterial));
        assertEquals("Not enough energy to build the Train Toy", exception.getMessage());
    }
}