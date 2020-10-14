package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class BreedingAction extends Action {
    protected Dinosaur target;


    public BreedingAction(Dinosaur target) {
        this.target=target;
    }


    /**
     * Allow the Actor to be moved.
     *
     * Overrides Action.execute()
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor instanceof Dinosaur)
        {
            if (((Dinosaur) actor).getAge()>30 && target.getAge()>30)
            {
                if (actor instanceof Allosaur)
                {
                    AllosaurEgg newEgg= new AllosaurEgg("AG");
                    if( ((Dinosaur) actor).getGender()=="female")
                    {
                        actor.addItemToInventory(newEgg);
                        return menuDescription(actor);
                    }
                    else {
                        target.addItemToInventory(newEgg);
                        return menuDescription(actor);
                    }
                }
                else {
                    StegosaurEgg newEgg= new StegosaurEgg("SG");
                    if ( ((Dinosaur) actor).getGender()=="female")
                    {
                        actor.addItemToInventory(newEgg);
                        return menuDescription(actor);
                    }
                    else {
                        target.addItemToInventory(newEgg);
                        return menuDescription(actor);
                    }
                }
            }
        }
        return "Dinosaurs couldn't mate";
    }

    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player moves east"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " mates with " + target;
    }


}
