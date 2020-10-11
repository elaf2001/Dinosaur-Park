package game;

public abstract class MealKitItem extends FoodItem {

    public MealKitItem(String name, char displayChar, int priceEcoPoints) {
        super(name, displayChar,100, priceEcoPoints);
    }
}
