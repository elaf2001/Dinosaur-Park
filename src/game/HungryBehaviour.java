package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;
import java.util.Collections;

import java.util.*;
public class HungryBehaviour implements Behaviour {


    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Location> locations = new ArrayList<>();
        Location locationOfActor = map.locationOf(actor);
        ArrayList<Integer> distances = new ArrayList<>();
        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();
        for(int x: xRange){
            for(int y: yRange){
                Location current = map.at(x,y);
                List<Item> items = current.getItems();
                for(Item item: items){
                    if(actor instanceof Stegosaur){
                        if(item instanceof FruitItem || item instanceof HayItem || item instanceof VegetarianMealKitItem){
                            locations.add(current);
                        }
                    }else if (actor instanceof Allosaur){
                        if(item instanceof EggItem || item instanceof CorpseItem || item instanceof CarnivoreMealKitItem){
                            locations.add(current);
                        }
                    }
                }
                if(actor instanceof Stegosaur){
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
            System.out.println(distances.size());
            //finding the minimum value
            int minIndex = distances.indexOf(Collections.min(distances));
            //getting the minimum location
            Location minLocation = locations.get(minIndex);
            // getting the exits

            if(locationOfActor == minLocation){
                List<Item> items = minLocation.getItems();
                for(Item item: items){
                    if(actor instanceof Stegosaur){
                        if(item instanceof FruitItem || item instanceof HayItem || item instanceof VegetarianMealKitItem){
                            return new EatingAction((FoodItem) item);
                        }
                    }else if (actor instanceof Allosaur){
                        if(item instanceof EggItem || item instanceof CorpseItem || item instanceof CarnivoreMealKitItem){
                            return new EatingAction((FoodItem) item);
                        }
                    }
                }
                if(actor instanceof Stegosaur){
                    Ground ground = minLocation.getGround();
                    if(ground.getDisplayChar() == 'g'){
                        return new GrazingGrassAction(ground);
                    }
                }
            }
            return new FollowFoodBehaviour(minLocation).getAction(actor,map);
        }
        return new WanderBehaviour().getAction(actor,map);
    }

    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
