package game;

public class Agilisaurus extends Dinosaur{
    /**
     * Constructor.
     * Sets the gender of the dinosaur by random.
     * Both dinosaurs have Wander and Hungry behaviours.
     *
     * @param name          Name to of the dinosaur
     * @param displayChar   Character to represent the dinosaur in the UI
     * @param hitPoints     Dinosaur's starting number of hitpoints
     * @param foodLevel     level of food, when the dinosaur appears on the map
     * @param is_carnivore
     * @param is_vegetarian
     */
    public Agilisaurus(String name) {
        super(name, 'i', 100, 10, true, true);
    }
}
