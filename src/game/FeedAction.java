package game;

import edu.monash.fit2099.engine.*;

public class FeedAction extends Action {

    protected Dinosaur target;

    /**
     * Constructor.
     * @param target the dinosaur to feed
     */
    public FeedAction(Dinosaur target) {
        this.target = target;
    }

//    @Override
//    public String execute(Actor actor, GameMap map) {
//        String output="";
//        Display display= new Display();
//        display.println("What would you like to feed?");
//        display.println("1. Hay  ");
//        display.println("2. Fruit ");
//        display.println("3. Vegetarian meal kit ");
//        display.println("4. Carnivore meal kit ");
//        display.println("5. Stegosaur eggs ");
//        display.println("6. Allosaur eggs ");
//        char playerChoice=display.readChar();
//
//
//
//        if (playerChoice == '1'){
//            boolean found=false;
//            if (target instanceof Stegosaur) {
//                for (Item item : actor.getInventory()) {
//                    if (item instanceof HayItem) {
//                        if(target.eat((FoodItem) item)){
//                            if(actor instanceof Player){
//                                actor.removeItemFromInventory(item);
//                                ((Player) actor).gainEcoPoint(10);
//                                output+="Dinosaur is successfully fed";
//                                found=true;
//                                break;
//                            }
//
//                        }
//                        else
//                        {
//                            output+="The dinosaur is full";
//                        }
//                    }
//                }
//                if (!found)
//                {
//                    output+="The following item is not found in your inventory";
//                }
//            }
//            else
//            {
//               output+="This dinosaur is not vegeterain." ;
//            }
//        }
//
//        else if(playerChoice == '2')
//        {
//            boolean found=false;
//            if (target instanceof Stegosaur) {
//                for (Item item : actor.getInventory()) {
//                    if (item instanceof FruitItem) {
//                        if(target.eat((FoodItem) item)){
//                            if(actor instanceof Player) {
//                                actor.removeItemFromInventory(item);
//                                ((Player) actor).gainEcoPoint(15);
//                                output+="Dinosaur is successfully fed";
//                                found=true;
//                                break;
//                            }
//
//                        }
//                       else
//                        {
//                            output+="The dinosaur is full";
//                        }
//                    }
//                }
//                if (!found)
//                {
//                    output+="The following item is not found in your inventory";
//                }
//            }
//            else
//            {
//                output+="This dinosaur is not vegeterain." ;
//            }
//        }
//        else if(playerChoice == '3')
//        {
//            boolean found=false;
//            if (target instanceof Stegosaur) {
//                for (Item item : actor.getInventory()) {
//                    if (item instanceof VegetarianMealKitItem) {
//                        if(target.eat((FoodItem) item)){
//                            actor.removeItemFromInventory(item);
//                            output+="Dinosaur is successfully fed";
//                            found=true;
//                            break;
//                        }
//                        else
//                        {
//                            output+="The dinosaur is full";
//                        }
//                    }
//                }
//                if (!found)
//                {
//                    output+="The following item is not found in your inventory";
//                }
//            }
//            else
//            {
//                output+="This dinosaur is not vegeterain." ;
//            }
//        }
//        else if(playerChoice == '4')
//        {
//            boolean found=false;
//            if (target instanceof Allosaur) {
//                for (Item item : actor.getInventory()) {
//                    if (item instanceof CarnivoreMealKitItem) {
//                        if(target.eat((FoodItem) item)){
//                            actor.removeItemFromInventory(item);
//                            output+="Dinosaur is successfully fed";
//                            found=true;
//                            break;
//                        }
//                        else
//                        {
//                            output+="The dinosaur is full";
//                        }
//                    }
//                }
//                if (!found)
//                {
//                    output+="The following item is not found in your inventory";
//                }
//            }
//            else
//            {
//                output+="This dinosaur is not carnivore." ;
//            }
//        }
//        else if(playerChoice == '5')
//        {
//            boolean found=false;
//            if (target instanceof Allosaur) {
//                for (Item item : actor.getInventory()) {
//                    if (item instanceof StegosaurEgg) {
//                        if(target.eat((FoodItem) item)){
//                            actor.removeItemFromInventory(item);
//                            output+="Dinosaur is successfully fed";
//                            found=true;
//                            break;
//                        }
//                        else
//                        {
//                            output+="The dinosaur is full";
//                        }
//                    }
//                }
//                if (!found)
//                {
//                    output+="The following item is not found in your inventory";
//                }
//            }
//            else
//            {
//                output+="This dinosaur is not carnivore." ;
//            }
//        }
//        else if(playerChoice == '6')
//        {
//            boolean found=false;
//            if (target instanceof Allosaur) {
//                for (Item item : actor.getInventory()) {
//                    if (item instanceof AllosaurEgg) {
//                        if(target.eat((FoodItem) item)){
//                            actor.removeItemFromInventory(item);
//                            output+="Dinosaur is successfully fed";
//                            found=true;
//                            break;
//                        }
//                        else
//                        {
//                            output+="The dinosaur is full";
//                        }
//                    }
//                }
//                if (!found)
//                {
//                    output+="The following item is not found in your inventory";
//                }
//            }
//            else
//            {
//                output+="This dinosaur is not carnivore." ;
//            }
//        }
//        //else nothing reenter again
//        else
//        {
//            output+="Invalid input";
//        }
//        return output;
//    }
//
//

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
        char playerChoice=display.readChar();

        if (playerChoice == '1'||playerChoice == '2'||playerChoice == '3'||playerChoice == '4'||playerChoice == '5'||playerChoice == '6')
        {
            boolean found=false;
            if (playerChoice == '1'||playerChoice == '2'||playerChoice == '3')
            {
                if (target instanceof Stegosaur) {
                    for (Item item : actor.getInventory()) {
                        if (playerChoice == '1')
                        {
                            if (item instanceof HayItem) {
                                actor.removeItemFromInventory(item);
                                ((Player) actor).gainEcoPoint(10);
                                output+="Dinosaur is successfully fed";
                                found=true;
                                break;
                            }
                        }
                        else if (playerChoice == '2')
                        {
                            if (item instanceof FruitItem) {
                                actor.removeItemFromInventory(item);
                                ((Player) actor).gainEcoPoint(10);
                                output+="Dinosaur is successfully fed";
                                found=true;
                                break;
                            }
                        }
                        else if (playerChoice == '3')
                        {
                            if (item instanceof VegetarianMealKitItem) {
                                actor.removeItemFromInventory(item);
                                ((Player) actor).gainEcoPoint(10);
                                output+="Dinosaur is successfully fed";
                                found=true;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    output+="This dinosaur is not vegeterain." ;
                }
            }
            else if (playerChoice == '4'||playerChoice == '5'||playerChoice == '6')
            {
                if (target instanceof Allosaur) {
                    for (Item item : actor.getInventory()) {
                        if (playerChoice == '4')
                        {
                            if (item instanceof CarnivoreMealKitItem) {
                                actor.removeItemFromInventory(item);
                                ((Player) actor).gainEcoPoint(10);
                                output+="Dinosaur is successfully fed";
                                found=true;
                                break;
                            }
                        }
                        else if (playerChoice == '5')
                        {
                            if (item instanceof StegosaurEgg) {
                                actor.removeItemFromInventory(item);
                                ((Player) actor).gainEcoPoint(10);
                                output+="Dinosaur is successfully fed";
                                found=true;
                                break;
                            }
                        }
                        else if (playerChoice == '6')
                        {
                            if (item instanceof AllosaurEgg) {
                                actor.removeItemFromInventory(item);
                                ((Player) actor).gainEcoPoint(10);
                                output+="Dinosaur is successfully fed";
                                found=true;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    output+="This dinosaur is not carnivore." ;
                }
            }

        }
        //else nothing reenter again
        else
        {
            output+="Invalid input";
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
