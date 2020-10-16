package game;

import edu.monash.fit2099.engine.*;

/**
 * Represents the feed action.
 * target is the dinosaur to feed
 */
public class FeedAction extends Action {

    protected Dinosaur target;

    /**
     * Constructor.
     * @param target the dinosaur to feed
     */
    public FeedAction(Dinosaur target) {
        this.target = target;
    }

    /**
     * Performs the Action, that allows the player to feed the dinosaur with the food item from the inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description  that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String output="";
        Display display= new Display();
        display.println("What would you like to feed?");
        display.println("1. Hay  ");
        display.println("2. Fruit ");
        display.println("3. Vegetarian meal kit ");
        display.println("4. Carnivore meal kit ");
        display.println("5. Stegosaur eggs ");
        display.println("6. Allosaur eggs ");
        char playerChoice = display.readChar();
        while (playerChoice != '1' && playerChoice !='2' && playerChoice != '3' && playerChoice != '4' && playerChoice != '5' && playerChoice != '6'){
            playerChoice=display.readChar();
        }
        boolean found = false;
        if (playerChoice == '1' || playerChoice == '2' || playerChoice == '3') {
            if (target instanceof Stegosaur) {
                for (Item item : actor.getInventory()) {
                    if (playerChoice == '1') {
                        if (item instanceof HayItem) {
                            actor.removeItemFromInventory(item);
                            ((Player) actor).gainEcoPoint(10);
                            output += "Dinosaur is successfully fed";
                            found = true;
                            break;
                        }
                    } else if (playerChoice == '2') {
                        if (item instanceof FruitItem) {
                            actor.removeItemFromInventory(item);
                            ((Player) actor).gainEcoPoint(10);
                            output += "Dinosaur is successfully fed";
                            found = true;
                            break;
                        }
                    } else if (playerChoice == '3') {
                        if (item instanceof VegetarianMealKitItem) {
                            actor.removeItemFromInventory(item);
                            ((Player) actor).gainEcoPoint(10);
                            output += "Dinosaur is successfully fed";
                            found = true;
                            break;
                        }
                    }
                }
            }
            else {
                output += "This dinosaur is not vegeterain.\n";
            }
            if (!found) {
                output += "The following item is not found in your inventory";
            }
        }
        else {
            if (target instanceof Allosaur) {
                for (Item item : actor.getInventory()) {
                    if (playerChoice == '4') {
                        if (item instanceof CarnivoreMealKitItem) {
                            actor.removeItemFromInventory(item);
                            ((Player) actor).gainEcoPoint(10);
                            output += "Dinosaur is successfully fed";
                            found = true;
                            break;
                        }
                    } else if (playerChoice == '5') {
                        if (item instanceof StegosaurEgg) {
                            actor.removeItemFromInventory(item);
                            ((Player) actor).gainEcoPoint(10);
                            output += "Dinosaur is successfully fed";
                            found = true;
                            break;
                        }
                    } else if (playerChoice == '6') {
                        if (item instanceof AllosaurEgg) {
                            actor.removeItemFromInventory(item);
                            ((Player) actor).gainEcoPoint(10);
                            output += "Dinosaur is successfully fed";
                            found = true;
                            break;
                        }
                    }
                }
            } else {
                output += "This dinosaur is not carnivore.\n";
            }
            if (!found) {
                output += "The following item is not found in your inventory";
            }
        }
        return output;
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text to put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds " + target;
    }
}
