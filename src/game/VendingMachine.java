package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

public class VendingMachine extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public VendingMachine(char displayChar) {
        super('V');
    }

    public void checkSufficient(Player player, Item item)
    {
        if (player.getEcoPoints()>=getRequiredPoints(item))
        {
            player.payEcoPoints(getRequiredPoints(item));
            player.addItemToInventory(item);
        }
        else
        {
            System.out.println("Not enough money to buy the following item");
        }
    }
    public int getRequiredPoints(Item item){
        return item.getPriceEcoPoints();
    }




    // string menu asking the user what he wants to buy
}
