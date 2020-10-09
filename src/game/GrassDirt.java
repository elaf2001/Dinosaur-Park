package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represents bare dirt.
 */
public class GrassDirt extends Ground {

	public GrassDirt() {
		super('.');
	}

	@Override
	public void tick(Location location) {
		super.tick(location);
		int xLocation = location.x();
		int yLocation = location.y();
		GameMap gameMap = location.map();
		// Checking
		ArrayList<Location> locations = new ArrayList<>();
		locations.add(new Location(gameMap,xLocation,yLocation+1)); //North
		locations.add(new Location(gameMap,xLocation,yLocation-1)); //South
		locations.add(new Location(gameMap, xLocation-1, yLocation)); //West
		locations.add(new Location(gameMap, xLocation+1, yLocation)); //East
		locations.add(new Location(gameMap, xLocation-1, yLocation+1)); //NorthWest
		locations.add(new Location(gameMap, xLocation+1, yLocation+1)); //NorthEast
		locations.add(new Location(gameMap, xLocation-1, yLocation-1)); //SouthWest
		locations.add(new Location(gameMap, xLocation+1, yLocation-1)); //SouthEast
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
