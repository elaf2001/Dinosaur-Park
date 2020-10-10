package game;

public abstract class FoodItem extends PortableItem {
    private  int FOOD_POINTS;

    public FoodItem(String name, char displayChar) {
        super(name, displayChar);
    }

    public int getFoodPoints() {
        return FOOD_POINTS;
    }

    public String getName()
    {
        return this.name;
    }


}
