package game;

/**
 * A omnivorous dinosaur of agilisaurus specie
 */
public class Agilisaurus extends Dinosaur{
    /**
     * Constructor
     * All Agilisaurus are represented by 'i' , have hit points=100,
     * food level=10, and they are omnivorous
     * @param name Name to of the dinosaur
     */
    public Agilisaurus(String name) {
        super(name, 'i', 100, 10, true, true);
    }
}
