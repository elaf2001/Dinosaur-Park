package game;


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
	public Stegosaur(String name) {
		super(name, 's', 100);
	}

	/**
	 * This method allows to set a food level for the newly created stegosaur.
	 * It is needed since stegosaur may be created in the beginning of
	 * the game with the food level of 50 or hatched from the egg with the food
	 * level of 10.
	 * This method is called once, when the dinosaur is created.
	 * @param newFoodLevel food level of the stegosaur when it is created
	 */
	public void setFoodLevel(int newFoodLevel)
	{
		foodLevel=newFoodLevel;
	}

}
