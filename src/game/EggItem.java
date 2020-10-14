package game;

import edu.monash.fit2099.engine.*;
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
     * @param foodPoints - food points of the egg item
     * @param priceEcoPoints - price in eco points
     */
    public EggItem(String name, char displayChar, int foodPoints, int priceEcoPoints) {
        super(name, displayChar, foodPoints, priceEcoPoints );
    }

    @Override
    public DropItemAction getDropAction() {
        return new DropItemAction(this);
    }
    /**
     * Increases ecoPoints of the player when the egg hatches.
     * @param location location of the item
     * @param ecoPoints the amount of ecoPoints, that will be added to the player, when the egg hatches
     */
    public void increasePlayerPoints(Location location, int ecoPoints){
        GameMap map = location.map();
        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();
        for (int x: xRange) {
            for (int y: yRange) {
                Location possibleLocation = map.at(x,y);
                if(possibleLocation.containsAnActor()){
                    Actor actor = possibleLocation.getActor();
                    if (actor instanceof Player){
                        ((Player) actor).gainEcoPoint(ecoPoints);
                    }
                }
            }
        }
    }


    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
        if(actor instanceof Dinosaur) {
            turns+=1;
            if (turns == 10) {
                getDropAction().execute(actor, currentLocation.map());
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
