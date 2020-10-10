package game;

public abstract class FoodItem extends PortableItem {
    private int foodPoints;

    public FoodItem(String name, char displayChar, int foodPoints) {
        super(name, displayChar);
        this.foodPoints=foodPoints;
    }
    public FoodItem(String name, char displayChar) {
        super(name, displayChar);
    }

    public int getFoodPoints() {
        return foodPoints;
    }

    public String getName()
    {
        return this.name;
    }


}
