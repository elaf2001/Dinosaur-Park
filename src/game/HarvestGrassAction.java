package game;

import edu.monash.fit2099.engine.*;

public class HarvestGrassAction extends Action {

    protected Ground target;
    public HarvestGrassAction(Ground target) {
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        target.setDisplayChar('.');
        if(actor instanceof Player){
            HayItem hay = new HayItem();
            actor.addItemToInventory(hay);
            ((Player) actor).gainEcoPoint(1);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " harvest grass ";
    }
}
