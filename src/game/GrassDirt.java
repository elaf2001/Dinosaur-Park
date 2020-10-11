package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represents bare dirt and grass.
 */
public class GrassDirt extends Ground {

	public GrassDirt() {
		super('.');
	}

	/**
	 * Calculates the probability based on the requirements and allows for the dirt to grow into grass.
	 * These requirements are:
	 * If there are no Grass cells nearby or there is a tree in the neighbour cell,
	 * Dirt has a 2% of growing into grass, but if there are 2 or more grass cells around,
	 * the Dirt has a probability of 10% of growing into Grass.
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);
		int xLocation = location.x();
		int yLocation = location.y();
		GameMap gameMap = location.map();
		// Checking
		ArrayList<Location> locations = new ArrayList<>();
		if (xLocation == 0 & yLocation == 0) {
			locations.add(new Location(gameMap,xLocation,yLocation+1)); //South
			locations.add(new Location(gameMap, xLocation+1, yLocation)); //East
			locations.add(new Location(gameMap, xLocation+1, yLocation+1)); //SouthEast
		} else if(xLocation == 0 & yLocation == 24){
			locations.add(new Location(gameMap,xLocation,yLocation-1)); //North
			locations.add(new Location(gameMap, xLocation+1, yLocation)); //East
			locations.add(new Location(gameMap, xLocation+1, yLocation-1)); //NorthEast
		} else if(xLocation ==79 & yLocation==0){
			locations.add(new Location(gameMap,xLocation,yLocation+1)); //South
			locations.add(new Location(gameMap, xLocation-1, yLocation)); //West
			locations.add(new Location(gameMap, xLocation-1, yLocation+1)); //SouthWest
		} else if(xLocation == 79 & yLocation==24){
			locations.add(new Location(gameMap, xLocation-1, yLocation)); //West
			locations.add(new Location(gameMap,xLocation,yLocation-1)); //North
			locations.add(new Location(gameMap, xLocation-1, yLocation-1)); //NorthWest
		} else {
			locations.add(new Location(gameMap,xLocation,yLocation+1)); //South
			locations.add(new Location(gameMap, xLocation+1, yLocation)); //East
			locations.add(new Location(gameMap, xLocation-1, yLocation)); //West
			locations.add(new Location(gameMap,xLocation,yLocation-1)); //North
			locations.add(new Location(gameMap, xLocation+1, yLocation+1)); //SouthEast
			locations.add(new Location(gameMap, xLocation+1, yLocation-1)); //NorthEast
			locations.add(new Location(gameMap, xLocation-1, yLocation+1)); //SouthWest
			locations.add(new Location(gameMap, xLocation-1, yLocation-1)); //NorthWest
		}

		// checking the arrays surrounding the grass location, can u check if this is correct?
		for(Location place: locations){
			Ground ground = place.getGround();
			int turn = 0;
			if(ground.getDisplayChar()== '.'){
				if(new java.util.Random().nextInt(50)==0){
					location.getGround().setDisplayChar('g');
					return;
				}
			} else if(ground.getDisplayChar()== 'g'){
				turn +=1;
				if (turn == 2){
					if(new java.util.Random().nextInt(10)==0){
						location.getGround().setDisplayChar('g');
						return;
					}
				}
			}
		}



	}
}
