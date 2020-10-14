package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represents bare dirt and grass.
 */
public class GrassDirt extends Ground {

	/**
	 * Constructor.
	 * Initially setting the square to "."
	 */
	public GrassDirt() {
		super('.');
	}

	/**
	 * Allows the player to harvest the grass
	 *
	 * @returns initialised harvest grass action
	 */
	public HarvestGrassAction getHarvestGrassAction(){
		if (displayChar == 'g'){
			return new HarvestGrassAction(this);
		}
		return null;
	}

	/**
	 * Allows the dinosaur to graze on the grass
	 *
	 * @returns initialised grazing grass action
	 */
	public GrazingGrassAction getGrazingGrassAction(){
		if (displayChar == 'g'){
			return new GrazingGrassAction(this);
		}
		return null;
	}

	/**
	 * Increases the amount of player's eco points by searching for all the players on the map
	 *
	 * @param location location where the player is standing
	 */
	public void increasePlayerPoints(Location location){
		GameMap map = location.map();
		Location[][] mapLocations = map.getMap();
		for (int row = 0; row < mapLocations.length; row++) {
			for (int col = 0; col < mapLocations[row].length; col++) {
				Location possibleLocation = mapLocations[row][col];
				if(possibleLocation.containsAnActor()){
					Actor actor = possibleLocation.getActor();
					if (actor instanceof Player){
						((Player) actor).gainEcoPoint(1);
					}
				}
			}
		}
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
		Location[][] mapLocations = gameMap.getMap();
		// Checking
		ArrayList<Location> locations = new ArrayList<>();

		if (yLocation == 0) {
			locations.add(mapLocations[xLocation][yLocation + 1]); //South
			if(xLocation==0){
				locations.add(mapLocations[xLocation + 1][yLocation]); //East
				locations.add(mapLocations[xLocation + 1][yLocation + 1]); //SouthEast
			}
			else
			{
				locations.add(mapLocations[xLocation-1][yLocation]); //West
				locations.add(mapLocations[xLocation-1][yLocation+1]); //SouthWest
				if(xLocation >0 & xLocation <79)
				{
					locations.add(mapLocations[xLocation + 1][yLocation]); //East
					locations.add(mapLocations[xLocation + 1][yLocation + 1]); //SouthEast
				}
			}
		}
		else if(yLocation == 24){
			locations.add(mapLocations[xLocation][yLocation-1]); //North
			if(xLocation==0){
				locations.add(mapLocations[xLocation + 1][yLocation]); //East
				locations.add(mapLocations[xLocation+1][yLocation-1]); //NorthEast
			}
			else
			{
				locations.add(mapLocations[xLocation-1][yLocation]); //West
				locations.add(mapLocations[xLocation-1][yLocation-1]); //NorthWest
				if(xLocation >0 & xLocation <79){
					locations.add(mapLocations[xLocation + 1][yLocation]); //East
					locations.add(mapLocations[xLocation+1][yLocation-1]); //NorthEast
				}
			}
		}
		else {
			locations.add(mapLocations[xLocation][yLocation + 1]); //South
			locations.add(mapLocations[xLocation][yLocation - 1]); //North
			if(xLocation == 0){
				locations.add(mapLocations[xLocation + 1][yLocation + 1]); //SouthEast
				locations.add(mapLocations[xLocation + 1][yLocation - 1]); //NorthEast
				locations.add(mapLocations[xLocation + 1][yLocation]); //East
			} else {
				locations.add(mapLocations[xLocation - 1][yLocation]); //West
				locations.add(mapLocations[xLocation - 1][yLocation + 1]); //SouthWest
				locations.add(mapLocations[xLocation - 1][yLocation - 1]); //NorthWest
				if (xLocation != 79) {
					locations.add(mapLocations[xLocation + 1][yLocation + 1]); //SouthEast
					locations.add(mapLocations[xLocation + 1][yLocation - 1]); //NorthEast
					locations.add(mapLocations[xLocation + 1][yLocation]); //East
				}
			}
		}

		boolean isTree=false;
		boolean isGrass=false;
		// checking the arrays surrounding the grass location
		for(Location place: locations){
			Ground ground = place.getGround();
			//counter for tree changes if there is a tree around
			if (ground.getDisplayChar() == '+' || ground.getDisplayChar() == 't' || ground.getDisplayChar() == 'T' || ground.getDisplayChar() == 'f')
			{
				isTree=true;
			}
			//counter for grass changes if there is grass around
			else if(ground.getDisplayChar()== 'g') {
				isGrass=true;
			}
		}
		// if it is next to a tree, it only has 2% of growing into grass
		if (isTree){
			if(Math.random()<=0.02)
			{
				location.getGround().setDisplayChar('g');
				increasePlayerPoints(location);
			}
		}
		else if(location.getGround().getDisplayChar() != 'g'){
			// if it is next to grass, it has 10% of growing into grass
			if(isGrass){
				if(Math.random()<=0.1){
					location.getGround().setDisplayChar('g');
					increasePlayerPoints(location);
				}
			}
			//if there is neither tree nor grass around it has 2% probability of growing
			else{
				if(Math.random()<=0.02){
					location.getGround().setDisplayChar('g');
					increasePlayerPoints(location);
				}
			}
		}
	}
}