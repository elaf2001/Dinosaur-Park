package game;

import edu.monash.fit2099.engine.Location;

public class FruitItem extends FoodItem {

    private int turns = 0;

    /**
     * Constructor.
     * All fruits are represented by 'F', have the name 'fruit', food point of 30 and price of 30 in eco points.
     */
    public FruitItem() {
        super("Fruit", 'F',30, 30);
    }

    /**
     * Allows the fruit to rot away if it's left on the ground for too long
     * @param currentLocation location where the fruit is left
     */
    @Override
    public void tick(Location currentLocation) {
        turns +=1;
        if (turns ==20){
            currentLocation.removeItem(this);
        }
    }
}
