package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThirstyBehaviour implements Behaviour {

    /** Searches for the nearest water source and moves towards the nearest one.
     * When the dinosaur reaches the water cell and is standing next to it, it can perform a drinking action.
     */
    public Action getAction(Dinosaur dinosaur, GameMap map) {

        ArrayList<Location> locations = new ArrayList<>();
        Location locationOfActor = map.locationOf(dinosaur);
        ArrayList<Integer> distances = new ArrayList<>();

        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();

        for (int x : xRange) {
            for (int y : yRange) {
                Location current = map.at(x, y);
                if (current.getGround() instanceof Water) {
                    locations.add(current);
                }
            }
        }
        //calculating distances
        for (Location i : locations) {
            distances.add(distance(locationOfActor, i));
        }
        //finding the minimum value
        int minIndex = distances.indexOf(Collections.min(distances));
        //getting the minimum location
        Location minLocation = locations.get(minIndex);
        // getting the exits
        List<Exit> exits = locationOfActor.getExits();
        for (Exit exit : exits) {
            if (exit.getDestination().getGround() instanceof Water) {
                Water target = (Water) exit.getDestination().getGround();
                return new DrinkAction(target);
            }
        }
        return new FollowBehaviour(minLocation).getAction(dinosaur, map);
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
