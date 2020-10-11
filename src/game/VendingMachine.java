package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

public class VendingMachine extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public VendingMachine() {
        super('V');
    }

    public void checkSufficient(Player player, BoughtItem boughtItem)
    {
        if (player.getEcoPoints()>=getRequiredPoints(boughtItem))
        {
            player.payEcoPoints(getRequiredPoints(boughtItem));
            player.addItemToInventory(boughtItem);
        }
        else
        {
            System.out.println("Not enough money to buy the following item");
        }
    }
    public int getRequiredPoints(BoughtItem boughtItem){
        return boughtItem.getPriceEcoPoints();
    }


    // string menu asking the user what he wants to buy
}
