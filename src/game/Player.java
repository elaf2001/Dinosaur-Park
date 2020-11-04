package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.ActorInterface;

/**
 * Class representing the Player.
 * menu is the main interaction tool
 * ecoPoints is amount of the local currency that the player has
 */
public class Player extends Actor implements ActorInterface {

	private Menu menu = new Menu();
	private int ecoPoints;
	private int moveChoice;
	private int turns=0;
	private int ecoPointsChoice;

	/**
	 * Constructor. Initialises the amount of eco points of the player to 0.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.ecoPoints=100000;
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

		if(this.moveChoice>0){
			if (this.moveChoice == this.turns){
				if(this.ecoPoints >= this.ecoPointsChoice){
					System.out.println("You Win!");
				} else {
					System.out.println("You lose!");
				}
				System.out.println("Your Eco points: " + this.ecoPoints);
				return new EndGameAction();
			}
			this.turns +=1;
			System.out.println("Turn #" + this.turns + ". Eco points: " + this.ecoPoints);
		}
		actions.add(new EndGameAction());
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

	public void setChallenge(int moveChoice, int ecoPointsChoice){
		this.moveChoice = moveChoice;
		this.ecoPointsChoice = ecoPointsChoice;
	}



}
