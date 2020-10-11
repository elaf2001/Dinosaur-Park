package game;

public class BoughtItem extends PortableItem{
    private int priceEcoPoints;

    public BoughtItem(String name, char displayChar, int priceEcoPoints) {
        super(name, displayChar);
        this.priceEcoPoints= priceEcoPoints;
    }

    public int getPriceEcoPoints() {
        return priceEcoPoints;
    }

}
