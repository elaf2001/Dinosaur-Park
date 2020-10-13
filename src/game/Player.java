package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.ActorInterface;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements ActorInterface {

	private Menu menu = new Menu();
	private int ecoPoints;
	//private ArrayList<BoughtItem> inventory= new ArrayList<BoughtItem>();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		ecoPoints=1000;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// new
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

	public int getEcoPoints(){
		return ecoPoints;
	}

	public void payEcoPoints(int ecoPoints){
		this.ecoPoints -= ecoPoints;
	}

	public void gainEcoPoint( int ecoPoints){
		this.ecoPoints += ecoPoints;
	}

}
