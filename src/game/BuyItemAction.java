package game;

import edu.monash.fit2099.engine.*;

public class BuyItemAction extends Action {

    /**
     * The Item to be bought
     */
    protected VendingMachine vendingMachine;

    public BuyItemAction(VendingMachine vendingMachine)
    {
        this.vendingMachine=vendingMachine;
    }


    public String execute(Player player, GameMap map) {
        String output="";
        BoughtItem itemToBuy=vendingMachine.menuVendingMachine();
        int requiredEcoPoints=vendingMachine.getRequiredPoints(itemToBuy);
        if (player.getEcoPoints()>= requiredEcoPoints)
        {
            player.payEcoPoints(requiredEcoPoints);
            player.addItemToInventory(itemToBuy);
            output+="Item is successfully bought";
        }
        else
        {
            output+="Not enough money to buy the following item";
        }
        return output;
    }
    
    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor+" buys from"+vendingMachine;
    }
}
