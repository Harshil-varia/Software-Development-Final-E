/**
 * A class representing the Cotton material.
 * It can be used to build a StuffedAnimal.
 */
public class Cotton {

    /**
     * Construct a new Cotton object.
     */
    public Cotton() {}

    /**
     * A BuilderElf can call this method to transform this Cotton material
     * into a StuffedAnimal.
     * @return the newly created StuffedAnimal.
     */
    public StuffedAnimal transform() {
        return new StuffedAnimal();
    }

}
