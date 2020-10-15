package game;


import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

import java.util.List;

/**
 * Class that represents the Allosaur eggs in the system. It is the child class of {EggItem}.
 */
public class AllosaurEgg extends EggItem{

    /**
     * Constructor for the AllosaurEgg
     * @param name The name of the Allosaur Egg
     */
    public AllosaurEgg(String name) {
        super(name, 'O',10,1000);
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
     * another dinosaur. The dinosaur added will be based on the type of egg. In this
     * scenario it is Allosaur
     * @param currentLocation the current location of the egg.
     */
    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        this.increasePlayerPoints(currentLocation,1000);
        Allosaur newAllosaur = new Allosaur("Allosaur");
        if(currentLocation.containsAnActor()){
            List<Exit> exits = currentLocation.getExits();
            for(Exit exit: exits){
                Location newLoc = exit.getDestination();
                if(!newLoc.containsAnActor()){
                    newLoc.addActor(newAllosaur);
                }
            }
        }else{
            currentLocation.addActor(newAllosaur);
        }

    }
}
