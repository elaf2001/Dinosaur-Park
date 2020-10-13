package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

public class SearchTreeAction extends Action {


    private Ground target;

    public SearchTreeAction(Ground target) {
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        String output = menuDescription(actor);
        if(Math.random()<=0.4){
            FruitItem fruit = new FruitItem();
            actor.addItemToInventory(fruit);
            output+= "\n You found a fruit!";
        } else{
            output += "\n You search the tree for fruit, but you can't find ripe ones";
        }
        return output;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " search tree ";
    }
}
