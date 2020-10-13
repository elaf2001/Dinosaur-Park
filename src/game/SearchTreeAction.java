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
        if(Math.random()<=0.4){
            FruitItem fruit = new FruitItem();
            actor.addItemToInventory(fruit);
            return "You found a fruit!";
        }
        return "You search the tree for fruit, but you can't find ripe ones";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " search tree ";
    }
}
