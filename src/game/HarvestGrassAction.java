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
        HayItem hay = new HayItem();
        actor.addItemToInventory(hay);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " harvest grass ";
    }
}
