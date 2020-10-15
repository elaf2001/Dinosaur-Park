package game;

import edu.monash.fit2099.engine.*;

import java.util.Iterator;
import java.util.List;

public class BreedingBehaviour implements Behaviour  {



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

