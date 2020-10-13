package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

public class GrazingGrassAction extends Action {
    protected Ground target;
    public GrazingGrassAction(Ground target) {
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        target.setDisplayChar('.');
        HayItem hay = new HayItem();
        if (actor instanceof Stegosaur) {
            ((Stegosaur) actor).eat(hay);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " ate grass";
    }
}


