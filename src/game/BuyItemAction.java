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


    public String execute(Actor actor, GameMap map) {
        String output = "";
        BoughtItem itemToBuy = vendingMachine.menuVendingMachine();
        int requiredEcoPoints = vendingMachine.getRequiredPoints(itemToBuy);
        if (actor instanceof Player) {
            if (((Player) actor).getEcoPoints() >= requiredEcoPoints) {
                ((Player) actor).payEcoPoints(requiredEcoPoints);
                ((Player) actor).addItemToInventory(itemToBuy);
                output += "Item is successfully bought";
            } else {
                output += "Not enough money to buy the following item";
            }
        }
        return output;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor+" buys from"+vendingMachine;
    }
}
