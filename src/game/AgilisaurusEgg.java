package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

import java.util.List;

/**
 * Egg class for the dinosaur of agilisaurus specie
 */
public class AgilisaurusEgg extends EggItem{
    /**
     * Constructor
     * All Agilisaurus Eggs are represented by 'D' , have food points of 10 and price of 600 eco points
     * @param name The name of the Agilisaurus Egg
     */
    public AgilisaurusEgg(String name) {
        super(name, 'D', 10, 600);
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
     * Allows the egg to hatch and an Agilisaurus will be born
     * @param currentLocation the location of the ground the actor lies on
     */
    @Override
    public void hatchEgg(Location currentLocation) {
        currentLocation.removeItem(this);
        this.increasePlayerPoints(currentLocation,600);
        Agilisaurus newAgilisaurus = new Agilisaurus("Agilisaurus");
        if(currentLocation.containsAnActor()){
            List<Exit> exits = currentLocation.getExits();
            for(Exit exit: exits){
                Location newLoc = exit.getDestination();
                if(newLoc.canActorEnter(newAgilisaurus) && !newLoc.containsAnActor()){
                    newLoc.addActor(newAgilisaurus);
                    break;
                }
            }
        }
        else{
            currentLocation.addActor(newAgilisaurus);
        }
    }
}
