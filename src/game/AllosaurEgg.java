package game;


import edu.monash.fit2099.engine.Location;

public class AllosaurEgg extends EggItem{

    public AllosaurEgg(String name) {
        super(name, 'O');
    }

    public void hatchEgg(Location currentLocation){
        currentLocation.removeItem(this);
        Allosaur newAllosaur = new Allosaur("Allosaur");
        currentLocation.addActor(newAllosaur);
    }
}
