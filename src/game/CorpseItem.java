package game;

import edu.monash.fit2099.engine.Item;

public class CorpseItem extends FoodItem {
    /**
     *
     * All Stegosaurs eggs are represented by a '0' and have 10 food points and 200 eco points price.
     */
    public CorpseItem() {
        super("Dead Dinosaur", '%', 50, 0);
    }

}
