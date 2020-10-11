package game;

public abstract class FoodItem extends BoughtItem {
    private int foodPoints;

    public FoodItem(String name, char displayChar, int foodPoints, int priceEcoPoints ) {
        super(name, displayChar, priceEcoPoints);
        this.foodPoints=foodPoints;
    }

    public int getFoodPoints() {
        return foodPoints;
    }

    public String getName()
    {
        return this.name;
    }


}
