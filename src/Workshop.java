import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class representing an elven toy workshop.
 * Elves love making toys and eating cookies.
 *
 * In this workshop, maker elves process raw goods to make materials.
 * Using those materials, builder elves build toys.
 * Each "round" of work in the workshop consists of
 * maker elves making materials and adding them to a queue,
 * and builder elves taking materials from the queue to build a toy.
 * Maker elves always make the material with highest energy cost
 * that they have sufficient energy to make.
 * During each round, each elf can perform at most one action.
 *
 * As long as every elf in the workshop has energy, materials and toys
 * are produced during each "round" of work in the workshop.
 * If even one elf has no energy at the start of a round of work,
 * all elves skip work for that round and instead have a break together
 * to eat cookies and gain energy.
 */
public class Workshop {

    private ArrayList<BuilderElf> builders;
    private ArrayList<MakerElf> makers;
    private Queue<Object> materials;
    private ArrayList<Train> trains;
    private ArrayList<StuffedAnimal> animals;

    /**
     * Create a new elven Workshop with a certain number of
     * resident makers and builders.
     * There must be at least one maker and one builder in a Workshop.
     * @param numMakers: the number of MakerElfs in the workshop.
     * @param numBuilders: the number of BuilderElfs in the workshop.
     */
    public Workshop(int numMakers, int numBuilders) throws IllegalStateException {
        int numberOfBuilder= numBuilders;
        int numberOfMaker= numMakers;
        if(numberOfMaker<0 || numberOfBuilder<0){
            throw new IllegalStateException("Number of Builder/maker cannot be negative");
        }
        makers = new ArrayList<>();
        for (int i = 0; i < numberOfMaker; ++i) {
            makers.add(new MakerElf());
        }
        builders = new ArrayList<>();
        for (int i = 0; i < numberOfBuilder; ++i) {
            builders.add(new BuilderElf());
        }

        materials = new LinkedList<>();
        trains = new ArrayList<>();
        animals = new ArrayList<>();
    }

    /**
     * Perform a round of work in the Workshop.
     *
     * Depending on the energy levels of the resident elves,
     * certain materials and toys may be made.
     * If there is insufficient energy among the elves,
     * they take a communal break instead.
     */
    public void nextRound() {

        Workshop_Department helper= new Workshop_Department();
        Boolean b= helper.checkEnergyLevels(makers, builders);
        if (b) {
            breakTime();
            return;
        }

        helper.makeMaterials(makers, materials);
        helper.buildToys(builders,materials,trains,animals);

    }

    /**
     * Get the total number of toys built to far in this workshop.
     * @return the number of toys built.
     */
    public int buildCount() {
        return trains.size() + animals.size();
    }

    /**
     * Get the number of materials made in the workshop
     * which have not yet been transformed into toys.
     * @return the current number of materials in this workshop.
     */
    public int materialCount() {
        return materials.size();
    }

    /**
     * Initiate a communal break of the resident elves.
     * Every elf has a cookie break to gain energy to make more toys.
     */
    public void breakTime() {
        for (MakerElf maker : makers) {
            maker.cookieBreak();
        }
        for (BuilderElf builder : builders) {
            builder.cookieBreak();
        }
    }
}
