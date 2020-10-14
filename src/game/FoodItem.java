package game;

public abstract class FoodItem extends BoughtItem {

    private int foodPoints;

    /**
     * Constructor for the StegosaurEgg
     * All Stegosaurs eggs are represented by a '0' and have 10 food points and 200 eco points price.
     * @param name The name of the Stegosaur Egg
     */
    public FoodItem(String name, char displayChar, int foodPoints, int priceEcoPoints ) {
        super(name, displayChar, priceEcoPoints);
        this.foodPoints=foodPoints;
    }

    /**
     * getter for the food points
     * @return food points (amount of food points that the food level of the dinosaur that ate this food item
     * will be increased by)
     */
    public int getFoodPoints() {
        return foodPoints;
    }

    /**
     * getter for the name of the food item
     * @return the name of the food item
     */
    public String getName()
    {
        return this.name;
    }


}
