/**
 * A class representing the Wood material.
 * It can be used to build a toy Train.
 */
public class Wood {

    /**
     * Construct a new Wood object.
     */
    public Wood() {}

    /**
     * A BuilderElf can call this method to transform this Wood material
     * into a Train.
     * @return the newly created Train.
     */
    public Train transform() {
        return new Train();
    }

}
