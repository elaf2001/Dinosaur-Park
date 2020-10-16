package game;

import edu.monash.fit2099.engine.*;

import java.util.Iterator;
import java.util.List;

/**
 * A class that finds the nearest dinosaur to breed and follows it.
 * When target and actor are in adjacent cells, they mate
 */
public class BreedingBehaviour implements Behaviour  {
   /** Searches for the nearest dinosaur of the opposite gender, same kind as an actor and with no egg in its inventory
    * and if there is one found, moves towards it.
    * If the target dinosaur and actor are in the adjacent cells, they perform a breed action.
    * If no dinosaur is found, returns null.
    */
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur target;
        if(!map.contains(actor))
            return null;
        if(actor instanceof Dinosaur){
            NumberRange xRange = map.getXRange();
            NumberRange yRange = map.getYRange();
            for (int x: xRange) {
                for (int y: yRange) {
                    Location possibleLocation = map.at(x,y);
                    if(map.isAnActorAt(possibleLocation)){
                        if(map.getActorAt(possibleLocation) instanceof Dinosaur){
                            target = (Dinosaur) map.getActorAt(possibleLocation);
                            if ((actor instanceof Allosaur && target instanceof Allosaur )||(actor instanceof Stegosaur && target instanceof Stegosaur)) {
                                if (((Dinosaur) actor).getGender() != target.getGender()) {
                                    if(actor.getInventory().size() == 1 || target.getInventory().size() == 1){
                                        return null;
                                    }
                                    List<Exit> exits =map.locationOf(actor).getExits();
                                    for(Exit exit: exits){
                                        if(exit.getDestination() == map.locationOf(target)){
                                            return new BreedingAction(target);
                                        }
                                    }
                                    return new FollowBehaviour(target).getAction(actor,map);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}

