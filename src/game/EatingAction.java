package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class EatingAction extends Action {
    private FoodItem item;

    public EatingAction(FoodItem item){
        this.item = item;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        if(actor instanceof Dinosaur){
            ((Dinosaur) actor).eat(this.item);
            return menuDescription(actor,this.item);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }


    public String menuDescription(Actor actor, Item item) {
        return actor +" ate " + item;
    }
}
