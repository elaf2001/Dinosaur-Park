package game;

import edu.monash.fit2099.engine.Location;


public class StegosaurEgg extends EggItem{

    public StegosaurEgg(String name) {
        super(name, '0');
    }

    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        Stegosaur newStegosaur = new Stegosaur("Stegosaur");
        currentLocation.addActor(newStegosaur);
    }
}
