package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.ActorInterface;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements ActorInterface {

	private Menu menu = new Menu();
	private int ecoPoints;

	/**
	 * Constructor. Initialises the amount of eco points of the player to 0.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		ecoPoints=0;
	}

	/**
	 * Allows to perform different actions depending on what the player is standing on:
	 * Tree -> allows to search the Tree
	 * GrassDirt -> allows to harvest the grass
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		Location locationOfPlayer = map.locationOf(this);
		if(locationOfPlayer.getGround() instanceof Tree){
			actions.add(((Tree) locationOfPlayer.getGround()).getSearchTreeAction());
		}
		if(locationOfPlayer.getGround() instanceof GrassDirt){
			actions.add(((GrassDirt) locationOfPlayer.getGround()).getHarvestGrassAction());
		}
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		return menu.showMenu(this, actions, display);
	}

	/**
	 * gets the amount of eco points that this player has
	 * @return amount of eco points
	 */
	public int getEcoPoints(){
		return ecoPoints;
	}

	/**
	 * deducts the number of eco points from the user
	 * @param ecoPoints amount of eco points to be deducted
	 */
	public void payEcoPoints(int ecoPoints){
		this.ecoPoints -= ecoPoints;
	}

	/**
	 * adds the number of eco points to the user
	 * @param ecoPoints amount of eco points to be added
	 */
	public void gainEcoPoint( int ecoPoints){
		this.ecoPoints += ecoPoints;
	}

}
