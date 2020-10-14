package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

/**
 * Class that represents the Stegosaur eggs in the system. It is the child class of {EggItem}.
 */
public class StegosaurEgg extends EggItem{

    /**
     * Constructor for the StegosaurEgg
     * All Stegosaurs eggs are represented by a '0' and have 10 food points and 200 eco points price.
     * @param name The name of the Stegosaur Egg
     */
    public StegosaurEgg(String name) {
        super(name, '0',10,200);
    }

    @Override
    public void tick(Location currentLocation, Actor actor){
        super.tick(currentLocation, actor);
    }
    /**
     * Overrides the method from the EggItem class, which increases ecoPoints of the player when the
     * egg hatches.
     * @param location location of the item
     * @param ecoPoints the amount of ecoPoints, that will be added to the player, when the egg hatches
     */
    @Override
    public void increasePlayerPoints(Location location, int ecoPoints) {
        super.increasePlayerPoints(location, ecoPoints);
    }

    /**
     * This function will allow the egg to hatch by removing the egg item and adding a
     * dinosaur. The dinosaur added will be based on the type of egg. In this
     * scenario it is Stegosaur
     * @param currentLocation the current location of the egg.
     */
    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        this.increasePlayerPoints(currentLocation,100);
        Stegosaur newStegosaur = new Stegosaur("Stegosaur", 10);
        currentLocation.addActor(newStegosaur);
    }
}
