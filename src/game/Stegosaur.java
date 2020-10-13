package game;


import edu.monash.fit2099.engine.*;

/**
 * A herbivorous dinosaur.
 *
 */
public class Stegosaur extends Dinosaur {
	/** 
	 * Constructor.
	 * All Stegosaurs are represented by a 's' and have 100 hit points.
	 * 
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name, int foodLevel) {
		super(name, 's', 100);
		this.foodLevel = foodLevel;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {

		return super.playTurn(actions, lastAction, map, display);

	}
}
