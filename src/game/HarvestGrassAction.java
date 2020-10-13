package game;

import edu.monash.fit2099.engine.*;

public class HarvestGrassAction extends Action {

    protected Ground target;
    public HarvestGrassAction(Ground target) {
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        Location locationOfActor = map.locationOf(actor);
        target.setDisplayChar('.');
        HayItem hay = new HayItem();
        actor.addItemToInventory(hay);
        return "Grass harvested by the player";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " harvest grass ";
    }
}
