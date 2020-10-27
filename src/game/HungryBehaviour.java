package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;
import java.util.Collections;

import java.util.*;

/**
 * A class that find the nearest food source to eat and moves towards it.
 * When target and actor are in the same cell, the dinosaur is able to eat it.
 */
public class HungryBehaviour implements Behaviour {


    /** Searches for the nearest food source, which suits the dinosaur preferences (carnivore or vegetarian food)
     * and if there is one found, moves towards it.
     * When the dinosaur reaches the food item and is standing in the same cell, it can perform an eating action.
     * If no food is found, returns null.
     */
    public Action getAction(Dinosaur dinosaur, GameMap map) {
        ArrayList<Location> locations = new ArrayList<>();
        Location locationOfActor = map.locationOf(dinosaur);
        ArrayList<Integer> distances = new ArrayList<>();
        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();
        for(int x: xRange){
            for(int y: yRange){
                Location current = map.at(x,y);
                List<Item> items = current.getItems();
                for(Item item: items){
                    if(dinosaur.getIs_vegetarian()){
                        if(item instanceof FruitItem || item instanceof HayItem || item instanceof VegetarianMealKitItem){
                            locations.add(current);
                        }
                    }else if (dinosaur.getIs_carnivore()){
                        if(item instanceof EggItem || item instanceof CorpseItem || item instanceof CarnivoreMealKitItem){
                            locations.add(current);
                        }
                    }
                }
                if(dinosaur.getIs_vegetarian()){
                    Ground ground = current.getGround();
                    if(ground.getDisplayChar() == 'g'){
                        locations.add(current);
                    }
                }
            }
        }

        //calculating distances
        if(locations.size() >0){
            for (Location i : locations) {
                distances.add(distance(locationOfActor,i));
            }
            //finding the minimum value
            int minIndex = distances.indexOf(Collections.min(distances));
            //getting the minimum location
            Location minLocation = locations.get(minIndex);
            // getting the exits

            if(locationOfActor == minLocation){
                List<Item> items = minLocation.getItems();
                for(Item item: items){
                    if(dinosaur.getIs_vegetarian()){
                        if(item instanceof FruitItem || item instanceof HayItem || item instanceof VegetarianMealKitItem){
                            minLocation.removeItem(item);
                            return new EatingAction((FoodItem) item);
                        }
                    }else if (dinosaur.getIs_carnivore()){
                        minLocation.removeItem(item);
                        if(item instanceof EggItem || item instanceof CorpseItem || item instanceof CarnivoreMealKitItem){
                            return new EatingAction((FoodItem) item);
                        }
                    }
                }
                if(dinosaur.getIs_vegetarian()){
                    Ground ground = minLocation.getGround();
                    if(ground.getDisplayChar() == 'g'){
                        return new GrazingGrassAction(ground);
                    }
                }
            }
            return new FollowBehaviour(minLocation).getAction(dinosaur,map);
        }
        return new WanderBehaviour().getAction(dinosaur,map);
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
