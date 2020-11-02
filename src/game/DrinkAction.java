package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class DrinkAction extends Action {

    private Water water;

    public DrinkAction(Water water) {
        this.water=water;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if(actor instanceof Dinosaur){
            if (((Dinosaur) actor).drink(water))
            {
                return menuDescription(actor);
            }
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor +" drank water ";
    }

}
