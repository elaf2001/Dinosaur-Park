package game;

import edu.monash.fit2099.engine.*;

public class FeedAction extends Action {

    protected Dinosaur target;

    public FeedAction(Dinosaur target) {
        this.target = target;
    }
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
        if (String.valueOf(playerChoice).equals('1')){
            boolean found=false;
            if (target instanceof Stegosaur) {
                for (Item item : actor.getInventory()) {
                    if (item instanceof HayItem) {
                        if(target.eat((FoodItem) item)){
                            actor.removeItemFromInventory(item);
                            output+="Dinosaur is successfully fed";
                            found=true;
                            break;
                        }
                        else
                        {
                            output+="The dinosaur is full";
                        }
                    }
                }
                if (!found)
                {
                    output+="The following item is not found in your inventory";
                }
            }
            else
            {
               output+="This dinosaur is not vegeterain." ;
            }
        }
        else if(String.valueOf(playerChoice).equals('2'))
        {
            boolean found=false;
            if (target instanceof Stegosaur) {
                for (Item item : actor.getInventory()) {
                    if (item instanceof FruitItem) {
                        if(target.eat((FoodItem) item)){
                            actor.removeItemFromInventory(item);
                            output+="Dinosaur is successfully fed";
                            found=true;
                            break;
                        }
                       else
                        {
                            output+="The dinosaur is full";
                        }
                    }
                }
                if (!found)
                {
                    output+="The following item is not found in your inventory";
                }
            }
            else
            {
                output+="This dinosaur is not vegeterain." ;
            }
        }
        else if(String.valueOf(playerChoice).equals('3'))
        {
            boolean found=false;
            if (target instanceof Stegosaur) {
                for (Item item : actor.getInventory()) {
                    if (item instanceof VegetarianMealKitItem) {
                        if(target.eat((FoodItem) item)){
                            actor.removeItemFromInventory(item);
                            output+="Dinosaur is successfully fed";
                            found=true;
                            break;
                        }
                        else
                        {
                            output+="The dinosaur is full";
                        }
                    }
                }
                if (!found)
                {
                    output+="The following item is not found in your inventory";
                }
            }
            else
            {
                output+="This dinosaur is not vegeterain." ;
            }
        }
        else if(String.valueOf(playerChoice).equals('4'))
        {
            boolean found=false;
            if (target instanceof Allosaur) {
                for (Item item : actor.getInventory()) {
                    if (item instanceof CarnivoreMealKitItem) {
                        if(target.eat((FoodItem) item)){
                            actor.removeItemFromInventory(item);
                            output+="Dinosaur is successfully fed";
                            found=true;
                            break;
                        }
                        else
                        {
                            output+="The dinosaur is full";
                        }
                    }
                }
                if (!found)
                {
                    output+="The following item is not found in your inventory";
                }
            }
            else
            {
                output+="This dinosaur is not carnivore." ;
            }
        }
        else if(String.valueOf(playerChoice).equals('5'))
        {
            boolean found=false;
            if (target instanceof Allosaur) {
                for (Item item : actor.getInventory()) {
                    if (item instanceof StegosaurEgg) {
                        if(target.eat((FoodItem) item)){
                            actor.removeItemFromInventory(item);
                            output+="Dinosaur is successfully fed";
                            found=true;
                            break;
                        }
                        else
                        {
                            output+="The dinosaur is full";
                        }
                    }
                }
                if (!found)
                {
                    output+="The following item is not found in your inventory";
                }
            }
            else
            {
                output+="This dinosaur is not carnivore." ;
            }
        }
        else if(String.valueOf(playerChoice).equals('6'))
        {
            boolean found=false;
            if (target instanceof Allosaur) {
                for (Item item : actor.getInventory()) {
                    if (item instanceof AllosaurEgg) {
                        if(target.eat((FoodItem) item)){
                            actor.removeItemFromInventory(item);
                            output+="Dinosaur is successfully fed";
                            found=true;
                            break;
                        }
                        else
                        {
                            output+="The dinosaur is full";
                        }
                    }
                }
                if (!found)
                {
                    output+="The following item is not found in your inventory";
                }
            }
            else
            {
                output+="This dinosaur is not carnivore." ;
            }
        }
        //else nothing reenter again
        else
        {
            output+="Invalid input";
        }
        return output;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
