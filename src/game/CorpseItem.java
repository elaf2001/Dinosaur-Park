package game;

import edu.monash.fit2099.engine.Item;

/**
 * Class that represents the item, which is created if the dinosaur dies.
 **/
public class CorpseItem extends FoodItem {

    /**
     * Constructor that sets the name, display character, and food points of the item.
     */
    public CorpseItem() {
        super("Dead Dinosaur", '%', 50, 0);
        this.portable=false;
    }

}
