package game;

import edu.monash.fit2099.engine.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FollowFoodBehaviour implements Behaviour{

    private Location location;
    public FollowFoodBehaviour(Location minLoc){
        this.location = minLoc;
    }



    public Action getAction(Actor actor, GameMap map) {
        if (!map.contains(actor))
            return null;

        Location here = map.locationOf(actor);
        int currentDistance = distance(here, this.location);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, this.location);
                if (newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }
        return null;
    }



    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

}
