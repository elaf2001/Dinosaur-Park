package game;

public class Agilisaurus extends Dinosaur{
    /**
     * Constructor.
     * Sets the gender of the dinosaur by random.
     * Both dinosaurs have Wander and Hungry behaviours.
     *
     * @param name          Name to of the dinosaur
     */
    public Agilisaurus(String name) {
        super(name, 'i', 100, 10, true, true);
    }
}
