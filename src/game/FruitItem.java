package game;

import edu.monash.fit2099.engine.Location;

public class FruitItem extends FoodItem {
    private int turns = 0;
    public FruitItem(String name, char displayChar) {
        super(name, displayChar,30, 30);

    }

    @Override
    public void tick(Location currentLocation) {
        turns +=1;
        if (turns ==20){
            currentLocation.removeItem(this);
        }
    }
}
