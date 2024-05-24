/**
 * A class representing an elf which makes materials in an elven Workshop.
 * The elf uses its energy to gather and process materials from which toys are made.
 * To regain energy and make more materials, the elf must have a cookie break.
 */
public class MakerElf {

    private int energy;

    /**
     * Construct a new MakerElf with the default energy of 3.
     */
    public MakerElf() {
        energy = 3;
    }

    /**
     * Construct a new MakerElf with the specified amount of energy.
     * @param energy: a positive integer for the Elf's amount of energy
     */
    public MakerElf(int energy) {
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
     * Adds 5 units of energy to the elf's current amount of energy.
     */
    public void cookieBreak() {
        energy += 5;
    }

    /**
     * Consume 1 unit of elf energy to produce a Cotton.
     * It is invalid to attempt to weave when the elf has insufficient energy.
     * @return a newly manufactured Cotton object
     */
    public Cotton weaveCotton() throws NullPointerException {
        if (energy < 1) {
            throw new NullPointerException("Energy not enough to produce Cotton.");
        }
        energy -= 1;
        return new Cotton();
    }

    /**
     * Consume 2 units of elf energy to produce a Wood.
     * It is invalid to attempt to chop when the elf has insufficient energy.
     * @return a newly manufactured Wood object
     */
    public Wood chopWood() {
        assert energy>= 2: "Not enough energy";
        energy -= 2;
        return new Wood();
    }

}
