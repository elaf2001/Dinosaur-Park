package game;

import edu.monash.fit2099.engine.Location;

/**
 * Class that represents the Stegosaur eggs in the system. It is the child class of {EggItem}.
 */
public class StegosaurEgg extends EggItem{
    /**
     * Constructor for the StegosaurEgg
     * @param name The name of the Stegosaur Egg
     */
    public StegosaurEgg(String name) {
        super(name, '0',10,200);
    }

    @Override
    public void increasePlayerPoints(Location location, int ecoPoints) {

        super.increasePlayerPoints(location, ecoPoints);
    }

    /**
     * This function will allow the egg to hatch by removing the egg item and adding
     * another dinosaur. The dinosaur added will be based on the type of egg. In this
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
