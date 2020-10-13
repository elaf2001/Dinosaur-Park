package game;



import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import game.PortableItem;

/**
 * An abstract class that represents all the eggs that will be implemented in the system.
 * Has two children classes: {StegosaurEgg} and {AllosaurEgg}
 * It inherits {PortableItem}.
 * Has two variables: turns and age
 */
public abstract class EggItem extends FoodItem {
    private int turns = 0;
    private int age =0;

    /**
     * Constructor.
     * @param name - name of the egg
     * @param displayChar - Display character of the egg
     */
    public EggItem(String name, char displayChar, int foodPoints, int priceEcoPoints) {
        super(name, displayChar, foodPoints,priceEcoPoints );
    }

    public void increasePlayerPoints(Location location, int ecoPoints){
        GameMap map = location.map();
        Location[][] mapLocations = map.getMap();
        for (int row = 0; row < mapLocations.length; row++) {
            for (int col = 0; col < mapLocations[row].length; col++) {
                Location possibleLocation = mapLocations[row][col];
                if(possibleLocation.containsAnActor()){
                    Actor actor = possibleLocation.getActor();
                    if (actor instanceof Player){
                        ((Player) actor).gainEcoPoint(ecoPoints);
                    }
                }
            }
        }
    }
    /**
     * Updates the turn variable. when the turns reach 10, the dinosaur will lay the egg on the location it was in.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */

    @Override
    public void tick(Location currentLocation, Actor actor) {
        /**
         * This will add turns and after 10 turns the dinosaur (actor) will drop the egg from it is inventory
         */
        super.tick(currentLocation, actor);
        if(actor instanceof Dinosaur){
            turns++;
            if (turns == 10){
                getDropAction();
            }
        }

    }

    /**
     * Updates the age variable. When the age reaches 10, the function calls {hatchEgg} to hatch the egg.
     * @param currentLocation The location of the ground on which actor lies on.
     */
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

    /**
     * Allows the egg to hatch and a new dinosaur to be born based on the type of egg.
     * @param currentLocation the location of the ground the actor lies on
     */
    public abstract void hatchEgg(Location currentLocation);
}
