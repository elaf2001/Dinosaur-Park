package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

import java.util.List;

/**
 * Class that represents the Stegosaur eggs in the system.
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

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
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
     * This function allows the egg to hatch by removing the egg item and adding
     * a new Stegosaur.
     * If there is an actor standing on the location of the egg, it will
     * hatch to the nearest empty location.
     * @param currentLocation the current location of the egg.
     */
    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        this.increasePlayerPoints(currentLocation,100);
        Stegosaur newStegosaur = new Stegosaur("Stegosaur", 10);
        if(currentLocation.containsAnActor()){
            List<Exit> exits = currentLocation.getExits();
            for(Exit exit: exits){
                Location newLoc = exit.getDestination();
                if(newLoc.canActorEnter(newStegosaur) && !newLoc.containsAnActor()){
                    newLoc.addActor(newStegosaur);
                    break;
                }
            }
        }
        else{
            currentLocation.addActor(newStegosaur);
        }
    }
}
