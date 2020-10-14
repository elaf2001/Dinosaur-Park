package game;

import edu.monash.fit2099.engine.*;

public class Tree extends Ground {

	private int age = 0;

	/**
	 * Constructor
	 * Trees are represented by +, in the beginning of the game
	 */
	public Tree() {
		super('+');
	}

	/**
	 * Allows to perform the search tree action on this tree.
	 */
	public SearchTreeAction getSearchTreeAction() {
		return new SearchTreeAction(this);
	}

	/**
	 * Tree can grow and drop the fruit.
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';
		// Tree has small % chance of dropping a fruit
		if(Math.random()<=0.05){
			FruitItem newFruit = new FruitItem();
			location.addItem(newFruit);
		}
	}
}
