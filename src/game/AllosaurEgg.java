package game;


import edu.monash.fit2099.engine.Location;
/**
 * Class that represents the Allosaur eggs in the system. It is the child class of {EggItem}.
 */
public class AllosaurEgg extends EggItem{
    /**
     * Constructor for the AllosaurEgg
     * @param name The name of the Allosaur Egg
     */
    public AllosaurEgg(String name) {
        super(name, 'O');
    }

    /**
     * This function will allow the egg to hatch by removing the egg item and adding
     * another dinosaur. The dinosaur added will be based on the type of egg. In this
     * scenario it is Allosaur
     * @param currentLocation the current location of the egg.
     */
    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        Allosaur newAllosaur = new Allosaur("Allosaur");
        currentLocation.addActor(newAllosaur);
    }
}
