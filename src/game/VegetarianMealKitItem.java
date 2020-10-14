package game;

public class VegetarianMealKitItem extends MealKitItem {

    /**
     * Constructor.
     * Vegetarian meal kits are represented by a '>' and have 100 eco points price.
     * @param name the name of the vegetarian meal kit
     *
     */
    public VegetarianMealKitItem(String name) {
        super(name,'>',100);
    }
}
