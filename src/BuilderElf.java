/**
 * A class representing an elf which builds toys in an elven Workshop.
 * The elf uses its energy to build toys from materials.
 * To regain energy, the elf either relaxes to gain a bit of energy
 * or has a cookie break to gain a moderate amount of energy.
 */
public class BuilderElf {

    public static final int MINENERGY = 1;
    public static final int DEFAULT_BUILDER_ENERGY = 2;
    private int energy;

    /**
     * Construct a new BuilderElf with the default energy of 2.
     */
    public BuilderElf() {
        energy = DEFAULT_BUILDER_ENERGY;
    }

    /**
     * Construct a new BuilderElf with the specified amount of energy.
     * @param energy: a positive integer for the Elf's amount of energy
     */
    public BuilderElf(int energy) {
        this.energy = energy;
    }

    /**
     * Get the elf's current amount of energy.
     * @return the current energy of this elf.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Let the elf have a break to eat cookies and gain energy.
     * Adds 2 units of energy to the elf's current amount of energy.
     */
    public void cookieBreak() {
            energy += DEFAULT_BUILDER_ENERGY;
    }

    /**
     * Let the elf relax for a moment and regain a small amount of energy.
     * Adds 1 unit of energy to the elf.
     */
    public void relax() {
        energy += MINENERGY;
    }

    /**
     * Given a Wood material, expend 1 unit of energy to
     * transform it into a train.
     * It is invalid to attempt to build when the elf has insufficient energy.
     * @param material: the material to use to build the toy
     * @return the newly built Train
     */
    public Train build(Wood material) {
        if (energy < MINENERGY) {
            throw new IllegalArgumentException("Not enough energy to build the Train Toy");
        }
        energy -= MINENERGY;
        return material.transform();
    }

    /**
     * Given a Cotton material, expend 1 unit of energy to
     * transform it into a stuffed animal.
     * It is invalid to attempt to build when the elf has insufficient energy.
     * @param material: the material to use to build the toy
     * @return the newly built StuffedAnimal
     */
    public StuffedAnimal build(Cotton material) {
        if (energy < MINENERGY) {
            return null;
        }
        energy -= MINENERGY;
        return material.transform();
    }

}
