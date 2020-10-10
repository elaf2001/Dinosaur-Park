package game;


/**
 * A carnivore dinosaur.
 *
 */
public class Allosaur extends Dinosaur {

    /**
     * Constructor.
     * All Allosaurs are represented by a 'a' and have 100 hit points.
     *
     * @param name the name of this Allosaur
     */
    public Allosaur(String name) {
        super(name, 'a', 100);
    }
    //has its own special behaviours that are including attack etc
}
