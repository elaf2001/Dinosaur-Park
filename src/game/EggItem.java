package game;



import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import game.PortableItem;

public abstract class EggItem extends PortableItem  {
    int turns = 0;
    int age =0;
    public EggItem(String name, char displayChar) {
        super(name, displayChar);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        /**
         * This will add turns and after 10 turns the dinosaur (actor) will drop the egg from it is inventory
         */
        super.tick(currentLocation, actor);

        turns++;
        if (turns == 10){
            getDropAction();
        }
    }

    @Override
    public void tick(Location currentLocation) {
        /**
         * This will hatch the egg after 10 turns and will create a dinosaur actor
         */
        age++;
        if (age == 10){
            hatchEgg(currentLocation);
        }
    }

    public abstract void hatchEgg(Location currentLocation);
}
