package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

import java.util.List;

public class ArchaeopteryxEgg extends EggItem {

    /**
     * Constructor for the AllosaurEgg
     * All Allosaurs Eggs are represented by 'O' and have food points of 10 and price of 1000 eco points
     * @param name The name of the Allosaur Egg
     */
    public ArchaeopteryxEgg(String name) {
        super(name, 'Q',10,600);
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
     * a new Allosaur.
     * If there is an actor standing on the location of the egg, it will
     * hatch to the nearest empty location.
     * @param currentLocation the current location of the egg.
     */
    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        this.increasePlayerPoints(currentLocation,600);
        Archaeopteryx newArchaeopteryx = new Archaeopteryx("Archaeopteryx");
        if(currentLocation.containsAnActor()){
            List<Exit> exits = currentLocation.getExits();
            for(Exit exit: exits){
                Location newLoc = exit.getDestination();
                if(newLoc.canActorEnter(newArchaeopteryx) && !newLoc.containsAnActor()){
                    newLoc.addActor(newArchaeopteryx);
                    break;
                }
            }
        }
        else{
            currentLocation.addActor(newArchaeopteryx);
        }

    }
}
